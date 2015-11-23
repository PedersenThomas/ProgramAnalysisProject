package frameworks.detectionOfSigns;

import ast.BooleanExpression;
import graph.BranchType;

public class FalseTransferFunction extends BooleanTransferFunction {

    public FalseTransferFunction(int inputIndex, BooleanExpression expression) {
        super(inputIndex, false, expression);
    }

    @Override
    public BranchType getBranchType() {
        return BranchType.False;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
