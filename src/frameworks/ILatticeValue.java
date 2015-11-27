package frameworks;

public interface ILatticeValue {
	public boolean isSubset(ILatticeValue other);
	public ILatticeValue join(ILatticeValue other);
}
