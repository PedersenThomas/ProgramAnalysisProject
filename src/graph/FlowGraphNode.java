package graph;

public class FlowGraphNode {
	int label1;
	int label2;
	
	public FlowGraphNode(int label1, int label2) {
		this.label1 = label1;
		this.label2 = label2;
	}
	
	@Override
	public String toString() {
		return "(" + label1 + ", " + label2 + ")";
	}
}
