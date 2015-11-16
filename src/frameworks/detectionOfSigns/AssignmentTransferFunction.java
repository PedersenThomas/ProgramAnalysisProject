package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;
import ast.VariableAssignment;
import frameworks.ILatticeValue;
import frameworks.TransferFunction;
import frameworks.reachingDefinitions.RDLatticeValue;
import graph.Variable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (signsOfRight.equals(Util.EMPTY_SET)) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {  // The right hand side is not the empty set of signs.
            Map<Variable, PowerSetOfSigns> clone = new HashMap<>(inputValue.getSignState());
            clone.put(left, signsOfRight);
            return new DSLatticeValue(clone);
        }
    }

}
