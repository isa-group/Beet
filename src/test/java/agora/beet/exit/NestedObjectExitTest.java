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
public class NestedObjectExitTest {

    @Test
    public void testGenerationOfNestedObjectExitTest() {
        deleteAllDeclsClasses();

        String oasPath = "src/test/resources/DHL/swagger_nestedObjectOutput.yaml";

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
                assertEquals("Incorrect number of classes", 1, allDeclsClasses.size());

                DeclsClass declsClassEnterAndExit = allDeclsClasses.get(0);

                System.out.println(declsClassEnterAndExit);

                // CLASS
                assertEquals("Incorrect class name", operationEndpoint, declsClassEnterAndExit.getClassName());
                assertEquals("The size of the list of enters is not 2", 2, declsClassEnterAndExit.getDeclsEnters().size());
                assertEquals("The size of the list of exits is not 2", 2, declsClassEnterAndExit.getDeclsExits().size());

                // OBJECT (ONLY EXIT)
                // EXIT 1
                DeclsExit declsExit1 = declsClassEnterAndExit.getDeclsExits().get(0);
                String exitName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";

                assertEquals("Incorrect exit name", exitName1, declsExit1.getExitName());

                // VARIABLES
                // ENTER
                // Only the Father
                DeclsVariable enterDeclsFatherVariable1 = declsExit1.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "findByAddress" + HIERARCHY_SEPARATOR + "Input", enterDeclsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 9, enterDeclsFatherVariable1.getEnclosedVariables().size());


