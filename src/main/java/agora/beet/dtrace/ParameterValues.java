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
        value = queryParametersValues.get(key);
        if(value == null) {
            value = pathParametersValues.get(key);
        }
        if(value == null) {
            value = headerParametersValues.get(key);
        }
        if(value == null) {
            value = formParametersValues.get(key);
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
            hierarchy = hierarchy.subList(1, hierarchy.size());

            if(hierarchy.size()>0) {
                String key = getEnterParameterValue(testCase, hierarchy);
                if(key==null){
                    value = null;
                }
            }

        }

        return value;
    }


    
}
