package frameworks.detectionOfSigns;

import ast.BooleanExpression;
import graph.BranchType;

public class TrueTransferFunction extends BooleanTransferFunction {

    public TrueTransferFunction(int inputIndex, BooleanExpression expression) {
        super(inputIndex, true, expression);
    }

    @Override
    public BranchType getBranchType() {
        return BranchType.True;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
