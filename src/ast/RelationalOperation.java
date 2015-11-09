package ast;

import org.antlr.runtime.Token;

public class RelationalOperation extends BooleanExpression {
	private Token token;
	ArithmeticExpression left;
	RelationalOperator operator;
	ArithmeticExpression right;
	
	public RelationalOperation(ArithmeticExpression left, RelationalOperator operator, ArithmeticExpression right, Token token){
		this.left = left;
		this.operator = operator;
		this.right = right;
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "" + left + " " + operator + " " + right;
	}
}
