package frameworks.detectionOfSigns;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;

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
        HashMap<String, PowerSetOfSigns> clone =
                new HashMap<>(inputValue.getSignState());
        return new DSLatticeValue(clone);
    }
}