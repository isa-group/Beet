package agora.beet.dtrace;

import agora.beet.util.FileManager;
import agora.beet.main.GenerateInstrumentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static agora.beet.main.GenerateInstrumentation.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Juan C. Alonso
 */
public class DtraceE2ETests {

    private static Stream<Arguments> dtraceGeneration() {
        return Stream.of(
                /*
                 *  TEST CASES RELATED TO ENTER
                 */
                /*      e2e_dtrace_enter_001
                This test receives as an input parameters of type primitive in query, path, header and form
                    (doubleInQuery, string.In.Path, integerInHeader, booleanInForm)
                 */
                Arguments.of("src/test/resources/dtraceOracles/enter/primitiveInputs/primitiveInputs.yaml", "src/test/resources/dtraceOracles/enter/primitiveInputs/setValues/testCase_primitiveInputs.csv",
                        "src/test/resources/dtraceOracles/enter/primitiveInputs/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/enter/primitiveInputs/setValues/dtraceFile_primitiveInputs.dtrace"
                ),
                /*      e2e_dtrace_enter_002
                This test uses the same OAS spec as e2e_dtrace_enter_001, but the values of the parameters are null
                in the csv containing the test cases. Note that null doubles must be printed as "nonsensical" in the dtrace file
                 */
                Arguments.of("src/test/resources/dtraceOracles/enter/primitiveInputs/primitiveInputs.yaml", "src/test/resources/dtraceOracles/enter/primitiveInputs/nullValues/testCase_primitiveInputsNullValues.csv",
                        "src/test/resources/dtraceOracles/enter/primitiveInputs/nullValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/enter/primitiveInputs/nullValues/dtraceFile_primitiveInputsNullValues.dtrace"
                ),

                /*
                 *  TEST CASES RELATED TO EXIT
                 */
                /* e2e_dtrace_exit_001
                The response of this test case is an object that contains properties of type primitive (string, double, integer and boolean)
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/primitiveExit/primitiveExit.yaml", "src/test/resources/dtraceOracles/exit/primitiveExit/setValues/testCase_primitiveExit.csv",
                        "src/test/resources/dtraceOracles/exit/primitiveExit/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/primitiveExit/setValues/dtraceFile_primitiveExit.dtrace"
                ),
                /* e2e_dtrace_exit_002
                This test uses the same OAS spec as e2e_dtrace_exit_002, but the values of the properties of the response are null
                in the csv containing the test cases. Note that null doubles must be printed as "nonsensical" in the dtrace file
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/primitiveExit/primitiveExit.yaml", "src/test/resources/dtraceOracles/exit/primitiveExit/nullValues/testCase_primitiveExit_nullValues.csv",
                        "src/test/resources/dtraceOracles/exit/primitiveExit/nullValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/primitiveExit/nullValues/dtraceFile_primitiveExit_nullValues.dtrace"
                ),
                /* e2e_dtrace_exit_003  (Nested objects in the exit)
                The response of this test case contains two properties of type object (Nested objects), with one of its properties being an array of primitives.
                One of the objects (and many of its properties) contains special characters in the variable names
                This object also contains another property of type object (Nested object inside a nested object) with one of its properties being an array of type double
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/objectExit/objectExit.yaml", "src/test/resources/dtraceOracles/exit/objectExit/setValues/testCase_objectExit.csv",
                        "src/test/resources/dtraceOracles/exit/objectExit/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/objectExit/setValues/dtraceFile_objectExit.dtrace"
                ),
                /* e2e_dtrace_exit_004 (Arrays of primitive elements containing null values)
                This test uses the same OAS spec as e2e_dtrace_exit_003, but the arrays of primitive elements contain a null element
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/objectExit/objectExit.yaml", "src/test/resources/dtraceOracles/exit/objectExit/nullValues/arraysWithNullElements/testCase_objectExit_arraysWitNullElements.csv",
                        "src/test/resources/dtraceOracles/exit/objectExit/nullValues/arraysWithNullElements/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/objectExit/nullValues/arraysWithNullElements/dtraceFile_objectExit_arraysWithNullElements.dtrace"
                ),
                /* e2e_dtrace_exit_005 (Array with elements of type object)
                    The response of this test contains a property of type array of objects.
                    This test also checks the behaviour of Beet when there are more than one exit per API operation (due to arrays of objects)
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/arrayOfObjects/arrayOfObjects.yaml", "src/test/resources/dtraceOracles/exit/arrayOfObjects/setValues/testCase_arrayOfObjects.csv",
                        "src/test/resources/dtraceOracles/exit/arrayOfObjects/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/arrayOfObjects/setValues/dtraceFile_arrayOfObjects.dtrace"
                ),
                /* e2e_dtrace_exit_006 (Array of objects with one of the elements being null)
                This test uses the same OAS spec as e2e_dtrace_exit_005, but one of the elements of the array (i.e., one of the objects) is null
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/arrayOfObjects/arrayOfObjects.yaml", "src/test/resources/dtraceOracles/exit/arrayOfObjects/nullValues/elementOfArrayNull/testCase_arrayOfObjects_elementOfArrayNull.csv",
                        "src/test/resources/dtraceOracles/exit/arrayOfObjects/nullValues/elementOfArrayNull/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/arrayOfObjects/nullValues/elementOfArrayNull/dtraceFile_arrayOfObjects_elementOfArrayNull.dtrace"
                ),
                /* e2e_dtrace_exit_007 (Array with elements of type object with special characters)
                This test uses an OAS spec similar to the one used in e2e_dtrace_exit_005, but the response field names contain special characters
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/arrayOfObjects/arrayOfObjectsSpecialCharacters.yaml","src/test/resources/dtraceOracles/exit/arrayOfObjects/specialCharacters/testCase_arrayOfObjectsSpecialCharacters.csv",
                        "src/test/resources/dtraceOracles/exit/arrayOfObjects/specialCharacters/dtraceFile.dtrace","src/test/resources/dtraceOracles/exit/arrayOfObjects/specialCharacters/dtraceFile_arrayOfObjectsSpecialCharacters.dtrace"),
                /* e2e_dtrace_exit_008 (Null array of objects)
                This test uses the same OAS spec as e2e_dtrace_exit_006, but the array of objects is null
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/arrayOfObjects/arrayOfObjects.yaml", "src/test/resources/dtraceOracles/exit/arrayOfObjects/nullValues/nullArray/testCase_arrayOfObjects_nullArray.csv",
                        "src/test/resources/dtraceOracles/exit/arrayOfObjects/nullValues/nullArray/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/arrayOfObjects/nullValues/nullArray/dtraceFile_arrayOfObjects_nullArray.dtrace"
                ),
                /* e2e_dtrace_exit_009 (Exit of type array, bad practice)
                This test analyses a response of type array (Without being a property of an object). This type of response is a bad practice, but
                it is used by APIs such as RestCountries
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/exitOfTypeArray.yaml", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/setValues/testCase_exitOfTypeArray.csv",
                        "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/setValues/dtraceFile_exitOfTypeArray.dtrace"
                ),
                /* e2e_dtrace_exit010 (Exit of type array, with a null element)
                This test uses the same OAS spec as e2e_dtrace_exit_009, but one of the elements of the array (i.e., one of the objects) is null
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/exitOfTypeArray.yaml", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/nullValues/elementOfArrayNull/testCase_exitOfTypeArray_elementOfArrayNull.csv",
                        "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/nullValues/elementOfArrayNull/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withoutNesting/nullValues/elementOfArrayNull/dtraceFile_exitOfTypeArray_elementOfArrayNull.dtrace"
                ),
                /* e2e_dtrace_exit_011
                This test analyses a response of type array (Without being a property of an object), with the elements of array being of type primitive.
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/exitOfTypeArray_primitiveElements.yaml", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/setValues/testCase_exitOfTypeArray_primitiveElements.csv",
                        "src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/setValues/dtraceFile_exitOfTypeArray_primitiveElements.dtrace"
                ),
                /* e2e_dtrace_exit_012
                This test uses the same OAS spec as e2e_dtrace_exit_011, but one of the elements of the array (i.e., one of the objects) is null
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/exitOfTypeArray_primitiveElements.yaml", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/nullValues/elementOfArrayNull/testCase_exitOfTypeArray_primitiveElements_elementOfArrayNull.csv",
                        "src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/nullValues/elementOfArrayNull/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/primitiveElementsOfArray/nullValues/elementOfArrayNull/dtraceFile_exitOfArray_primitiveElements_elementOfArrayNull.dtrace"
                ),
                /* e2e_dtrace_exit_013
                This test receives a test suite in csv format that contains test cases that contains different responses (200 and 400 status code),
                with one of them (the one returning a 200 code), containing two exists (EXIT 1 and EXIT 2)
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/multipleResponses/multipleResponses.yaml", "src/test/resources/dtraceOracles/exit/multipleResponses/testCase_multipleResponses.csv",
                        "src/test/resources/dtraceOracles/exit/multipleResponses/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/multipleResponses/dtraceFile_multipleResponses.dtrace"
                ),
                /* e2e_dtrace_exit_014
                This test receives a test suite in csv format that contains test cases that belong to different operations (/operation1 and /operation2),
                both of them returning a 200 code and one of them (/operation1), containing two exits (EXIT 1 and EXIT 2)
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/multipleOperations/multipleOperations.yaml", "src/test/resources/dtraceOracles/exit/multipleOperations/testCase_multipleOperations.csv",
                        "src/test/resources/dtraceOracles/exit/multipleOperations/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/multipleOperations/dtraceFile_multipleOperations.dtrace"
                ),
                /* e2e_dtrace_exit_015 (Response of type nested array)
                    The response of this test is a nested array following the following structure:
                            [
                              [
                                [
                                  {"location": "location1"},
                                  {"location": "location2"}
                                ],
                                [
                                  {"location": "location3"}
                                ]
                              ],
                              [
                                [
                                  {"location": "location4"},
                                  {"location": "location5"}
                                ],
                                [
                                  {"location": "location6"}
                                ]
                              ]
                            ]
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/exitOfTypeNestedArray.yaml", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/setValues/testCase_exitOfTypeNestedArray.csv",
                        "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/setValues/dtraceFile_exitOfTypeNestedArray.dtrace"
                ),
                /* e2e_dtrace_exit_016 (Response of type nested array with null and empty elements)
                    This test uses the same OAS spec as e2e_dtrace_exit_015, but some arrays (Nesting levels 2 and 3) are empty or null

                        [
                          [
                            [
                              {"location": "location1"},
                              {"location": "location2"}
                            ],
                            [
                              {"location": "location3"}
                            ]
                          ],
                          [
                            null,           # Null array nesting 3 (lower level)
                            []              # Empty array nesting 3 (lower level)
                          ],
                          null,             # Null array nesting 2
                          []                # Empty array nesting 2
                        ]

                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/exitOfTypeNestedArray.yaml", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/nullAndEmptyElements/testCase_exitOfTypeNestedArray_nullAndEmptyElements.csv",
                        "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/nullAndEmptyElements/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/exitOfTypeArray/withNesting/nullAndEmptyElements/dtraceFile_exitOfTypeNestedArray_nullAndEmptyElements.dtrace"
                ),
                /* e2e_dtrace_exit_017 (Property of type nested array)
                    The response of this test contains a property of type nested array. Structure:
                        {
                          "stringProperty": "stringPropertyValue",
                          "nestedArrayProperty": [
                                  [
                                    [
                                      {"propertyOfArray": 1.0},
                                      {"propertyOfArray": 2.0}
                                    ],
                                    [
                                      {"propertyOfArray": 3.0}
                                    ]
                                  ],
                                  [
                                    [
                                      {"propertyOfArray": 4.0}
                                    ]
                                  ]
                            ]
                        }
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/propertyOfTypeNestedArray.yaml", "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/setValues/testCase_propertyOfTypeNestedArray.csv",
                        "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/setValues/dtraceFile_propertyOfTypeNestedArray.dtrace"
                ),

                /* e2e_dtrace_exit_018 (Property of type nested array with null elements)
                This test uses the same OAS spec as e2e_dtrace_exit_017, but some arrays (Nesting levels 2 and 3) are empty or null

                        {
                          "stringProperty": "stringPropertyValue",
                          "nestedArrayProperty": [
                            [
                              [
                                {"propertyOfArray": 1.0},
                                {"propertyOfArray": 2.0}
                              ],
                              [
                                {"propertyOfArray": 3.0}
                              ]
                            ],
                            [
                              null,             # Null array nesting 3 (lower level)
                              []                # Empty array nesting 3 (lower level)
                            ],
                            null,               # Null array nesting 2
                            []                  # Empty array nesting 2
                         ]
                        }
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/propertyOfTypeNestedArray.yaml", "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/nullAndEmptyValues/testCase_propertyOfTypeNestedArray_nullAndEmptyValues.csv",
                        "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/nullAndEmptyValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfObjects/nullAndEmptyValues/dtraceFile_propertyOfTypeNestedArray_nullAndEmptyValues.dtrace"
                ),
                /* e2e_dtrace_exit_019 (Property of type nested array of primitives)
                The response of this test contains a property of type nested array of primitives. Structure:

                    {
                      "stringProperty": "stringPropertyValue",
                      "nestedArrayProperty": [
                        [
                          [
                            1.0,
                            2.0
                          ],
                          [
                            3.0
                          ]
                        ],
                        [
                          [
                            4.0
                          ]
                        ]
                    ]
                    }
                 */
                Arguments.of("src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfPrimitives/propertyOfTypeNestedArrayOfPrimitives.yaml", "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfPrimitives/setValues/testCase_propertyOfTypeNestedArrayOfPrimitives.csv",
                        "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfPrimitives/setValues/dtraceFile.dtrace", "src/test/resources/dtraceOracles/exit/propertyOfTypeNestedArray/nestedArrayOfPrimitives/setValues/dtraceFile_propertyOfTypeNestedArrayOfPrimitives.dtrace"
                )//,

        );
    }

