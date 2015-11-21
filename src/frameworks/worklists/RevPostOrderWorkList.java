package frameworks.worklists;

import java.util.*;
import java.util.List;

import frameworks.IWorklist;
import org.apache.commons.lang3.ArrayUtils;

public class RevPostOrderWorkList implements IWorklist {

	private List<Set<Integer>> influenceList;

	private int numberOfConstraints;
	private boolean[] marks;
	private int[] order;
	private int currentOrder;

	private Set<Integer> pending;
	private List<Integer> current;
	
	private int numberOfInsertions = 0;
	private int numberOfExtractions = 0;

	public RevPostOrderWorkList(List<Set<Integer>> influenceList) {

		this.influenceList = influenceList;

		numberOfConstraints = influenceList.size();
		marks = new boolean[numberOfConstraints];
		order = new int[numberOfConstraints];
		currentOrder = numberOfConstraints;

		pending = new HashSet<>();
		current = new LinkedList<>();

	}

	private void depthFirstSearchVisit(int constraint) {
		marks[constraint] = true;
		for (int incidentTo : influenceList.get(constraint)) {
			if (!marks[incidentTo]) {
				depthFirstSearchVisit(incidentTo);
			}
		}
		currentOrder--;
		order[constraint] = currentOrder;
	}
	
	@Override
	public void insert(int index) {
		numberOfInsertions += 1;
		pending.add(index);
	}

	protected void sort(List<Integer> list) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer c1, Integer c2) {
				int o1 = order[c1];
				int o2 = order[c2];
				if (o1 < o2) {
					return -1;
				} else if (o1 == o2) {
					return 0;
				} else {
					return 1;
				}
			}
		};
		Collections.sort(list, comparator);
	}


	@Override
	public int extract() {
		numberOfExtractions += 1;
		if(current.isEmpty()) {
			current = new ArrayList<>(pending);
			sort(current);
			pending.clear();
		}
		return current.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return current.isEmpty() && pending.isEmpty();
	}

	@Override
	public String getName() {
		return "Reverse Postorder Worklist";
	}

	@Override
	public int getNumberOfInsertions() {
		return numberOfInsertions;
	}

	@Override
	public int getNumberOfExtractions() {
		return numberOfExtractions;
	}

	@Override
	public String toString() {
		return "current=" + current + ", pending=" + pending + ", size=" + (current.size() + pending.size());
	}
}
