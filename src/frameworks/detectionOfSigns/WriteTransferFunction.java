package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class WriteTransferFunction extends DSTransferFunction {

    private ArithmeticExpression expression;

    public WriteTransferFunction(int inputIndex, ArithmeticExpression expression) {
        super(inputIndex);
        this.expression = expression;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        PowerSetOfSigns signsOfExpression =
                Util.evalDSArithmeticExpression(expression, inputValue.getSignState());
        if (signsOfExpression.isEmpty()) {
            return new DSLatticeValue(inputValue.getVariables());  // Bottom
        } else {
            return new DSLatticeValue(inputValue.getSignState());  // Exact copy
        }
    }
}
