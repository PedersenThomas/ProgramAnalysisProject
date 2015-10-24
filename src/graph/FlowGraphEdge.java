package graph;

public class FlowGraphEdge {
	private int label1;
	private int label2;

	public FlowGraphEdge(int label1, int label2) {
		this.label1 = label1;
		this.label2 = label2;
	}

	public int getLabel1() {
		return label1;
	}

	public int getLabel2() {
		return label2;
	}

	@Override
	public String toString() {
		return "(" + label1 + ", " + label2 + ")";
	}
}
