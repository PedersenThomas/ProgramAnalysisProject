package ast;

import org.antlr.runtime.Token;

public class ReadArray extends Statement {
	private Token token;
	String array;
	ArithmeticExpression index;
	
	public ReadArray(String array, ArithmeticExpression index, Token token) {
		this.array = array;
		this.index = index;
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "read " + array + "[" + index + "]";
	}
}
