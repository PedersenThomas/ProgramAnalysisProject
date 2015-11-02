package frameworks;

import java.util.List;

public interface IConstraint<T> {
	T eval(List<T> analysisList);
}
