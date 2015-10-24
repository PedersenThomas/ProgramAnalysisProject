package ast;

import org.antlr.runtime.Token;

public class ReadVariable extends Statement {
	private Token token;
	String identifier;
	
	public ReadVariable(String identifier, Token token) {
		this.identifier = identifier;
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "read " + identifier;
	}
}
