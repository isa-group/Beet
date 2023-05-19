package agora.beet.dtrace;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

import static agora.beet.variable.VariableUtils.decodeVariableName;

/**
 * @author Juan C. Alonso
 */
public class VariableValues {

    // This class contains functions related to both input and output

    public static String getPrimitiveValueFromHierarchy(JSONObject json, List<String> hierarchy) {
        String key = decodeVariableName(hierarchy.get(0));

        if(hierarchy.size() == 1) {

            if(json.get(key) == null){
                return null;
            } else {
                return String.valueOf(json.get(key));
            }

        } else {
            Object jsonSon = json.get(key);

            if(jsonSon instanceof JSONObject) {     // If JSONObject
                JSONObject jsonSonObject = (JSONObject) jsonSon;
                return getPrimitiveValueFromHierarchy(jsonSonObject, hierarchy.subList(1, hierarchy.size()));
            } else {    // If JSONArray
                // TODO: Complete
                return null;
            }
        }

    }

    public static JSONArray getArrayFromHierarchy(JSONObject json, List<String> hierarchy) {
        String key = decodeVariableName(hierarchy.get(0));

        if(hierarchy.size() ==1){
            return (JSONArray) json.get(key);
        } else {
            Object jsonSon = json.get(key);

            if(jsonSon instanceof JSONObject) {     // If JSONObject
                JSONObject jsonSonObject = (JSONObject) jsonSon;
                return getArrayFromHierarchy(jsonSonObject, hierarchy.subList(1, hierarchy.size()));

            } else{     // If JSONArray
                JSONArray jsonSonArray = (JSONArray) jsonSon;
                // TODO: Complete
                return null;
            }
        }

    }

}
