package ast;

public class ArithmeticOperation {
	ArithmeticExpression left;
	ArithmeticOperator Operator;
	ArithmeticExpression right;
	
	public ArithmeticOperation(ArithmeticExpression left, ArithmeticOperator Operator, ArithmeticExpression right){
		this.left = left;
		this.Operator = Operator;
		this.right = right;
	}
}
