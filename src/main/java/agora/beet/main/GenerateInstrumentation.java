package agora.beet.main;

import agora.beet.model.*;
import agora.beet.util.CSVManager;
import agora.beet.util.FileManager;
import agora.beet.util.TestCaseFileManager;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;


import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author Juan C. Alonso
 */
public class GenerateInstrumentation {

    private static String openApiSpecPath = "src/test/resources/examples/Spotify/getAlbumTracks/swagger_albumTracks.yaml";
    private static String testCasesFilePath = "src/test/resources/examples/Spotify/getAlbumTracks/50/Spotify_GetAlbumTracks_50.csv";
    private static boolean generateDtrace = true;
    public static String[] stringsToConsiderAsNull = {};


    public static String HIERARCHY_SEPARATOR = "&";
    public static String ARRAY_NESTING_SEPARATOR = "%";
    public static int bufferSize = 20;

    public static int numberOfExits = 1;

    private static List<DeclsClass> declsClasses = new ArrayList<>();
    // Stored so that NestedPpts can recover real schemas for circular-ref stubs (see lookupRealSchema)
    private static OpenAPI openAPISpec;

    public static final String HASHCODE_TYPE_NAME = "hashcode";
    public static final String STRING_TYPE_NAME = "java.lang.String";
    public static final String DOUBLE_TYPE_NAME = "double";
    public static final String INTEGER_TYPE_NAME = "int";
    public static final String BOOLEAN_TYPE_NAME = "boolean";
    public static final String OBJECT_TYPE_NAME = "object";
    public static final String ARRAY_TYPE_NAME = "array";

    public static final List<String> primitiveTypes = Arrays.asList(STRING_TYPE_NAME, DOUBLE_TYPE_NAME, INTEGER_TYPE_NAME, BOOLEAN_TYPE_NAME);

