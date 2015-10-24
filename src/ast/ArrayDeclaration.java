package ast;

import org.antlr.runtime.Token;

public class ArrayDeclaration extends Declaration {
	private Token token;
	String array;
	int size;
	
	public ArrayDeclaration(String array, int size, Token token) {
		this.array = array;
		this.size = size;
		this.token = token;
	}
	
	public String getArrayName() {
		return array;
	}
	
	public Token getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return "int " + array + "[" + size + "]";
	}
}
