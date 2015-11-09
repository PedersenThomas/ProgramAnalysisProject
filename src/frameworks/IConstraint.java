package frameworks;

import java.util.List;

public interface IConstraint<T> {
	ILaticeValue<T> eval(List<ILaticeValue<T>> analysisList);
}
