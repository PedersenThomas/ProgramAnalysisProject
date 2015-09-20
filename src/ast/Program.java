package ast;

import java.util.List;

public class Program {
	public List<Declaration> declarations;
	public List<Statement> statements;
	
	public Program(List<Declaration> declaration, List<Statement> statement) {
		this.declarations = declaration;
		this.statements = statement;
	}
	
	@Override
	public String toString() {
		String d = this.declarations != null ? this.declarations.toString() : "";
		String s = this.statements != null ? this.statements.toString() : "";
		return "PROGRAM\n-DECLARATION-\n" + d + "\n-STATEMENTS-\n" + s + "\nEND";
	}
}
