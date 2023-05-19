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
public class EnterReadParametersFromPathAndFormTest {

    @Test
    public void testEnterReadParametersFromPath() {
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
                assertEquals("The size of the list of enters is not 2", 2, declsClassEnterAndExit.getDeclsEnters().size());
                assertEquals("The size of the list of exits is not 2", 2, declsClassEnterAndExit.getDeclsExits().size());


                // OBJECT 1 (ONLY ENTER)
                DeclsEnter declsEnter1 = declsClassEnterAndExit.getDeclsEnters().get(0);
                String enterName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200" + ARRAY_NESTING_SEPARATOR + "array()";

                assertEquals("Incorrect enter name", enterName1, declsEnter1.getEnterName());

                // VARIABLES

                // Father
                DeclsVariable declsFatherVariable1 = declsEnter1.getDeclsVariables();
                assertEquals("Incorrect variable name", "input", declsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "variable", declsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", declsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", declsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", declsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 2, declsFatherVariable1.getEnclosedVariables().size());

                // Sons
                // Name is a path parameter
                List<DeclsVariable> declsSonVariables1 = declsFatherVariable1.getEnclosedVariables();
                DeclsVariable name1 = declsSonVariables1.get(0);
                assertEquals("Incorrect variable name", "input.name", name1.getVariableName());
                assertEquals("Incorrect var-kind", "field name", name1.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", name1.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", name1.getRepType());
                assertEquals("Incorrect enclosing var", "input", name1.getEnclosingVar());
                assertFalse("This variable should not be an array", name1.isArray());
                assertEquals("Unexpected number of son variables", 0, name1.getEnclosedVariables().size());

                DeclsVariable fullText1 = declsSonVariables1.get(1);
                assertEquals("Incorrect variable name", "input.fullText", fullText1.getVariableName());
                assertEquals("Incorrect var-kind", "field fullText", fullText1.getVarKind());
                assertEquals("Incorrect decType", "boolean", fullText1.getDecType());
                assertEquals("Incorrect repType", "boolean", fullText1.getRepType());
                assertEquals("Incorrect enclosing var", "input", fullText1.getEnclosingVar());
                assertFalse("This variable should not be an array", fullText1.isArray());
                assertEquals("Unexpected number of son variables", 0, fullText1.getEnclosedVariables().size());

                // OBJECT 2 (ONLY ENTER)
                DeclsEnter declsEnter2 = declsClassEnterAndExit.getDeclsEnters().get(1);
                String enterName2 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";

                assertEquals("Incorrect enter name", enterName2, declsEnter2.getEnterName());

                // VARIABLES

                // Father
                DeclsVariable declsFatherVariable2 = declsEnter2.getDeclsVariables();
                assertEquals("Incorrect variable name", "input", declsFatherVariable2.getVariableName());
                assertEquals("Incorrect var-kind", "variable", declsFatherVariable2.getVarKind());
                assertEquals("Incorrect decType", "v1Name" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable2.getDecType());
                assertEquals("Incorrect repType", "hashcode", declsFatherVariable2.getRepType());
                assertNull("The enclosing var should be null", declsFatherVariable2.getEnclosingVar());
                assertFalse("This variable should not be an array", declsFatherVariable2.isArray());
                assertEquals("Unexpected number of son variables", 2, declsFatherVariable2.getEnclosedVariables().size());

                // Sons
                // Name is a path variable
                List<DeclsVariable> declsSonVariables2 = declsFatherVariable2.getEnclosedVariables();
                DeclsVariable name2 = declsSonVariables2.get(0);
                assertEquals("Incorrect variable name", "input.name", name2.getVariableName());
                assertEquals("Incorrect var-kind", "field name", name2.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", name2.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", name2.getRepType());
                assertEquals("Incorrect enclosing var", "input", name2.getEnclosingVar());
                assertFalse("This variable should not be an array", name2.isArray());
                assertEquals("Unexpected number of son variables", 0, name2.getEnclosedVariables().size());

                DeclsVariable fullText2 = declsSonVariables2.get(1);
                assertEquals("Incorrect variable name", "input.fullText", fullText2.getVariableName());
                assertEquals("Incorrect var-kind", "field fullText", fullText2.getVarKind());
                assertEquals("Incorrect decType", "boolean", fullText2.getDecType());
                assertEquals("Incorrect repType", "boolean", fullText2.getRepType());
                assertEquals("Incorrect enclosing var", "input", fullText2.getEnclosingVar());
                assertFalse("This variable should not be an array", fullText2.isArray());
                assertEquals("Unexpected number of son variables", 0, fullText2.getEnclosedVariables().size());

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }

    }

    @Test
    public void testEnterReadPrimitiveParametersFromForm() {
        deleteAllDeclsClasses();
        String oasPath = "src/test/resources/LanguageTool/swagger.yaml";

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

                // ENTER 1
                DeclsEnter declsEnter1 = declsClassEnterAndExit.getDeclsEnters().get(0);
                String enterName1 = operationEndpoint + HIERARCHY_SEPARATOR + operationName + HIERARCHY_SEPARATOR + "200()";

                assertEquals("Incorrect enter name", enterName1, declsEnter1.getEnterName());

                // VARIABLES

                // Father
                DeclsVariable declsFatherVariable1 = declsEnter1.getDeclsVariables();
                assertEquals("Incorrect variable name", "input", declsFatherVariable1.getVariableName());
                assertEquals("Incorrect var-kind", "variable", declsFatherVariable1.getVarKind());
                assertEquals("Incorrect decType", "check" + HIERARCHY_SEPARATOR + "Input", declsFatherVariable1.getDecType());
                assertEquals("Incorrect repType", "hashcode", declsFatherVariable1.getRepType());
                assertNull("The enclosing var should be null", declsFatherVariable1.getEnclosingVar());
                assertFalse("This variable should not be an array", declsFatherVariable1.isArray());
                assertEquals("Unexpected number of son variables", 15, declsFatherVariable1.getEnclosedVariables().size());

                // Sons
                // text is a form parameter
                List<DeclsVariable> declsSonVariables1 = declsFatherVariable1.getEnclosedVariables();
                DeclsVariable text = declsSonVariables1.get(0);
                assertEquals("Incorrect variable name", "input.text", text.getVariableName());
                assertEquals("Incorrect var-kind", "field text", text.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", text.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", text.getRepType());
                assertEquals("Incorrect enclosing var", "input", text.getEnclosingVar());
                assertFalse("This variable should not be an array", text.isArray());
                assertEquals("Unexpected number of son variables", 0, text.getEnclosedVariables().size());

                // data is a form parameter
                DeclsVariable data = declsSonVariables1.get(1);
                assertEquals("Incorrect variable name", "input.data", data.getVariableName());
                assertEquals("Incorrect var-kind", "field data", data.getVarKind());
                assertEquals("Incorrect decType", "java.lang.String", data.getDecType());
                assertEquals("Incorrect repType", "java.lang.String", data.getRepType());
                assertEquals("Incorrect enclosing var", "input", data.getEnclosingVar());
                assertFalse("This variable should not be an array", data.isArray());
                assertEquals("Unexpected number of son variables", 0, data.getEnclosedVariables().size());

            }

            assertEquals("The expected total number of classes is one", getAllDeclsClasses().size(), 1);

        }




    }


}
