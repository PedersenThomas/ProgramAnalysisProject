package frameworks.detectionOfSigns;

import java.util.HashMap;
import java.util.Map;

import graph.Variable;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class ReadTransferFunction extends DSTransferFunction {

    private Variable variable;

    public ReadTransferFunction(int inputIndex, Variable variable) {
        super(inputIndex);
        this.variable = variable;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        Map<Variable, PowerSetOfSigns> clone = new HashMap<Variable, PowerSetOfSigns>(inputValue.getSignState());
        clone.put(variable, Util.ALL);
        return new DSLatticeValue(clone);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": read " + variable;
    }
}
