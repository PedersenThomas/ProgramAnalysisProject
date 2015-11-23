package frameworks;

import graph.BranchType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recombination implements IConstraint {

	private Set<Integer> freeVariables;

	public Recombination() {
		this.freeVariables = new HashSet<Integer>();
	}
	
    public Recombination(int singletonFreeVariable) {
        Set<Integer> singletonSet = new HashSet<Integer>();
        singletonSet.add(singletonFreeVariable);
        this.freeVariables = singletonSet;
    }

    public Recombination(int[] freeVariables) {
        this.freeVariables = new HashSet<Integer>();
        for (int i : freeVariables) {
            this.freeVariables.add(i);
        }
    }

	public Recombination(Set<Integer> freeVariables) {
		this.freeVariables = freeVariables;
	}

	@Override
	public ILatticeValue eval(List<ILatticeValue> analysisList) {
		ILatticeValue current = null;
        // Get the first value in the set.
		for (Integer i : this.freeVariables) {
			current = analysisList.get(i);
            break;
		}
        assert (current != null);
        // Join all incoming states.
        for (Integer i : this.freeVariables) {
            current = current.join(analysisList.get(i));
        }
		return current;
	}
	
	public void insertFreeVariable(int label) {
		this.freeVariables.add(label);
	}

	@Override
	public Set<Integer> getFreeVariables() {
		return freeVariables;
	}

	@Override
	public BranchType getBranchType() {
		return BranchType.None;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + freeVariables;
	}
}
