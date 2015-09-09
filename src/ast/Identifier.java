package ast;

public class Identifier extends ArithmeticExpression {
	String name;
	
	public Identifier(String name) {
		this.name = name;
	}
}
