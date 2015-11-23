package frameworks.reachingDefinitions;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;
import graph.OutType;

import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KillGenTransferFunction extends TransferFunction {

    private final BitSet killSet;
    private final BitSet genSet;

    private final OutType outType;

    public KillGenTransferFunction(int inputIndex, BitSet killSet, BitSet genSet) {
        this(inputIndex, killSet, genSet, OutType.None);
    }
    
    public KillGenTransferFunction(int inputIndex, BitSet killSet, BitSet genSet, OutType outType) {
        super(inputIndex);
        this.killSet = killSet;
        this.genSet = genSet;

        this.outType = outType;
    }

    public KillGenTransferFunction(int inputIndex, BitSet killSet, int gen) {
        super(inputIndex);
        this.killSet = killSet;

        BitSet genSet = new BitSet();
        genSet.set(gen);
        this.genSet = genSet;

        this.outType = OutType.None;
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
    public OutType getOutType() {
        return this.outType;
    }

    @Override
	public String toString() {
		return this.getClass().getSimpleName() + " WorksOnConstraint: " + 
	           this.getInputIndex() + " GenSet:" + genSet + " KillSet:" + killSet;
	}
}
