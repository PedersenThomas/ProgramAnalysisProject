package frameworks.reachingDefinitions;

import frameworks.*;

import java.util.*;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class ReachingDefinitions implements IMonotoneFramework {

    private List<IConstraint> constraints;

    public ReachingDefinitions(Object flowGraph) {

        this.constraints = new ArrayList<IConstraint>(4);

        //example1();
        example2();


    }

    private void example2() {

        BitSet initial = new BitSet();
        initial.set(0);
        this.constraints.add(new InitialConstraint(new RDLatticeValue(initial)));  // 0

        BitSet kill = new BitSet();
        kill.set(0, 5);

        BitSet gen1 = new BitSet();
        gen1.set(1);

        BitSet gen2 = new BitSet();
        gen2.set(2);

        BitSet gen3 = new BitSet();
        gen3.set(3);

        BitSet gen4 = new BitSet();
        gen4.set(4);

        this.constraints.add(new KillGenTransferFunction(0, kill, gen1));  // 1
        this.constraints.add(new BranchMerge(1));  // 2
        this.constraints.add(new KillGenTransferFunction(2, kill, gen2));  // 3
        int[] merge4 = {3, 7};
        this.constraints.add(new BranchMerge(merge4));  // 4
        this.constraints.add(new KillGenTransferFunction(0, kill, gen1));  // 5
        this.constraints.add(new BranchMerge(5));  // 6
        this.constraints.add(new KillGenTransferFunction(6, kill, gen3));  // 7
        this.constraints.add(new KillGenTransferFunction(4, kill, gen4)); // 8

    }

    private void example1() {

        BitSet initial = new BitSet();
        initial.set(0);
        this.constraints.add(new InitialConstraint(new RDLatticeValue(initial)));

        BitSet kill1 = new BitSet();
        kill1.set(0); kill1.set(1);
        BitSet gen1 = new BitSet();
        gen1.set(1);
        this.constraints.add(new KillGenTransferFunction(0, kill1, gen1));

        Set<Integer> free2 = new HashSet<>();
        free2.add(1);
        this.constraints.add(new BranchMerge(free2));

        BitSet kill2 = new BitSet();
        kill2.set(0); kill2.set(1); kill2.set(2);
        BitSet gen2 = new BitSet();
        gen2.set(2);
        this.constraints.add(new KillGenTransferFunction(2, kill2, gen2));

    }

    @Override
    public ILatticeValue getButtom() {
        return new RDLatticeValue();
    }

    @Override
    public List<IConstraint> getConstrains() {
        return Collections.unmodifiableList(this.constraints);
    }

}
