package ast;

import org.antlr.runtime.Token;

public class VariableAssignment extends Statement {

	private Token token;
	String left;
	ArithmeticExpression right;
	
	public VariableAssignment(String left, ArithmeticExpression right, Token token) {
		this.left = left;
		this.right = right;
		this.token = token;
	}

    public String getLeft() {
        return left;
    }

    public ArithmeticExpression getRight() {
        return right;
    }

    public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return left + " := " + right;
	}
}
