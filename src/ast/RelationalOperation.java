package ast;

public class RelationalOperation extends BooleanExpression {
	ArithmeticExpression left;
	RelationalOperator operator;
	ArithmeticExpression right;
	
	public RelationalOperation(ArithmeticExpression left, RelationalOperator operator, ArithmeticExpression right){
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + left + " " + operator + " " + right;
	}
}
