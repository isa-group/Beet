package agora.beet.model.harFiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Juan C. Alonso
 * This class represents the Http response part of an entry (HttpEntry) of a .har file
 */
public class HttpResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("statusText")
    @Expose
    private String statusText;
    @SerializedName("httpVersion")
    @Expose
    private String httpVersion;
    @SerializedName("content")
    @Expose
    private HttpResponseContent content;
    @SerializedName("redirectURL")
    @Expose
    private String redirectURL;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public HttpResponseContent getContent() {
        return content;
    }

    public void setContent(HttpResponseContent content) {
        this.content = content;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

}
