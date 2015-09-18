package ast;

public class ArithmeticArray extends ArithmeticExpression {
	String array; 
	ArithmeticExpression index;
	
	public ArithmeticArray(String array, ArithmeticExpression index) {
		this.array = array;
		this.index = index;
	}

	@Override
	public String toString() {
		return array + "[" + index + "]";
	}
}
