package ast;

public class ArithmeticOperation extends ArithmeticExpression {
	ArithmeticExpression left;
	ArithmeticOperator Operator;
	ArithmeticExpression right;
	
	public ArithmeticOperation(ArithmeticExpression left, ArithmeticOperator Operator, ArithmeticExpression right){
		this.left = left;
		this.Operator = Operator;
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + left + " " + Operator + " " + right;
	}
}
