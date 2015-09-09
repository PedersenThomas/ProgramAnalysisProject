package ast;

public class NotBooleanExpression extends BooleanExpression {
	BooleanExpression expression;
	
	public NotBooleanExpression(BooleanExpression expression) {
		this.expression = expression;
	}
}
