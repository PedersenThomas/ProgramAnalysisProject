package ast;

public class RelationalOperation extends BooleanExpression {
	ArithmeticExpression left;
	RelationalOperator Operator;
	ArithmeticExpression right;
	
	public RelationalOperation(ArithmeticExpression left, RelationalOperator Operator, ArithmeticExpression right){
		this.left = left;
		this.Operator = Operator;
		this.right = right;
	}
}
