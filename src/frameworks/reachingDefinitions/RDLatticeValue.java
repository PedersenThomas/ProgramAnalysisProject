package frameworks.reachingDefinitions;

import frameworks.ILatticeValue;

import java.util.BitSet;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class RDLatticeValue implements ILatticeValue {

    private BitSet bitSet;

    public RDLatticeValue() {
        this.bitSet = new BitSet();
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    @Override
    public String toString() {
        return "" + bitSet;
    }

    public RDLatticeValue(BitSet bitSet) {
        this.bitSet = bitSet;
    }

    public RDLatticeValue setBit(int pos, boolean high) {
        BitSet cloneOfThisBitSet = (BitSet) this.bitSet.clone();
        cloneOfThisBitSet.set(pos, high);
        return new RDLatticeValue(cloneOfThisBitSet);
    }

    @Override
    public boolean isSubset(ILatticeValue other) {
        try {
            BitSet cloneOfThisBitSet = (BitSet) this.bitSet.clone();
            RDLatticeValue otherRDLatticeValue = (RDLatticeValue) other;
            cloneOfThisBitSet.andNot(otherRDLatticeValue.bitSet);
            return cloneOfThisBitSet.isEmpty();
        } catch (Exception e) {
            throw new RuntimeException("Bad unboxing in RDLatticeValue.isSubset!");
        }
    }

    @Override
    public boolean isEqual(ILatticeValue other) {
        RDLatticeValue otherRDLatticeValue = (RDLatticeValue) other;
        return this.bitSet.equals(otherRDLatticeValue.bitSet);
    }

    @Override
    public ILatticeValue join(ILatticeValue other) {
        try {
            BitSet cloneOfThisBitSet = (BitSet) this.bitSet.clone();
            RDLatticeValue otherRDLatticeValue = (RDLatticeValue) other;
            cloneOfThisBitSet.or(otherRDLatticeValue.bitSet);
            return new RDLatticeValue(cloneOfThisBitSet);
        } catch (Exception e) {
            throw new RuntimeException("Bad unboxing in RDLatticeValue.join!");
        }
    }

}
