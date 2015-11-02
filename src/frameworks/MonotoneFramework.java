package frameworks;

import graph.FlowGraph;

public class MonotoneFramework {
	private FlowGraph flowgraph;
	
	public MonotoneFramework(FlowGraph flowgraph) {
		this.flowgraph = flowgraph;
	}
	
	public void SignDetection() {
		if (flowgraph != null) {
			System.out.println(flowgraph);
		}
	}
}
