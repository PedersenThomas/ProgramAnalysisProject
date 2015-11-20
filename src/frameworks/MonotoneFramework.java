package frameworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class MonotoneFramework {
	
	private ArrayList<Set<Integer>> influenceList;

	public abstract ILatticeValue getBottom();
	public abstract List<IConstraint> getConstraints();
	public abstract Integer ConstraintsMapToLabel(Integer label);

	
	public ArrayList<Set<Integer>> getInfluenceList() {
		if (influenceList == null) {
			List<IConstraint> constraints = getConstraints();
			this.influenceList = new ArrayList<Set<Integer>>(constraints.size());
	
			for (int i = 0; i < constraints.size(); i++) {
				this.influenceList.add(new HashSet<Integer>());
			}
	
			for (int i = 0; i < constraints.size(); i++) {
				Set<Integer> freeVariables = constraints.get(i).getFreeVariables();
	            for (Integer n : freeVariables) {
	                influenceList.get(n).add(i);
	            }
			}
		}
		return this.influenceList;
	}
	
}
