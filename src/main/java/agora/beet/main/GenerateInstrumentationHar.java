package agora.beet.main;

import agora.beet.model.*;
import agora.beet.model.harFiles.HttpEntry;
import agora.beet.util.CSVManager;
import agora.beet.util.FileManager;
import agora.beet.util.TestCaseFileManager;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static agora.beet.main.GenerateInstrumentation.*;

/**
 * @author Juan C. Alonso
 */
public class GenerateInstrumentationHar {

    private static String openApiSpecPath = "src/test/resources/har_examples/oas.yaml";
    private static String testCasesFilePath = "src/test/resources/har_examples/yelp.har";
    private static boolean generateDtrace = true;

    private static List<DeclsClass> declsClasses = new ArrayList<>();


    // TODO: Relocate
    private static final Gson GSON = new Gson();


    public static void main(String[] args) {
        declsClasses = new ArrayList<>();
        numberOfExits = 1;

        // TODO: ARGS

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
                JsonReader reader = new JsonReader(new FileReader(testCasesFilePath));
                reader.beginObject();

                while (reader.hasNext()) {
                    String name = reader.nextName();
                    if (name.equals("log")) {
                        reader.beginObject();
                        while (reader.hasNext()) {
                            name = reader.nextName();
                            if (name.equals("entries")) {
                                // TODO: Convert into separate function
                                // Stream Http requests
                                FileWriter dtraceFile = new FileWriter(dtraceFilePath);
                                BufferedWriter dtraceBuffer = new BufferedWriter(dtraceFile,bufferSize*1024);
                                reader.beginArray();
                                while (reader.hasNext()) {

                                    // Convert HttpEntry to TestCase
                                    HttpEntry httpEntry = GSON.fromJson(reader, HttpEntry.class);
                                    // TODO: Path parameters and operation id are not set yet, they require OAS
                                    TestCase testCase = new TestCase(httpEntry, specification);

                                    if(i%50==0){
                                        System.out.println("Generated dtrace for " + i + " test cases");
                                    }
                                    i++;

                                    // TODO: Use this same method on the original GenerateInstrumentation.java file
                                    // The enters and exits belong to the same class
                                    DeclsClass declsClass = declsFile.getClasses().stream()
                                            .filter(x-> x.getClassName().equalsIgnoreCase(testCase.getPath()))
                                            .findFirst()
                                            .orElseThrow(() -> new NullPointerException("No declsClass found for test case with path: " + testCase.getPath() + " and operation id: " + testCase.getOperationId()));

                                    // Get the correct declsExit by the responseCode
                                    // TODO: Consider HTTP method too (both here and in the original)
                                    List<DeclsExit> declsExits = declsClass.getDeclsExits().stream()
                                            .filter(x-> x.getStatusCode().equalsIgnoreCase(testCase.getStatusCode()))
                                            .toList();

                                    for (DeclsExit declsExit: declsExits) {
                                        // Find the corresponding DeclsEnter according to the statusCode and nameSuffix
                                        DeclsEnter declsEnter = declsClass.getDeclsEnters().stream()
                                                .filter(x-> x.getStatusCode().equals(declsExit.getStatusCode()) && x.getNameSuffix().equals(declsExit.getNameSuffix()))
                                                .findFirst().orElseThrow(() -> new NullPointerException("Could not find the corresponding DeclsEnter"));

                                        // Write the test case in dtrace format
                                        dtraceBuffer.write(declsExit.generateDtrace(testCase, declsEnter));
                                    }


                                }
                                // Close the writer
                                dtraceBuffer.close();
                                // Stop iterating over the array (equivalent to bufferedReader)
                                reader.endArray();
                            } else {
                                reader.skipValue();
                            }
                        }

                    } else {
                        reader.skipValue();
                    }

                }

                reader.endObject();

            } catch (FileNotFoundException e) {
                System.err.println("JSON file not found" + testCasesFilePath);
                e.printStackTrace();
            } catch (MalformedJsonException e) {
                System.err.println("Malformed JSON in file: " + testCasesFilePath);
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("I/O error while reading JSON file: " + testCasesFilePath);
                e.printStackTrace();
            }

        }

    }

    // TODO: DUPLICATED
    private static OpenAPI getOpenAPISpecification(){

        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setResolveFully(true);
        parseOptions.setFlatten(true);

        return new OpenAPIV3Parser().read(openApiSpecPath, null, parseOptions);
    }

    // TODO: DUPLICATED
    private static String getOutputPath(String filename, String folder) {
        Path path = java.nio.file.Paths.get(folder);      // openApiSpecPath
        Path dir = path.getParent();
        Path fn = path.getFileSystem().getPath(filename);
        Path target = (dir == null) ? fn : dir.resolve(fn);

        return target.toString();
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

}
