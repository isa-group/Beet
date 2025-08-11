package agora.beet.dtrace;

import agora.beet.model.TestCase;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static agora.beet.dtrace.EnterArray.generateDtraceEnterValueOfArray;
import static agora.beet.dtrace.VariableValues.getPrimitiveValueFromHierarchy;
import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.main.GenerateInstrumentation.HIERARCHY_SEPARATOR;
import static agora.beet.util.JSONManager.stringToJsonObject;
import static agora.beet.util.StringManager.decodeString;
import static agora.beet.util.StringManager.encodeString;
import static agora.beet.variable.VariableUtils.decodeVariableName;

/**
 * @author Juan C. Alonso
 */
public class ParameterValues {

    private static String getEnterParameterValue(TestCase testCase, List<String> hierarchy) {
        Map<String, String> queryParametersValues = testCase.getQueryParameters();
        Map<String, String> pathParametersValues = testCase.getPathParameters();
        Map<String, String> headerParametersValues = testCase.getHeaderParameters();
        Map<String, String> formParametersValues = testCase.getFormParameters();
        String bodyParameter = testCase.getBodyParameter();

        String value = null;

        String key = decodeVariableName(hierarchy.get(hierarchy.size()-1));
        value = getParameterValueFromSource(queryParametersValues, key);
        if(value == null) {
            value = getParameterValueFromSource(pathParametersValues, key);
        }
        if(value == null) {
            value = getParameterValueFromSource(headerParametersValues, key);
        }
        if(value == null) {
            value = getParameterValueFromSource(formParametersValues, key);
        }

        // Search in body parameter
        if(value == null &&  bodyParameter != null && !bodyParameter.equals("")) {
            JSONObject jsonBodyParameter = stringToJsonObject(bodyParameter);
            if(jsonBodyParameter != null) {
                List<String> hierarchyBody = hierarchy.subList(1, hierarchy.size());
                value = getPrimitiveValueFromHierarchy(jsonBodyParameter, hierarchyBody);
            }
        }

        // Set value to null if its value should be considered as null
        if(Arrays.asList(stringsToConsiderAsNull).contains(value)) {
            value = null;
        }

        return value;

    }

    /**
     * Try to get the parameter value from a specific source (i.e., query/path/header/form). If the key is not found
     * in the parameter source map, the method tries to find a URL encoded version of that key (e.g., convert image[0]
     * to images%5B0%5D in Stripe API) in the map.
     * @param sourceParametersValues: Map<String, String> containing the keys.
     * @param key: Parameter name to search for.
     * @return Parameter value, null if the parameter is not present
     */
    private static String getParameterValueFromSource(Map<String, String> sourceParametersValues, String key) {
        String value = sourceParametersValues.get(key);

        // If the key was not present in the map
        if (value == null) {
            // Try to find an encoded version of the parameter name in the map
            value = sourceParametersValues.get(encodeString(key));
        }

        return value;
    }


    // Used for ENTER parameters
    public static String getValueOfParameterForDtraceFile(TestCase testCase, String variableName, String decType, String repType) {
        String value = null;
        // Consider path, header and body parameter (First level)
        if(primitiveTypes.contains(decType)) { // If primitive value

            // Get the variable name (Without Wrapping)
            List<String> hierarchy = Arrays.asList(variableName.split("\\."));
            if(hierarchy.size() > 1) {
                value = getEnterParameterValue(testCase, hierarchy);
            } else {
                value = decodeVariableName(variableName);
            }

            if(repType.equals(STRING_TYPE_NAME) && value != null) {
                // Decode the parameter value. For example, "street+address" is decoded as "street address" and "1%2C2" is decoded as "1,2"
                value = decodeString(value);
                value = "\"" + value + "\"";
            }
        } else if(variableName.contains("[..]")){   // If array values
            List<String> hierarchy = Arrays.asList(variableName.replace("[..]", "").split("\\."));
            if(hierarchy.size() > 1) {
                // Get the array value. Example: element1%2element2%2Celement3
                value = getEnterParameterValue(testCase, hierarchy);
                if(value!=null){
                    // Decode the value. Example element1,element2,element3
                    value = decodeString(value);
                    // Convert the value to array (replace "," with spaces and add [])
                    value = generateDtraceEnterValueOfArray(testCase, value, decType, variableName);
                } else {
                    // If the array is null, return nonsensical
                    value = "nonsensical";
                }
            } else {
                value = variableName;
            }

        } else {    // If type = object or identifier of array
            value = "\"" + testCase.getTestCaseId() + variableName +  "input" + "\"";
            value = value.replace(HIERARCHY_SEPARATOR, "").replace("_", "");
            value = String.valueOf(Math.abs(value.hashCode()));

            List<String> hierarchy = Arrays.asList(variableName.split("\\."));

            if(hierarchy.size() > 1) {
                String key = getEnterParameterValue(testCase, hierarchy);
                if(key==null){
                    value = null;
                }
            }

        }

        return value;
    }


    
}
