package ast;

public class ReadArray extends Statement {
	String array;
	ArithmeticExpression index;
	
	public ReadArray(String array, ArithmeticExpression index) {
		this.array = array;
		this.index = index;
	}

	@Override
	public String toString() {
		return "read " + array + "[" + index + "]";
	}
}
