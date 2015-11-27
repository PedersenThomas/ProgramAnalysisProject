package frameworks.worklists;

import frameworks.IWorklist;

import java.util.HashSet;
import java.util.Set;

public class SetWorklist implements IWorklist {

	private Set<Integer> set = new HashSet<Integer>();

	private int numberOfInserts = 0;
	private int numberOfExtracts = 0;
	
	@Override
	public void insert(int index) {
		numberOfInserts += 1;
		set.add(index);
	}

	@Override
	public int extract() {
		numberOfExtracts += 1;

		// Finds an element in the set.
		Integer item = set.iterator().next();
		set.remove(item);

		return item;

	}

	@Override
	public String toString() {
		return "set=" + set.toString() + ", size=" + set.size();
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	public String getName() {
		return "Set Worklist";
	}

	@Override
	public int getNumberOfInsertions() {
		return numberOfInserts;
	}

	@Override
	public int getNumberOfExtractions() {
		return numberOfExtracts;
	}
}
