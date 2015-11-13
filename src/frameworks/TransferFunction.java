package frameworks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PatrickKasting on 13/11/15.
 */
public abstract class TransferFunction implements IConstraint {

    protected final int inputIndex;

    public TransferFunction(int inputIndex) {
        this.inputIndex = inputIndex;
    }

    @Override
    public abstract ILatticeValue eval(List<ILatticeValue> analysisList);

    @Override
    public Set<Integer> getFreeVariables() {
        Set<Integer> freeVariables = new HashSet<>();
        freeVariables.add(inputIndex);
        return freeVariables;
    }
}
