package frameworks;

import java.util.List;

public interface IMonotoneFramework {
	ILatticeValue getBottom();
	List<IConstraint> getConstrains();
	List<Integer> LabelMapToConstraints(Integer label);
}
