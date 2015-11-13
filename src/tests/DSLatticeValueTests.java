package tests;

import frameworks.ILatticeValue;
import frameworks.detectionOfSigns.DSLatticeValue;
import frameworks.detectionOfSigns.PowerSetOfSigns;
import frameworks.detectionOfSigns.Signs;
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

        Set<String> variables = new HashSet<String>();
        variables.add("a");
        variables.add("b");
        variables.add("c");
        DSLatticeValue bottom = new DSLatticeValue(variables);

        HashMap<String, PowerSetOfSigns> expectedSignState = new HashMap<>();
        expectedSignState.put("a", new PowerSetOfSigns());
        expectedSignState.put("b", new PowerSetOfSigns());
        expectedSignState.put("c", new PowerSetOfSigns());

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

        HashMap<String, PowerSetOfSigns> signState1 = new HashMap<>();
        signState1.put("a", new PowerSetOfSigns(signs1));
        signState1.put("b", new PowerSetOfSigns(signs2));

        HashMap<String, PowerSetOfSigns> signState2 = new HashMap<>();
        signState2.put("a", new PowerSetOfSigns(signs3));
        signState2.put("b", new PowerSetOfSigns(signs4));

        assertEquals(signState1, signState2);

        signState2.put("c", new PowerSetOfSigns());

        assertNotEquals(signState1, signState2);

        signState1.put("c", new PowerSetOfSigns());

        assertEquals(signState1, signState2);

    }

    @Test
    public void isSubset() {

        Set<String> variables = new HashSet<String>();
        variables.add("a");
        variables.add("b");
        variables.add("c");
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

        HashMap<String, PowerSetOfSigns> signState1 =
                new HashMap<>();
        signState1.put("a", new PowerSetOfSigns(signs1));
        signState1.put("b", new PowerSetOfSigns(signs2));
        signState1.put("c", new PowerSetOfSigns());

        DSLatticeValue latticeValue1 = new DSLatticeValue(signState1);

        assertTrue(latticeValue1.isSubset(latticeValue1));
        assertTrue(bottom1.isSubset(latticeValue1));
        assertFalse(latticeValue1.isSubset(bottom1));

        HashMap<String, PowerSetOfSigns> signState2 =
                new HashMap<>();
        signState2.put("a", new PowerSetOfSigns(signs4));
        signState2.put("b", new PowerSetOfSigns(signs4));
        signState2.put("c", new PowerSetOfSigns());

        DSLatticeValue latticeValue2 = new DSLatticeValue(signState2);

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertFalse(latticeValue2.isSubset(latticeValue1));

        latticeValue1.getSignState().put(
                "a", new PowerSetOfSigns(signs2));

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertTrue(latticeValue2.isSubset(latticeValue1));

        latticeValue1.getSignState().put("a", new PowerSetOfSigns(signs1));
        latticeValue2.getSignState().put("c", new PowerSetOfSigns(signs3));

        assertTrue(latticeValue1.isSubset(latticeValue2));
        assertFalse(latticeValue2.isSubset(latticeValue1));

    }

    @Test
    public void join() {

        Set<String> variables = new HashSet<String>();
        variables.add("a");
        variables.add("b");
        variables.add("c");
        DSLatticeValue bottom1 = new DSLatticeValue(variables);

        Set<Signs> signs1 = new HashSet<>();
        signs1.add(Signs.negative);

        Set<Signs> signs2 = new HashSet<>();
        signs2.add(Signs.negative);
        signs2.add(Signs.zero);

        Set<Signs> signs3 = new HashSet<>();
        signs3.add(Signs.positive);

        HashMap<String, PowerSetOfSigns> signState1 =
                new HashMap<>();
        signState1.put("a", new PowerSetOfSigns(signs1));
        signState1.put("b", new PowerSetOfSigns(signs2));
        signState1.put("c", new PowerSetOfSigns(signs3));

        DSLatticeValue latticeValue1 = new DSLatticeValue(signState1);

        ILatticeValue joined1 = bottom1.join(latticeValue1);
        ILatticeValue joined2 = latticeValue1.join(bottom1);
        assertEquals(joined1, joined2);
        assertEquals(joined1, latticeValue1);

        HashMap<String, PowerSetOfSigns> signState2 =
                new HashMap<>();
        signState2.put("a", new PowerSetOfSigns(signs3));
        signState2.put("b", new PowerSetOfSigns(signs1));
        signState2.put("c", new PowerSetOfSigns(signs3));

        DSLatticeValue latticeValue2 = new DSLatticeValue(signState2);
        ILatticeValue joined3 = latticeValue1.join(latticeValue2);
        ILatticeValue joined4 = latticeValue2.join(latticeValue1);
        assertEquals(joined3, joined4);

        HashMap<String, PowerSetOfSigns> resultSignState =
                new HashMap<>();
        HashSet<Signs> posNeg = new HashSet<>();
        posNeg.add(Signs.positive);
        posNeg.add(Signs.negative);
        resultSignState.put("a", new PowerSetOfSigns(posNeg));
        resultSignState.put("b", new PowerSetOfSigns(signs2));
        resultSignState.put("c", new PowerSetOfSigns(signs3));

        DSLatticeValue resultLatticeValue =
                new DSLatticeValue(resultSignState);
        assertEquals(resultLatticeValue, joined3);

    }

}
