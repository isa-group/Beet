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
            allSchemas.putAll(getAllNestedSchemas("", mapOfProperties, endpoint, operationName));

            for(String nameSuffix: allSchemas.keySet()) {
                Schema s = allSchemas.get(nameSuffix);
                String schemaType = s.getType();
                if (ARRAY_TYPE_NAME.equalsIgnoreCase(schemaType) && s instanceof ArraySchema) {
                    ArraySchema arraySchema = (ArraySchema) s;
                    DeclsExit declsExit = new DeclsExit(endpoint, operationName, variableNameInput, enterVariables, outputObjectName,
                            arraySchema, nameSuffix, nameSuffix, statusCode);
                    res.add(declsExit);
                } else if (!ARRAY_TYPE_NAME.equalsIgnoreCase(schemaType)) {
                    DeclsExit declsExit = new DeclsExit(endpoint, operationName,
                            variableNameInput, enterVariables, outputObjectName, s, nameSuffix, statusCode);
                    res.add(declsExit);
                }
                // else: type is "array" but not an ArraySchema instance — skip (no getItems() available)
            }
        }

        return res;

    }

    public static Map<String, Schema> getAllNestedSchemas(String nameSuffix, Schema mapOfProperties,
                                                          String endpoint, String operationName) {
        Map<String, Schema> res = new HashMap<>();

        Map<String, Schema> properties = mapOfProperties.getProperties();
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
                    if (schema.getProperties() == null && schema.getAdditionalProperties() == null) {
                        printCircularReferenceWarning(mapOfProperties, parameterName, schema, nameSuffix,
                                endpoint, operationName);
                    } else {
                        res.putAll(getAllNestedSchemas(nameSuffix + HIERARCHY_SEPARATOR + parameterName, schema,
                                endpoint, operationName));
                    }

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

                        if (subSchema.getProperties() == null && subSchema.getAdditionalProperties() == null) {
                            // swagger-parser breaks circular reference cycles by replacing a schema with a stub
                            // that has null properties. We recover one level of depth by looking up the real
                            // schema from components (identified by its preserved title field). We do NOT
                            // recurse into the real schema to avoid infinite loops.
                            printCircularReferenceWarning(mapOfProperties, parameterName, subSchema, nameSuffix,
                                    endpoint, operationName);
                            Schema realSchema = lookupRealSchema(subSchema);
                            if (realSchema != null && realSchema.getProperties() != null) {
                                res.put(nameSuffix + HIERARCHY_SEPARATOR + parameterName, realSchema);
                            } else {
                                res.put(nameSuffix + HIERARCHY_SEPARATOR + parameterName, subSchema);
                            }
                        } else {
                            res.put(nameSuffix + HIERARCHY_SEPARATOR + parameterName, subSchema);
                            res.putAll(getAllNestedSchemas(nameSuffix + HIERARCHY_SEPARATOR + parameterName, subSchema,
                                    endpoint, operationName));
                        }
                    }
                }
            }
        }

        return res;
    }

    private static void printCircularReferenceWarning(Schema parentSchema, String propertyName,
                                                      Schema unresolvedSchema, String path,
                                                      String endpoint, String operationName) {
        String parentName = parentSchema.getTitle() != null ? parentSchema.getTitle() : path;

        String childName;
        if (unresolvedSchema.getTitle() != null) {
            childName = unresolvedSchema.getTitle();
        } else if (unresolvedSchema.get$ref() != null) {
            String ref = unresolvedSchema.get$ref();
            childName = ref.substring(ref.lastIndexOf('/') + 1);
        } else {
            childName = propertyName;
        }

        System.err.println("WARNING: Circular reference detected in operation '" + operationName
                + "' (" + endpoint + ") between '" + parentName + "' and '" + childName
                + "' (property '" + propertyName + "'). This relationship cannot be fully resolved. "
                + "The generated .decls file may not be fully representative of the complete API functionality. "
                + "Consider restructuring the circular reference in the API specification.");
    }

}
