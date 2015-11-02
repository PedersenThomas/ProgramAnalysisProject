package frameworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WorklistAlgorithm<T> {
	private IWorklist<T> worklist;
	private ArrayList<T> analysis;
	private ArrayList<Set<Integer>> influenceList;
	
	public WorklistAlgorithm(IWorklist<T> worklist, ArrayList<IConstraint<T>> Contrains) {
		this.worklist = worklist;
		this.analysis = new ArrayList<T>(Contrains.size());
		this.influenceList = new ArrayList<Set<Integer>>(Contrains.size());
		for (int i = 0; i < Contrains.size(); i++) {
			this.influenceList.add(new HashSet<Integer>());
		}
	}
	
	ArrayList<T> Run() {
		
		return this.analysis;
	}
}
