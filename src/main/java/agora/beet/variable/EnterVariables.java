package agora.beet.variable;

import agora.beet.model.DeclsVariable;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.main.GenerateInstrumentation.HASHCODE_TYPE_NAME;
import static agora.beet.variable.ArrayVariables.generateDeclsVariablesOfArray;
import static agora.beet.variable.ArrayVariables.getDeclsVariablesArray;
import static agora.beet.variable.ExitVariables.generateDeclsVariablesOfExit;
import static agora.beet.variable.VariableUtils.translateDatatype;

/**
 * @author Juan C. Alonso
 */
public class EnterVariables {

    public static DeclsVariable getListOfDeclsVariables(String objectName, String rootVariableName, Operation operation) {
        // Father parameter
        DeclsVariable father = new DeclsVariable(rootVariableName, null,"variable",
                objectName, HASHCODE_TYPE_NAME, null);

        List<DeclsVariable> enclosedVariables = new ArrayList<>();


        // Extract parameters from path, query and header
        List<Parameter> parameters = operation.getParameters();
        if(parameters != null) {
            for(Parameter parameter: parameters) {

                String parameterType = parameter.getSchema().getType();
                if(parameterType == null) {
                    throw new NullPointerException("Please specify the parameter type for the parameter " + parameter.getName() +
                            "\n If the error persists, specify it explicitly in the 'parameters' field of the API specification rather than using a '$ref'");
                }

                if(parameterType.equalsIgnoreCase(OBJECT_TYPE_NAME)) {  // Object
                    throw new NullPointerException("Please provide a primitive object or an array as input parameter");
                } else if(parameterType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {    // Array
                    // Only the first nesting level for the ENTER program point
                    ArraySchema arraySchema = (ArraySchema) parameter.getSchema();
                    String itemsDataType = arraySchema.getItems().getType();

                    if(itemsDataType.equalsIgnoreCase(OBJECT_TYPE_NAME) || itemsDataType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {   // The content is an array or an object
                        List<DeclsVariable> declsVariables = getDeclsVariablesArray(rootVariableName, parameter.getName(),
                                parameter.getName(), HASHCODE_TYPE_NAME);

                        enclosedVariables.addAll(declsVariables);

                    } else {    // The content is a primitive type
                        String translatedDatatype = translateDatatype(itemsDataType);

                        List<DeclsVariable> declsVariables = getDeclsVariablesArray(rootVariableName,
                                parameter.getName(), translatedDatatype, translatedDatatype);
                        enclosedVariables.addAll(declsVariables);

                    }
                } else {    // Primitive type
                    DeclsVariable declsVariable = new DeclsVariable(parameter.getName(), rootVariableName,
                            "field " + parameter.getName(), translateDatatype(parameterType),
                            translateDatatype(parameterType), father.getVariableName());
                    enclosedVariables.add(declsVariable);
                }


            }
        }

        List<DeclsVariable> declsVariablesFromBodyAndForm = getDeclsVariablesOfBodyAndFormParameters(operation, rootVariableName, objectName, "body");
        enclosedVariables.addAll(declsVariablesFromBodyAndForm);

        father.setEnclosedVariables(enclosedVariables);
        return father;

    }

    public static List<DeclsVariable> getDeclsVariablesOfBodyAndFormParameters(Operation operation,
                                                                               String rootVariableName, String objectName, String sourceOfParameter) {
        List<DeclsVariable> res = new ArrayList<>();

        RequestBody requestBody = operation.getRequestBody();
        if(requestBody != null) {
            Content content = requestBody.getContent();
            if (content != null) {
                for (String key : content.keySet()) {
                    res.addAll(getDeclsVariablesOfBodyAndFormParameters(operation, key, rootVariableName, objectName, sourceOfParameter,
                            objectName + "." + sourceOfParameter + "Array"));
                }

            }
        }

        return res;
    }

    private static List<DeclsVariable> getDeclsVariablesOfBodyAndFormParameters(Operation operation, String key,
                                                                               String rootVariableName, String objectName,
                                                                               String sourceOfParameter, String dectype) {
        Schema schema = null;

        RequestBody requestBody = operation.getRequestBody();
        if(requestBody != null) {
            Content content = requestBody.getContent();
            if(content != null) {
                MediaType mediaType = content.get(key);
                if(mediaType != null) {
                    String schemaType = mediaType.getSchema().getType();
                    if(schemaType != null && schemaType.equals("array")) {       // The parameter is of type array
                        ArraySchema arraySchema = (ArraySchema) mediaType.getSchema();      // objectName = createPlaylist_Input    rootVariableName = this
                        return Collections.singletonList(generateDeclsVariablesOfArray(arraySchema, rootVariableName,
                                sourceOfParameter, "variable", rootVariableName, dectype));
                    } else {                                                    // The body is of type object
                        schema = mediaType.getSchema();
                        if(schema.getProperties() == null) {
                            schema = null;
                        }
                    }

                }
            }
        }

        List<DeclsVariable> res = new ArrayList<>();
        if(schema != null) {
            res = generateDeclsVariablesOfExit(schema, rootVariableName,
                    "variable", objectName, false);
        }

        return res;
    }


}
