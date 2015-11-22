package frameworks.detectionOfSigns;

import ast.BooleanExpression;
import graph.OutType;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class TrueTransferFunction extends BooleanTransferFunction {

    public TrueTransferFunction(int inputIndex, BooleanExpression expression) {
        super(inputIndex, true, expression);
    }

    @Override
    public OutType getOutType() {
        return OutType.True;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
