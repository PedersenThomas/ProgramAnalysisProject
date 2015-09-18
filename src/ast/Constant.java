package ast;

public class Constant extends ArithmeticExpression {
	int number;
	
	public Constant(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "" + number;
	}
}
