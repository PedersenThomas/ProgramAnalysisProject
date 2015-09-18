package ast;

public class Program {
	Declaration declaration;
	Statement statement;
	
	public Program(Declaration declaration, Statement statement) {
		this.declaration = declaration;
		this.statement = statement;
	}
	
	@Override
	public String toString() {
		String d = this.declaration != null ? this.declaration.toString() : "";
		String s = this.statement != null ? this.statement.toString() : "";
		return "PROGRAM\n" + d + "" + s + "\nEND";
	}
}
