package ast;

public class ArrayAssignment extends Statement {
	Identifier array;
	ArithmeticExpression index;
	ArithmeticExpression value;
	
	public ArrayAssignment(Identifier array, ArithmeticExpression index, ArithmeticExpression value) {
		this.array = array;
		this.index = index;
		this.value = value;
	}
}
