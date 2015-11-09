package frameworks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BranchMerge implements IConstraint {

	private Set<Integer> merges;

	public BranchMerge(Set<Integer> merges) {
		this.merges = merges;
	}

	@Override
	public ILatticeValue eval(List<ILatticeValue> analysisList) {
		ILatticeValue current = null;
		for (Integer i : this.merges) {
			ILatticeValue value = analysisList.get(i);
			if (current == null) {
				current = value;
			} else {
				current.join(value);
			}
		}
		return current;
	}

	@Override
	public Set<Integer> getFreeVariables() {
		return merges;
	}

}
