package frameworks.detectionOfSigns;

import java.util.HashMap;
import java.util.Map;

import ast.ArithmeticExpression;
import graph.Variable;

public class AssignmentTransferFunction extends DSTransferFunction {

    private Variable left;
    private ArithmeticExpression right;

    public AssignmentTransferFunction(int inputIndex, Variable left, ArithmeticExpression right) {
        super(inputIndex);
        this.left = left;
        this.right = right;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        SetOfSigns signsOfRight =
                Util.evalDSArithmeticExpression(right, inputValue.getSignState());
        if (signsOfRight.isEmpty()) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {  // The right hand side is not the empty set of signs.
            Map<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(inputValue.getSignState());
            clone.put(left, signsOfRight);
            return new DSLatticeValue(clone);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + left + " = " + right;
    }
}
