package frameworks;

import java.util.HashSet;
import java.util.Set;

public class SetWorklist<T> implements IWorklist<T> {
	private Set<WorklistEntry<T>> set = new HashSet<WorklistEntry<T>>();

	@Override
	public void insert(WorklistEntry<T> item) {
		set.add(item);
	}

	@Override
	public WorklistEntry<T> extract() {
		// Finds an element in the set.
		WorklistEntry<T> item = null;
		for (WorklistEntry<T> t : set) {
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
