package ast;

public class ReadArrayStatement extends Statement {
	Identifier array;
	ArithmeticExpression index;
	
	public ReadArrayStatement(Identifier array, ArithmeticExpression index) {
		this.array = array;
		this.index = index;
	}
}
