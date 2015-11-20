package frameworks.detectionOfSigns;

import frameworks.ILatticeValue;
import graph.Variable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public class DSLatticeValue implements ILatticeValue {

    private Map<Variable, PowerSetOfSigns> signState;

    /** Do not make an empty constructor!
     *  We need to know all the variables.
     **/

    public DSLatticeValue(Set<Variable> variables) {
        Map<Variable, PowerSetOfSigns> signState =
                new HashMap<Variable, PowerSetOfSigns>();
        for(Variable variable : variables) {
            signState.put(variable, new PowerSetOfSigns());
        }
        this.signState = signState;
    }

    public DSLatticeValue(Map<Variable, PowerSetOfSigns> signState) {
        this.signState = signState;
    }

    public Map<Variable, PowerSetOfSigns> getSignState() {
        return Collections.unmodifiableMap(signState);
    }

    public Set<Variable> getVariables() {
        return Collections.unmodifiableSet(this.signState.keySet());
    }

    public boolean isBottom() {
        PowerSetOfSigns empty = new PowerSetOfSigns();
        for(Map.Entry<Variable, PowerSetOfSigns> entry
                : this.signState.entrySet()) {
            if (!entry.getValue().isSubset(empty)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSubset(ILatticeValue other) {
        DSLatticeValue otherDSLatticeValue = (DSLatticeValue) other;

        for (Map.Entry<Variable, PowerSetOfSigns> entry
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

        for (Map.Entry<Variable, PowerSetOfSigns> entry
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

        Map<Variable, PowerSetOfSigns> resultSignState =
                new HashMap<Variable, PowerSetOfSigns>();

        for (Map.Entry<Variable, PowerSetOfSigns> entry
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