                // EXIT
                // Father
                DeclsVariable exitDeclsFatherVariable1 = declsExit1.getExitDeclsVariables();

                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "findByAddress" + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + "200", exitDeclsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable1.isArray());

                // The array is counted twice (normal and [..])
                assertEquals("Unexpected number of son variables", 3, exitDeclsFatherVariable1.getEnclosedVariables().size());

                List<DeclsVariable> declsSonVariables1 = exitDeclsFatherVariable1.getEnclosedVariables();
                // url and location (of type object)
                DeclsVariable url = declsSonVariables1.get(0);
                assertEquals("Incorrect variable name", "return.url", url.getVariableName());
                assertEquals("Incorrect var-kind", "field url", url.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", url.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", url.getRepType());
                assertEquals("Incorrect enclosing var", "return", url.getEnclosingVar());
                assertFalse("This variable should not be an array", url.isArray());
                assertEquals("Unexpected number of son variables", 0, url.getEnclosedVariables().size());


                // Variable of type object
                DeclsVariable locationObject = declsSonVariables1.get(1);
                assertEquals("Incorrect variable name", "return.location", locationObject.getVariableName());
                assertEquals("Incorrect var-kind", "field location", locationObject.getVarKind());
                assertEquals("Incorrect decType", "findByAddress" + HIERARCHY_SEPARATOR + "Output" +
                        HIERARCHY_SEPARATOR + "200" + HIERARCHY_SEPARATOR + "location", locationObject.getDecType());
                assertEquals("Incorrect repType", "hashcode", locationObject.getRepType());
                assertEquals("Incorrect enclosing var", "return", locationObject.getEnclosingVar());
                assertFalse("This variable should not be an array", locationObject.isArray());
                // 5 sons: ids, keyword, keywordId, type (ids is counted twice because it is of type array)
                assertEquals("Unexpected number of son variables", 5, locationObject.getEnclosedVariables().size());

                // Sons of the variable of type object
                List<DeclsVariable> sonsOfLocation = locationObject.getEnclosedVariables();

                // Properties of type String
                DeclsVariable keyword = sonsOfLocation.get(2);
                assertEquals("Incorrect variable name", "return.location.keyword",  keyword.getVariableName());
                assertEquals("Incorrect var-kind", "field keyword", keyword.getVarKind());
                assertEquals("Incorrect decType",  "java.lang.String", keyword.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", keyword.getRepType());
                assertEquals("Incorrect enclosing var", "return.location", keyword.getEnclosingVar());
                assertFalse("This variable should not be an array", keyword.isArray());
                assertEquals("Unexpected number of son variables", 0, keyword.getEnclosedVariables().size());

                DeclsVariable keywordId = sonsOfLocation.get(3);
                assertEquals("Incorrect variable name", "return.location.keywordId",  keywordId.getVariableName());
                assertEquals("Incorrect var-kind", "field keywordId", keywordId.getVarKind());
                assertEquals("Incorrect decType",  "java.lang.String", keywordId.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", keywordId.getRepType());
                assertEquals("Incorrect enclosing var", "return.location", keywordId.getEnclosingVar());
                assertFalse("This variable should not be an array", keywordId.isArray());
                assertEquals("Unexpected number of son variables", 0, keywordId.getEnclosedVariables().size());

                DeclsVariable type = sonsOfLocation.get(4);
                assertEquals("Incorrect variable name", "return.location.type",  type.getVariableName());
                assertEquals("Incorrect var-kind", "field type", type.getVarKind());
                assertEquals("Incorrect decType",  "java.lang.String", type.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", type.getRepType());
                assertEquals("Incorrect enclosing var", "return.location", type.getEnclosingVar());
                assertFalse("This variable should not be an array", type.isArray());
                assertEquals("Unexpected number of son variables", 0, type.getEnclosedVariables().size());

                // Array type with another nested object
                DeclsVariable ids1 = sonsOfLocation.get(0);
                assertEquals("Incorrect variable name", "return.location.ids",  ids1.getVariableName());
                assertEquals("Incorrect var-kind", "field ids", ids1.getVarKind());
                assertEquals("Incorrect decType",  "ids[]", ids1.getDecType());
                assertEquals("Incorrect repType", "hashcode", ids1.getRepType());
                assertEquals("Incorrect enclosing var", "return.location", ids1.getEnclosingVar());
                assertFalse("This variable should not be an array", ids1.isArray());
                assertEquals("Unexpected number of son variables", 0, ids1.getEnclosedVariables().size());

                DeclsVariable ids2 = sonsOfLocation.get(1);
                assertEquals("Incorrect variable name", "return.location.ids[..]",  ids2.getVariableName());
                assertEquals("Incorrect var-kind", "array", ids2.getVarKind());
                assertEquals("Incorrect decType",  "ids[]", ids2.getDecType());
                assertEquals("Incorrect repType", "hashcode[]", ids2.getRepType());
                assertEquals("Incorrect enclosing var", "return.location.ids", ids2.getEnclosingVar());
                assertTrue("This variable should be an array", ids2.isArray());
                assertEquals("Unexpected number of son variables", 0, ids2.getEnclosedVariables().size());

                // Variable of type object with special characters
                DeclsVariable latLongObject = declsSonVariables1.get(2);
                assertEquals("Incorrect variable name", "return.lat&lng", latLongObject.getVariableName());
                assertEquals("Incorrect var-kind", "field lat&lng", latLongObject.getVarKind());
                assertEquals("Incorrect decType", "findByAddress"+HIERARCHY_SEPARATOR+"Output"+HIERARCHY_SEPARATOR+"200"+HIERARCHY_SEPARATOR+"lat"+HIERARCHY_SEPARATOR+"lng", latLongObject.getDecType());
                assertEquals("Incorrect repType", "hashcode", latLongObject.getRepType());
                assertEquals("Incorrect enclosing var", "return", latLongObject.getEnclosingVar());
                assertFalse("This variable should not be an array", latLongObject.isArray());
                assertEquals("Unexpected number of son variables", 3, latLongObject.getEnclosedVariables().size());

                List<DeclsVariable> songsOfLatLng = latLongObject.getEnclosedVariables();

                // Enclosed variables of variable with special characters
                DeclsVariable latVariable = songsOfLatLng.get(0);
                assertEquals("Incorrect variable name", "return.lat" + HIERARCHY_SEPARATOR + "lng.lat",  latVariable.getVariableName());
                assertEquals("Incorrect var-kind", "field lat", latVariable.getVarKind());
                assertEquals("Incorrect decType",  "double", latVariable.getDecType());
                assertEquals("Incorrect repType", "double", latVariable.getRepType());
                assertEquals("Incorrect enclosing var", "return.lat" + HIERARCHY_SEPARATOR + "lng", latVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", latVariable.isArray());
                assertEquals("Unexpected number of son variables", 0, latVariable.getEnclosedVariables().size());

                DeclsVariable lngVariable = songsOfLatLng.get(1);
                assertEquals("Incorrect variable name", "return.lat" + HIERARCHY_SEPARATOR + "lng.lng",  lngVariable.getVariableName());
                assertEquals("Incorrect var-kind", "field lng", lngVariable.getVarKind());
                assertEquals("Incorrect decType",  "double", lngVariable.getDecType());
                assertEquals("Incorrect repType", "double", lngVariable.getRepType());
                assertEquals("Incorrect enclosing var", "return.lat" + HIERARCHY_SEPARATOR + "lng", lngVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", lngVariable.isArray());
                assertEquals("Unexpected number of son variables", 0, lngVariable.getEnclosedVariables().size());

                DeclsVariable coordinatesInfoVariable = songsOfLatLng.get(2);
                assertEquals("Incorrect variable name", "return.lat" + HIERARCHY_SEPARATOR + "lng.coordinates" + HIERARCHY_SEPARATOR + "info",  coordinatesInfoVariable.getVariableName());
                assertEquals("Incorrect var-kind", "field coordinates" + HIERARCHY_SEPARATOR + "info", coordinatesInfoVariable.getVarKind());
                assertEquals("Incorrect decType",  "java.lang.String", coordinatesInfoVariable.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", coordinatesInfoVariable.getRepType());
                assertEquals("Incorrect enclosing var", "return.lat" + HIERARCHY_SEPARATOR + "lng", coordinatesInfoVariable.getEnclosingVar());
                assertFalse("This variable should not be an array", coordinatesInfoVariable.isArray());
                assertEquals("Unexpected number of son variables", 0, coordinatesInfoVariable.getEnclosedVariables().size());



                // EXIT 2
                DeclsExit declsExit2 = declsClassEnterAndExit.getDeclsExits().get(1);
                String exitName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200"+HIERARCHY_SEPARATOR+"location"+HIERARCHY_SEPARATOR+"ids()";

                assertEquals("Incorrect exit name", exitName2, declsExit2.getExitName());

                // VARIABLES
                // ENTER
                // Only the Father
                DeclsVariable enterDeclsFatherVariable2 = declsExit2.getEnterDeclsVariables();
                assertEquals("Incorrect variable name", "input", enterDeclsFatherVariable2.getVariableName());
                assertEquals("Incorrect var-kind", "variable", enterDeclsFatherVariable2.getVarKind());
                assertEquals("Incorrect decType", "findByAddress"+HIERARCHY_SEPARATOR+"Input", enterDeclsFatherVariable2.getDecType());
                assertEquals("Incorrect repType", "hashcode", enterDeclsFatherVariable2.getRepType());
                assertNull("The enclosing var should be null", enterDeclsFatherVariable2.getEnclosingVar());
                assertFalse("This variable should not be an array", enterDeclsFatherVariable2.isArray());
                assertEquals("Unexpected number of son variables", 9, enterDeclsFatherVariable2.getEnclosedVariables().size());


                // EXIT
                // Father
                DeclsVariable exitDeclsFatherVariable2 = declsExit2.getExitDeclsVariables();

                assertEquals("Incorrect variable name", "return", exitDeclsFatherVariable2.getVariableName());
                assertEquals("Incorrect var-kind", "return", exitDeclsFatherVariable2.getVarKind());
                assertEquals("Incorrect decType", "findByAddress"+HIERARCHY_SEPARATOR+"Output"+HIERARCHY_SEPARATOR+"200"+HIERARCHY_SEPARATOR+"location"+HIERARCHY_SEPARATOR+"ids", exitDeclsFatherVariable2.getDecType());
                assertEquals("Incorrect repType", "hashcode", exitDeclsFatherVariable2.getRepType());
                assertNull("The enclosing var should be null", exitDeclsFatherVariable2.getEnclosingVar());
                assertFalse("This variable should not be an array", exitDeclsFatherVariable2.isArray());


                List<DeclsVariable> declsSonVariables2 = exitDeclsFatherVariable2.getEnclosedVariables();

                DeclsVariable locationId = declsSonVariables2.get(0);
                assertEquals("Incorrect variable name", "return.locationId", locationId.getVariableName());
                assertEquals("Incorrect var-kind", "field locationId", locationId.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", locationId.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", locationId.getRepType());
                assertEquals("Incorrect enclosing var", "return", locationId.getEnclosingVar());
                assertFalse("This variable should not be an array", locationId.isArray());
                assertEquals("Unexpected number of son variables", 0, locationId.getEnclosedVariables().size());

                DeclsVariable provider = declsSonVariables2.get(1);
                assertEquals("Incorrect variable name", "return.provider", provider.getVariableName());
                assertEquals("Incorrect var-kind", "field provider", provider.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", provider.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", provider.getRepType());
                assertEquals("Incorrect enclosing var", "return", provider.getEnclosingVar());
                assertFalse("This variable should not be an array", provider.isArray());
                assertEquals("Unexpected number of son variables", 0, provider.getEnclosedVariables().size());

            }

        }



    }


}
