package frameworks;

public interface ILatticeValue {
	public abstract boolean isSubset(ILatticeValue other);
	public abstract ILatticeValue join(ILatticeValue other);
}
