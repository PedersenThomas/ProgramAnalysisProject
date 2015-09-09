package ast;

public class ReadStatement extends Statement {
	Identifier identifier;
	
	public ReadStatement(Identifier identifier) {
		this.identifier = identifier;
	}
}
