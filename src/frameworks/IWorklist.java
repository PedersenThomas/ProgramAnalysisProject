package frameworks;

public interface IWorklist<T> {
	void insert(T item);
	T extract();
	boolean isEmpty();
}
