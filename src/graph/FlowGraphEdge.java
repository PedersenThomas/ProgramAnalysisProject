package graph;

public class FlowGraphEdge {
	int label1;
	int label2;
	
	public FlowGraphEdge(int label1, int label2) {
		this.label1 = label1;
		this.label2 = label2;
	}
	
	@Override
	public String toString() {
		return "(" + label1 + ", " + label2 + ")";
	}
}
