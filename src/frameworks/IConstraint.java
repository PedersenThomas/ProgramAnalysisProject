package frameworks;

import graph.OutType;

import java.util.List;
import java.util.Set;

public interface IConstraint {
	ILatticeValue eval(List<ILatticeValue> analysisList);
	Set<Integer> getFreeVariables();
	OutType getOutType();
}