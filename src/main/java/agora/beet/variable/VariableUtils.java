package agora.beet.variable;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.main.GenerateInstrumentation.STRING_TYPE_NAME;

/**
 * @author Juan C. Alonso
 */
public class VariableUtils {

    // Converts the datatype name from OAS to daikon
    // Returns String by default
    public static String translateDatatype(String input) {

        return switch (input.toLowerCase()) {
            case "number" -> DOUBLE_TYPE_NAME;
            case "integer" -> INTEGER_TYPE_NAME;
            case "boolean" -> BOOLEAN_TYPE_NAME;
            case "object" -> OBJECT_TYPE_NAME;
            case "array" -> ARRAY_TYPE_NAME;
            default -> STRING_TYPE_NAME;   // Including case "string"
        };

    }

    // Replaces special characters from variable name
    public static String encodeVariableName(String variableName) {
        return variableName.replace(".", HIERARCHY_SEPARATOR);
    }

    // Replaces hierarchy separator from variable name to special character
    public static String decodeVariableName(String encodedVariableName) {
        return encodedVariableName.replace(HIERARCHY_SEPARATOR, ".");
    }

}
