package agora.beet.enter;

import agora.beet.model.DeclsClass;
import agora.beet.model.DeclsEnter;
import agora.beet.model.DeclsVariable;
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
public class EnterReadBodyParameters {

    @Test
    public void testEnterReadPrimitiveParametersFromBody() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/Spotify_createPlaylist/spec.yaml";

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


                // ONLY ENTERS
                DeclsEnter declsEnter1 = declsClassEnterAndExit.getDeclsEnters().get(0);
                String enterName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201()";
                assertEquals("Incorrect enter name", enterName1, declsEnter1.getEnterName());

                DeclsEnter declsEnter2 = declsClassEnterAndExit.getDeclsEnters().get(1);
                String enterName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "images()";
                assertEquals("Incorrect enter name", enterName2, declsEnter2.getEnterName());

                DeclsEnter declsEnter3 = declsClassEnterAndExit.getDeclsEnters().get(2);
                String enterName3 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "tracks" + HIERARCHY_SEPARATOR + "items()";
                assertEquals("Incorrect enter name", enterName3, declsEnter3.getEnterName());

                // Father
                DeclsVariable declsFatherVariable1 = declsEnter1.getDeclsVariables();
                assertEquals("Incorrect variable name", "input", declsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "variable", declsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", declsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", declsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", declsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 5, declsFatherVariable1.getEnclosedVariables().size());

                // Sons
                List<DeclsVariable> declsSonVariables1 = declsFatherVariable1.getEnclosedVariables();
                DeclsVariable user_id = declsSonVariables1.get(0);
                assertEquals("Incorrect variable name", "input.user_id", user_id.getVariableName());
                assertEquals("Incorrect var-kind", "field user_id", user_id.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", user_id.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", user_id.getRepType());
                assertEquals("Incorrect enclosing var", "input", user_id.getEnclosingVar());
                assertFalse("This variable should not be an array", user_id.isArray());
                assertEquals("Unexpected number of son variables", 0, user_id.getEnclosedVariables().size());

                DeclsVariable Accept = declsSonVariables1.get(1);
                assertEquals("Incorrect variable name", "input.Accept", Accept.getVariableName());
                assertEquals("Incorrect var-kind", "field Accept", Accept.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", Accept.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", Accept.getRepType());
                assertEquals("Incorrect enclosing var", "input", Accept.getEnclosingVar());
                assertFalse("This variable should not be an array", Accept.isArray());
                assertEquals("Unexpected number of son variables", 0, Accept.getEnclosedVariables().size());

                // Name, description and public are body parameters
                DeclsVariable name = declsSonVariables1.get(2);
                assertEquals("Incorrect variable name", "input.name", name.getVariableName());
                assertEquals("Incorrect var-kind", "field name", name.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", name.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", name.getRepType());
                assertEquals("Incorrect enclosing var", "input", name.getEnclosingVar());
                assertFalse("This variable should not be an array", name.isArray());
                assertEquals("Unexpected number of son variables", 0, name.getEnclosedVariables().size());

                DeclsVariable description = declsSonVariables1.get(3);
                assertEquals("Incorrect variable name", "input.description", description.getVariableName());
                assertEquals("Incorrect var-kind", "field description", description.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", description.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", description.getRepType());
                assertEquals("Incorrect enclosing var", "input", description.getEnclosingVar());
                assertFalse("This variable should not be an array", description.isArray());
                assertEquals("Unexpected number of son variables", 0, description.getEnclosedVariables().size());

                DeclsVariable isPublic = declsSonVariables1.get(4);
                assertEquals("Incorrect variable name", "input.public", isPublic.getVariableName());
                assertEquals("Incorrect var-kind", "field public", isPublic.getVarKind());
                assertEquals("Incorrect decType", "boolean", isPublic.getDecType());
                assertEquals("Incorrect repType", "boolean", isPublic.getRepType());
                assertEquals("Incorrect enclosing var", "input", isPublic.getEnclosingVar());
                assertFalse("This variable should not be an array", isPublic.isArray());
                assertEquals("Unexpected number of son variables", 0, isPublic.getEnclosedVariables().size());

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }

    }

    @Test
    public void testEnterReadNestedObjectParametersFromBody() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/Spotify_createPlaylist/spec_nestedObjects_body.yaml";

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


                // ONLY ENTERS
                DeclsEnter declsEnter1 = declsClassEnterAndExit.getDeclsEnters().get(0);
                String enterName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201()";
                assertEquals("Incorrect enter name", enterName1, declsEnter1.getEnterName());

                DeclsEnter declsEnter2 = declsClassEnterAndExit.getDeclsEnters().get(1);
                String enterName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "images()";
                assertEquals("Incorrect enter name", enterName2, declsEnter2.getEnterName());

                DeclsEnter declsEnter3 = declsClassEnterAndExit.getDeclsEnters().get(2);
                String enterName3 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "tracks" + HIERARCHY_SEPARATOR + "items()";
                assertEquals("Incorrect enter name", enterName3, declsEnter3.getEnterName());

                for(DeclsEnter declsEnter: declsClassEnterAndExit.getDeclsEnters()) {
                    // Father
                    DeclsVariable declsFatherVariable = declsEnter.getDeclsVariables();
                    assertEquals("Incorrect variable name", "input", declsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", declsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", declsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", declsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", declsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 5, declsFatherVariable.getEnclosedVariables().size());

                    // Sons
                    List<DeclsVariable> declsSonVariables = declsFatherVariable.getEnclosedVariables();
                    DeclsVariable user_id = declsSonVariables.get(0);
                    assertEquals("Incorrect variable name", "input.user_id", user_id.getVariableName());
                    assertEquals("Incorrect var-kind", "field user_id", user_id.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", user_id.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", user_id.getRepType());
                    assertEquals("Incorrect enclosing var", "input", user_id.getEnclosingVar());
                    assertFalse("This variable should not be an array", user_id.isArray());
                    assertEquals("Unexpected number of son variables", 0, user_id.getEnclosedVariables().size());

                    DeclsVariable Accept = declsSonVariables.get(1);
                    assertEquals("Incorrect variable name", "input.Accept", Accept.getVariableName());
                    assertEquals("Incorrect var-kind", "field Accept", Accept.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", Accept.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", Accept.getRepType());
                    assertEquals("Incorrect enclosing var", "input", Accept.getEnclosingVar());
                    assertFalse("This variable should not be an array", Accept.isArray());
                    assertEquals("Unexpected number of son variables", 0, Accept.getEnclosedVariables().size());

                    // Name, description and public are body parameters
                    DeclsVariable name = declsSonVariables.get(2);
                    assertEquals("Incorrect variable name", "input.name", name.getVariableName());
                    assertEquals("Incorrect var-kind", "field name", name.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", name.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", name.getRepType());
                    assertEquals("Incorrect enclosing var", "input", name.getEnclosingVar());
                    assertFalse("This variable should not be an array", name.isArray());
                    assertEquals("Unexpected number of son variables", 0, name.getEnclosedVariables().size());

                    DeclsVariable description = declsSonVariables.get(3);
                    assertEquals("Incorrect variable name", "input.description", description.getVariableName());
                    assertEquals("Incorrect var-kind", "field description", description.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", description.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", description.getRepType());
                    assertEquals("Incorrect enclosing var", "input", description.getEnclosingVar());
                    assertFalse("This variable should not be an array", description.isArray());
                    assertEquals("Unexpected number of son variables", 0, description.getEnclosedVariables().size());


                    // Location is of type object
                    DeclsVariable location = declsSonVariables.get(4);
                    assertEquals("Incorrect variable name", "input.location", location.getVariableName());
                    assertEquals("Incorrect var-kind", "field location", location.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input" + HIERARCHY_SEPARATOR + "location", location.getDecType());
                    assertEquals("Incorrect repType", "hashcode", location.getRepType());
                    assertEquals("Incorrect enclosing var", "input", location.getEnclosingVar());
                    assertFalse("This variable should not be an array", location.isArray());
                    assertEquals("Unexpected number of son variables", 3, location.getEnclosedVariables().size());

                    List<DeclsVariable> locationSons = location.getEnclosedVariables();

                    // Location id is of type string
                    DeclsVariable locationId = locationSons.get(0);
                    assertEquals("Incorrect variable name", "input.location.locationId", locationId.getVariableName());
                    assertEquals("Incorrect var-kind", "field locationId", locationId.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", locationId.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", locationId.getRepType());
                    assertEquals("Incorrect enclosing var", "input.location", locationId.getEnclosingVar());
                    assertFalse("This variable should not be an array", locationId.isArray());
                    assertEquals("Unexpected number of son variables", 0, locationId.getEnclosedVariables().size());

                    // Keyword is an array of primitive elements
                    DeclsVariable keywords1 = locationSons.get(1);
                    assertEquals("Incorrect variable name", "input.location.keywords", keywords1.getVariableName());
                    assertEquals("Incorrect var-kind", "field keywords", keywords1.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String[]", keywords1.getDecType());
                    assertEquals("Incorrect repType", "hashcode", keywords1.getRepType());
                    assertEquals("Incorrect enclosing var", "input.location", keywords1.getEnclosingVar());
                    assertFalse("This variable should not be an array", keywords1.isArray());
                    assertEquals("Unexpected number of son variables", 0, keywords1.getEnclosedVariables().size());

                    DeclsVariable keywords2 = locationSons.get(2);
                    assertEquals("Incorrect variable name", "input.location.keywords[..]", keywords2.getVariableName());
                    assertEquals("Incorrect var-kind", "array", keywords2.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String[]", keywords2.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String[]", keywords2.getRepType());
                    assertEquals("Incorrect enclosing var", "input.location.keywords", keywords2.getEnclosingVar());
                    assertTrue("This variable should be an array", keywords2.isArray());
                    assertEquals("Unexpected number of son variables", 0, keywords2.getEnclosedVariables().size());

                }

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }

    }

    @Test
    public void testEnterReadNestedArrayOfObjectsParametersFromBody() {

        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/Spotify_createPlaylist/spec_nestedArrayOfObjects_body.yaml";

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


                // ONLY ENTERS
                DeclsEnter declsEnter1 = declsClassEnterAndExit.getDeclsEnters().get(0);
                String enterName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201()";
                assertEquals("Incorrect enter name", enterName1, declsEnter1.getEnterName());

                DeclsEnter declsEnter2 = declsClassEnterAndExit.getDeclsEnters().get(1);
                String enterName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "images()";
                assertEquals("Incorrect enter name", enterName2, declsEnter2.getEnterName());

                DeclsEnter declsEnter3 = declsClassEnterAndExit.getDeclsEnters().get(2);
                String enterName3 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "tracks" + HIERARCHY_SEPARATOR + "items()";
                assertEquals("Incorrect enter name", enterName3, declsEnter3.getEnterName());

                for(DeclsEnter declsEnter: declsClassEnterAndExit.getDeclsEnters()) {
                    // Father
                    DeclsVariable declsFatherVariable = declsEnter.getDeclsVariables();
                    assertEquals("Incorrect variable name", "input", declsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", declsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", declsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", declsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", declsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 5, declsFatherVariable.getEnclosedVariables().size());

                    // Sons
                    List<DeclsVariable> declsSonVariables = declsFatherVariable.getEnclosedVariables();
                    DeclsVariable user_id = declsSonVariables.get(0);
                    assertEquals("Incorrect variable name", "input.user_id", user_id.getVariableName());
                    assertEquals("Incorrect var-kind", "field user_id", user_id.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", user_id.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", user_id.getRepType());
                    assertEquals("Incorrect enclosing var", "input", user_id.getEnclosingVar());
                    assertFalse("This variable should not be an array", user_id.isArray());
                    assertEquals("Unexpected number of son variables", 0, user_id.getEnclosedVariables().size());

                    DeclsVariable Accept = declsSonVariables.get(1);
                    assertEquals("Incorrect variable name", "input.Accept", Accept.getVariableName());
                    assertEquals("Incorrect var-kind", "field Accept", Accept.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", Accept.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", Accept.getRepType());
                    assertEquals("Incorrect enclosing var", "input", Accept.getEnclosingVar());
                    assertFalse("This variable should not be an array", Accept.isArray());
                    assertEquals("Unexpected number of son variables", 0, Accept.getEnclosedVariables().size());

                    // Name, description and public are body parameters
                    DeclsVariable name = declsSonVariables.get(2);
                    assertEquals("Incorrect variable name", "input.name", name.getVariableName());
                    assertEquals("Incorrect var-kind", "field name", name.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", name.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", name.getRepType());
                    assertEquals("Incorrect enclosing var", "input", name.getEnclosingVar());
                    assertFalse("This variable should not be an array", name.isArray());
                    assertEquals("Unexpected number of son variables", 0, name.getEnclosedVariables().size());

                    DeclsVariable description = declsSonVariables.get(3);
                    assertEquals("Incorrect variable name", "input.description", description.getVariableName());
                    assertEquals("Incorrect var-kind", "field description", description.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", description.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", description.getRepType());
                    assertEquals("Incorrect enclosing var", "input", description.getEnclosingVar());
                    assertFalse("This variable should not be an array", description.isArray());
                    assertEquals("Unexpected number of son variables", 0, description.getEnclosedVariables().size());


                    // Location is of type object
                    DeclsVariable location = declsSonVariables.get(4);
                    assertEquals("Incorrect variable name", "input.location", location.getVariableName());
                    assertEquals("Incorrect var-kind", "field location", location.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input" + HIERARCHY_SEPARATOR + "location", location.getDecType());
                    assertEquals("Incorrect repType", "hashcode", location.getRepType());
                    assertEquals("Incorrect enclosing var", "input", location.getEnclosingVar());
                    assertFalse("This variable should not be an array", location.isArray());
                    assertEquals("Unexpected number of son variables", 3, location.getEnclosedVariables().size());

                    List<DeclsVariable> locationSons = location.getEnclosedVariables();

                    // Location id is of type string
                    DeclsVariable locationId = locationSons.get(0);
                    assertEquals("Incorrect variable name", "input.location.locationId", locationId.getVariableName());
                    assertEquals("Incorrect var-kind", "field locationId", locationId.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", locationId.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", locationId.getRepType());
                    assertEquals("Incorrect enclosing var", "input.location", locationId.getEnclosingVar());
                    assertFalse("This variable should not be an array", locationId.isArray());
                    assertEquals("Unexpected number of son variables", 0, locationId.getEnclosedVariables().size());

                    // Keyword is an array of primitive elements
                    DeclsVariable keywords1 = locationSons.get(1);
                    assertEquals("Incorrect variable name", "input.location.keywords", keywords1.getVariableName());
                    assertEquals("Incorrect var-kind", "field keywords", keywords1.getVarKind());
                    assertEquals("Incorrect decType", "keywords[]", keywords1.getDecType());
                    assertEquals("Incorrect repType", "hashcode", keywords1.getRepType());
                    assertEquals("Incorrect enclosing var", "input.location", keywords1.getEnclosingVar());
                    assertFalse("This variable should not be an array", keywords1.isArray());
                    assertEquals("Unexpected number of son variables", 0, keywords1.getEnclosedVariables().size());

                    DeclsVariable keywords2 = locationSons.get(2);
                    assertEquals("Incorrect variable name", "input.location.keywords[..]", keywords2.getVariableName());
                    assertEquals("Incorrect var-kind", "array", keywords2.getVarKind());
                    assertEquals("Incorrect decType", "keywords[]", keywords2.getDecType());
                    assertEquals("Incorrect repType", "hashcode[]", keywords2.getRepType());
                    assertEquals("Incorrect enclosing var", "input.location.keywords", keywords2.getEnclosingVar());
                    assertTrue("This variable should be an array", keywords2.isArray());
                    assertEquals("Unexpected number of son variables", 0, keywords2.getEnclosedVariables().size());

                }

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }

    }

    // The Schema of the body parameter is of type ArraySchema and the elements are primitive
    @Test
    public void testEnterReadPrimitiveArrayParameterFromBody() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/Spotify_createPlaylist/spec_bodyParameter_primitiveArray.yaml";

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


                // ONLY ENTERS
                DeclsEnter declsEnter1 = declsClassEnterAndExit.getDeclsEnters().get(0);
                String enterName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201()";
                assertEquals("Incorrect enter name", enterName1, declsEnter1.getEnterName());

                DeclsEnter declsEnter2 = declsClassEnterAndExit.getDeclsEnters().get(1);
                String enterName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "images()";
                assertEquals("Incorrect enter name", enterName2, declsEnter2.getEnterName());

                DeclsEnter declsEnter3 = declsClassEnterAndExit.getDeclsEnters().get(2);
                String enterName3 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "201" + HIERARCHY_SEPARATOR + "tracks" + HIERARCHY_SEPARATOR + "items()";
                assertEquals("Incorrect enter name", enterName3, declsEnter3.getEnterName());

                for(DeclsEnter declsEnter: declsClassEnterAndExit.getDeclsEnters()) {
                    // Father
                    DeclsVariable declsFatherVariable = declsEnter.getDeclsVariables();
                    assertEquals("Incorrect variable name", "input", declsFatherVariable.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", declsFatherVariable.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable.getDecType());
                    assertEquals("Incorrect repType", "hashcode", declsFatherVariable.getRepType());
                    assertNull("The enclosing var should be null", declsFatherVariable.getEnclosingVar());
                    assertFalse("This variable should not be an array", declsFatherVariable.isArray());
                    assertEquals("Unexpected number of son variables", 2, declsFatherVariable.getEnclosedVariables().size());

                    // Sons
                    List<DeclsVariable> declsSonVariables = declsFatherVariable.getEnclosedVariables();
                    DeclsVariable user_id = declsSonVariables.get(0);
                    assertEquals("Incorrect variable name", "input.user_id", user_id.getVariableName());
                    assertEquals("Incorrect var-kind", "field user_id", user_id.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String", user_id.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String", user_id.getRepType());
                    assertEquals("Incorrect enclosing var", "input", user_id.getEnclosingVar());
                    assertFalse("This variable should not be an array", user_id.isArray());
                    assertEquals("Unexpected number of son variables", 0, user_id.getEnclosedVariables().size());

                    // Array of primitives
                    DeclsVariable body = declsSonVariables.get(1);
                    assertEquals("Incorrect variable name", "input.body", body.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", body.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input.bodyArray", body.getDecType());
                    assertEquals("Incorrect repType", "hashcode", body.getRepType());
                    assertEquals("Incorrect enclosing var", "input", body.getEnclosingVar());
                    assertFalse("This variable should not be an array", body.isArray());
                    assertEquals("Unexpected number of son variables", 2, body.getEnclosedVariables().size());

                    List<DeclsVariable> bodySons = body.getEnclosedVariables();

                    DeclsVariable array1 = bodySons.get(0);
                    assertEquals("Incorrect variable name", "input.body.array", array1.getVariableName());
                    assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String[]", array1.getDecType());
                    assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                    assertEquals("Incorrect enclosing var", "input.body", array1.getEnclosingVar());
                    assertFalse("This variable should not be an array", array1.isArray());
                    assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());


                    DeclsVariable array2 = bodySons.get(1);
                    assertEquals("Incorrect variable name", "input.body.array[..]", array2.getVariableName());
                    assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                    assertEquals("Incorrect decType", "java.lang.String[]", array2.getDecType());
                    assertEquals("Incorrect repType", "java.lang.String[]", array2.getRepType());
                    assertEquals("Incorrect enclosing var", "input.body.array", array2.getEnclosingVar());
                    assertTrue("This variable should be an array", array2.isArray());
                    assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

                }

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }

    }

    // The Schema of the body parameter is of type ArraySchema and the elements are of type object
    // Only the first nesting level is taken into account
    @Test
    public void testEnterReadObjectArrayParameterFromBody() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/Spotify_createPlaylist/spec_bodyParameter_objectArray.yaml";

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

                for(DeclsEnter declsEnter: declsClassEnterAndExit.getDeclsEnters()) {
                    // Father
                    DeclsVariable declsFatherVariable = declsEnter.getDeclsVariables();

                    // Sons
                    List<DeclsVariable> declsSonVariables = declsFatherVariable.getEnclosedVariables();

                    // Array of objects
                    DeclsVariable body = declsSonVariables.get(1);
                    assertEquals("Incorrect variable name", "input.body", body.getVariableName());
                    assertEquals("Incorrect var-kind", "variable", body.getVarKind());
                    assertEquals("Incorrect decType", "createPlaylist" + HIERARCHY_SEPARATOR + "Input.bodyArray", body.getDecType());
                    assertEquals("Incorrect repType", "hashcode", body.getRepType());
                    assertEquals("Incorrect enclosing var", "input", body.getEnclosingVar());
                    assertFalse("This variable should not be an array", body.isArray());
                    assertEquals("Unexpected number of son variables", 2, body.getEnclosedVariables().size());

                    List<DeclsVariable> bodySons = body.getEnclosedVariables();

                    DeclsVariable array1 = bodySons.get(0);
                    assertEquals("Incorrect variable name", "input.body.array", array1.getVariableName());
                    assertEquals("Incorrect var-kind", "field array", array1.getVarKind());
                    assertEquals("Incorrect decType", "array[]", array1.getDecType());
                    assertEquals("Incorrect repType", "hashcode", array1.getRepType());
                    assertEquals("Incorrect enclosing var", "input.body", array1.getEnclosingVar());
                    assertFalse("This variable should not be an array", array1.isArray());
                    assertEquals("Unexpected number of son variables", 0, array1.getEnclosedVariables().size());


                    DeclsVariable array2 = bodySons.get(1);
                    assertEquals("Incorrect variable name", "input.body.array[..]", array2.getVariableName());
                    assertEquals("Incorrect var-kind", "array", array2.getVarKind());
                    assertEquals("Incorrect decType", "array[]", array2.getDecType());
                    assertEquals("Incorrect repType", "hashcode[]", array2.getRepType());
                    assertEquals("Incorrect enclosing var", "input.body.array", array2.getEnclosingVar());
                    assertTrue("This variable should be an array", array2.isArray());
                    assertEquals("Unexpected number of son variables", 0, array2.getEnclosedVariables().size());

                }

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }

    }

}
