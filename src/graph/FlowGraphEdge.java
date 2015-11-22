package graph;

public class FlowGraphEdge {
	private int label1;
	private int label2;
	private OutType type;

	public FlowGraphEdge(int label1, int label2, OutType type) {
		this.label1 = label1;
		this.label2 = label2;
		this.type = type;
	}
	
	public OutType getType() {
		return type;
	}

	public int getLabel1() {
		return label1;
	}

	public int getLabel2() {
		return label2;
	}

	@Override
	public String toString() {
		return "(" + label1 + ", " + label2 + "){Type:" + type + "}";
	}
}
