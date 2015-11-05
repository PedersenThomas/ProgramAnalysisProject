package frameworks;

public interface IWorklist<T> {
	void insert(WorklistEntry<T> item);
	WorklistEntry<T> extract();
	boolean isEmpty();
}
