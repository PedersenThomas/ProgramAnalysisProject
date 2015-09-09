package ast;

public class Program {
	Declaration declaration;
	Statement statement;
	
	public Program(Declaration declaration, Statement statement) {
		this.declaration = declaration;
		this.statement = statement;
	}
}
