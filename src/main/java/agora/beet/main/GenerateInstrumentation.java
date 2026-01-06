package agora.beet.main;

import agora.beet.model.DeclsFile;
import agora.beet.model.DeclsClass;
import agora.beet.model.DeclsEnter;
import agora.beet.model.DeclsExit;
import agora.beet.model.TestCase;
import agora.beet.model.Comparability;
import agora.beet.model.harFiles.HttpEntry;
import agora.beet.util.CSVManager;
import agora.beet.util.FileManager;
import agora.beet.util.TestCaseFileManager;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;


import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import static agora.beet.dtrace.DtraceFileWriter.generateDtraceFile;
import static agora.beet.dtrace.DtraceFileWriter.generateDtraceFromHar;

/**
 * @author Juan C. Alonso
 */
public class GenerateInstrumentation {

    private static String openApiSpecPath = "src/test/resources/har_examples/yelp/oas.yaml";
    private static String testCasesFilePath = "src/test/resources/har_examples/yelp/yelp.har";
    private static boolean generateDtrace = true;
    public static String[] stringsToConsiderAsNull = {};


    public static String HIERARCHY_SEPARATOR = "&";
    public static String ARRAY_NESTING_SEPARATOR = "%";
    public static int bufferSize = 20;

    public static int numberOfExits = 1;

    private static List<DeclsClass> declsClasses = new ArrayList<>();

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

        // Generate data trace file
        if(generateDtrace){
            generateDtraceFile(testCasesFilePath, declsFile, specification);
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

        return new OpenAPIV3Parser().read(openApiSpecPath, null, parseOptions);
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

    public static String getOutputPath(String filename, String folder) {
        Path path = java.nio.file.Paths.get(folder);      // openApiSpecPath
        Path dir = path.getParent();
        Path fn = path.getFileSystem().getPath(filename);
        Path target = (dir == null) ? fn : dir.resolve(fn);

        return target.toString();
    }

}
