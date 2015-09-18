package ast;

public class BooleanConstant extends BooleanExpression {
	boolean value;
	
	public BooleanConstant(boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return ""+value;
	}
}
