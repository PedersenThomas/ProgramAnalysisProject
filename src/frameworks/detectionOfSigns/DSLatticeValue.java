package frameworks.detectionOfSigns;

import frameworks.ILatticeValue;
import graph.Variable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DSLatticeValue implements ILatticeValue {

    private Map<Variable, SetOfSigns> signState;

    /** Do not make an empty constructor!
     *  We need to know all the variables.
     **/

    public DSLatticeValue(Set<Variable> variables) {
        Map<Variable, SetOfSigns> signState = new HashMap<Variable, SetOfSigns>();
        for(Variable variable : variables) {
            signState.put(variable, new SetOfSigns());
        }
        this.signState = signState;
    }

    public DSLatticeValue(Map<Variable, SetOfSigns> signState) {
        this.signState = signState;
    }

    public Map<Variable, SetOfSigns> getSignState() {
        return Collections.unmodifiableMap(signState);
    }

    public Set<Variable> getVariables() {
        return Collections.unmodifiableSet(this.signState.keySet());
    }

    public SetOfSigns lookUp(Variable variable) {
        return this.signState.get(variable);
    }

    public boolean isBottom() {
        SetOfSigns empty = new SetOfSigns();
        for(Map.Entry<Variable, SetOfSigns> entry
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

        for (Map.Entry<Variable, SetOfSigns> entry
                : this.signState.entrySet()) {
            SetOfSigns otherPowerSetOfSigns =
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

        for (Map.Entry<Variable, SetOfSigns> entry
                : this.signState.entrySet()) {
            SetOfSigns otherPowerSetOfSigns =
                    otherDSLatticeValue.signState.get(entry.getKey());
            if (!entry.getValue().equals(otherPowerSetOfSigns)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return signState.hashCode();
    }

    @Override
    public ILatticeValue join(ILatticeValue other) {
        DSLatticeValue otherDSLatticeValue = (DSLatticeValue) other;

        Map<Variable, SetOfSigns> resultSignState =
                new HashMap<Variable, SetOfSigns>();

        for (Map.Entry<Variable, SetOfSigns> entry
                : this.signState.entrySet()) {
            SetOfSigns otherPowerSetOfSigns =
                    otherDSLatticeValue.signState.get(entry.getKey());
            resultSignState.put(entry.getKey(),
                    entry.getValue().union(otherPowerSetOfSigns));
        }

        return new DSLatticeValue(resultSignState);
    }

    @Override
    public String toString() {
        return signState.toString();
    }
}
