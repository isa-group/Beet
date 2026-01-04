package agora.beet.model.harFiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 * @author Juan C. Alonso
 * This class contains both the request body and the form parameters.
 */
public class PostData {

    @SerializedName("params")
    @Expose
    private List<Parameter> params;
    @SerializedName("text")
    @Expose
    private String text;

    public List<Parameter> getParams() {
        return params;
    }

    public void setParams(List<Parameter> params) {
        this.params = params;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
