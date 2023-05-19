package agora.beet.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Juan C. Alonso
 */
public class StringManager {

    /**
     * Used to decode URL special characters (e.g., replace "+" with " ")
     * @param parameterValue: Encoded URL string
     * @return Decoded URL string
     */
    public static String decodeString(String parameterValue) {
        try {
            return URLDecoder.decode(parameterValue, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
