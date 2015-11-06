package frameworks;

public interface ILaticeValue {
	public abstract boolean isSubset(ILaticeValue other);

	public abstract boolean isEqual(ILaticeValue other);

	public abstract ILaticeValue join(ILaticeValue other);
}
