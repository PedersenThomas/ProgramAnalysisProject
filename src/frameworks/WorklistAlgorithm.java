package frameworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WorklistAlgorithm<T> {
	private IWorklist<T> worklist;
	private ArrayList<ILaticeValue<T>> analysis;
	private ArrayList<Set<WorklistEntry<T>>> influenceList;
	
	//Step 1
	public WorklistAlgorithm(IWorklist<T> worklist, ArrayList<IConstraint<T>> Contrains) {
		this.worklist = worklist;
		this.analysis = new ArrayList<ILaticeValue<T>>(Contrains.size());
		this.influenceList = new ArrayList<Set<WorklistEntry<T>>>(Contrains.size());
		for (int i = 0; i < Contrains.size(); i++) {
			this.influenceList.add(new HashSet<WorklistEntry<T>>());
		}
	}
	
	//Step 2
	ArrayList<ILaticeValue<T>> Run() {
		while (!worklist.isEmpty()) {
			WorklistEntry<T> item = worklist.extract();
			ILaticeValue<T> newValue = item.getItem().eval(analysis);
			if ( !analysis.get(item.getIndex()).isSubset(newValue) ) {
				analysis.set(item.getIndex(), analysis.get(item.getIndex()).join(newValue) );
				for (WorklistEntry<T> value : influenceList.get(item.getIndex())) {
					worklist.insert(value);
				}
			}
		}
		
		return this.analysis;
	}
}
