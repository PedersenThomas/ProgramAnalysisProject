package ast;

public class ArithmeticArray extends ArithmeticExpression {
	String array;

	public String getArray() {
		return array;
	}

	public ArithmeticExpression getIndex() {
		return index;
	}

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
