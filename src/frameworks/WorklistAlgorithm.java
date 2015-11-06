package frameworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WorklistAlgorithm<T> {
	private IWorklist worklist;
	private ArrayList<ILaticeValue<T>> analysis;
	private ArrayList<Set<Integer>> influenceList;
	private ArrayList<IConstraint<T>> constrains;
	
	//Step 1
	public WorklistAlgorithm(IWorklist worklist, ArrayList<IConstraint<T>> contrains) {
		this.worklist = worklist;
		this.constrains = contrains;
		this.analysis = new ArrayList<ILaticeValue<T>>(contrains.size());
		this.influenceList = new ArrayList<Set<Integer>>(contrains.size());
		for (int i = 0; i < contrains.size(); i++) {
			this.influenceList.add(new HashSet<Integer>());
		}
	}
	
	//Step 2
	public ArrayList<ILaticeValue<T>> Run() {
		while (!worklist.isEmpty()) {
			int index = worklist.extract();
			IConstraint<T> constraint = constrains.get(index);
			ILaticeValue<T> newValue = constraint.eval(analysis);
			if ( !analysis.get(index).isSubset(newValue) ) {
				analysis.set(index, analysis.get(index).join(newValue) );
				for (int indexPrime : influenceList.get(index)) {
					worklist.insert(indexPrime);
				}
			}
		}
		
		return this.analysis;
	}
}
