package frameworks.detectionOfSigns;

import graph.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class DeclarationTransferFunction extends DSTransferFunction {

    Variable variable;

    public DeclarationTransferFunction(int inputIndex, Variable variable) {
        super(inputIndex);
        this.variable = variable;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        Map<Variable, PowerSetOfSigns> clone = new HashMap<>(inputValue.getSignState());
        clone.put(variable, Util.ZERO_ONLY);
        return new DSLatticeValue(clone);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": int " + variable;
    }
}
