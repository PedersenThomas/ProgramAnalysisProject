package frameworks.reachingDefinitions;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;

import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class KillGenTransferFunction extends TransferFunction {

    private final BitSet killSet;
    private final BitSet genSet;
    
    public KillGenTransferFunction(int inputIndex, BitSet killSet, BitSet genSet) {
        super(inputIndex);
        this.killSet = killSet;
        this.genSet = genSet;
    }

    public KillGenTransferFunction(int inputIndex, BitSet killSet, int gen) {
        super(inputIndex);
        this.killSet = killSet;

        BitSet genSet = new BitSet();
        genSet.set(gen);
        this.genSet = genSet;
    }

    @Override
    public ILatticeValue eval(List<ILatticeValue> analysisList) {
        RDLatticeValue dependency = (RDLatticeValue) analysisList.get(this.getInputIndex());
        BitSet cloneOfDependencyBitSet = (BitSet) dependency.getBitSet().clone();
        cloneOfDependencyBitSet.andNot(killSet);
        cloneOfDependencyBitSet.or(genSet);
        return new RDLatticeValue(cloneOfDependencyBitSet);
    }

    @Override
    public Set<Integer> getFreeVariables() {
        Set<Integer> freeVariables = new HashSet<Integer>();
        freeVariables.add(this.getInputIndex());
        return freeVariables;
    }
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " WorksOnConstraint: " + 
	           this.getInputIndex() + " GenSet:" + genSet + " KillSet:" + killSet;
	}
}
