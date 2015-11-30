package frameworks;

import graph.BranchType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtremalConstraint implements IConstraint {

    private ILatticeValue extremalValue;
	
	public ExtremalConstraint(ILatticeValue extremalValue) {
		this.extremalValue = extremalValue;
	}
	
	@Override
	public ILatticeValue eval(List<ILatticeValue> analysisList) {
		return extremalValue;
	}

	@Override
	public Set<Integer> getFreeVariables() {
		return new HashSet<Integer>();
	}

	@Override
	public BranchType getBranchType() {
		return BranchType.None;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + extremalValue;
	}
}
