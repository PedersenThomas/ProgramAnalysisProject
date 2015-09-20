package ast;

public class ArrayDeclaration extends Declaration {
	String array;
	int size;
	
	public ArrayDeclaration(String array, int size) {
		this.array = array;
		this.size = size;
	}
	
	public String getArrayName() {
		return array;
	}

	@Override
	public String toString() {
		return "int " + array + "[" + size + "]";
	}
}
