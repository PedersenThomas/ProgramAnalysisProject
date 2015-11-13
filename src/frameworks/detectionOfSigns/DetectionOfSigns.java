package frameworks.detectionOfSigns;

import java.util.List;
import java.util.Set;

import frameworks.IConstraint;
import frameworks.ILatticeValue;
import frameworks.IMonotoneFramework;
import graph.FlowGraph;

public class DetectionOfSigns implements IMonotoneFramework {

    private Set<String> variables;

    public DetectionOfSigns(Set<String> variables) {
        this.variables = variables;
    }

    @Override
	public ILatticeValue getBottom() {
		return new DSLatticeValue(this.variables);
	}

	@Override
	public List<IConstraint> getConstrains() {
		return null;
	}

}
