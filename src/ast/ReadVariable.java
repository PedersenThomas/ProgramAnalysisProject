package ast;

public class ReadVariable extends Statement {
	String identifier;
	
	public ReadVariable(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return "read " + identifier;
	}
}
