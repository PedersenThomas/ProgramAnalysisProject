package frameworks.reachingDefinitions;

import frameworks.IConstraint;
import frameworks.ILatticeValue;

import java.util.BitSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class KillGenTransferFunction implements IConstraint {

    private final int inputIndex;
    private final Set<Integer> freeVariables;

    private final BitSet killSet;
    private final BitSet genSet;

    public KillGenTransferFunction(int inputIndex, Set<Integer> freeVariables, BitSet killSet, BitSet genSet) {
        this.inputIndex = inputIndex;
        this.freeVariables = freeVariables;
        this.killSet = killSet;
        this.genSet = genSet;
    }

    @Override
    public ILatticeValue eval(List<ILatticeValue> analysisList) {
        RDLatticeValue dependency = (RDLatticeValue) analysisList.get(this.inputIndex);
        BitSet cloneOfDependencyBitSet = (BitSet) dependency.getBitSet().clone();
        cloneOfDependencyBitSet.andNot(killSet);
        cloneOfDependencyBitSet.or(genSet);
        return new RDLatticeValue(cloneOfDependencyBitSet);
    }

    @Override
    public Set<Integer> getFreeVariables() {
        return this.freeVariables;
    }
}
