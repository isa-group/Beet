package agora.beet.model;

import io.swagger.v3.oas.models.Operation;

import static agora.beet.main.GenerateInstrumentation.HIERARCHY_SEPARATOR;
import static agora.beet.variable.EnterVariables.getListOfDeclsVariables;

/**
 * @author Juan C. Alonso
 */
public class DeclsEnter {

    private String endpoint;
    private String operationName;
    private String variableNameInput;
    private String nameSuffix;
    private String statusCode;

    private DeclsVariable declsVariables;

    public DeclsEnter(String endpoint,
                      String operationName, String variableNameInput,
                      Operation operation, String rootVariableName,
                      String nameSuffix, String statusCode) {
        this.endpoint = endpoint;
        this.operationName = operationName;
        this.variableNameInput = variableNameInput;
        this.declsVariables = getListOfDeclsVariables(variableNameInput, rootVariableName, operation);

        this.nameSuffix = nameSuffix;
        this.statusCode = statusCode;
    }

    public String getEnterName() {
        return this.endpoint + HIERARCHY_SEPARATOR + this.operationName + HIERARCHY_SEPARATOR
                + this.statusCode + this.nameSuffix + "()";
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getVariableNameInput() {
        return variableNameInput;
    }

    public void setVariableNameInput(String variableNameInput) {
        this.variableNameInput = variableNameInput;
    }

    public String getNameSuffix() { return nameSuffix; }

    public void setNameSuffix(String nameSuffix) { this.nameSuffix = nameSuffix; }

    public String getStatusCode() { return statusCode; }

    public void setStatusCode(String statusCode) { this.statusCode = statusCode; }

    public DeclsVariable getDeclsVariables() {
        return declsVariables;
    }

    public void setDeclsVariables(DeclsVariable declsVariables) {
        this.declsVariables = declsVariables;
    }

    public String toString() {
        String res = "ppt " + this.getEnterName() + ":::ENTER" + "\n" +
                "ppt-type enter";

        res = res + "\n" + declsVariables;

        return res;
    }

    public String generateDtrace(TestCase testCase) {

        String res = this.getEnterName() + ":::ENTER";

        res = res + "\n" + declsVariables.generateDtraceEnter(testCase);

        res = res + "\n";

        return res;
    }

}
