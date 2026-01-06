package agora.beet.dtrace;

import agora.beet.model.DeclsFile;
import agora.beet.model.TestCase;
import agora.beet.model.DeclsClass;
import agora.beet.model.DeclsEnter;
import agora.beet.model.DeclsExit;
import agora.beet.model.harFiles.HttpEntry;
import agora.beet.util.CSVManager;
import agora.beet.util.FileManager;
import agora.beet.util.TestCaseFileManager;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import io.swagger.v3.oas.models.OpenAPI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.List;

import static agora.beet.main.GenerateInstrumentation.bufferSize;
import static agora.beet.main.GenerateInstrumentation.getOutputPath;

/**
 *
 * @author Juan C. Alonso
 */
public class DtraceFileWriter {

    public static void generateDtraceFile(String testCasesFilePath, DeclsFile declsFile, OpenAPI specification) {

        String dtraceFilePath = getOutputPath("dtraceFile.dtrace", testCasesFilePath);      // openApiSpecPath testCasesFilePath
        FileManager.deleteFile(dtraceFilePath);     // Delete file if exists

        if (testCasesFilePath.endsWith(".csv")) {
            generateDtraceFromCSV(testCasesFilePath, dtraceFilePath, declsFile);
        } else if(testCasesFilePath.endsWith(".har") ||  testCasesFilePath.endsWith(".json")) {
            generateDtraceFromHar(testCasesFilePath, dtraceFilePath, declsFile, specification);
        } else {
            throw new IllegalArgumentException("Unsupported file format for test cases file path. Supported values: .csv, .har, .json");
        }

    }

    public static void generateDtraceFromCSV(String testCasesFilePath, String dtraceFilePath, DeclsFile declsFile) {
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

            int i = 0;
            while((testCasesLine = testCasesBR.readLine()) != null) {
                TestCase testCase = testCaseFileManager.getTestCase(CSVManager.getCSVRecord(testCasesLine));

                if(i%50==0){
                    System.out.println("Generated dtrace for " + i + " test cases");
                }
                i++;

                writeDtraceSingleTestCase(testCase, declsFile, dtraceBuffer);

            }

            // Close the writer
            dtraceBuffer.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void generateDtraceFromHar(String testCasesFilePath, String dtraceFilePath, DeclsFile declsFile, OpenAPI specification) {
        try {
            // Read test cases
            JsonReader reader = new JsonReader(new FileReader(testCasesFilePath));
            reader.beginObject();

            Gson gson = new Gson();

            int i = 0;
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("log")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        if (name.equals("entries")) {
                            // Stream Http requests
                            FileWriter dtraceFile = new FileWriter(dtraceFilePath);
                            BufferedWriter dtraceBuffer = new BufferedWriter(dtraceFile,bufferSize*1024);
                            reader.beginArray();
                            while (reader.hasNext()) {

                                // Convert HttpEntry to TestCase
                                HttpEntry httpEntry = gson.fromJson(reader, HttpEntry.class);
                                TestCase testCase = new TestCase(httpEntry, specification);

                                if(i%50==0){
                                    System.out.println("Generated dtrace for " + i + " test cases");
                                }
                                i++;

                                writeDtraceSingleTestCase(testCase, declsFile, dtraceBuffer);

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

    private static void writeDtraceSingleTestCase(TestCase testCase, DeclsFile declsFile, BufferedWriter dtraceBuffer) {
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
            try {
                dtraceBuffer.write(declsExit.generateDtrace(testCase, declsEnter));
            } catch (IOException e) {
                System.err.println("I/O error while reading test cases file");
                e.printStackTrace();
            }
        }
    }

}
