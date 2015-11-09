package frameworks.worklists;

import frameworks.IWorklist;

import java.util.HashSet;
import java.util.Set;

public class SetWorklist implements IWorklist {
	private Set<Integer> set = new HashSet<Integer>();

	@Override
	public void insert(int index) {
		set.add(index);
	}

	@Override
	public int extract() {
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
	public boolean isEmpty() {
		return set.isEmpty();
	}
}
