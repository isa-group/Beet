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
public class NestedArraysResponseExit {

    // Nested array of objects
    @Test
    public void testNestedArraysOfObjectsResponseExit() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/RestCountries/swagger_nestedArraysResponse.yaml";

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
                assertEquals("The size of the list of enters is not 4", 4, declsClassEnterAndExit.getDeclsEnters().size());
                assertEquals("The size of the list of exits is not 4", 4, declsClassEnterAndExit.getDeclsExits().size());

                List<DeclsExit> declsExits = declsClassEnterAndExit.getDeclsExits();

                for(int i = 0; i < 3; i++) {
                    String repeatedArray = new String(new char[i+1]).replace("\0", ARRAY_NESTING_SEPARATOR + "array");
                    String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200" +
                            repeatedArray + "()";

                    DeclsExit declsExit = declsExits.get(i);
                    assertEquals("Incorrect exit name", exitName, declsExit.getExitName());

                    // VARIABLES
                    // ENTER
                    // Only the father
                    DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                    assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable.getEnclosedVariables().size());

                    // EXIT
                    DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                    // Father
                    assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200" + repeatedArray, exitDeclsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable.getEnclosedVariables().size());

                    // Sons (array)
                    List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();

                    DeclsVariable array1 = declsSonVariables.get(0);
                    assertEquals("Incorrect variable name", "return.array", array1.getVariableName());
                    assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                    assertEquals("Incorrect decType", "array[]", array1.getDecType());
                    assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                    assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                    assertFalse("This variable should not be an array", array1.isArray());
                    assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

