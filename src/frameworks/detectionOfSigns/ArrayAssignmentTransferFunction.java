package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;
import graph.Variable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class ArrayAssignmentTransferFunction extends DSTransferFunction {

    Variable array;
    ArithmeticExpression index;
    ArithmeticExpression right;

    public ArrayAssignmentTransferFunction(
            int inputIndex, Variable array,
            ArithmeticExpression indexExpression,ArithmeticExpression rightHandSide) {
        super(inputIndex);
        this.array = array;
        this.index = indexExpression;
        this.right = rightHandSide;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {

        PowerSetOfSigns signsOfIndex = Util.evalDSArithmeticExpression(this.index, inputValue.getSignState());
        PowerSetOfSigns signsOfRight = Util.evalDSArithmeticExpression(this.right, inputValue.getSignState());

        if (signsOfIndex.isEmpty() || signsOfIndex.equals(Util.NEGATIVE_ONLY)
                || signsOfRight.isEmpty()) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {
            Map<Variable, PowerSetOfSigns> clone = new HashMap<>(inputValue.getSignState());
            Set<Signs> newSigns = new HashSet<>(inputValue.lookUp(array).getSigns());
            newSigns.addAll(signsOfRight.getSigns());
            clone.put(array, new PowerSetOfSigns(newSigns));
            return new DSLatticeValue(clone);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + array + "[" + index + "]" + " = " + right;
    }
}
