package frameworks.detectionOfSigns;

import frameworks.ILatticeValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public class DSLatticeValue implements ILatticeValue {

    private Map<String, PowerSetOfSigns> signState;

    /** Do not make an empty constructor!
     *  We need to know all the variables.
     **/

    public DSLatticeValue(Set<String> variables) {
        Map<String, PowerSetOfSigns> signState =
                new HashMap<String, PowerSetOfSigns>();
        for(String variable : variables) {
            signState.put(variable, new PowerSetOfSigns());
        }
        this.signState = signState;
    }

    public DSLatticeValue(Map<String, PowerSetOfSigns> signState) {
        this.signState = signState;
    }

    public Map<String, PowerSetOfSigns> getSignState() {
        return signState;
    }

    public Set<String> getVariables() {
        return this.signState.keySet();
    }

    @Override
    public boolean isSubset(ILatticeValue other) {
        DSLatticeValue otherDSLatticeValue = (DSLatticeValue) other;

        for (Map.Entry<String, PowerSetOfSigns> entry
                : this.signState.entrySet()) {
            PowerSetOfSigns otherPowerSetOfSigns =
                    otherDSLatticeValue.signState.get(entry.getKey());
            if (!entry.getValue().isSubset(otherPowerSetOfSigns)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DSLatticeValue)) {
            return false;
        }

        DSLatticeValue otherDSLatticeValue = (DSLatticeValue) other;

        for (Map.Entry<String, PowerSetOfSigns> entry
                : this.signState.entrySet()) {
            PowerSetOfSigns otherPowerSetOfSigns =
                    otherDSLatticeValue.signState.get(entry.getKey());
            if (!entry.getValue().equals(otherPowerSetOfSigns)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ILatticeValue join(ILatticeValue other) {
        DSLatticeValue otherDSLatticeValue = (DSLatticeValue) other;

        Map<String, PowerSetOfSigns> resultSignState =
                new HashMap<String, PowerSetOfSigns>();

        for (Map.Entry<String, PowerSetOfSigns> entry
                : this.signState.entrySet()) {
            PowerSetOfSigns otherPowerSetOfSigns =
                    otherDSLatticeValue.signState.get(entry.getKey());
            resultSignState.put(entry.getKey(),
                    entry.getValue().union(otherPowerSetOfSigns));
        }

        return new DSLatticeValue(resultSignState);
    }

    @Override
    public String toString() {
        return "DSLatticeValue{" +
                "signState=" + signState +
                '}';
    }
}