                    DeclsVariable array2 = declsSonVariables.get(1);
                    assertEquals("Incorrect variable name", "return.array[..]", array2.getVariableName());
                    assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                    assertEquals("Incorrect decType", "array[]", array2.getDecType());
                    assertEquals("Incorrect repType", "hashcode[]", array2.getRepType());
                    assertEquals("Incorrect enclosing var", "return.array", array2.getEnclosingVar());
                    assertTrue("This variable should be an array", array2.isArray());
                    assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

                }

                DeclsExit declsExit = declsExits.get(3);

                String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";
                assertEquals("Incorrect exit name", exitName, declsExit.getExitName());

                // VARIABLES
                // ENTER
                // Only the father
                DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable.getEnclosedVariables().size());

                // EXIT
                DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                // Father
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200", exitDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 30, exitDeclsFatherVariable.getEnclosedVariables().size());

                // Sons
                List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();
                DeclsVariable name = declsSonVariables.get(0);
                assertEquals("Incorrect variable name", "return.name", name.getVariableName());
                assertEquals("Incorrect var-kind", "field name", name.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", name.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", name.getRepType());
                assertEquals("Incorrect enclosing var", "return", name.getEnclosingVar());
                assertFalse("This variable should not be an array", name.isArray());
                assertEquals("Unexpected number of son variables", 0, name.getEnclosedVariables().size());

                // Variable with special characters
                DeclsVariable countryId = declsSonVariables.get(1);
                assertEquals("Incorrect variable name", "return.country&id", countryId.getVariableName());
                assertEquals("Incorrect var-kind", "field country&id", countryId.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", countryId.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", countryId.getRepType());
                assertEquals("Incorrect enclosing var", "return", countryId.getEnclosingVar());
                assertFalse("This variable should not be an array", countryId.isArray());
                assertEquals("Unexpected number of son variables", 0, countryId.getEnclosedVariables().size());

            }

        }

    }

    // Nested array of primitives
    @Test
    public void testNestedArraysOfPrimitivesResponseExit() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/RestCountries/swagger_nestedArraysResponse_primitive.yaml";

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

                List<DeclsExit> declsExits = declsClassEnterAndExit.getDeclsExits();

                for(int i = 0; i < 2; i++) {
                    String repeatedArray = new String(new char[i+1]).replace("\0", ARRAY_NESTING_SEPARATOR + "array");
                    String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200" +
                            repeatedArray + "()";

                    DeclsExit declsExit = declsExits.get(i);
                    assertEquals("Incorrect exit name", exitName, declsExit.getExitName());

                    // VARIABLES
                    // ENTER
                    // Only the father
                    DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                    assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable.getEnclosedVariables().size());

                    // EXIT
                    DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                    // Father
                    assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200" + repeatedArray, exitDeclsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable.getEnclosedVariables().size());

                    // Sons (array)
                    List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();

                    DeclsVariable array1 = declsSonVariables.get(0);
                    assertEquals("Incorrect variable name", "return.array", array1.getVariableName());
                    assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                    assertEquals("Incorrect decType", "array[]", array1.getDecType());
                    assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                    assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                    assertFalse("This variable should not be an array", array1.isArray());
                    assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

                    DeclsVariable array2 = declsSonVariables.get(1);
                    assertEquals("Incorrect variable name", "return.array[..]", array2.getVariableName());
                    assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                    assertEquals("Incorrect decType", "array[]", array2.getDecType());
                    assertEquals("Incorrect repType", "hashcode[]", array2.getRepType());
                    assertEquals("Incorrect enclosing var", "return.array", array2.getEnclosingVar());
                    assertTrue("This variable should be an array", array2.isArray());
                    assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

                }

                DeclsExit declsExit = declsExits.get(2);

                String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR +
                        "200" + ARRAY_NESTING_SEPARATOR + "array" + ARRAY_NESTING_SEPARATOR + "array" + ARRAY_NESTING_SEPARATOR + "array()";
                assertEquals("Incorrect exit name", exitName, declsExit.getExitName());

                // VARIABLES
                // ENTER
                // Only the father
                DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable.getEnclosedVariables().size());

                // EXIT
                DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                // Father
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" +
                        HIERARCHY_SEPARATOR + "200" + ARRAY_NESTING_SEPARATOR + "array" + ARRAY_NESTING_SEPARATOR +
                        "array" + ARRAY_NESTING_SEPARATOR + "array", exitDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 2, exitDeclsFatherVariable.getEnclosedVariables().size());

                // Sons
                List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();
                DeclsVariable array1 = declsSonVariables.get(0);
                assertEquals("Incorrect variable name", "return.array", array1.getVariableName());
                assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                assertEquals("Incorrect decType", "double[]", array1.getDecType());
                assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                assertFalse("This variable should not be an array", array1.isArray());
                assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

                DeclsVariable array2 = declsSonVariables.get(1);
                assertEquals("Incorrect variable name", "return.array[..]", array2.getVariableName());
                assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                assertEquals("Incorrect decType", "double[]", array2.getDecType());
                assertEquals("Incorrect repType", "double[]", array2.getRepType());
                assertEquals("Incorrect enclosing var", "return.array", array2.getEnclosingVar());
                assertTrue("This variable should be an array", array2.isArray());
                assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

            }

        }

    }

    @Test
    public void testPrimitiveResponseExit() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/RestCountries/swagger_primitiveResponse.yaml";

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

                List<DeclsExit> declsExits = declsClassEnterAndExit.getDeclsExits();

                DeclsExit declsExit = declsExits.get(0);

                String exitName = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";
                assertEquals("Incorrect exit name", exitName, declsExit.getExitName());

                // VARIABLES
                // ENTER
                // Only the father
                DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 2, enterDeclsFatherVariable.getEnclosedVariables().size());

                // EXIT
                DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                // Father
                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200", exitDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 1, exitDeclsFatherVariable.getEnclosedVariables().size());

                // Sons
                List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();
                DeclsVariable array1 = declsSonVariables.get(0);
                assertEquals("Incorrect variable name", "return.primitive", array1.getVariableName());
                assertEquals("Incorrect var-kind", "field primitive", array1.getVarKind());
                assertEquals("Incorrect decType", "double", array1.getDecType());
                assertEquals("Incorrect repType", "double", array1.getRepType());
                assertEquals("Incorrect enclosing var", "return", array1.getEnclosingVar());
                assertFalse("This variable should not be an array", array1.isArray());
                assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());

            }

        }

    }



}
