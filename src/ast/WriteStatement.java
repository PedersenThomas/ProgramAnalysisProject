package ast;

public class WriteStatement extends Statement {
	ArithmeticExpression expression;
	
	public WriteStatement(ArithmeticExpression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "write " + expression;
	}
}
