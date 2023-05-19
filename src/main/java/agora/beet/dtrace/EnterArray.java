package agora.beet.dtrace;

import agora.beet.model.TestCase;
import agora.beet.util.JSONManager;
import org.json.simple.JSONArray;

import static agora.beet.dtrace.ExitArray.generateDtraceExitValueOfJSONArray;
import static agora.beet.main.GenerateInstrumentation.STRING_TYPE_NAME;

/**
 * @author Juan C. Alonso
 */
public class EnterArray {

    public static String generateDtraceEnterValueOfArray(TestCase testCase, String elements, String dectype, String variableName) {
        // Convert the input into a JSONArray in order to call the generateDtraceExitValueOfJSONArray
        JSONArray valueArray = null;
        if(dectype.replace("[]","").equals(STRING_TYPE_NAME)) {
            // Add double quotes to all array elementsApply if the elements are of type string
            valueArray = JSONManager.stringToJsonArray( "[\"" + elements.replace(",","\",\"") + "\"]");
        } else {
            valueArray = JSONManager.stringToJsonArray("[" + elements + "]");
        }

        return generateDtraceExitValueOfJSONArray(testCase, valueArray, dectype, variableName);
    }

}
