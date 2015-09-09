package ast;

public class WriteStatement extends Statement {
	Identifier identifier;
	
	public WriteStatement(Identifier identifier) {
		this.identifier = identifier;
	}
}
