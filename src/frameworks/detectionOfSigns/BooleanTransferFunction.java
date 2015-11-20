package frameworks.detectionOfSigns;

/**
 * Created by PatrickKasting on 16/11/15.
 */
public class BooleanTransferFunction extends DSTransferFunction {

    private boolean branch;

    public BooleanTransferFunction(int inputIndex, boolean branch) {
        super(inputIndex);
        this.branch = branch;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        return null;
    }

}
