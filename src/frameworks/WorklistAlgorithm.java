package frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WorklistAlgorithm {

	private IWorklist worklist;
	private List<ILatticeValue> analysis;
	private List<Set<Integer>> influenceList;
	private List<IConstraint> constraints;
	private MonotoneFramework framework;

	private boolean hasRun;

	// Step 1
	public WorklistAlgorithm(IWorklist worklist, MonotoneFramework framework) {
		assert (worklist.isEmpty() && framework != null);

		this.framework = framework;

		this.worklist = worklist;
		this.constraints = framework.getConstraints();
		this.analysis = new ArrayList<ILatticeValue>(constraints.size());
		this.influenceList = framework.getInfluenceList();

		for (int i = 0; i < constraints.size(); i++) {
			this.worklist.insert(i);
			this.analysis.add(framework.getBottom());
		}

		hasRun = false;

    }

	// Step 2
	public List<ILatticeValue> run() {

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

		hasRun = true;
		return this.analysis;

	}

	@Override
	public String toString() {
		if (!hasRun) {
			return "This Worklist Algorithm has not been run.";
		} else {
			StringBuilder result = new StringBuilder();
			result.append("Result of " + framework + " using a " + worklist.getName() + ":\n");
			result.append("\n" + framework.labelsTable() + "\n");
			result.append(framework.formatResult(this.analysis));
			result.append("\nPerformance:\n");
			result.append("* Worklist insertions: " + worklist.getNumberOfInsertions() + "\n");
			result.append("* Worklist extractions: " + worklist.getNumberOfExtractions() + "\n");
			return result.toString();
		}
	}

}
