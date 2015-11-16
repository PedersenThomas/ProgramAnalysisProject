package frameworks.reachingDefinitions;

import graph.VariableType;

public class AssignmentTableEntry {
	private String variable;
	private VariableType type;
	private int label;
	
	public AssignmentTableEntry(String variable, VariableType type, int label) {
		this.variable = variable;
		this.type = type;
		this.label = label;
	}

	public String getVariable() {
		return this.variable;
	}

	public int getLabel() {
		return this.label;
	}
	
	public VariableType getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		String lbl = label < 0 ? "?" : Integer.toString(label);
		return variable + " " + lbl;
	}
}
