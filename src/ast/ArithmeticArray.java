package ast;

public class ArithmeticArray extends ArithmeticExpression {
	Identifier array; 
	ArithmeticExpression index;
	
	public ArithmeticArray(Identifier array, ArithmeticExpression index) {
		this.array = array;
		this.index = index;
	}
}
