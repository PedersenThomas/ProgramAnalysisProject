package ast;

import org.antlr.runtime.Token;

public class WriteStatement extends Statement {
	private Token token;
	ArithmeticExpression expression;
	
	public WriteStatement(ArithmeticExpression expression, Token token) {
		this.expression = expression;
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "write " + expression;
	}
}
