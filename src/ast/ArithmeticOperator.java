package ast;

public enum ArithmeticOperator {
	Plus,
	Minus,
	Multiply,
	Divide;

	public String toString() {
		switch (this.name()) {
			case "Plus":
				return "+";
			case "Minus":
				return "-";
			case "Multiply":
				return "*";
			case "Divide":
				return "/";
			default:
				throw new IllegalArgumentException("Unknown operator.");
		}
	}

}
