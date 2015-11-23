package frameworks.detectionOfSigns;

import java.util.HashMap;

import graph.Variable;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public class SkipTransferFunction extends DSTransferFunction {

    public SkipTransferFunction(int inputIndex) {
        super(inputIndex);
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        HashMap<Variable, PowerSetOfSigns> clone =
                new HashMap<Variable, PowerSetOfSigns>(inputValue.getSignState());
        return new DSLatticeValue(clone);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}