    public static void main(String[] args) {
        declsClasses = new ArrayList<>();
        numberOfExits = 1;

        if(args.length == 2) {
            openApiSpecPath = args[0];
            testCasesFilePath = args[1];
            stringsToConsiderAsNull = new String[]{};
            generateDtrace = true;
        } else if(args.length == 1) {
            openApiSpecPath = args[0];
            generateDtrace = false;
            stringsToConsiderAsNull = new String[]{};
        } else if(args.length==3) {
            openApiSpecPath = args[0];
            testCasesFilePath = args[1];
            generateDtrace = true;
            // The set of strings to consider as null must be a list of strings separated by ";"
            stringsToConsiderAsNull = args[2].split(";");
        }

        OpenAPI specification = getOpenAPISpecification();
        Paths paths = specification.getPaths();

        // A path (endpoint) contains several operations (http methods/verbs)
        for(Entry<String, PathItem> path: paths.entrySet()) {

            PathItem pathItem = path.getValue();

            for (Entry<HttpMethod, Operation> operationEntry: pathItem.readOperationsMap().entrySet()) {
                Operation operation = operationEntry.getValue();
                String operationEndpoint = path.getKey();

                // Set the operation name for the .decls file
                String operationName = getOperationName(operation, operationEntry, operationEndpoint);

                // Extracting the input parameters
                String objectName = operationName + HIERARCHY_SEPARATOR + "Input";

                // Extracting enter and exits
                DeclsClass.setDeclsClassEnterAndExit(operationEndpoint, operationName,
                        objectName, operation);

            }

        }

        // PRINT DECLS file
        DeclsFile declsFile = new DeclsFile(2.0, Comparability.implicit, declsClasses);
        String declsFilePath = getOutputPath("declsFile.decls", openApiSpecPath);
        if (generateDtrace){
            declsFilePath = getOutputPath("declsFile.decls", testCasesFilePath);
        }

        // Delete file if exists
        FileManager.deleteFile(declsFilePath);
        FileManager.writeFile(declsFilePath, declsFile.toString());


        // Generate dTrace file
        if(generateDtrace){
            int i = 0;
            String dtraceFilePath = getOutputPath("dtraceFile.dtrace", testCasesFilePath);      // openApiSpecPath testCasesFilePath
            FileManager.deleteFile(dtraceFilePath);     // Delete file if exists

            try {
                // Read test cases
                File testCasesFile = new File(testCasesFilePath);
                FileReader testCasesFileReader = new FileReader(testCasesFile);
                BufferedReader testCasesBR = new BufferedReader(testCasesFileReader,bufferSize*1024);
                String testCasesLine = "";

                // The first line must be the header
                String header = testCasesBR.readLine();
                if (header == null) {
                    throw new NullPointerException("The csv file containing the test cases is empty");
                }

                TestCaseFileManager testCaseFileManager = new TestCaseFileManager(header);

                FileWriter dtraceFile = new FileWriter(dtraceFilePath);
                BufferedWriter dtraceBuffer = new BufferedWriter(dtraceFile,bufferSize*1024);

                while((testCasesLine = testCasesBR.readLine()) != null) {
                    TestCase testCase = testCaseFileManager.getTestCase(CSVManager.getCSVRecord(testCasesLine));

                    if(i%50==0){
                        System.out.println("Generated dtrace for " + i + " test cases");
                    }
                    i++;

                    for(DeclsClass declsClass: declsFile.getClasses()) {
                        // The enter and exits belong to the same class
                        if(declsClass.getClassName().equalsIgnoreCase(testCase.getPath())){

                            // Get the correct declsExit by the responseCode
                            List<DeclsExit> declsExits = declsClass.getDeclsExits().stream()
                                    .filter(x-> x.getStatusCode().equalsIgnoreCase(testCase.getStatusCode()))
                                    .collect(Collectors.toList());

                            for(DeclsExit declsExit: declsExits) {
                                // Find the corresponding DeclsEnter according to the statusCode and nameSuffix
                                DeclsEnter declsEnter = declsClass.getDeclsEnters().stream()
                                        .filter(x-> x.getStatusCode().equals(declsExit.getStatusCode()) && x.getNameSuffix().equals(declsExit.getNameSuffix()))
                                        .findFirst().orElseThrow(() -> new NullPointerException("Could not find the corresponding DeclsEnter"));

                                // Write the test case in dtrace format the buffer
                                dtraceBuffer.write(declsExit.generateDtrace(testCase, declsEnter));

                            }

                        }

                    }

                }

                // Close the writer
                dtraceBuffer.close();

            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public static String getOperationName(Operation operation, Entry<HttpMethod, Operation> operationEntry, String operationEndpoint){

        String operationName;
        if (operation.getOperationId() == null) {
            String httpMethod = operationEntry.getKey().toString();
            operationName = operationEndpoint + HIERARCHY_SEPARATOR + httpMethod.toLowerCase();
        } else {
            operationName = operation.getOperationId();
        }

        return operationName;
    }

    private static OpenAPI getOpenAPISpecification(){

        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setResolveFully(true);
        parseOptions.setFlatten(true);

        // Store the parsed spec so circular-ref resolution can look up real schemas later
        openAPISpec = new OpenAPIV3Parser().read(openApiSpecPath, null, parseOptions);
        return openAPISpec;
    }

    // Exposes the parsed spec for circular-ref stub recovery
    public static OpenAPI getOpenAPISpec() {
        return openAPISpec;
    }

    /**
     * Resolves a circular-reference stub back to the real schema from the OAS components map.
     *
     * swagger-parser stubs preserve the $ref field (e.g. "#/components/schemas/Holiday") but NOT
     * the title. We extract the schema name from $ref as the primary identifier, falling back to
     * the title when $ref is absent. The components map holds the first fully-resolved version of
     * each schema, safe to use for one level of variable/ppt generation without further recursion.
     */
    public static Schema lookupRealSchema(Schema stub) {
        String schemaName = null;
        if (stub.get$ref() != null) {
            String ref = stub.get$ref();
            schemaName = ref.substring(ref.lastIndexOf('/') + 1);
        } else if (stub.getTitle() != null) {
            schemaName = stub.getTitle();
        }
        if (schemaName == null) {
            return null;
        }
        if (openAPISpec == null || openAPISpec.getComponents() == null
                || openAPISpec.getComponents().getSchemas() == null) {
            return null;
        }
        return openAPISpec.getComponents().getSchemas().get(schemaName);
    }

    public static void addNewDeclsClass(DeclsClass declsClass){
        declsClasses.add(declsClass);
    }

    public static List<DeclsClass> getAllDeclsClasses(){
        return declsClasses;
    }

    public static void deleteAllDeclsClasses(){
        declsClasses.clear();
    }

    private static String getOutputPath(String filename, String folder) {
        Path path = java.nio.file.Paths.get(folder);      // openApiSpecPath
        Path dir = path.getParent();
        Path fn = path.getFileSystem().getPath(filename);
        Path target = (dir == null) ? fn : dir.resolve(fn);

        return target.toString();
    }

}
