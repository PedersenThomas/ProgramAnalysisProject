package ast;

public class WhileStatement extends Statement {
	BooleanExpression condition;
	Statement body;
	
	public WhileStatement(BooleanExpression condition, Statement body) {
		this.condition = condition;
		this.body = body;
	}
}
