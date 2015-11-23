package frameworks.detectionOfSigns;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;
import graph.Variable;

import java.util.HashMap;
import java.util.List;

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