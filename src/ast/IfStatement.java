package ast;

public class IfStatement extends Statement {
	BooleanExpression condition;
	Statement trueBody;
	Statement falseBody;
	
	public IfStatement(BooleanExpression condition, Statement trueBody, Statement falseBody) {
		this.condition = condition;
		this.trueBody = trueBody;
		this.falseBody = falseBody;
	}
}
