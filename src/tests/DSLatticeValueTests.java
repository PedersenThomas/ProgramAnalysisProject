package tests;

import frameworks.ILatticeValue;
import frameworks.detectionOfSigns.DSLatticeValue;
import frameworks.detectionOfSigns.SetOfSigns;
import frameworks.detectionOfSigns.Sign;
import graph.Variable;
import graph.VariableType;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


import static org.junit.Assert.*;

public class DSLatticeValueTests {

    @Test
    public void bottomValue() {

        Set<Variable> variables = new HashSet<Variable>();
        variables.add(new Variable("a", VariableType.Array));
        variables.add(new Variable("b", VariableType.Variable));
        variables.add(new Variable("c", VariableType.Variable));
        DSLatticeValue bottom = new DSLatticeValue(variables);

        HashMap<Variable, SetOfSigns> expectedSignState = new HashMap<Variable, SetOfSigns>();
        expectedSignState.put(new Variable("a", VariableType.Variable), new SetOfSigns());
        expectedSignState.put(new Variable("b", VariableType.Variable), new SetOfSigns());
        expectedSignState.put(new Variable("c", VariableType.Variable), new SetOfSigns());

        assertEquals(expectedSignState, bottom.getSignState());

    }

    @Test
    public void equals() {

        Set<Sign> signs1 = new HashSet<Sign>();
        signs1.add(Sign.positive);

        Set<Sign> signs2 = new HashSet<Sign>();
        signs2.add(Sign.negative);
        signs2.add(Sign.zero);

        Set<Sign> signs3 = new HashSet<Sign>();
        signs3.add(Sign.positive);

        Set<Sign> signs4 = new HashSet<Sign>();
        signs4.add(Sign.negative);
        signs4.add(Sign.zero);

        HashMap<Variable, SetOfSigns> signState1 = new HashMap<Variable, SetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs2));

        HashMap<Variable, SetOfSigns> signState2 = new HashMap<Variable, SetOfSigns>();
        signState2.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs3));
        signState2.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs4));

        assertEquals(signState1, signState2);

        signState2.put(new Variable("c", VariableType.Variable), new SetOfSigns());

        assertNotEquals(signState1, signState2);

        signState1.put(new Variable("c", VariableType.Variable), new SetOfSigns());

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

        Set<Sign> signs1 = new HashSet<Sign>();
        signs1.add(Sign.negative);

        Set<Sign> signs2 = new HashSet<Sign>();
        signs2.add(Sign.negative);
        signs2.add(Sign.zero);

        Set<Sign> signs3 = new HashSet<Sign>();
        signs3.add(Sign.negative);

        Set<Sign> signs4 = new HashSet<Sign>();
        signs4.add(Sign.negative);
        signs4.add(Sign.zero);

        HashMap<Variable, SetOfSigns> signState1 =
                new HashMap<Variable, SetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs2));
        signState1.put(new Variable("c", VariableType.Variable), new SetOfSigns());

        DSLatticeValue latticeValue1 = new DSLatticeValue(signState1);

        assertTrue(latticeValue1.isSubset(latticeValue1));
        assertTrue(bottom1.isSubset(latticeValue1));
        assertFalse(latticeValue1.isSubset(bottom1));

        HashMap<Variable, SetOfSigns> signState2 =
                new HashMap<Variable, SetOfSigns>();
        signState2.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs4));
        signState2.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs4));
        signState2.put(new Variable("c", VariableType.Variable), new SetOfSigns());

        DSLatticeValue latticeValue2 = new DSLatticeValue(signState2);

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertFalse(latticeValue2.isSubset(latticeValue1));

        signState1.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs2));
        latticeValue1 = new DSLatticeValue(signState1);

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertTrue(latticeValue2.isSubset(latticeValue1));

        signState1.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs1));
        signState2.put(new Variable("c", VariableType.Variable), new SetOfSigns(signs3));

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

        Set<Sign> signs1 = new HashSet<Sign>();
        signs1.add(Sign.negative);

        Set<Sign> signs2 = new HashSet<Sign>();
        signs2.add(Sign.negative);
        signs2.add(Sign.zero);

        Set<Sign> signs3 = new HashSet<Sign>();
        signs3.add(Sign.positive);

        HashMap<Variable, SetOfSigns> signState1 =
                new HashMap<Variable, SetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs2));
        signState1.put(new Variable("c", VariableType.Variable), new SetOfSigns(signs3));

        DSLatticeValue latticeValue1 = new DSLatticeValue(signState1);

        ILatticeValue joined1 = bottom1.join(latticeValue1);
        ILatticeValue joined2 = latticeValue1.join(bottom1);
        assertEquals(joined1, joined2);
        assertEquals(joined1, latticeValue1);

        HashMap<Variable, SetOfSigns> signState2 =
                new HashMap<Variable, SetOfSigns>();
        signState2.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs3));
        signState2.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs1));
        signState2.put(new Variable("c", VariableType.Variable), new SetOfSigns(signs3));

        DSLatticeValue latticeValue2 = new DSLatticeValue(signState2);
        ILatticeValue joined3 = latticeValue1.join(latticeValue2);
        ILatticeValue joined4 = latticeValue2.join(latticeValue1);
        assertEquals(joined3, joined4);

        HashMap<Variable, SetOfSigns> resultSignState =
                new HashMap<Variable, SetOfSigns>();
        HashSet<Sign> posNeg = new HashSet<Sign>();
        posNeg.add(Sign.positive);
        posNeg.add(Sign.negative);
        resultSignState.put(new Variable("a", VariableType.Variable), new SetOfSigns(posNeg));
        resultSignState.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs2));
        resultSignState.put(new Variable("c", VariableType.Variable), new SetOfSigns(signs3));

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

        Set<Sign> signs1 = new HashSet<Sign>();
        signs1.add(Sign.negative);

        Set<Sign> signs2 = new HashSet<Sign>();
        signs2.add(Sign.negative);
        signs2.add(Sign.zero);

        Set<Sign> signs3 = new HashSet<Sign>();
        signs3.add(Sign.positive);

        HashMap<Variable, SetOfSigns> signState1 =
                new HashMap<Variable, SetOfSigns>();
        signState1.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs1));
        signState1.put(new Variable("b", VariableType.Variable), new SetOfSigns(signs2));
        signState1.put(new Variable("c", VariableType.Variable), new SetOfSigns(signs3));

        DSLatticeValue nonBottom = new DSLatticeValue(signState1);
        assertFalse(nonBottom.isBottom());

    }

}
