package agora.beet.print;

import agora.beet.main.GenerateInstrumentation;
import agora.beet.model.*;
import agora.beet.util.CSVManager;
import agora.beet.util.TestCaseFileManager;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Juan C. Alonso
 */
public class SimpleDtraceFileTest {

    @Test
    public void testPrintSimpleDtraceFile() {
        GenerateInstrumentation.deleteAllDeclsClasses();
        GenerateInstrumentation.numberOfExits = 1;

        GenerateInstrumentation.deleteAllDeclsClasses();

        String oasPath = "src/main/resources/AirportInfo/OpenAPISpec.yaml";
        String testCasesFilePath = "src/test/resources/airportInfo/testCases_simplified.csv";

        // Equivalent to the getOpenAPISpecification private function
        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setResolveFully(true);
        parseOptions.setFlatten(true);
        OpenAPI specification = new OpenAPIV3Parser().read(oasPath, null, parseOptions);

        Paths paths = specification.getPaths();

        // Get the Declaration file
        for(Map.Entry<String, PathItem> path: paths.entrySet()) {

            PathItem pathItem = path.getValue();

            for (Map.Entry<PathItem.HttpMethod, Operation> operationEntry: pathItem.readOperationsMap().entrySet()) {
                Operation operation = operationEntry.getValue();
                String operationEndpoint = path.getKey();

                // Set the operation name for the .decls file
                String operationName = GenerateInstrumentation.getOperationName(operation, operationEntry, operationEndpoint);

                // Extracting the input parameters
                String objectName = operationName + GenerateInstrumentation.HIERARCHY_SEPARATOR + "Input";

                // Extracting enter and exits
                DeclsClass.setDeclsClassEnterAndExit(operationEndpoint, operationName,
                        objectName, operation);

            }

        }

        DeclsFile declsFile = new DeclsFile(2.0, Comparability.implicit, GenerateInstrumentation.getAllDeclsClasses());

        try {
            // Generate dTrace file
            // Read test cases
            File testCasesFile = new File(testCasesFilePath);
            FileReader testCasesFileReader = new FileReader(testCasesFile);
            BufferedReader testCasesBR = new BufferedReader(testCasesFileReader);
            String testCasesLine = "";

            // The first line must be the header
            String header = testCasesBR.readLine();
            if (header == null) {
                throw new NullPointerException("The csv file containing the test cases is empty");
            }

            TestCaseFileManager testCaseFileManager = new TestCaseFileManager(header);

            while((testCasesLine = testCasesBR.readLine()) != null) {
                TestCase testCase = testCaseFileManager.getTestCase(CSVManager.getCSVRecord(testCasesLine));
                for(DeclsClass declsClass: declsFile.getClasses()) {
                    // The enter and exits belong to the same class
                    if(declsClass.getClassName().equalsIgnoreCase(testCase.getPath())){
                        DeclsEnter declsEnter = declsClass.getDeclsEnters().get(0);

                        // Checks in ENTER
                        String[] enterDtraceLines = declsEnter.generateDtrace(testCase).split("\n");
                        Assert.assertEquals("Incorrect enter name", "/airport" + GenerateInstrumentation.HIERARCHY_SEPARATOR + "findAirports" + GenerateInstrumentation.HIERARCHY_SEPARATOR + "200():::ENTER", enterDtraceLines[0]);
                        assertEquals("Incorrect wrapper name", "input", enterDtraceLines[1]);
                        assertTrue(enterDtraceLines[2].matches("^\\d+$"));
                        assertEquals("Incorrect end of trace", "1", enterDtraceLines[3]);

                        // iata
                        assertEquals("Incorrect variable name", "input.iata", enterDtraceLines[4]);
                        assertEquals("Incorrect variable value", "\"BCS\"", enterDtraceLines[5]);
                        assertEquals("Incorrect end of trace", "1", enterDtraceLines[6]);

                        // icao
                        assertEquals("Incorrect variable name", "input.icao", enterDtraceLines[7]);
                        assertEquals("Incorrect variable value", "null", enterDtraceLines[8]);
                        assertEquals("Incorrect end of trace", "1", enterDtraceLines[9]);


                        // Get the correct declsExit by the responseCode
                        DeclsExit declsExit = declsClass.getDeclsExits().stream().filter(x->x.getStatusCode().equalsIgnoreCase(testCase.getStatusCode())).findFirst()
                                .orElseThrow(() -> new NullPointerException("Type of response not found in the specification"));


                        // Checks in EXIT
                        // INPUT
                        System.out.println(declsExit.generateDtrace(testCase, declsEnter));
                        String[] exitDtraceLines = declsExit.generateDtrace(testCase, declsEnter).split("\n");

                        // Checks in ENTER
                        Assert.assertEquals("Incorrect enter name", "/airport" + GenerateInstrumentation.HIERARCHY_SEPARATOR + "findAirports" + GenerateInstrumentation.HIERARCHY_SEPARATOR + "200():::ENTER", exitDtraceLines[0]);
                        assertEquals("Incorrect wrapper name", "input", exitDtraceLines[1]);
                        assertTrue(exitDtraceLines[2].matches("^\\d+$"));
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[3]);

                        // iata
                        assertEquals("Incorrect variable name", "input.iata", exitDtraceLines[4]);
                        assertEquals("Incorrect variable value", "\"BCS\"", exitDtraceLines[5]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[6]);

                        // icao
                        assertEquals("Incorrect variable name", "input.icao", exitDtraceLines[7]);
                        assertEquals("Incorrect variable value", "null", exitDtraceLines[8]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[9]);


                        Assert.assertEquals("Incorrect exit name", "/airport" + GenerateInstrumentation.HIERARCHY_SEPARATOR + "findAirports" + GenerateInstrumentation.HIERARCHY_SEPARATOR + "200():::EXIT1", exitDtraceLines[11]);
                        assertEquals("Incorrect wrapper name", "input", exitDtraceLines[12]);
                        assertTrue(exitDtraceLines[13].matches("^\\d+$"));
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[14]);

                        // iata
                        assertEquals("Incorrect variable name", "input.iata", exitDtraceLines[15]);
                        assertEquals("Incorrect variable value", "\"BCS\"", exitDtraceLines[16]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[17]);

                        // icao
                        assertEquals("Incorrect variable name", "input.icao", exitDtraceLines[18]);
                        assertEquals("Incorrect variable value", "null", exitDtraceLines[19]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[20]);

                        // RETURN
                        assertEquals("Incorrect wrapper name", "return", exitDtraceLines[21]);
                        assertTrue(exitDtraceLines[22].matches("^\\d+$"));
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[23]);

                        // id
                        assertEquals("Incorrect variable name", "return.id", exitDtraceLines[24]);
                        assertEquals("Incorrect variable value", "588", exitDtraceLines[25]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[26]);

                        // iata
                        assertEquals("Incorrect variable name", "return.iata", exitDtraceLines[27]);
                        assertEquals("Incorrect variable value", "\"BCS\"", exitDtraceLines[28]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[29]);

                        // icao
                        assertEquals("Incorrect variable name", "return.icao", exitDtraceLines[30]);
                        assertEquals("Incorrect variable value", "\"\"", exitDtraceLines[31]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[32]);

                        // name
                        assertEquals("Incorrect variable name", "return.name", exitDtraceLines[33]);
                        assertEquals("Incorrect variable value", "\"Southern Seaplane Airport (FAA: 65LA)\"", exitDtraceLines[34]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[35]);

                        // location
                        assertEquals("Incorrect variable name", "return.location", exitDtraceLines[36]);
                        assertEquals("Incorrect variable value", "\"Belle Chasse, Louisiana, United States\"", exitDtraceLines[37]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[38]);

                        // street_number
                        assertEquals("Incorrect variable name", "return.street_number", exitDtraceLines[39]);
                        assertEquals("Incorrect variable value", "\"1\"", exitDtraceLines[40]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[41]);

                        // street
                        assertEquals("Incorrect variable name", "return.street", exitDtraceLines[42]);
                        assertEquals("Incorrect variable value", "\"Coquille Road\"", exitDtraceLines[43]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[44]);

                        // city
                        assertEquals("Incorrect variable name", "return.city", exitDtraceLines[45]);
                        assertEquals("Incorrect variable value", "\"Belle Chasse\"", exitDtraceLines[46]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[47]);

                        // county
                        assertEquals("Incorrect variable name", "return.county", exitDtraceLines[48]);
                        assertEquals("Incorrect variable value", "\"Plaquemines Parish\"", exitDtraceLines[49]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[50]);

                        // state
                        assertEquals("Incorrect variable name", "return.state", exitDtraceLines[51]);
                        assertEquals("Incorrect variable value", "\"Louisiana\"", exitDtraceLines[52]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[53]);

                        // country_iso
                        assertEquals("Incorrect variable name", "return.country_iso", exitDtraceLines[54]);
                        assertEquals("Incorrect variable value", "\"US\"", exitDtraceLines[55]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[56]);

                        // country
                        assertEquals("Incorrect variable name", "return.country", exitDtraceLines[57]);
                        assertEquals("Incorrect variable value", "\"United States\"", exitDtraceLines[58]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[59]);

                        // postal_code
                        assertEquals("Incorrect variable name", "return.postal_code", exitDtraceLines[60]);
                        assertEquals("Incorrect variable value", "\"70037\"", exitDtraceLines[61]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[62]);

                        // phone
                        assertEquals("Incorrect variable name", "return.phone", exitDtraceLines[63]);
                        assertEquals("Incorrect variable value", "\"+1 504-394-5633\"", exitDtraceLines[64]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[65]);

                        // latitude
                        assertEquals("Incorrect variable name", "return.latitude", exitDtraceLines[66]);
                        assertEquals("Incorrect variable value", "29.866688", exitDtraceLines[67]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[68]);

                        // longitude
                        assertEquals("Incorrect variable name", "return.longitude", exitDtraceLines[69]);
                        assertEquals("Incorrect variable value", "-90.020775", exitDtraceLines[70]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[71]);

                        // uct
                        assertEquals("Incorrect variable name", "return.uct", exitDtraceLines[72]);
                        assertEquals("Incorrect variable value", "-300", exitDtraceLines[73]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[74]);

                        // website
                        assertEquals("Incorrect variable name", "return.website", exitDtraceLines[75]);
                        assertEquals("Incorrect variable value", "\"http://www.southernseaplane.com/\"", exitDtraceLines[76]);
                        assertEquals("Incorrect end of trace", "1", exitDtraceLines[77]);

                    }

                }

            }

        } catch(IOException e){
            e.printStackTrace();
        }



    }

}
