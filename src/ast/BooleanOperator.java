package ast;

public enum BooleanOperator {
	And,
	Or;

	@Override
	public String toString() {
		switch (this.name()) {
			case "And":
				return "&";
			case "Or":
				return "|";
			default:
				throw new IllegalArgumentException("Unknown boolean operator.");
		}
	}
}
