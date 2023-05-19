package agora.beet.variable;

import agora.beet.model.DeclsVariable;
import io.swagger.v3.oas.models.media.ArraySchema;

import java.util.ArrayList;
import java.util.List;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.variable.VariableUtils.*;

/**
 * @author Juan C. Alonso
 */
public class ArrayVariables {

    public static DeclsVariable generateDeclsVariablesOfArray(ArraySchema arraySchema, String variablePath,
                                                              String variableName, String varKind, String enclosingVar, String dectype) {
        DeclsVariable res = generateDeclsVariablesOfArrayExit(arraySchema, dectype, variableName, varKind, variablePath);
        res.setEnclosingVar(enclosingVar);
        return res;
    }


    // Used when the return type is an array of objects (Bad practice)
    // Used for both output and exit
    public static DeclsVariable generateDeclsVariablesOfArrayExit(ArraySchema arraySchema, String decType,
                                                                  String variableName, String varKind, String variablePath) {

        // In this case, the parentVariable is the variableName
        DeclsVariable father = new DeclsVariable(variableName,
                variablePath,
                varKind,
                decType,
                HASHCODE_TYPE_NAME, null);

        List<DeclsVariable> enclosedVars;
        String itemsDatatype = arraySchema.getItems().getType();

        String translatedDatatype = translateDatatype(itemsDatatype);

        String updatedVariablePath = encodeVariableName(variableName);
        if (variablePath != null) {
            updatedVariablePath = variablePath + "." + encodeVariableName(variableName);
        }


        if(primitiveTypes.contains(translatedDatatype) && !itemsDatatype.equals(OBJECT_TYPE_NAME)) {
            enclosedVars = getDeclsVariablesArray(updatedVariablePath, ARRAY_TYPE_NAME, translatedDatatype,
                    translatedDatatype);
        } else{
            enclosedVars = getDeclsVariablesArray(updatedVariablePath, ARRAY_TYPE_NAME, ARRAY_TYPE_NAME,
                    HASHCODE_TYPE_NAME);
        }

        father.setEnclosedVariables(enclosedVars);

        return father;
    }

    public static List<DeclsVariable> getDeclsVariablesArray(String variablePath, String parameterName,
                                                             String decType, String repType) {
        List<DeclsVariable> res = new ArrayList<>();

        String arrayIndicator = "[]";

        if(!primitiveTypes.contains(decType)) {
            decType = encodeVariableName(decType);
        }

//        String variableName = variablePath + "." + parameterName;
        // The enclosing var does not contain the name of the variable (this)
        res.add(new DeclsVariable(parameterName, variablePath,"field " + parameterName, decType + arrayIndicator, HASHCODE_TYPE_NAME, variablePath));

        // The enclosing var name contains the name of the variable (this.array)
        DeclsVariable arrayElementsVariable = new DeclsVariable(parameterName, variablePath, ARRAY_TYPE_NAME, decType + arrayIndicator,
                repType  + arrayIndicator, variablePath + "." + encodeVariableName(parameterName));
        arrayElementsVariable.setVariableName(arrayElementsVariable.getVariableName() + "[..]");
        res.add(arrayElementsVariable);

        return res;
    }

}
