package graph;

public class Variable {
	private String name;
	private VariableType type;
	
	public Variable(String name, VariableType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public VariableType getType() {
		return type;
	}
	
	public boolean equals(Variable other) {
		return this.name.equals(other.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Variable) {
			return this.equals((Variable)obj);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public String toString() {
		String type;
        if (this.type.equals(VariableType.Variable)) {
            type = "var";
        } else {
            type = "arr";
        }
		return name + ":" + type;
	}
}
