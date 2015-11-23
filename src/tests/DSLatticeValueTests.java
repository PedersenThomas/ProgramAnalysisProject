package tests;

import frameworks.ILatticeValue;
import frameworks.detectionOfSigns.DSLatticeValue;
import frameworks.detectionOfSigns.PowerSetOfSigns;
import frameworks.detectionOfSigns.Signs;
import graph.Variable;
import graph.VariableType;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


import static org.junit.Assert.*;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public class DSLatticeValueTests {

    @Test
    public void bottomValue() {

        Set<Variable> variables = new HashSet<Variable>();
        variables.add(new Variable("a", VariableType.Array));
        variables.add(new Variable("b", VariableType.Variable));
        variables.add(new Variable("c", VariableType.Variable));
        DSLatticeValue bottom = new DSLatticeValue(variables);

        HashMap<Variable, PowerSetOfSigns> expectedSignState = new HashMap<Variable, PowerSetOfSigns>();
        expectedSignState.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns());
        expectedSignState.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns());
        expectedSignState.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns());

        assertEquals(expectedSignState, bottom.getSignState());

    }

    @Test
    public void equals() {

        Set<Signs> signs1 = new HashSet<Signs>();
        signs1.add(Signs.positive);

        Set<Signs> signs2 = new HashSet<Signs>();
        signs2.add(Signs.negative);
        signs2.add(Signs.zero);

        Set<Signs> signs3 = new HashSet<Signs>();
        signs3.add(Signs.positive);

        Set<Signs> signs4 = new HashSet<Signs>();
        signs4.add(Signs.negative);
        signs4.add(Signs.zero);

        HashMap<Variable, PowerSetOfSigns> signState1 = new HashMap<Variable, PowerSetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs2));

        HashMap<Variable, PowerSetOfSigns> signState2 = new HashMap<Variable, PowerSetOfSigns>();
        signState2.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs3));
        signState2.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs4));

        assertEquals(signState1, signState2);

        signState2.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns());

        assertNotEquals(signState1, signState2);

        signState1.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns());

        assertEquals(signState1, signState2);

    }

    @Test
    public void isSubset() {

        Set<Variable> variables = new HashSet<Variable>();
        variables.add(new Variable("a", VariableType.Variable));
        variables.add(new Variable("b", VariableType.Variable));
        variables.add(new Variable("c", VariableType.Variable));
        DSLatticeValue bottom1 = new DSLatticeValue(variables);
        DSLatticeValue bottom2 = new DSLatticeValue(variables);

        assertTrue(bottom1.isSubset(bottom2));
        assertTrue(bottom2.isSubset(bottom1));

        Set<Signs> signs1 = new HashSet<Signs>();
        signs1.add(Signs.negative);

        Set<Signs> signs2 = new HashSet<Signs>();
        signs2.add(Signs.negative);
        signs2.add(Signs.zero);

        Set<Signs> signs3 = new HashSet<Signs>();
        signs3.add(Signs.negative);

        Set<Signs> signs4 = new HashSet<Signs>();
        signs4.add(Signs.negative);
        signs4.add(Signs.zero);

        HashMap<Variable, PowerSetOfSigns> signState1 =
                new HashMap<Variable, PowerSetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs2));
        signState1.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns());

        DSLatticeValue latticeValue1 = new DSLatticeValue(signState1);

        assertTrue(latticeValue1.isSubset(latticeValue1));
        assertTrue(bottom1.isSubset(latticeValue1));
        assertFalse(latticeValue1.isSubset(bottom1));

        HashMap<Variable, PowerSetOfSigns> signState2 =
                new HashMap<Variable, PowerSetOfSigns>();
        signState2.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs4));
        signState2.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs4));
        signState2.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns());

        DSLatticeValue latticeValue2 = new DSLatticeValue(signState2);

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertFalse(latticeValue2.isSubset(latticeValue1));

        signState1.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs2));
        latticeValue1 = new DSLatticeValue(signState1);

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertTrue(latticeValue2.isSubset(latticeValue1));

        signState1.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState2.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns(signs3));

        latticeValue1 = new DSLatticeValue(signState1);
        latticeValue2 = new DSLatticeValue(signState2);

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertFalse(latticeValue2.isSubset(latticeValue1));

    }

    @Test
    public void join() {

        Set<Variable> variables = new HashSet<Variable>();
        variables.add(new Variable("a", VariableType.Variable));
        variables.add(new Variable("b", VariableType.Variable));
        variables.add(new Variable("c", VariableType.Variable));
        DSLatticeValue bottom1 = new DSLatticeValue(variables);

        Set<Signs> signs1 = new HashSet<Signs>();
        signs1.add(Signs.negative);

        Set<Signs> signs2 = new HashSet<Signs>();
        signs2.add(Signs.negative);
        signs2.add(Signs.zero);

        Set<Signs> signs3 = new HashSet<Signs>();
        signs3.add(Signs.positive);

        HashMap<Variable, PowerSetOfSigns> signState1 =
                new HashMap<Variable, PowerSetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs2));
        signState1.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns(signs3));

        DSLatticeValue latticeValue1 = new DSLatticeValue(signState1);

        ILatticeValue joined1 = bottom1.join(latticeValue1);
        ILatticeValue joined2 = latticeValue1.join(bottom1);
        assertEquals(joined1, joined2);
        assertEquals(joined1, latticeValue1);

        HashMap<Variable, PowerSetOfSigns> signState2 =
                new HashMap<Variable, PowerSetOfSigns>();
        signState2.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs3));
        signState2.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState2.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns(signs3));

        DSLatticeValue latticeValue2 = new DSLatticeValue(signState2);
        ILatticeValue joined3 = latticeValue1.join(latticeValue2);
        ILatticeValue joined4 = latticeValue2.join(latticeValue1);
        assertEquals(joined3, joined4);

        HashMap<Variable, PowerSetOfSigns> resultSignState =
                new HashMap<Variable, PowerSetOfSigns>();
        HashSet<Signs> posNeg = new HashSet<Signs>();
        posNeg.add(Signs.positive);
        posNeg.add(Signs.negative);
        resultSignState.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(posNeg));
        resultSignState.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs2));
        resultSignState.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns(signs3));

        DSLatticeValue resultLatticeValue =
                new DSLatticeValue(resultSignState);
        assertEquals(resultLatticeValue, joined3);

    }

    @Test
    public void testIsBottom() {

        Set<Variable> variables = new HashSet<Variable>();
        variables.add(new Variable("a", VariableType.Variable));
        variables.add(new Variable("b", VariableType.Variable));
        variables.add(new Variable("c", VariableType.Variable));
        DSLatticeValue bottom1 = new DSLatticeValue(variables);

        assertTrue(bottom1.isBottom());

        Set<Signs> signs1 = new HashSet<Signs>();
        signs1.add(Signs.negative);

        Set<Signs> signs2 = new HashSet<Signs>();
        signs2.add(Signs.negative);
        signs2.add(Signs.zero);

        Set<Signs> signs3 = new HashSet<Signs>();
        signs3.add(Signs.positive);

        HashMap<Variable, PowerSetOfSigns> signState1 =
                new HashMap<Variable, PowerSetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(signs2));
        signState1.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns(signs3));

        DSLatticeValue nonBottom = new DSLatticeValue(signState1);
        assertFalse(nonBottom.isBottom());

    }

}
