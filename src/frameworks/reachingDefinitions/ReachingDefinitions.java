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

        BitSet initial = new BitSet();
        initial.set(0);
        this.constraints.add(new InitialConstraint(new RDLatticeValue(initial)));

        Set<Integer> dep1 = new HashSet<Integer>();
        dep1.add(0);
        BitSet kill1 = new BitSet();
        kill1.set(0); kill1.set(1);
        BitSet gen1 = new BitSet();
        gen1.set(1);
        this.constraints.add(new KillGenTransferFunction(0, dep1, kill1, gen1));

        Set<Integer> free2 = new HashSet<>();
        free2.add(1);
        this.constraints.add(new BranchMerge(free2));

        Set<Integer> dep2 = new HashSet<Integer>();
        dep2.add(2);
        BitSet kill2 = new BitSet();
        kill2.set(0); kill2.set(1); kill2.set(2);
        BitSet gen2 = new BitSet();
        gen2.set(2);
        this.constraints.add(new KillGenTransferFunction(0, dep2, kill2, gen2));

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
