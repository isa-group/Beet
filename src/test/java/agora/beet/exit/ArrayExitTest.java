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
public class ArrayExitTest {

    @Test
    public void testGenerationOfArrayExit() {
        deleteAllDeclsClasses();

        String oasPath = "src/test/resources/RestCountries/swagger.yaml";

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
                assertEquals("The size of the list of enters is not 1", 2, declsClassEnterAndExit.getDeclsEnters().size());
                assertEquals("The size of the list of exits is not 1", 2, declsClassEnterAndExit.getDeclsExits().size());

                // OBJECT (ONLY EXIT)
                // EXIT 1
                DeclsExit declsExit1 = declsClassEnterAndExit.getDeclsExits().get(0);
                String exitName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200" + ARRAY_NESTING_SEPARATOR + "array()";
                assertEquals("Incorrect exit name", exitName1, declsExit1.getExitName());

                // VARIABLES
                // ENTER
                // Only the Father
                DeclsVariable enterDeclsFatherVariable1 = declsExit1.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable1.getEnclosedVariables().size());

                // EXIT
                // Father
                DeclsVariable exitDeclsFatherVariable1 = declsExit1.getExitDeclsVariables();
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200" + ARRAY_NESTING_SEPARATOR + "array", exitDeclsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable1.isArray());

                // The array is counted twice (normal and [..])
                assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable1.getEnclosedVariables().size());

                List<DeclsVariable> declsSonVariables1 = exitDeclsFatherVariable1.getEnclosedVariables();

                // Array type with another nested object
                DeclsVariable array1 = declsSonVariables1.get(0);
                assertEquals("Incorrect variable name", "return.array",  array1.getVariableName());
                assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                assertEquals("Incorrect decType",  "array[]", array1.getDecType());
                assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                assertFalse("This variable should not be an array", array1.isArray());
                assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

                DeclsVariable array2 = declsSonVariables1.get(1);
                assertEquals("Incorrect variable name", "return.array[..]",  array2.getVariableName());
                assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                assertEquals("Incorrect decType",  "array[]", array2.getDecType());
                assertEquals("Incorrect repType", "hashcode[]", array2.getRepType());
                assertEquals("Incorrect enclosing var", "return.array", array2.getEnclosingVar());
                assertTrue("This variable should be an array", array2.isArray());
                assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

                // EXIT 2
                DeclsExit declsExit2 = declsClassEnterAndExit.getDeclsExits().get(1);
                String exitName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";
                assertEquals("Incorrect exit name", exitName2, declsExit2.getExitName());

                // VARIABLES
                // ENTER
                // Only the Father
                DeclsVariable enterDeclsFatherVariable2 = declsExit2.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable2.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable2.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable2.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable2.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable2.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable2.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable2.getEnclosedVariables().size());

                // EXIT
                // Only the Father
                DeclsVariable exitDeclsFatherVariable2 = declsExit2.getExitDeclsVariables();

                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable2.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable2.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200", exitDeclsFatherVariable2.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable2.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable2.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable2.isArray());
                assertEquals("Unexpected number of son variables", 29, exitDeclsFatherVariable2.getEnclosedVariables().size());

            }

        }

    }
}
