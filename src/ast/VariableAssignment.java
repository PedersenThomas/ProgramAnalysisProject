package ast;

public class VariableAssignment extends Statement {
	String left;
	ArithmeticExpression right;
	
	public VariableAssignment(String left, ArithmeticExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return left + " := " + right;
	}
}
