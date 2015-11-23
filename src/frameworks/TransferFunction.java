package frameworks;

import graph.BranchType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TransferFunction implements IConstraint {

    private final int inputIndex;

    public TransferFunction(int inputIndex) {
        this.inputIndex = inputIndex;
    }

    public int getInputIndex() {
        return inputIndex;
    }

    @Override
    public BranchType getBranchType() {
        return BranchType.None;
    }

    @Override
    public abstract ILatticeValue eval(List<ILatticeValue> analysisList);

    @Override
    public Set<Integer> getFreeVariables() {
        Set<Integer> freeVariables = new HashSet<Integer>();
        freeVariables.add(inputIndex);
        return freeVariables;
    }
}
