package frameworks.detectionOfSigns;

import java.util.List;
import java.util.Set;

import frameworks.IConstraint;
import frameworks.ILatticeValue;
import frameworks.IMonotoneFramework;
import graph.FlowGraph;
import graph.Variable;

public class DetectionOfSigns implements IMonotoneFramework {

    private Set<Variable> variables;

    public DetectionOfSigns(Set<Variable> variables) {
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

	@Override
	public List<Integer> LabelMapToConstraints(Integer label) {
		// TODO Auto-generated method stub
		return null;
	}
}
