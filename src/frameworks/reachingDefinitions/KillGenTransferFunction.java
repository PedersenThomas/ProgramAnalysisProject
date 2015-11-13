package frameworks.reachingDefinitions;

import frameworks.IConstraint;
import frameworks.ILatticeValue;

import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class KillGenTransferFunction implements IConstraint {

    private final int inputIndex;

    private final BitSet killSet;
    private final BitSet genSet;

    public KillGenTransferFunction(int inputIndex, BitSet killSet, BitSet genSet) {
        this.inputIndex = inputIndex;
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
        Set<Integer> freeVariables = new HashSet<>();
        freeVariables.add(inputIndex);
        return freeVariables;
    }
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " InputIndex" + inputIndex + " GenSet:" + genSet + " KillSet:" + killSet;
	}
}
