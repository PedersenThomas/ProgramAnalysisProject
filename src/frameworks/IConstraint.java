package frameworks;

import java.util.List;
import java.util.Set;

public interface IConstraint {
	ILaticeValue eval(List<ILaticeValue> analysisList);

	Set<Integer> getFreeVariables();
}
