package agora.beet.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Juan C. Alonso
 */
public class ArrayNestingManager {


    // Based on: https://stackoverflow.com/questions/54008740/parse-multi-dimensional-json-array-to-flat-int-list-in-java
    // This function flattens all the objects contained within nested arrays
    public static List<JSONObject> doBubbleSort(JSONArray jsonArray) {

        List<?> list = Arrays.asList(jsonArray.toArray());

        return list.stream().map(x-> {
            List<JSONObject> r = new ArrayList<>();
            try {
                if(x != null) {
                    r = getOrFlatten(x);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return r;
        }).flatMap(List::stream).collect(Collectors.toList());

    }

    private static List<JSONObject> getOrFlatten(Object o) throws Exception {
        List<JSONObject> res = new ArrayList<>();
        if(o instanceof JSONObject) {
            res = Collections.singletonList((JSONObject) o);
        } else if(o instanceof List) {
            List<?> list = (List) o;
            res = list.stream().map(x-> {
                List<JSONObject> r = new ArrayList<>();
                try {
                    if(x != null) {
                        r = getOrFlatten(x);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                return r;
            }).flatMap(List::stream).collect(Collectors.toList());
        } else {
            throw new Exception(o.getClass() + " is not supported at getOrFlatten");

        }
        return res;
    }

    // This function returns all the arrays that belong to the provided targetNestingLevel
    public static List<JSONArray> getJSONArraysOfSpecifiedNestingLevel(JSONArray jsonArray,
                                                                   int targetNestingLevel, int currentNestingLevel) throws IllegalArgumentException {

        // Throw exception if currentNestingLevel is greater than targetNestingLevel
        if(currentNestingLevel > targetNestingLevel) {
            throw new IllegalArgumentException("targetNestingLevel must be greater or equal than currentNestingLevel");
        }

        List<JSONArray> res = new ArrayList<>();

        if(currentNestingLevel != targetNestingLevel) {     // Case 1: The nesting level IS NOT the target one
            // Recursive call increasing the nesting level
            currentNestingLevel = currentNestingLevel + 1;
            if(jsonArray != null){
                for (Object element : jsonArray) {
                    res.addAll(getJSONArraysOfSpecifiedNestingLevel((JSONArray) element, targetNestingLevel, currentNestingLevel));
                }
            }
        } else {    // Case 2: The nesting level IS the target one
            // Base case: return the jsonArray
            res.add(jsonArray);
        }

        return res;
    }

}
