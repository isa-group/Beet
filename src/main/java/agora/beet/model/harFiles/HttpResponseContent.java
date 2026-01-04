package agora.beet.model.harFiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Juan C. Alonso
 * This class stores the response text of an HttpResponse
 */
public class HttpResponseContent {

    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    @SerializedName("text")
    @Expose
    private String text;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
