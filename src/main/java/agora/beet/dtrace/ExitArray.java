package agora.beet.dtrace;

import agora.beet.model.TestCase;
import agora.beet.util.TestCaseFileManager;
import org.json.simple.JSONArray;

import java.util.Arrays;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.main.GenerateInstrumentation.HIERARCHY_SEPARATOR;

/**
 * @author Juan C. Alonso
 */
public class ExitArray {

    public static String generateDtraceExitValueOfJSONArray(TestCase testCase, JSONArray elements, String dectype,
                                                            String variableName) {
        StringBuilder value = new StringBuilder("nonsensical");

        // If elements == null, the elements are set to nonsensical
        if(elements != null){
            if(primitiveTypes.contains(dectype.replace("[]", ""))) { // If array of primitives
                boolean isString = dectype.replace("[]", "").equals(STRING_TYPE_NAME);
                value = new StringBuilder();
                for (Object element : elements) {

                    if (isString) {
                        if (element == null || Arrays.asList(stringsToConsiderAsNull).contains(element)) {
                            value.append(" ").append("null");
                        } else {
                            value.append(" \"").append(TestCaseFileManager.removeNewLineChars((String) element)).append("\"");
                        }
                    } else {
                        value.append(" ").append(element);
                    }
                }

                value = new StringBuilder("[" + value.toString().trim() + "]");

            } else {    // If array of objects
                StringBuilder hashcode = new StringBuilder();
                for(int i = 1; i <= elements.size(); i++) {
                    if(elements.get(i-1) != null) {
                        String v = "\"" + testCase.getTestCaseId() + HIERARCHY_SEPARATOR +
                                variableName.replace("[..]", "") + HIERARCHY_SEPARATOR + "output"
                                + HIERARCHY_SEPARATOR + i + "\"";
                        v = v.replace(HIERARCHY_SEPARATOR, "").replace("_", "");
                        hashcode.append(Math.abs(v.hashCode())).append(" ");
                    } else {
                        hashcode.append("null ");
                    }

                }

                value = new StringBuilder("[" + hashcode.toString().trim() + "]");
            }
        }
        return value.toString();
    }

}
