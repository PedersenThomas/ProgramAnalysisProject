package frameworks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitialContraint implements IConstraint {
	private ILaticeValue initialValue;
	
	public InitialContraint(ILaticeValue initialValue) {
		this.initialValue = initialValue;
	}
	
	@Override
	public ILaticeValue eval(List<ILaticeValue> analysisList) {
		return initialValue;
	}

	@Override
	public Set<Integer> getFreeVariables() {
		return new HashSet<Integer>();
	}
}
