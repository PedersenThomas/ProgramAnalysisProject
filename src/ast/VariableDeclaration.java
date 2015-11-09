package ast;

import org.antlr.runtime.Token;

public class VariableDeclaration extends Declaration {
	private Token token;
	String name;
	
	public VariableDeclaration(String name, Token token) {
		this.name = name;
		this.token = token;
	}
	
	public String getName() {
		return name;
	}
	
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "int " + name;
	}
}
