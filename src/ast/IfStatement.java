package ast;

import java.util.List;

public class IfStatement extends Statement {
	BooleanExpression condition;
	List<Statement> trueBody;
	List<Statement> falseBody;
	
	public IfStatement(BooleanExpression condition, List<Statement> trueBody, List<Statement> falseBody) {
		this.condition = condition;
		this.trueBody = trueBody;
		this.falseBody = falseBody;
	}
	
	public String toString() {
		return "if " + condition + " then\n" + trueBody + "else\n" + falseBody + "fi";
	}
}
