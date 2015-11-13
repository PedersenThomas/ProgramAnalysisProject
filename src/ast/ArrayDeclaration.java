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
	
	public Token getToken() {
		return this.token;
	}
	
	@Override
	public String getName() {
		return array;
	}

	@Override
	public String toString() {
		return "int " + array + "[" + size + "]";
	}
}
