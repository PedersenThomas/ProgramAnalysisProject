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
		Integer item = null;
		for (int t : set) {
			item = t;
			break;
		}

		//If the collection is not empty.
		if (item != null) {
			set.remove(item);
		}
		return item;
	}

	@Override
	public String toString() {
		return "SetWorkList{" +
				"set=" + set +
				'}';
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
	public int getNumberOfExtracts() {
		return numberOfExtracts;
	}
}
