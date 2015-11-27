package ast;

import java.util.List;
import org.antlr.runtime.Token;

public class WhileStatement extends Statement {
	private Token token;
	BooleanExpression condition;
	List<Statement> body;
	
	public WhileStatement(BooleanExpression condition, List<Statement> body, Token token) {
		this.condition = condition;
		this.body = body;
		this.token = token;
	}

	public BooleanExpression getCondition() {
		return condition;
	}
	
	public List<Statement> getBody() {
		return body;
	}
	
	public Token getToken() {
		return this.token;
	}
	
	@Override
	public String toString() {
		return "while " + condition + " do " + body + " od";
	}
}
