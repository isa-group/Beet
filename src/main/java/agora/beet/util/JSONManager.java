package agora.beet.util;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Juan C. Alonso
 */
public class JSONManager {

    public static JSONArray stringToJsonArray(String input) {

        JSONParser parser = new JSONParser();
        try {
            return (JSONArray) parser.parse(input);
        } catch (ParseException e) {
            System.err.println("Error converting the response body to string");
            System.exit(1);
        }

        return null;
    }

    public static JSONObject stringToJsonObject(String input) {

        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(input);
        } catch (ParseException e) {
            System.err.println("Error converting the response body to string");
            System.exit(1);
        }

        return null;
    }

    public static boolean isStringJsonArray(String input) {
        JSONParser parser = new JSONParser();

        try{
            return parser.parse(input) instanceof JSONArray;
        } catch (ParseException e) {
            System.err.println("Error converting the response body to string");
            System.exit(1);
        }

        return false;

    }

}
