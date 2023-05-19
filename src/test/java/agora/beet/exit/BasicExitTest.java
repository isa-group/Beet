package agora.beet.exit;

import agora.beet.model.DeclsVariable;
import agora.beet.model.DeclsClass;
import agora.beet.model.DeclsExit;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.model.DeclsClass.setDeclsClassEnterAndExit;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Juan C. Alonso
 */
public class BasicExitTest {

    @Test
    public void testGenerationOfBasicExit() {

        deleteAllDeclsClasses();

        String oasPath = "src/test/resources/airportInfo/swagger_simplified.yaml";

        // Equivalent to the getOpenAPISpecification private function
        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setResolveFully(true);
        parseOptions.setFlatten(true);
        OpenAPI specification = new OpenAPIV3Parser().read(oasPath, null, parseOptions);

        Paths paths = specification.getPaths();

        for(Map.Entry<String, PathItem> path: paths.entrySet()) {
            PathItem pathItem = path.getValue();

            for (Map.Entry<PathItem.HttpMethod, Operation> operationEntry: pathItem.readOperationsMap().entrySet()) {

                Operation operation = operationEntry.getValue();
                String operationEndpoint = path.getKey();

                // Set the operation name for the .decls file
                String operationName = getOperationName(operation, operationEntry, operationEndpoint);

                // Extracting the input parameters
                String objectName = operationName + HIERARCHY_SEPARATOR + "Input";

                setDeclsClassEnterAndExit(operationEndpoint, operationName,
                        objectName, operation);

                List<DeclsClass> allDeclsClasses = getAllDeclsClasses();
                assertEquals("Incorrect number of classes", allDeclsClasses.size(), 1);

                DeclsClass declsClassEnterAndExit = allDeclsClasses.get(0);

                System.out.println(declsClassEnterAndExit);

                // CLASS
                assertEquals("Incorrect class name", operationEndpoint, declsClassEnterAndExit.getClassName());
                assertEquals("The size of the list of enters is not 1", 1, declsClassEnterAndExit.getDeclsEnters().size());
                assertEquals("The size of the list of exits is not 1", 1, declsClassEnterAndExit.getDeclsExits().size());


                // OBJECT (ONLY EXIT)
                DeclsExit declsExit = declsClassEnterAndExit.getDeclsExits().get(0);
                String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";

                assertEquals("Incorrect exit name", exitName, declsExit.getExitName());
                assertEquals("The exit number is not correct", numberOfExits, declsExit.getExitNumber() + 1);


                // VARIABLES
                // ENTER
                // Father
                DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "findAirports" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable.getEnclosedVariables().size());

                // Sons
                List<DeclsVariable> enterDeclsSonVariables = enterDeclsFatherVariable.getEnclosedVariables();
                DeclsVariable iataInput = enterDeclsSonVariables.get(0);
                assertEquals("Incorrect variable name", "input.iata", iataInput.getVariableName());
                assertEquals("Incorrect var-kind", "field iata", iataInput.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", iataInput.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", iataInput.getRepType());
                assertEquals("Incorrect enclosing var", "input", iataInput.getEnclosingVar());
                assertFalse("This variable should not be an array", iataInput.isArray());
                assertEquals("Unexpected number of son variables", 0, iataInput.getEnclosedVariables().size());

                DeclsVariable icaoInput = enterDeclsSonVariables.get(1);
                assertEquals("Incorrect variable name", "input.icao", icaoInput.getVariableName());
                assertEquals("Incorrect var-kind", "field icao", icaoInput.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", icaoInput.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", icaoInput.getRepType());
                assertEquals("Incorrect enclosing var", "input", icaoInput.getEnclosingVar());
                assertFalse("This variable should not be an array", icaoInput.isArray());
                assertEquals("Unexpected number of son variables", 0, icaoInput.getEnclosedVariables().size());

                // EXIT
                // Father
                DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "findAirports" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200", exitDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 6, exitDeclsFatherVariable.getEnclosedVariables().size());

                // Sons (id, iata, icao, name, version)
                List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();

                DeclsVariable id = declsSonVariables.get(0);
                assertEquals("Incorrect variable name", "return.id", id.getVariableName());
                assertEquals("Incorrect var-kind", "field id", id.getVarKind());
                assertEquals("Incorrect decType", "int", id.getDecType());
                assertEquals("Incorrect repType", "int", id.getRepType());
                assertEquals("Incorrect enclosing var", "return", id.getEnclosingVar());
                assertFalse("This variable should not be an array", id.isArray());
                assertEquals("Unexpected number of son variables", 0, id.getEnclosedVariables().size());

                DeclsVariable iataOutput = declsSonVariables.get(1);
                assertEquals("Incorrect variable name", "return.iata", iataOutput.getVariableName());
                assertEquals("Incorrect var-kind", "field iata", iataOutput.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", iataOutput.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", iataOutput.getRepType());
                assertEquals("Incorrect enclosing var", "return", iataOutput.getEnclosingVar());
                assertFalse("This variable should not be an array", iataOutput.isArray());
                assertEquals("Unexpected number of son variables", 0, iataOutput.getEnclosedVariables().size());

                DeclsVariable icaoOutput = declsSonVariables.get(2);
                assertEquals("Incorrect variable name", "return.icao", icaoOutput.getVariableName());
                assertEquals("Incorrect var-kind", "field icao", icaoOutput.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", icaoOutput.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", icaoOutput.getRepType());
                assertEquals("Incorrect enclosing var", "return", icaoOutput.getEnclosingVar());
                assertFalse("This variable should not be an array", icaoOutput.isArray());
                assertEquals("Unexpected number of son variables", 0, icaoOutput.getEnclosedVariables().size());

                DeclsVariable name = declsSonVariables.get(3);
                assertEquals("Incorrect variable name", "return.name", name.getVariableName());
                assertEquals("Incorrect var-kind", "field name", name.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", name.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", name.getRepType());
                assertEquals("Incorrect enclosing var", "return", name.getEnclosingVar());
                assertFalse("This variable should not be an array", name.isArray());
                assertEquals("Unexpected number of son variables", 0, name.getEnclosedVariables().size());

                DeclsVariable version = declsSonVariables.get(4);
                assertEquals("Incorrect variable name", "return.version", version.getVariableName());
                assertEquals("Incorrect var-kind", "field version", version.getVarKind());
                assertEquals("Incorrect decType", "double", version.getDecType());
                assertEquals("Incorrect repType", "double", version.getRepType());
                assertEquals("Incorrect enclosing var", "return", version.getEnclosingVar());
                assertFalse("This variable should not be an array", version.isArray());
                assertEquals("Unexpected number of son variables", 0, version.getEnclosedVariables().size());

                // Variable with special character (.)
                DeclsVariable latLng = declsSonVariables.get(5);
                assertEquals("Incorrect variable name", "return.lat&lng", latLng.getVariableName());
                assertEquals("Incorrect var-kind", "field lat&lng", latLng.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", latLng.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", latLng.getRepType());
                assertEquals("Incorrect enclosing var", "return", latLng.getEnclosingVar());
                assertFalse("This variable should not be an array", latLng.isArray());
                assertEquals("Unexpected number of son variables", 0, latLng.getEnclosedVariables().size());


            }


        }


    }

}
