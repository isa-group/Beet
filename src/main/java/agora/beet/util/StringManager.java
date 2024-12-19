package agora.beet.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Juan C. Alonso
 */
public class StringManager {

    /**
     * Used to encode URL special characters (e.g., convert image[0] to images%5B0%5D in Stripe API)
     * @param parameterName Name of the input parameter we want to encode
     * @return Encoded string
     */
    public static String encodeString(String parameterName) {

        if (parameterName == null) {
            throw new IllegalArgumentException("parameterValue cannot be null");
        }

        return URLEncoder.encode(parameterName, StandardCharsets.UTF_8);
    }

    /**
     * Used to decode URL special characters (e.g., replace "+" with " ")
     * @param parameterValue: Encoded URL string
     * @return Decoded URL string
     */
    public static String decodeString(String parameterValue) {

        if (parameterValue == null) {
            throw new IllegalArgumentException("parameterValue cannot be null");
        }

        return URLDecoder.decode(parameterValue, StandardCharsets.UTF_8);
    }

}
