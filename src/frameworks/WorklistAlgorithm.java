package frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class WorklistAlgorithm {

	private IWorklist worklist;
	private ArrayList<ILatticeValue> analysis;
	private ArrayList<Set<Integer>> influenceList;
	private List<IConstraint> constraints;
	private MonotoneFramework framework;

	private long timer;
	private boolean hasRun;

	// Step 1
	public WorklistAlgorithm(IWorklist worklist, MonotoneFramework framework) {

		long constructorStartTime = System.currentTimeMillis();

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
		timer = System.currentTimeMillis() - constructorStartTime;

    }

	// Step 2
	public ArrayList<ILatticeValue> run() {

		long runStartTime = System.currentTimeMillis();

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
		timer += System.currentTimeMillis() - runStartTime;
		return this.analysis;

	}

	@Override
	public String toString() {
		if (!hasRun) {
			return "This Worklist Algorithm has not been run.";
		} else {
			StringBuilder result = new StringBuilder();
			result.append("Result of " + framework + " using a " + worklist.getName() + ":\n\n");
			result.append(framework.formatResult(this.analysis));
			result.append("\nPerformance:\n");
			result.append("* Worklist insertions: " + worklist.getNumberOfInsertions() + "\n");
			result.append("* Worklist extraction: " + worklist.getNumberOfExtracts() + "\n");
			result.append(String.format(Locale.US, "* Running time: %.3f seconds\n", timer / 1000f));
			return result.toString();
		}
	}

}
