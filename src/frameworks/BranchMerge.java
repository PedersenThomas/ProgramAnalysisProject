package frameworks;

import java.util.List;
import java.util.Set;

public class BranchMerge implements IConstraint {

	private Set<Integer> freeVariable;

	public BranchMerge(Set<Integer> freeVariable) {
		this.freeVariable = freeVariable;
	}

	@Override
	public ILatticeValue eval(List<ILatticeValue> analysisList) {
		ILatticeValue current = analysisList.get(0);
		for (ILatticeValue value : analysisList) {
			current = current.join(value);
		}
		return current;
	}

	@Override
	public Set<Integer> getFreeVariables() {
		return freeVariable;
	}

}
