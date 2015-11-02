package frameworks;

public interface ILaticeValue<T> {
	boolean isSubset(ILaticeValue<T> other);
	boolean isEquals(ILaticeValue<T> other);
	ILaticeValue<T> join(ILaticeValue<T> other);
	ILaticeValue<T> getButtom();
}
