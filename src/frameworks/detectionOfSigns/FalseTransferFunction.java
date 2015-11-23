package frameworks.detectionOfSigns;

import ast.BooleanExpression;
import graph.OutType;

public class FalseTransferFunction extends BooleanTransferFunction {

    public FalseTransferFunction(int inputIndex, BooleanExpression expression) {
        super(inputIndex, false, expression);
    }

    @Override
    public OutType getOutType() {
        return OutType.False;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
