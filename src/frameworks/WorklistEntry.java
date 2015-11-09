package frameworks;

public class WorklistEntry<T> {
	private int index;
	private IConstraint<T> item;
	
	public WorklistEntry(int index, IConstraint<T> item) {
		this.index = index;
		this.item = item;
	}

	public int getIndex() {
		return index;
	}

	public IConstraint<T> getItem() {
		return item;
	}
}
