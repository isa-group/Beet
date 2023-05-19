package agora.beet.model;

import java.util.List;

/**
 * @author Juan C. Alonso
 */
public class DeclsFile {

    private double version;
    private Comparability comparability;
    private List<DeclsClass> declsClasses;

    public DeclsFile(double version, Comparability comparability, List<DeclsClass> declsClasses) {
        this.version = version;
        this.comparability = comparability;
        this.declsClasses = declsClasses;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public Comparability getComparability() {
        return comparability;
    }

    public void setComparability(Comparability comparability) {
        this.comparability = comparability;
    }

    public List<DeclsClass> getClasses() {
        return declsClasses;
    }

    public void setClasses(List<DeclsClass> declsClasses) {
        this.declsClasses = declsClasses;
    }

    public String toString() {
        StringBuilder res = new StringBuilder("decl-version " + version + "\n" +
                "var-comparability " + comparability + "\n");

        for(DeclsClass declsClass: declsClasses) {
            res.append("\n").append(declsClass).append("\n");
        }

        return res.toString();
    }
}
