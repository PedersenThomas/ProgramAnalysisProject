package ast;

import org.antlr.runtime.Token;

public class VariableDeclaration extends Declaration {
	private Token token;
	String name;
	
	public VariableDeclaration(String name, Token token) {
		this.name = name;
		this.token = token;
	}
	
	@Override
	public Token getToken() {
		return this.token;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "int " + name;
	}
}
