package frameworks;

import java.util.List;

public interface IMonotoneFramework {
	ILatticeValue getButtom();
	List<IConstraint> getConstrains();
}
