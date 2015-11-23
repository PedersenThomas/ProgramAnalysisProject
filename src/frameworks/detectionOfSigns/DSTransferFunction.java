package frameworks.detectionOfSigns;

import java.util.List;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;

public abstract class DSTransferFunction extends TransferFunction {

    public DSTransferFunction(int inputIndex) {
        super(inputIndex);
    }

    @Override
    public ILatticeValue eval(List<ILatticeValue> analysisList) {
        DSLatticeValue inputValue =
                (DSLatticeValue) analysisList.get(this.getInputIndex());
        if (inputValue.isBottom()) {  // Pass on the error state, if the input is bottom.
            return new DSLatticeValue(inputValue.getSignState());
        } else {
            return this.evalOnNonBottom(inputValue);
        }
    }

    public abstract DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue);

}
