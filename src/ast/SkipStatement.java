package ast;

import org.antlr.runtime.Token;

public class SkipStatement extends Statement {
	private Token token;
	
	public SkipStatement(Token token) {
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}
	public String toString() {
		return "skip";
	}
}
