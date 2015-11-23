package frameworks.detectionOfSigns;

import ast.BooleanExpression;
import frameworks.ILatticeValue;
import graph.Variable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BooleanTransferFunction extends DSTransferFunction {

    private boolean branch;
    private BooleanExpression expression;

    public BooleanTransferFunction(int inputIndex, boolean branch, BooleanExpression expression) {
        super(inputIndex);
        this.branch = branch;
        this.expression = expression;
    }

    @Override
    public DSLatticeValue evalOnNonBottom(DSLatticeValue inputValue) {

        Set<Map<Variable, SetOfSigns>> atoms = Util.atom(inputValue.getSignState());

        Set<DSLatticeValue> relevantAtoms = new HashSet<DSLatticeValue>();

        for (Map<Variable, SetOfSigns> atom : atoms) {
            SetOfBooleans bools = Util.evalDSBooleanExpression(expression, atom);
            if (bools.getBooleans().contains(branch)) {
                relevantAtoms.add(new DSLatticeValue(atom));
            }
        }

        ILatticeValue result = new DSLatticeValue(inputValue.getVariables());

        for (DSLatticeValue atom : relevantAtoms) {
            result = result.join(atom);
        }

        return (DSLatticeValue) result;

    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
