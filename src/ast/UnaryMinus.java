package ast;

public class UnaryMinus extends ArithmeticExpression {
	Identifier identifier;
	
	public UnaryMinus(Identifier identifier) {
		this.identifier = identifier;
	}
}
