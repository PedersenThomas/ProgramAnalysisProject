package ast;

import java.util.List;
import org.antlr.runtime.Token;

public class IfStatement extends Statement {
	private Token token;
	BooleanExpression condition;
	List<Statement> trueBody;
	List<Statement> falseBody;
	
	public IfStatement(BooleanExpression condition, List<Statement> trueBody, List<Statement> falseBody, Token token) {
		this.condition = condition;
		this.trueBody = trueBody;
		this.falseBody = falseBody;
		this.token = token;
	}
	
	public BooleanExpression getCondition() {
		return condition;
	}
	
	public List<Statement> getTrueBody() {
		return trueBody;
	}
	
	public List<Statement> getFalseBody() {
		return falseBody;
	}
	
	public Token getToken() {
		return this.token;
	}
	
	public String toString() {
		return "if " + condition + " then\n" + trueBody + "else\n" + falseBody + "fi";
	}
}
