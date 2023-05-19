package agora.beet.model;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.Map.Entry;

import java.util.*;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.pptNesting.NestedPpts.getAllNestedDeclsExits;
import static agora.beet.variable.EnterVariables.getListOfDeclsVariables;

/**
 * @author Juan C. Alonso
 */
public class DeclsClass {

    private String className;
    private List<DeclsEnter> declsEnters;
    private List<DeclsExit> declsExits;


    public DeclsClass(String className) {
        this.className = className;
        this.declsEnters = new ArrayList<>();
        this.declsExits = new ArrayList<>();

    }

    // DeclsClass for ENTER
    public static void setDeclsClassEnterAndExit(String endpoint, String operationName,
                                                 String variableNameInput, Operation operation) {

        // ApiResponses = operation.getResponses
        DeclsClass declsClass = new DeclsClass(endpoint);

        // Variables of the enter
        DeclsVariable enterVariables = getListOfDeclsVariables(variableNameInput, "input", operation);

        // for loop that adds all the possible subexits
        List<DeclsExit> declsExits = new ArrayList<>();

        ApiResponses apiResponses = operation.getResponses();
        for(Entry<String, ApiResponse> apiResponse: apiResponses.entrySet()) {
            String outputObjectName = operationName + HIERARCHY_SEPARATOR + "Output" + HIERARCHY_SEPARATOR + apiResponse.getKey();

            for(MediaType mediaType: apiResponse.getValue().getContent().values()) {

                List<DeclsExit> nestedDeclsExits = getAllNestedDeclsExits(endpoint, operationName,
                        variableNameInput, enterVariables, outputObjectName, mediaType, apiResponse.getKey());

                declsExits.addAll(nestedDeclsExits);
            }
        }

        List<DeclsEnter> declsEnters = new ArrayList<>();
        for(DeclsExit declsExit: declsExits) {
            declsEnters.add(new DeclsEnter(endpoint, operationName, variableNameInput, operation, "input",
                    declsExit.getNameSuffix(), declsExit.getStatusCode()));
        }

        declsClass.setDeclsEnters(declsEnters);
        declsClass.setDeclsExits(declsExits);
        addNewDeclsClass(declsClass);

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<DeclsEnter> getDeclsEnters() {
        return declsEnters;
    }

    public void setDeclsEnters(List<DeclsEnter> declsEnters) {
        this.declsEnters = declsEnters;
    }

    public List<DeclsExit> getDeclsExits() {
        return declsExits;
    }

    public void setDeclsExits(List<DeclsExit> declsExits) {
        this.declsExits = declsExits;
    }

    public String toString() {
        StringBuilder res = new StringBuilder("ppt " + className + ":::CLASS" + "\n" +
                "ppt-type class" + "\n");

        for(DeclsEnter declsEnter: declsEnters) {
            res.append("\n").append(declsEnter).append("\n");
        }

        for(DeclsExit declsExit: declsExits) {
            res.append("\n").append(declsExit).append("\n");
        }

        return res.toString();
    }

}
