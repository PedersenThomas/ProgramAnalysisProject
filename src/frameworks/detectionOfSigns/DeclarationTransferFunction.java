package frameworks.detectionOfSigns;

import graph.Variable;

import java.util.HashMap;
import java.util.Map;

public class DeclarationTransferFunction extends DSTransferFunction {

    Variable variable;

    public DeclarationTransferFunction(int inputIndex, Variable variable) {
        super(inputIndex);
        this.variable = variable;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        Map<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(inputValue.getSignState());
        clone.put(variable, Util.ZERO_ONLY);
        return new DSLatticeValue(clone);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": int " + variable;
    }
}
