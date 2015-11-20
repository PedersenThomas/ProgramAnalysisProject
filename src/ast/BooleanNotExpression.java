package ast;

import org.antlr.runtime.Token;

public class BooleanNotExpression extends BooleanExpression {
	private Token token;
	BooleanExpression expression;
	
	public BooleanNotExpression(BooleanExpression expression, Token token) {
		this.expression = expression;
		this.token = token;
	}

    public BooleanExpression getExpression() {
        return expression;
    }

    public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "!" + expression;
	}
}
