package ast;

import org.antlr.runtime.Token;

public class ArrayAssignment extends Statement {
	private Token token;
	String array;
	ArithmeticExpression index;
	ArithmeticExpression value;
	
	public ArrayAssignment(String array, ArithmeticExpression index, ArithmeticExpression value, Token token) {
		this.array = array;
		this.index = index;
		this.value = value;
		this.token = token;
	}

	public ArithmeticExpression getIndex() {
		return index;
	}

	public ArithmeticExpression getValue() {
		return value;
	}

	public String getArrayName() {
		return this.array;
	}
	
	@Override
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return array + "[" + index + "] := " + value;
	}
}
