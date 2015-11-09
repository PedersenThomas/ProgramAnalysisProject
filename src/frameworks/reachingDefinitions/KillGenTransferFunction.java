package frameworks.reachingDefinitions;

import frameworks.TransferFunction;

import java.util.BitSet;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class KillGenTransferFunction implements TransferFunction<RDLatticeValue> {

    private BitSet killSet;
    private BitSet genSet;

    public KillGenTransferFunction(BitSet killSet, BitSet genSet) {
        this.killSet = killSet;
        this.genSet = genSet;
    }

    @Override
    public RDLatticeValue Eval() {
        return null;
    }
}
