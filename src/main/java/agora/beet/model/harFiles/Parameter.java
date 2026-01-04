package agora.beet.model.harFiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Juan C. Alonso
 * This class represents a parameter (e.g., query or header) from an HttpRequest of a .har file.
 */
public class Parameter {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
