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
public class NestedArraysPrimitiveExitTest {

    @Test
    public void testGenerationOfNestedArraysPrimitiveExit() {
        deleteAllDeclsClasses();

        String oasPath = "src/test/resources/sampleAPI/swagger_nestedArraysPrimitive.yaml";

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
                assertEquals("The size of the list of enters is not 3", 3, declsClassEnterAndExit.getDeclsEnters().size());
                assertEquals("The size of the list of exits is not 3", 3, declsClassEnterAndExit.getDeclsExits().size());

                // OBJECT (ONLY EXIT)
                List<DeclsExit> declsExitList = declsClassEnterAndExit.getDeclsExits();
                DeclsExit declsExit1 = declsExitList.get(0);
                String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";
                assertEquals("Incorrect exit name", exitName, declsExit1.getExitName());

                // VARIABLES
                // ENTER
                // Only Father
                DeclsVariable enterDeclsFatherVariable1 = declsExit1.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "sampleEndpointId" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable1.getEnclosedVariables().size());

                // EXIT
                DeclsVariable exitDeclsFatherVariable1 = declsExit1.getExitDeclsVariables();

                // Father
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "sampleEndpointId" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200", exitDeclsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable1.getEnclosedVariables().size());

                // Sons (array)
                List<DeclsVariable> declsSonVariables1 = exitDeclsFatherVariable1.getEnclosedVariables();

                DeclsVariable location1 = declsSonVariables1.get(0);
                assertEquals("Incorrect variable name", "return.locations", location1.getVariableName());
                assertEquals("Incorrect var-kind", "field locations", location1.getVarKind());
                assertEquals("Incorrect decType", "locations[]", location1.getDecType());
                assertEquals("Incorrect repType", "hashcode", location1.getRepType());
                assertEquals("Incorrect enclosing var", "return", location1.getEnclosingVar());
                assertFalse("This variable should not be an array", location1.isArray());
                assertEquals("Unexpected number of son variables", 0, location1.getEnclosedVariables().size());

                DeclsVariable location2 = declsSonVariables1.get(1);
                assertEquals("Incorrect variable name", "return.locations[..]", location2.getVariableName());
                assertEquals("Incorrect var-kind", "array", location2.getVarKind());
                assertEquals("Incorrect decType", "locations[]", location2.getDecType());
                assertEquals("Incorrect repType", "hashcode[]", location2.getRepType());
                assertEquals("Incorrect enclosing var", "return.locations", location2.getEnclosingVar());
                assertTrue("This variable should be an array", location2.isArray());
                assertEquals("Unexpected number of son variables", 0, location2.getEnclosedVariables().size());


                // SECOND EXIT
                DeclsExit declsExit2 = declsExitList.get(1);
                exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200"
                        + HIERARCHY_SEPARATOR + "locations" + ARRAY_NESTING_SEPARATOR + "array" + ARRAY_NESTING_SEPARATOR + "array()";
                assertEquals("Incorrect exit name", exitName, declsExit2.getExitName());

                // EXIT
                DeclsVariable exitDeclsFatherVariable2 = declsExit2.getExitDeclsVariables();

                // Father
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable2.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable2.getVarKind());
                assertEquals("Incorrect decType", "sampleEndpointId"+HIERARCHY_SEPARATOR+"Output"+HIERARCHY_SEPARATOR+"200"+HIERARCHY_SEPARATOR+"locations" + ARRAY_NESTING_SEPARATOR + "array" + ARRAY_NESTING_SEPARATOR + "array", exitDeclsFatherVariable2.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable2.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable2.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable2.isArray());
                assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable2.getEnclosedVariables().size());

                // Sons (array)
                List<DeclsVariable> declsSonVariables2 = exitDeclsFatherVariable2.getEnclosedVariables();

                DeclsVariable array1 = declsSonVariables2.get(0);
                assertEquals("Incorrect variable name", "return.array", array1.getVariableName());
                assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                assertEquals("Incorrect decType", "double[]", array1.getDecType());
                assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                assertFalse("This variable should not be an array", array1.isArray());
                assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

                DeclsVariable array2 = declsSonVariables2.get(1);
                assertEquals("Incorrect variable name", "return.array[..]", array2.getVariableName());
                assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                assertEquals("Incorrect decType", "double[]", array2.getDecType());
                assertEquals("Incorrect repType", "double[]", array2.getRepType());
                assertEquals("Incorrect enclosing var", "return.array", array2.getEnclosingVar());
                assertTrue("This variable should be an array", array2.isArray());
                assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());


                // THIRD EXIT
                DeclsExit declsExit3 = declsExitList.get(2);
                exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR +"200"+
                        HIERARCHY_SEPARATOR+"locations" + ARRAY_NESTING_SEPARATOR + "array()";
                assertEquals("Incorrect exit name", exitName, declsExit3.getExitName());

                // EXIT
                DeclsVariable exitDeclsFatherVariable3 = declsExit3.getExitDeclsVariables();

                // Father
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable3.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable3.getVarKind());
                assertEquals("Incorrect decType", "sampleEndpointId" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200" + HIERARCHY_SEPARATOR + "locations" + ARRAY_NESTING_SEPARATOR + "array", exitDeclsFatherVariable3.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable3.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable3.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable3.isArray());
                assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable3.getEnclosedVariables().size());

                // Sons (array)
                List<DeclsVariable> declsSonVariables3 = exitDeclsFatherVariable3.getEnclosedVariables();

                array1 = declsSonVariables3.get(0);
                assertEquals("Incorrect variable name", "return.array", array1.getVariableName());
                assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                assertEquals("Incorrect decType", "array[]", array1.getDecType());
                assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                assertFalse("This variable should not be an array", array1.isArray());
                assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

                array2 = declsSonVariables3.get(1);
                assertEquals("Incorrect variable name", "return.array[..]", array2.getVariableName());
                assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                assertEquals("Incorrect decType", "array[]", array2.getDecType());
                assertEquals("Incorrect repType", "hashcode[]", array2.getRepType());
                assertEquals("Incorrect enclosing var", "return.array", array2.getEnclosingVar());
                assertTrue("This variable should be an array", array2.isArray());
                assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

            }


        }


    }
}
