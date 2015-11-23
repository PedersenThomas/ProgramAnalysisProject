package frameworks.detectionOfSigns;

import java.util.HashMap;
import java.util.Map;

import ast.ArithmeticExpression;
import graph.Variable;

/**
 * Created by PatrickKasting on 13/11/15.
 */
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
        PowerSetOfSigns signsOfRight =
                Util.evalDSArithmeticExpression(right, inputValue.getSignState());
        if (signsOfRight.isEmpty()) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {  // The right hand side is not the empty set of signs.
            Map<Variable, PowerSetOfSigns> clone = new HashMap<Variable, PowerSetOfSigns>(inputValue.getSignState());
            clone.put(left, signsOfRight);
            return new DSLatticeValue(clone);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + left + " = " + right;
    }
}
