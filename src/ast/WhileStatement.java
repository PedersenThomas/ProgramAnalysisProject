package ast;

import java.util.List;

public class WhileStatement extends Statement {
	BooleanExpression condition;
	List<Statement> body;
	
	public WhileStatement(BooleanExpression condition, List<Statement> body) {
		this.condition = condition;
		this.body = body;
	}

	@Override
	public String toString() {
		return "While " + condition + " do\n" + body;
	}
}
