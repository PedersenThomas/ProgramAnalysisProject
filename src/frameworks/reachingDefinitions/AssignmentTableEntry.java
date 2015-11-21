package frameworks.reachingDefinitions;

import graph.Variable;
import graph.VariableType;

public class AssignmentTableEntry {
	private Variable variable;
	private int label;
	
	public AssignmentTableEntry(String name, VariableType type, int label) {
		this.variable = new Variable(name, type);
		this.label = label;
	}

	public Variable getVariable() {
		return variable;
	}

	public String getName() {
		return this.variable.getName();
	}

	public int getLabel() {
		return this.label;
	}
	
	public VariableType getType() {
		return this.variable.getType();
	}
	
	@Override
	public String toString() {
		String lbl = label < 0 ? "?" : Integer.toString(label);
		return "(" + getName() + ", " + lbl + ")";
	}
}
