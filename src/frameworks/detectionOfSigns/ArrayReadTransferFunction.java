package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;
import graph.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class ArrayReadTransferFunction extends DSTransferFunction {

    private Variable array;
    private ArithmeticExpression index;

    public ArrayReadTransferFunction(
            int inputIndex, Variable array, ArithmeticExpression indexExpression) {
        super(inputIndex);
        this.array = array;
        this.index = indexExpression;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        PowerSetOfSigns signsOfIndex = Util.evalDSArithmeticExpression(index, inputValue.getSignState());
        if (signsOfIndex.isEmpty() || signsOfIndex.equals(Util.NEGATIVE_ONLY)) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {
            Map<Variable, PowerSetOfSigns> clone = new HashMap<>(inputValue.getSignState());
            clone.put(array, Util.ALL);
            return new DSLatticeValue(clone);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": read " + array + "[" + index + "]";
    }
}
