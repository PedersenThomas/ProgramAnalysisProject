package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;
import graph.Variable;

import java.util.HashMap;
import java.util.Map;

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
        SetOfSigns signsOfIndex = Util.evalDSArithmeticExpression(index, inputValue.getSignState());
        if (signsOfIndex.isEmpty() || signsOfIndex.equals(Util.NEGATIVE_ONLY)) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {
            Map<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(inputValue.getSignState());
            clone.put(array, Util.ALL);
            return new DSLatticeValue(clone);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": read " + array + "[" + index + "]";
    }
}
