package frameworks.reachingDefinitions;

import frameworks.ILatticeValue;

import java.util.BitSet;

public class RDLatticeValue implements ILatticeValue {

    private BitSet bitSet;

    public RDLatticeValue() {
        this.bitSet = new BitSet();
    }

    public BitSet getBitSet() {
        return bitSet;
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
    public boolean lessThanOrEqualTo(ILatticeValue other) {
        BitSet cloneOfThisBitSet = (BitSet) this.bitSet.clone();
        RDLatticeValue otherRDLatticeValue = (RDLatticeValue) other;
        cloneOfThisBitSet.andNot(otherRDLatticeValue.bitSet);
        return cloneOfThisBitSet.isEmpty();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof RDLatticeValue)) {
            return false;
        }
        RDLatticeValue otherRDLatticeValue = (RDLatticeValue) other;
        return this.bitSet.equals(otherRDLatticeValue.bitSet);
    }

    @Override
    public ILatticeValue join(ILatticeValue other) {
        BitSet cloneOfThisBitSet = (BitSet) this.bitSet.clone();
        RDLatticeValue otherRDLatticeValue = (RDLatticeValue) other;
        cloneOfThisBitSet.or(otherRDLatticeValue.bitSet);
        return new RDLatticeValue(cloneOfThisBitSet);
    }

    @Override
    public String toString() {
        return bitSet.toString();
    }
}
