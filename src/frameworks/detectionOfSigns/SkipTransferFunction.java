package frameworks.detectionOfSigns;

import java.util.HashMap;

import graph.Variable;

public class SkipTransferFunction extends DSTransferFunction {

    public SkipTransferFunction(int inputIndex) {
        super(inputIndex);
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        HashMap<Variable, SetOfSigns> clone =
                new HashMap<Variable, SetOfSigns>(inputValue.getSignState());
        return new DSLatticeValue(clone);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}