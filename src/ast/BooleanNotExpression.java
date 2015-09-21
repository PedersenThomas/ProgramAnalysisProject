package ast;

public class BooleanNotExpression extends BooleanExpression {
	BooleanExpression expression;
	
	public BooleanNotExpression(BooleanExpression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "!" + expression;
	}
}
