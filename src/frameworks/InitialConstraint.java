package frameworks;

import graph.OutType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitialConstraint implements IConstraint {

    private ILatticeValue initialValue;
	
	public InitialConstraint(ILatticeValue initialValue) {
		this.initialValue = initialValue;
	}
	
	@Override
	public ILatticeValue eval(List<ILatticeValue> analysisList) {
		return initialValue;
	}

	@Override
	public Set<Integer> getFreeVariables() {
		return new HashSet<Integer>();
	}

	@Override
	public OutType getOutType() {
		return OutType.None;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + initialValue;
	}
}
