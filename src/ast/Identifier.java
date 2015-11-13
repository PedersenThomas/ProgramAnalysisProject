package ast;

public class Identifier extends ArithmeticExpression {

	public String getName() {
		return name;
	}

	private String name;
	
	public Identifier(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
