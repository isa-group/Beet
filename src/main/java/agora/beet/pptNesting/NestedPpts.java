package agora.beet.pptNesting;

import agora.beet.model.DeclsExit;
import agora.beet.model.DeclsVariable;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

import java.util.*;

import static agora.beet.main.GenerateInstrumentation.*;
import static agora.beet.main.GenerateInstrumentation.HIERARCHY_SEPARATOR;
import static agora.beet.variable.VariableUtils.translateDatatype;

/**
 * @author Juan C. Alonso
 */
public class NestedPpts {

    public static List<DeclsExit> getAllNestedDeclsExits(String endpoint, String operationName, String variableNameInput,
                                                         DeclsVariable enterVariables, String outputObjectName, MediaType mediaType,
                                                         String statusCode) {

        List<DeclsExit> res = new ArrayList<>();
        String parameterType = mediaType.getSchema().getType();
        Schema mapOfProperties = mediaType.getSchema();

        if(parameterType !=null && parameterType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {
            // Get the schema as ArraySchema
            ArraySchema arraySchema = (ArraySchema) mediaType.getSchema();
            // nameSuffix = parentVariable
            String nameSuffix = ARRAY_NESTING_SEPARATOR + "array";

            while(parameterType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {
                DeclsExit declsExit = new DeclsExit(endpoint, operationName, variableNameInput, enterVariables, outputObjectName,
                        arraySchema, "array", nameSuffix, statusCode);
                res.add(declsExit);

                parameterType = arraySchema.getItems().getType();

                if(parameterType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {
                    arraySchema = (ArraySchema) arraySchema.getItems();
                } else {
                    mapOfProperties = arraySchema.getItems();
                }
                nameSuffix = nameSuffix + ARRAY_NESTING_SEPARATOR + "array";
            }

        } else if(parameterType !=null && primitiveTypes.contains(translateDatatype(parameterType))) {
            DeclsExit primitiveExit = new DeclsExit(endpoint, operationName, variableNameInput, enterVariables,
                    outputObjectName, parameterType, statusCode);
            return Collections.singletonList(primitiveExit);
        }

        // Create DeclsObjects with the elements of the array
        // If there is an allOf, parameterType is null, but the schema contains all the properties
        if(parameterType ==null || parameterType.equalsIgnoreCase(OBJECT_TYPE_NAME)) {
            Map<String, Schema> allSchemas = new HashMap<>();

            allSchemas.put("", mapOfProperties);
            allSchemas.putAll(getAllNestedSchemas("", mapOfProperties));

            for(String nameSuffix: allSchemas.keySet()) {
                if(allSchemas.get(nameSuffix).getProperties()==null){       // If the element is of type array, call the constructor that receives an ArraySchema
                    ArraySchema arraySchema = (ArraySchema) allSchemas.get(nameSuffix);
                    DeclsExit declsExit = new DeclsExit(endpoint, operationName, variableNameInput, enterVariables, outputObjectName,
                            arraySchema, nameSuffix, nameSuffix, statusCode);
                    res.add(declsExit);
                } else {    // If the element is of type object, call the constructor that receives an Schema
                    DeclsExit declsExit = new DeclsExit(endpoint, operationName,
                            variableNameInput, enterVariables, outputObjectName, allSchemas.get(nameSuffix), nameSuffix, statusCode);
                    res.add(declsExit);
                }

            }

        }

        return res;

    }

    public static Map<String, Schema> getAllNestedSchemas(String nameSuffix, Schema mapOfProperties) {
        Map<String, Schema> res = new HashMap<>();

        Map<String, Schema> properties = mapOfProperties.getProperties();
        // Warnings if properties == null
        if (properties == null) {
            if(mapOfProperties.getAdditionalProperties() == null) {
                System.err.println("WARNING: No properties found for object: " + nameSuffix);
            } else{
                System.err.println("WARNING: Object: " + nameSuffix + " only contains additional properties");
            }
        } else {
            Set<String> parameterNames = properties.keySet();

            for(String parameterName: parameterNames) {
                Schema schema = (Schema) mapOfProperties.getProperties().get(parameterName);
                String parameterType = schema.getType();

                // If there is an allOf, parameterType is null, but the schema contains all the properties
                if(parameterType == null || parameterType.equalsIgnoreCase(OBJECT_TYPE_NAME)) {     // If object
                    // Recursive call with object.getParameter
                    res.putAll(getAllNestedSchemas(nameSuffix + HIERARCHY_SEPARATOR + parameterName, schema));

                } else if(parameterType.equalsIgnoreCase(ARRAY_TYPE_NAME)) {    // If array
                    ArraySchema arraySchema = (ArraySchema) mapOfProperties.getProperties().get(parameterName);
                    String itemsDatatype = arraySchema.getItems().getType();
                    StringBuilder nestingSuffix = new StringBuilder(ARRAY_NESTING_SEPARATOR + "array");

                    // If there is an allOf, parameterType is null, but the schema contains all the properties
                    while(itemsDatatype != null && itemsDatatype.equals(ARRAY_TYPE_NAME)) {
                        arraySchema = (ArraySchema) arraySchema.getItems();
                        res.put(nameSuffix + HIERARCHY_SEPARATOR + parameterName + nestingSuffix, arraySchema);
                        itemsDatatype = arraySchema.getItems().getType();
                        nestingSuffix.append(ARRAY_NESTING_SEPARATOR).append("array");
                    }

                    // If there is an allOf, parameterType is null, but the schema contains all the properties
                    if(itemsDatatype == null || itemsDatatype.equalsIgnoreCase(OBJECT_TYPE_NAME)) {
                        Schema subSchema = arraySchema.getItems();

                        res.put(nameSuffix + HIERARCHY_SEPARATOR + parameterName, subSchema);

                        res.putAll(getAllNestedSchemas(nameSuffix + HIERARCHY_SEPARATOR + parameterName, subSchema));
                    }
                }
            }
        }

        return res;
    }

}
