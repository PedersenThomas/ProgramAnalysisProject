package frameworks.detectionOfSigns;

import ast.BooleanExpression;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class FalseTransferFunction extends BooleanTransferFunction {

    public FalseTransferFunction(int inputIndex, BooleanExpression expression) {
        super(inputIndex, false, expression);
    }

}
