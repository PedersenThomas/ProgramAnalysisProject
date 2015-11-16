package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;
import ast.VariableAssignment;
import frameworks.ILatticeValue;
import frameworks.TransferFunction;
import frameworks.reachingDefinitions.RDLatticeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public class AssignmentTransferFunction extends DSTransferFunction {

    private VariableAssignment assignment;

    public AssignmentTransferFunction(int inputIndex, VariableAssignment assignment) {
        super(inputIndex);
        this.assignment = assignment;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        String left = this.assignment.getVariableName();
        ArithmeticExpression right = this.assignment.getRight();
        PowerSetOfSigns signsOfRight =
                Util.evalDSArithmeticExpression(right, inputValue.getSignState());
        if (signsOfRight.equals(Util.EMPTY_SET)) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {  // The right hand side is not the empty set of signs.
            Map<String, PowerSetOfSigns> clone = new HashMap<>(inputValue.getSignState());
            clone.put(left, signsOfRight);
            return new DSLatticeValue(clone);
        }
    }

}
