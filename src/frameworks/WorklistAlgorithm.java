package frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WorklistAlgorithm {
	private IWorklist worklist;
	private ArrayList<ILatticeValue> analysis;
	private ArrayList<Set<Integer>> influenceList;
	private List<IConstraint> constraints;

	// Step 1
	public WorklistAlgorithm(IWorklist worklist, MonotoneFramework framework) {

		this.worklist = worklist;
		this.constraints = framework.getConstraints();
		this.analysis = new ArrayList<ILatticeValue>(constraints.size());
		this.influenceList = framework.getInfluenceList();

		for (int i = 0; i < constraints.size(); i++) {
			this.worklist.insert(i);
			this.analysis.add(framework.getBottom());
		}

    }

	// Step 2
	public ArrayList<ILatticeValue> run() {
		while (!worklist.isEmpty()) {
			int index = worklist.extract();
            IConstraint constraint = constraints.get(index);
			ILatticeValue newValue = constraint.eval(analysis);
			if (!newValue.isSubset(analysis.get(index))) {
                analysis.set(index, analysis.get(index).join(newValue));
				for (int indexPrime : influenceList.get(index)) {
					worklist.insert(indexPrime);
				}
			}
		}

		return this.analysis;
	}
}
