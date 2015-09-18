package ast;

import java.util.List;

public class Program {
	Declaration declaration;
	List<Statement> statement;
	
	public Program(Declaration declaration, List<Statement> statement) {
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
