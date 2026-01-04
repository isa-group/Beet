package agora.beet.model.harFiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Juan C. Alonso
 * This class represents a single entry from a .har file, which contains both the HTTP request and its corresponding
 * response.
 */
public class HttpEntry {


    @SerializedName("request")
    @Expose
    private HttpRequest request;
    @SerializedName("response")
    @Expose
    private HttpResponse response;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public void setResponse(HttpResponse response) {
        this.response = response;
    }

}
