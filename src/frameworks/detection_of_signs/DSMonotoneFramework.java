package frameworks.detection_of_signs;

import java.util.List;

import frameworks.IConstraint;
import frameworks.ILaticeValue;
import frameworks.IMonotoneFramework;
import graph.FlowGraph;

public class DSMonotoneFramework implements IMonotoneFramework {
	private FlowGraph flowgraph;

	public DSMonotoneFramework(FlowGraph flowgraph) {
		this.flowgraph = flowgraph;
	}

	@Override
	public ILaticeValue getButtom() {
		return new DSLaticeValue();
	}

	@Override
	public List<IConstraint> getConstrains() {
		// TODO Auto-generated method stub
		return null;
	}
}
