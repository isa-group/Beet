package agora.beet.variable;

import agora.beet.model.DeclsVariable;
import agora.beet.util.ArrayNestingManager;
import io.swagger.v3.oas.models.media.Schema;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.variable.NestedArrays.getDeclsVariablesOfNestedArray;
import static agora.beet.variable.VariableUtils.*;

/**
 * @author Juan C. Alonso
 */
public class ExitVariables {

    // Creates the father variable
    public static DeclsVariable generateDeclsVariablesOfExit(String variableName, String varKind,
                                                             String variableNameOutput, Schema mapOfProperties) {
        // This variable has no parentVariable
        DeclsVariable father = new DeclsVariable(variableName, null,varKind,
                variableNameOutput, HASHCODE_TYPE_NAME, null);

        // Creates the son variables
        List<DeclsVariable> enclosedVars = generateDeclsVariablesOfExit(mapOfProperties, variableName, varKind, variableNameOutput, false);
        father.setEnclosedVariables(enclosedVars);

        return father;
    }

    // Recursive method
    public static List<DeclsVariable> generateDeclsVariablesOfExit(Schema mapOfProperties, String parentVariable,
                                                                   String varKind, String variableNameOutput,
                                                                   boolean isArray) {
        List<DeclsVariable> res = new ArrayList<>();
        Map<String, Schema> properties = mapOfProperties.getProperties();
        // Warnings if properties == null
        if (properties == null) {
            if(mapOfProperties.getAdditionalProperties() == null) {
                System.err.println("WARNING: No properties found for object: " + parentVariable);
            } else{
                System.err.println("WARNING: Object: " + parentVariable + " only contains additional properties");
            }
        } else {
            Set<String> parameterNames = properties.keySet();

            for(String parameterName: parameterNames) {
                Schema schema = (Schema) mapOfProperties.getProperties().get(parameterName);
                String parameterType = schema.getType();

                // If there is an allOf, parameterType is null, but the schema contains all the properties
                if(parameterType == null || parameterType.equalsIgnoreCase(OBJECT_TYPE_NAME)) {  // Object
                    // Generate the father variable
                    DeclsVariable declsVariable = new DeclsVariable(parameterName, parentVariable, "field " + parameterName,
                            variableNameOutput + HIERARCHY_SEPARATOR + encodeVariableName(parameterName), HASHCODE_TYPE_NAME, parentVariable, isArray);

                    // Recursive call for son variables
                    List<DeclsVariable> enclosedVariables =
                            generateDeclsVariablesOfExit(schema, parentVariable + "." + encodeVariableName(parameterName), varKind,
                                    variableNameOutput, false);
                    // Set enclosed variables
                    declsVariable.setEnclosedVariables(enclosedVariables);
                    // Add to list
                    res.add(declsVariable);

                } else if(parameterType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {    // Array

                    // Obtain variables of nested arrays
                    List<DeclsVariable> declsVariables = getDeclsVariablesOfNestedArray(mapOfProperties, parentVariable,
                            varKind,  parameterName, variableNameOutput);
                    // Add to list
                    res.addAll(declsVariables);

                } else {    // Primitive type

                    // Create new variable
                    DeclsVariable declsVariable = new DeclsVariable(parameterName, parentVariable,"field " + parameterName,
                            translateDatatype(parameterType), translateDatatype(parameterType), parentVariable, isArray);
                    // Add to list
                    res.add(declsVariable);
                }
            }
        }

        return res;
    }

    // Used when the response is primitive (Bad practice)
    // Used for both output and exit
    // generateDeclsVariablesOfPrimitiveResponse(parameterType, objectName, "this", "variable")
    public static DeclsVariable generateDeclsVariablesOfPrimitiveResponse(String parameterType, String objectName,
                                                                          String parentVariable, String varKind) {
        DeclsVariable father = new DeclsVariable(parentVariable, null, varKind, objectName, HASHCODE_TYPE_NAME, null);

        String translatedDatatype = translateDatatype(parameterType);

        DeclsVariable enclosedVar = new DeclsVariable("primitive", parentVariable,"field primitive",
                translatedDatatype, translatedDatatype,
                parentVariable, false);

        father.setEnclosedVariables(Collections.singletonList(enclosedVar));

        return father;

    }

    public static List<Object> getListOfJsonElementsForDeclsExit(JSONObject json, List<String> elementRoute) {

        List<Object> res = new ArrayList<>();

        String element = decodeVariableName(elementRoute.get(0));

        if(json == null) {
            throw new NullPointerException("The response of the test case cannot be null");
        }

        // If the target element is a nested array
        List<String> elementArrayRoute = Arrays.stream(element.split(ARRAY_NESTING_SEPARATOR))
                .filter(e -> e.trim().length() > 0)
                .collect(Collectors.toList());
        // If the target element is a nested array
        if(elementArrayRoute.size() > 1) {
            // Get the nested arrays (i.e., value of the element)
            JSONArray jsonArray = (JSONArray) json.get(elementArrayRoute.get(0));
            // We increase the targetNestingLevel by one because the first level of nesting is already present in the father exit
            int targetNestingLevel = (int) Arrays
                    .stream(element.split(ARRAY_NESTING_SEPARATOR))
                    .filter(x->x.equalsIgnoreCase("array"))
                    .count() + 1;
            List<JSONArray> jsonArraysToGenerateDtrace = ArrayNestingManager
                    .getJSONArraysOfSpecifiedNestingLevel(jsonArray, targetNestingLevel, 1);
            res.addAll(jsonArraysToGenerateDtrace);

            return res;
        }

        Object jsonSon = json.get(element);

        if(jsonSon instanceof  JSONObject) {        // If jsonSon is of type JSONObject
            JSONObject jsonSonObject = (JSONObject) jsonSon;
            if(elementRoute.size() == 1) {      // If element is the last element of elementRoute (i.e. is the object we are looking for)
                res.add(jsonSonObject.get(element));    // Add JSONObject
            } else {
                // Recursive call if element is not the last element of elementRoute
                res.addAll(getListOfJsonElementsForDeclsExit(jsonSonObject, elementRoute.subList(1, elementRoute.size())));
            }
        } else if(jsonSon instanceof JSONArray) {   // If jsonSon is of type JSONArray
            JSONArray jsonSonArray = (JSONArray) jsonSon;

            // Iterate over all elements of the JSONArray
            for(int i = 0; i < jsonSonArray.size(); i++) {
                Object jsonSonElement = jsonSonArray.get(i);

                if(jsonSonElement instanceof JSONObject) {
                    if(elementRoute.size()==1){
                        res.add(jsonSonElement);       // Add JSONObject
                    } else {
                        res.addAll(getListOfJsonElementsForDeclsExit((JSONObject) jsonSonElement, elementRoute.subList(1, elementRoute.size())));
                    }
                } else if(jsonSonElement instanceof JSONArray) {        // This condition is reached when we are dealing with a nested array
                    // Get all the properties of the nested array
                    List<JSONObject> flatList = ArrayNestingManager.doBubbleSort((JSONArray) jsonSonElement);
                    res.addAll(flatList);
                }
            }

        }

        return res;

    }

}
