package ast;

public class BooleanOperation extends BooleanExpression {
	BooleanExpression left;
	BooleanOperator operator;
	BooleanExpression right;
	
	public BooleanOperation(BooleanExpression left, BooleanOperator operator, BooleanExpression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + left + " " + operator + " " + right;
	}
}
