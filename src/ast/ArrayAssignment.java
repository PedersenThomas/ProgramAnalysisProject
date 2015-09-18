package ast;

public class ArrayAssignment extends Statement {
	String array;
	ArithmeticExpression index;
	ArithmeticExpression value;
	
	public ArrayAssignment(String array, ArithmeticExpression index, ArithmeticExpression value) {
		this.array = array;
		this.index = index;
		this.value = value;
	}

	@Override
	public String toString() {
		return array + "[" + index + "] := " + value;
	}
}
