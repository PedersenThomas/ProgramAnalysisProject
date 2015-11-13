package frameworks.reachingDefinitions;

import frameworks.ILatticeValue;
import frameworks.TransferFunction;

import java.util.BitSet;
import java.util.List;

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

    @Override
    public ILatticeValue eval(List<ILatticeValue> analysisList) {
        RDLatticeValue dependency = (RDLatticeValue) analysisList.get(this.inputIndex);
        BitSet cloneOfDependencyBitSet = (BitSet) dependency.getBitSet().clone();
        cloneOfDependencyBitSet.andNot(killSet);
        cloneOfDependencyBitSet.or(genSet);
        return new RDLatticeValue(cloneOfDependencyBitSet);
    }

}
