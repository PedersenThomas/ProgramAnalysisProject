package ast;

public class Assignment extends Statement {
	String left;
	ArithmeticExpression right;
	
	public Assignment(String left, ArithmeticExpression right) {
		this.left = left;
		this.right = right;
	}
}
