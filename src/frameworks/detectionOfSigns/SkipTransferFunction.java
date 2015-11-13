package frameworks.detectionOfSigns;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public class SkipTransferFunction extends TransferFunction {

    public SkipTransferFunction(int inputIndex) {
        super(inputIndex);
    }

    @Override
    public ILatticeValue eval(List<ILatticeValue> analysisList) {
        DSLatticeValue inputValue =
                (DSLatticeValue) analysisList.get(this.getInputIndex());
        HashMap<String, PowerSetOfSigns> clone =
                new HashMap<>(inputValue.getSignState());
        return new DSLatticeValue(clone);
    }
}
