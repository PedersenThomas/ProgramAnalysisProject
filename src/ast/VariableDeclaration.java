package ast;

public class VariableDeclaration extends Declaration {
	Identifier name;
	
	public VariableDeclaration(Identifier name) {
		this.name = name;
	}
}
