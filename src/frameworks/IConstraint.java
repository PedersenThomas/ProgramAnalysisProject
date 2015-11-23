package frameworks;

import graph.BranchType;

import java.util.List;
import java.util.Set;

public interface IConstraint {
	ILatticeValue eval(List<ILatticeValue> analysisList);
	Set<Integer> getFreeVariables();
	BranchType getBranchType();
}