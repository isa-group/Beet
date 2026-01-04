package agora.beet.model.harFiles;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Juan C. Alonso
 * This class represents the Http request part of an entry (HttpEntry) of a .har file.
 */
public class HttpRequest {

    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("headers")
    @Expose
    private List<Parameter> headers;
    @SerializedName("queryString")
    @Expose
    private List<Parameter> queryString;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Parameter> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Parameter> headers) {
        this.headers = headers;
    }

    public List<Parameter> getQueryString() {
        return queryString;
    }

    public void setQueryString(List<Parameter> queryString) {
        this.queryString = queryString;
    }

}
