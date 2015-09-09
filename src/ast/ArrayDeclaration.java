package ast;

public class ArrayDeclaration extends Declaration {
	Identifier array;
	Constant size;
	
	public ArrayDeclaration(Identifier array, Constant size) {
		this.array = array;
		this.size = size;
	}
}
