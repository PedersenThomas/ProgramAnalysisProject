package ast;

public class ArithmeticOperation extends ArithmeticExpression {
	ArithmeticExpression left;
	ArithmeticOperator Operator;
	ArithmeticExpression right;

	public ArithmeticExpression getLeft() {
		return left;
	}

	public ArithmeticExpression getRight() {
		return right;
	}

	public ArithmeticOperator getOperator() {

		return Operator;
	}

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
