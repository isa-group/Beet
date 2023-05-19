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
public class PrimitiveArrayExitTest {

    @Test
    public void testGenerationOfPrimitiveExitArray() {

        deleteAllDeclsClasses();

        String oasPath = "src/test/resources/DHL/swagger_primitiveOutputArray.yaml";

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
                // Only the Father
                DeclsVariable enterDeclsFatherVariable = declsExit.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "findByAddress"+ HIERARCHY_SEPARATOR +"Input", enterDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable.isArray());
                assertEquals("Unexpected number of son variables", 9, enterDeclsFatherVariable.getEnclosedVariables().size());


                // EXIT
                // Father
                DeclsVariable exitDeclsFatherVariable = declsExit.getExitDeclsVariables();

                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable.getVarKind());
                assertEquals("Incorrect decType", "findByAddress"+HIERARCHY_SEPARATOR+"Output"+HIERARCHY_SEPARATOR+"200", exitDeclsFatherVariable.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable.isArray());

                // The array is counted twice (normal and [..])
                assertEquals("Unexpected number of son variables", 7, exitDeclsFatherVariable.getEnclosedVariables().size());

                // Sons
                List<DeclsVariable> declsSonVariables = exitDeclsFatherVariable.getEnclosedVariables();
                // url, name, distance, servicesTypes (twice)
                DeclsVariable url = declsSonVariables.get(0);
                assertEquals("Incorrect variable name", "return.url", url.getVariableName());
                assertEquals("Incorrect var-kind", "field url", url.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", url.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", url.getRepType());
                assertEquals("Incorrect enclosing var", "return", url.getEnclosingVar());
                assertFalse("This variable should not be an array", url.isArray());
                assertEquals("Unexpected number of son variables", 0, url.getEnclosedVariables().size());

                DeclsVariable name = declsSonVariables.get(1);
                assertEquals("Incorrect variable name", "return.name", name.getVariableName());
                assertEquals("Incorrect var-kind", "field name", name.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", name.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", name.getRepType());
                assertEquals("Incorrect enclosing var", "return", name.getEnclosingVar());
                assertFalse("This variable should not be an array", name.isArray());
                assertEquals("Unexpected number of son variables", 0, name.getEnclosedVariables().size());

                DeclsVariable distance = declsSonVariables.get(2);
                assertEquals("Incorrect variable name", "return.distance", distance.getVariableName());
                assertEquals("Incorrect var-kind", "field distance", distance.getVarKind());
                assertEquals("Incorrect decType", "double", distance.getDecType());
                assertEquals("Incorrect repType", "double", distance.getRepType());
                assertEquals("Incorrect enclosing var", "return", distance.getEnclosingVar());
                assertFalse("This variable should not be an array", distance.isArray());
                assertEquals("Unexpected number of son variables", 0, distance.getEnclosedVariables().size());

                // Analyzing the parameters of type array:
                DeclsVariable serviceTypes1 = declsSonVariables.get(3);
                assertEquals("Incorrect variable name", "return.serviceTypes", serviceTypes1.getVariableName());
                assertEquals("Incorrect var-kind", "field serviceTypes", serviceTypes1.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String[]", serviceTypes1.getDecType());
                assertEquals("Incorrect repType", "hashcode", serviceTypes1.getRepType());
                assertEquals("Incorrect enclosing var", "return", serviceTypes1.getEnclosingVar());
                // The first occurrence should not be an array (flag array 1)
                assertFalse("This variable should not be an array", serviceTypes1.isArray());
                assertEquals("Unexpected number of son variables", 0, serviceTypes1.getEnclosedVariables().size());

                DeclsVariable serviceTypes2 = declsSonVariables.get(4);
                assertEquals("Incorrect variable name", "return.serviceTypes[..]", serviceTypes2.getVariableName());
                assertEquals("Incorrect var-kind", "array", serviceTypes2.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String[]", serviceTypes2.getDecType());
                assertEquals("Incorrect repType", "java.lang.String[]", serviceTypes2.getRepType());
                assertEquals("Incorrect enclosing var", "return.serviceTypes", serviceTypes2.getEnclosingVar());
                // The second occurrence should be an array (flag array 1)
                assertTrue("This variable should be an array", serviceTypes2.isArray());
                assertEquals("Unexpected number of son variables", 0, serviceTypes2.getEnclosedVariables().size());

                // service.definitions (array of primitives with special character)
                DeclsVariable servicePrices1 = declsSonVariables.get(5);
                assertEquals("Incorrect variable name", "return.service&prices", servicePrices1.getVariableName());
                assertEquals("Incorrect var-kind", "field service&prices", servicePrices1.getVarKind());
                assertEquals("Incorrect decType", "double[]", servicePrices1.getDecType());
                assertEquals("Incorrect repType", "hashcode", servicePrices1.getRepType());
                assertEquals("Incorrect enclosing var", "return", servicePrices1.getEnclosingVar());
                // The first occurrence should not be an array (flaga array 1)
                assertFalse("This variable should not be an array", servicePrices1.isArray());
                assertEquals("Unexpected number of son variables", 0, servicePrices1.getEnclosedVariables().size());

                DeclsVariable servicePrices2 = declsSonVariables.get(6);
                assertEquals("Incorrect variable name", "return.service&prices[..]", servicePrices2.getVariableName());
                assertEquals("Incorrect var-kind", "array", servicePrices2.getVarKind());
                assertEquals("Incorrect decType", "double[]", servicePrices2.getDecType());
                assertEquals("Incorrect repType", "double[]", servicePrices2.getRepType());
                assertEquals("Incorrect enclosing var", "return.service&prices", servicePrices2.getEnclosingVar());
                // The second occurrence should be an array (flag array 1)
                assertTrue("This variable should be an array", servicePrices2.isArray());
                assertEquals("Unexpected number of son variables", 0, servicePrices2.getEnclosedVariables().size());

            }

        }

    }

}
