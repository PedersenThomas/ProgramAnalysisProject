package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;

public class WriteTransferFunction extends DSTransferFunction {

    private ArithmeticExpression expression;

    public WriteTransferFunction(int inputIndex, ArithmeticExpression expression) {
        super(inputIndex);
        this.expression = expression;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        SetOfSigns signsOfExpression =
                Util.evalDSArithmeticExpression(expression, inputValue.getSignState());
        if (signsOfExpression.isEmpty()) {
            return new DSLatticeValue(inputValue.getVariables());  // Bottom
        } else {
            return new DSLatticeValue(inputValue.getSignState());  // Exact copy
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": write " + expression;
    }
}
