package ast;

public class StatementSequence extends Statement {
	Statement s1;
	Statement s2;
	
	public StatementSequence(Statement s1, Statement s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
}
