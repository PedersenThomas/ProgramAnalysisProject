package frameworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorklistAlgorithm {
	private IWorklist worklist;
	private ArrayList<ILaticeValue> analysis;
	private ArrayList<Set<Integer>> influenceList;
	private List<IConstraint> constrains;

	// Step 1
	public WorklistAlgorithm(IWorklist worklist, IMonotoneFramework framework) {
		this.worklist = worklist;
		this.constrains = framework.getConstrains();
		this.analysis = new ArrayList<ILaticeValue>(constrains.size());
		this.influenceList = new ArrayList<Set<Integer>>(constrains.size());

		for (int i = 0; i < constrains.size(); i++) {
			this.worklist.insert(i);
			this.analysis.add(framework.getButtom());
			this.influenceList.add(new HashSet<Integer>());
		}

		for (int i = 0; i < constrains.size(); i++) {
			Set<Integer> freeVariables = this.constrains.get(i).getFreeVariables();
			Set<Integer> newValue = Util.Union(this.influenceList.get(i), freeVariables);
			this.influenceList.set(i, newValue);
		}
	}

	// Step 2
	public ArrayList<ILaticeValue> Run() {
		while (!worklist.isEmpty()) {
			int index = worklist.extract();
			IConstraint constraint = constrains.get(index);
			ILaticeValue newValue = constraint.eval(analysis);
			if (!analysis.get(index).isSubset(newValue)) {
				analysis.set(index, analysis.get(index).join(newValue));
				for (int indexPrime : influenceList.get(index)) {
					worklist.insert(indexPrime);
				}
			}
		}

		return this.analysis;
	}
}
