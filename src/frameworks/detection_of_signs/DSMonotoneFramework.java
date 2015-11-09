package frameworks.detection_of_signs;

import java.util.ArrayList;
import java.util.List;

import frameworks.IConstraint;
import frameworks.ILatticeValue;
import frameworks.IMonotoneFramework;
import frameworks.InitialConstraint;
import graph.FlowGraph;

public class DSMonotoneFramework implements IMonotoneFramework {
	private FlowGraph flowgraph;

	public DSMonotoneFramework(FlowGraph flowgraph) {
		this.flowgraph = flowgraph;
	}

	@Override
	public ILatticeValue getButtom() {
		return new DSLatticeValue();
	}

	@Override
	public List<IConstraint> getConstrains() {
		ArrayList<IConstraint> constrains = new ArrayList<IConstraint>();
		constrains.add(new InitialConstraint(this.getButtom()));

		return constrains;
	}
}
