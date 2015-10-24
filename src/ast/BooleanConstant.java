package ast;

import org.antlr.runtime.Token;

public class BooleanConstant extends BooleanExpression {
	private Token token;
	boolean value;
	
	public BooleanConstant(boolean value, Token token) {
		this.value = value;
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}
	
	@Override
	public String toString() {
		return ""+value;
	}
}
