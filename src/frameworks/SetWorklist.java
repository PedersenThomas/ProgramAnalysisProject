package frameworks;

import java.util.HashSet;
import java.util.Set;

public class SetWorklist<T> implements IWorklist<T> {
	private Set<T> set = new HashSet<T>();

	@Override
	public void insert(T item) {
		set.add(item);
	}

	@Override
	public T extract() {
		// Finds an element in the set.
		T item = null;
		for (T t : set) {
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
