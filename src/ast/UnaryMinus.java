package ast;

public class UnaryMinus extends ArithmeticExpression {
	ArithmeticExpression expression;

	public ArithmeticExpression getExpression() {
		return expression;
	}

	public UnaryMinus(ArithmeticExpression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "-" + expression;
	}
}