    @ParameterizedTest
    @MethodSource("dtraceGeneration")
    public void testDtraceGeneration(String oasSpecPath, String testCasesCSVPath, String generatedPath, String oraclePath) throws IOException {
        numberOfExits = 1;
        deleteAllDeclsClasses();

        // OAS spec and testCases.csv
        String[] args = {oasSpecPath,
                testCasesCSVPath};
        GenerateInstrumentation.main(args);

        String[] generatedDtrace = FileManager.readFileAsString(generatedPath, StandardCharsets.UTF_8).split("\n");


        // Read files as list of String
        String[] oracleDtrace = FileManager.readFileAsString(oraclePath, StandardCharsets.UTF_8).split("\n");


        // Assert both dtrace files have the same number of lines
        Assertions.assertEquals(oracleDtrace.length, generatedDtrace.length, "The generated dtrace file does not have the expected number of lines");
        assertNotEquals("Path and oracle path must be different", generatedPath, oraclePath);

        for(int i = 0; i < oracleDtrace.length ; i++) {
            System.out.println(oracleDtrace[i]);
            int lineNumber = i + 1;
            Assertions.assertEquals(oracleDtrace[i].trim().replace("&", HIERARCHY_SEPARATOR), generatedDtrace[i], "The content of line " + lineNumber + " content is different from the expected");
        }

        // Remove the generated file
        FileManager.deleteFile(generatedPath);
    }



}
