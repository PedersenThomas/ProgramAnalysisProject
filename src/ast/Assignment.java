package ast;

public class Assignment extends Statement {
	Identifier left;
	ArithmeticExpression right;
	
	public Assignment(Identifier left, ArithmeticExpression right) {
		this.left = left;
		this.right = right;
	}
}
