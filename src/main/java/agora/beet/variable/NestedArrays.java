package agora.beet.variable;

import agora.beet.model.DeclsVariable;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;

import java.util.ArrayList;
import java.util.List;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.variable.ArrayVariables.getDeclsVariablesArray;
import static agora.beet.variable.VariableUtils.translateDatatype;

/**
 * @author Juan C. Alonso
 */
public class NestedArrays {

    public static List<DeclsVariable> getDeclsVariablesOfNestedArray(Schema mapOfProperties , String variablePath,
                                                                     String varKind, String parameterName, String variableNameOutput) {

        List<DeclsVariable> res = new ArrayList<>();

        ArraySchema arraySchema = (ArraySchema) mapOfProperties.getProperties().get(parameterName);
        String itemsDatatype = arraySchema.getItems().getType();

        // Three possible situations:
        // If there is an allOf, parameterType is null, but the schema contains all the properties
        if(itemsDatatype == null || itemsDatatype.equalsIgnoreCase(OBJECT_TYPE_NAME) || itemsDatatype.equalsIgnoreCase(ARRAY_TYPE_NAME)) {
            // 1. The content is of type OBJECT (recursive call) (It will be necessary to create a new class)
            // OR
            // 2. The content is another ARRAY

            // Generate the father variable
            List<DeclsVariable> declsVariables = getDeclsVariablesArray(variablePath, parameterName,
                    parameterName, HASHCODE_TYPE_NAME);

            res.addAll(declsVariables);

        } else {    // 3. The content is a primitive type (base case)
            String translatedDatatype = translateDatatype(itemsDatatype);
            List<DeclsVariable> declsVariablesArrays = getDeclsVariablesArray(variablePath, parameterName,
                    translatedDatatype, translatedDatatype);

            res.addAll(declsVariablesArrays);
        }

        return res;

    }

}
