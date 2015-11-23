package frameworks.detectionOfSigns;

import ast.ArithmeticExpression;
import graph.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class ArrayDeclarationTransferFunction extends DSTransferFunction {

    private Variable array;
    private ArithmeticExpression size;

    public ArrayDeclarationTransferFunction(int inputIndex, Variable array, ArithmeticExpression size) {
        super(inputIndex);
        this.array = array;
        this.size = size;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {
        SetOfSigns signsOfSize =
                Util.evalDSArithmeticExpression(size, inputValue.getSignState());
        if (signsOfSize.equals(Util.NEGATIVE_ONLY) || signsOfSize.isEmpty()) {
            return new DSLatticeValue(inputValue.getVariables());
        } else {
            Map<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(inputValue.getSignState());
            clone.put(array, Util.ZERO_ONLY);
            return new DSLatticeValue(clone);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": int " + array + "[" + size + "]";
    }
}
