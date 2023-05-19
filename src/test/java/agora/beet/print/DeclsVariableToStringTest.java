package agora.beet.print;

import agora.beet.model.DeclsVariable;
import org.junit.Test;

import java.util.Collections;

import static agora.beet.main.GenerateInstrumentation.HIERARCHY_SEPARATOR;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Juan C. Alonso
 */
public class DeclsVariableToStringTest {

    // Basic constructor
    @Test
    public void testPrintDeclsVariableWithoutEnclosingVar() {

        // Without enclosing var
        DeclsVariable declsVariable1 = new DeclsVariable("variable.name", "parentVariable", "varKind", "int", "double", null);
        String[] declsVariable1Lines = declsVariable1.toString().split("\n");

        assertFalse(declsVariable1.isArray());
        assertEquals("Incorrect variable name line", "variable parentVariable.variable" + HIERARCHY_SEPARATOR + "name", declsVariable1Lines[0]);
        assertEquals("Incorrect var-kind line", "\tvar-kind varKind", declsVariable1Lines[1]);
        assertEquals("Incorrect dec-type line", "\tdec-type int", declsVariable1Lines[2]);
        assertEquals("Incorrect rep-type line", "\trep-type double", declsVariable1Lines[3]);

    }

    @Test
    public void testPrintDeclsVariableWithEnclosingVar() {
        // With enclosing var
        DeclsVariable declsVariable2 = new DeclsVariable("variable.name", "parentVariable","varKind", "int", "double", "enclosingVar");
        String[] declsVariable2Lines = declsVariable2.toString().split("\n");

        assertFalse(declsVariable2.isArray());
        assertEquals("Incorrect variable name line", "variable parentVariable.variable" + HIERARCHY_SEPARATOR + "name", declsVariable2Lines[0]);
        assertEquals("Incorrect var-kind line", "\tvar-kind varKind", declsVariable2Lines[1]);
        assertEquals("Incorrect dec-type line", "\tenclosing-var enclosingVar", declsVariable2Lines[2]);
        assertEquals("Incorrect dec-type line", "\tdec-type int", declsVariable2Lines[3]);
        assertEquals("Incorrect rep-type line", "\trep-type double", declsVariable2Lines[4]);

    }

    @Test
    public void testPrintDeclsVariableIsArrayTrue() {
        // isArray = true
        DeclsVariable declsVariable = new DeclsVariable("variable.name", "parentVariable", "varKind", "int", "double", "enclosingVar", true);
        String[] declsVariableLines = declsVariable.toString().split("\n");

        assertTrue(declsVariable.isArray());

        assertEquals("Incorrect variable name line",
                "variable parentVariable.variable" + HIERARCHY_SEPARATOR + "name",
                declsVariableLines[0]);
        assertEquals("Incorrect var-kind line", "\tvar-kind varKind", declsVariableLines[1]);
        assertEquals("Incorrect dec-type line", "\tenclosing-var enclosingVar", declsVariableLines[2]);
        assertEquals("Incorrect dec-type line", "\tarray 1", declsVariableLines[3]);
        assertEquals("Incorrect dec-type line", "\tdec-type int[]", declsVariableLines[4]);
        assertEquals("Incorrect rep-type line", "\trep-type double[]", declsVariableLines[5]);

    }

    @Test
    public void testPrintDeclsVariableTypeArray() {
        // varKind = array
        DeclsVariable declsVariable = new DeclsVariable("variable.name", "parentVariable","array", "int", "double", "enclosingVar");
        String[] declsVariableLines = declsVariable.toString().split("\n");

        assertTrue(declsVariable.isArray());

        assertEquals("Incorrect variable name line", "variable parentVariable.variable" + HIERARCHY_SEPARATOR + "name", declsVariableLines[0]);
        assertEquals("Incorrect var-kind line", "\tvar-kind array", declsVariableLines[1]);
        assertEquals("Incorrect dec-type line", "\tenclosing-var enclosingVar", declsVariableLines[2]);
        assertEquals("Incorrect dec-type line", "\tarray 1", declsVariableLines[3]);
        assertEquals("Incorrect dec-type line", "\tdec-type int", declsVariableLines[4]);
        assertEquals("Incorrect rep-type line", "\trep-type double", declsVariableLines[5]);

    }

    @Test
    public void testPrintDeclsVariableWithASon() {
        // With a son
        DeclsVariable father = new DeclsVariable("variableNameFather", null, "varKindFather", "int", "double", null);
        DeclsVariable son = new DeclsVariable("variableNameSon", "variableNameFather","varKindSon", "int", "double", "variableNameFather");
        father.setEnclosedVariables(Collections.singletonList(son));


        String[] declsVariableLines = father.toString().split("\n");

        assertEquals("Incorrect variable name line", "variable variableNameFather", declsVariableLines[0]);
        assertEquals("Incorrect var-kind line", "\tvar-kind varKindFather", declsVariableLines[1]);
        assertEquals("Incorrect dec-type line", "\tdec-type int", declsVariableLines[2]);
        assertEquals("Incorrect dec-type line", "\trep-type double", declsVariableLines[3]);

        assertEquals("Incorrect dec-type line", "variable variableNameFather.variableNameSon", declsVariableLines[4]);
        assertEquals("Incorrect rep-type line", "\tvar-kind varKindSon", declsVariableLines[5]);
        assertEquals("Incorrect rep-type line", "\tenclosing-var variableNameFather", declsVariableLines[6]);
        assertEquals("Incorrect rep-type line", "\tdec-type int", declsVariableLines[7]);
        assertEquals("Incorrect rep-type line", "\trep-type double", declsVariableLines[8]);

    }


}
