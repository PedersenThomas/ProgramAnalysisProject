package frameworks;

public interface ILatticeValue {
	public boolean lessThanOrEqualTo(ILatticeValue other);
	public ILatticeValue join(ILatticeValue other);
}
