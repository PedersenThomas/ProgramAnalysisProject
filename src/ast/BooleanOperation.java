package ast;

import org.antlr.runtime.Token;

public class BooleanOperation extends BooleanExpression {
	private Token token;
	BooleanExpression left;
	BooleanOperator operator;
	BooleanExpression right;
	
	public BooleanOperation(BooleanExpression left, BooleanOperator operator, BooleanExpression right, Token token) {
		this.left = left;
		this.operator = operator;
		this.right = right;
		this.token = token;
	}

	public BooleanExpression getLeft() {
		return left;
	}

	public BooleanOperator getOperator() {
		return operator;
	}

	public BooleanExpression getRight() {
		return right;
	}

	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "" + left + " " + operator + " " + right;
	}
}
