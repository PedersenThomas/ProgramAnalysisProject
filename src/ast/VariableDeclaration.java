package ast;

public class VariableDeclaration extends Declaration {
	String name;
	
	public VariableDeclaration(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "int " + name;
	}
}
