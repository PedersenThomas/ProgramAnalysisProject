package ast;

public enum RelationalOperator {
	LessThan,
	GreaterThan,
	LessThanOrEqual,
	GreaterThanOrEqual,
	Equal,
	NotEqual;

	@Override
	public String toString() {
		switch (this.name()) {
			case "LessThan":
				return "<";
			case "GreaterThan":
				return ">";
			case "LessThanOrEqual":
				return "<=";
			case "GreaterThanOrEqual":
				return ">=";
			case "Equal":
				return "=";
			case "NotEqual":
				return "!=";
			default:
				throw new IllegalArgumentException("Unknown relational operator.");
		}
	}
}
