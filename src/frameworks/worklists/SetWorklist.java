package frameworks.worklists;

import frameworks.IWorkList;

import java.util.HashSet;
import java.util.Set;

public class SetWorkList implements IWorkList {
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
	public String toString() {
		return "SetWorkList{" +
				"set=" + set +
				'}';
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}
}
