package ast;

public class Identifier extends ArithmeticExpression {
	private String name;

	public String getName() {
		return name;
	}
	
	public Identifier(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
