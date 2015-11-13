package frameworks.reachingDefinitions;

public class AssignmentTableEntry {
	private String variable;
	private int label;
	
	public AssignmentTableEntry(String variable, int label) {
		this.variable = variable;
		this.label = label;
	}

	public String getVariable() {
		return variable;
	}

	public int getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		String lbl = label < 0 ? "?" : Integer.toString(label);
		return variable + " " + lbl;
	}
}
