package ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import thelang.TheLangParser;

public class AstBuilder {
	public static Program build(CommonTree tree) {
		if (tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}
		return parseProgram(tree);
	}

	private static Program parseProgram(CommonTree tree) {
		if (tree.getType() != TheLangParser.THEPROGRAM) {
			throw new IllegalArgumentException("The passed CommonTree was not of type \"THEPROGRAM\".");
		}

		ArrayList<CommonTree> chrildren = getChildren(tree);

		List<Declaration> declarations = parseDeclarationBlock(chrildren.get(0));
		List<Statement> statements = parseStatmentBlock(chrildren.get(1));

		return new Program(declarations, statements);
	}

	private static List<Declaration> parseDeclarationBlock(CommonTree tree) {
		if (tree.getType() != TheLangParser.BLOCK_DECLARATION) {
			throw new IllegalArgumentException("The passed CommonTree was not of type \"BLOCK_DECLARATION\".");
		}
		ArrayList<Declaration> declarations = new ArrayList<Declaration>();

		ArrayList<CommonTree> chrildren = getChildren(tree);
		if (chrildren != null) {
			for (CommonTree commonTree : chrildren) {
				declarations.add(parseDeclaration(commonTree));
			}
		}

		return declarations;
	}

	private static Declaration parseDeclaration(CommonTree tree) {
		if (tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}

		ArrayList<CommonTree> children = getChildren(tree);
		switch (tree.getType()) {
		case TheLangParser.DECLARE_VARIABLE:
			return new VariableDeclaration( nameFromVariable(children.get(0)), tree.token );
			
		case TheLangParser.DECLARE_ARRAY:
			return new ArrayDeclaration( nameFromVariable(children.get(0)), intFromConstant(children.get(1)), tree.token );
			
		default:
			throw new IllegalArgumentException("The passed CommonTree was of unexpected type: " + tree.getType());
		}
	}
	
	private static List<Statement> parseStatmentBlock(CommonTree tree) {
		if (tree.getType() != TheLangParser.BLOCK_STATEMENT) {
			throw new IllegalArgumentException("The passed CommonTree was not of type \"BLOCK_DECLARATION\".");
		}
		ArrayList<Statement> statements = new ArrayList<Statement>();
		
		ArrayList<CommonTree> chrildren = getChildren(tree);
		if (chrildren != null) {
			for (CommonTree commonTree : chrildren) {
				statements.add(parseStatement(commonTree));
			}
		}
		
		return statements;
	}
	
	private static Statement parseStatement(CommonTree tree) {
		if (tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}

		ArrayList<CommonTree> children = getChildren(tree);
		switch (tree.getType()) {
		case TheLangParser.ASSIGNMENT_VARIABLE:
			return new VariableAssignment( nameFromVariable(children.get(0)), parseArithmeticExpression(children.get(1)), tree.token );
		case TheLangParser.ASSIGNMENT_ARRAY:
			return new ArrayAssignment(
					nameFromVariable(children.get(0)), 
					parseArithmeticExpression(children.get(1)), 
					parseArithmeticExpression(children.get(2)), 
					tree.token
				);
		case TheLangParser.SKIP_STATEMENT:
			return new SkipStatement(tree.token);
		case TheLangParser.READ_VARIABLE:
			return new ReadVariable( nameFromVariable(children.get(0)), tree.token );
		case TheLangParser.READ_ARRAY:
			return new ReadArray( nameFromVariable(children.get(0)), parseArithmeticExpression(children.get(1)), tree.token );
		case TheLangParser.WRITE_EXPRESSION:
			return new WriteStatement( parseArithmeticExpression(children.get(0)), tree.token );
		case TheLangParser.IF_STATEMENT:
			return new IfStatement(
					parseBooleanExpression(children.get(0)), 
					parseStatmentBlock(children.get(1)), 
					parseStatmentBlock(children.get(2)), 
					tree.token
				);
		case TheLangParser.WHILE_STATEMENT:
			return new WhileStatement( parseBooleanExpression(children.get(0)), parseStatmentBlock(children.get(1)), tree.token );
			
		default:
			throw new IllegalArgumentException("The passed CommonTree was of unexpected type: " + tree.getType());
		}
	}
	
	private static ArithmeticExpression parseArithmeticExpression(CommonTree tree) {
		if(tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}
		ArrayList<CommonTree> children = getChildren(tree);
		
		switch(tree.getType()) {
		case TheLangParser.PLUS:
			return new ArithmeticOperation(
					parseArithmeticExpression(children.get(0)), 
					ArithmeticOperator.Plus, 
					parseArithmeticExpression(children.get(1)));
			
		case TheLangParser.MINUS:
			return new ArithmeticOperation(
					parseArithmeticExpression(children.get(0)), 
					ArithmeticOperator.Minus, 
					parseArithmeticExpression(children.get(1)));
			
		case TheLangParser.DIV:
			return new ArithmeticOperation(
					parseArithmeticExpression(children.get(0)), 
					ArithmeticOperator.Divide, 
					parseArithmeticExpression(children.get(1)));

		case TheLangParser.MUL:
			return new ArithmeticOperation(
					parseArithmeticExpression(children.get(0)), 
					ArithmeticOperator.Multiply, 
					parseArithmeticExpression(children.get(1)));
		
		case TheLangParser.UNARY_MINUS:
			return new UnaryMinus(parseArithmeticExpression(children.get(0)));
		
		case TheLangParser.VARIABLE:
			return new Identifier(children.get(0).getText());
		
		case TheLangParser.ARRAY_ACCESS:
			return new ArithmeticArray(
					nameFromVariable(children.get(0)),
					parseArithmeticExpression(children.get(1)));
		
		case TheLangParser.CONSTANT:
			return new Constant(intFromConstant(tree));
			
		default:
			throw new IllegalArgumentException("The passed CommonTree was of unexpected type: " + tree.getType());
		}
	}
	
	private static BooleanExpression parseBooleanExpression(CommonTree tree) {
		if(tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}
		ArrayList<CommonTree> children = getChildren(tree);
		
		switch (tree.getType()) {
		case TheLangParser.OR:
			return new BooleanOperation(
					parseBooleanExpression(children.get(0)), 
					BooleanOperator.Or, 
					parseBooleanExpression(children.get(1)), 
					tree.token
				);
			
		case TheLangParser.AND:
			return new BooleanOperation(
					parseBooleanExpression(children.get(0)), 
					BooleanOperator.And, 
					parseBooleanExpression(children.get(1)), 
					tree.token
				);

		case TheLangParser.NOT_EXPRESSION:
			return new BooleanNotExpression( parseBooleanExpression(children.get(0)), tree.token );
		
		case TheLangParser.BOOL_CONSTANT:
			return new BooleanConstant( booleanFromBooleanConstant(tree), tree.token );
		
		case TheLangParser.GT:
			return new RelationalOperation(
					parseArithmeticExpression(children.get(0)), 
					RelationalOperator.GreaterThan, 
					parseArithmeticExpression(children.get(1)), 
					tree.token
				);
			
		case TheLangParser.GE:
			return new RelationalOperation(
					parseArithmeticExpression(children.get(0)), 
					RelationalOperator.GreaterThanOrEqual, 
					parseArithmeticExpression(children.get(1)), 
					tree.token
				);
			
		case TheLangParser.LT:
			return new RelationalOperation(
					parseArithmeticExpression(children.get(0)), 
					RelationalOperator.LessThan, 
					parseArithmeticExpression(children.get(1)), 
					tree.token
				);
			
		case TheLangParser.LE:
			return new RelationalOperation(
					parseArithmeticExpression(children.get(0)), 
					RelationalOperator.LessThanOrEqual, 
					parseArithmeticExpression(children.get(1)), 
					tree.token
				);
			
		case TheLangParser.EQ:
			return new RelationalOperation(
					parseArithmeticExpression(children.get(0)), 
					RelationalOperator.Equal, 
					parseArithmeticExpression(children.get(1)), 
					tree.token
				);
			
		case TheLangParser.NEQ:
			return new RelationalOperation(
					parseArithmeticExpression(children.get(0)), 
					RelationalOperator.NotEqual, 
					parseArithmeticExpression(children.get(1)), 
					tree.token
				);		
			
		default:
			throw new IllegalArgumentException("The passed CommonTree was of unexpected type: " + tree.getType());
		}
	}
	
	private static ArrayList<CommonTree> getChildren(CommonTree tree) {
		@SuppressWarnings("unchecked")
		ArrayList<CommonTree> children = (ArrayList<CommonTree>)tree.getChildren();
		return children;
	}
	
	/**
	 * Utility function, for extracting the name of a variable as a string
	 * @param tree CommonTree node of type VARIABLE
	 * @return
	 */
	private static String nameFromVariable(CommonTree tree) {
		if(tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}
		if(tree.getType() != TheLangParser.VARIABLE) {
			throw new IllegalArgumentException("The passed CommonTree was not of type \"VARIABLE\". It was: " + tree.getType());
		}
		ArrayList<CommonTree> children = getChildren(tree);
		
		return children.get(0).getText();
	}
	
	/**
	 * Utility function, for extracting the number of a constant as a int.
	 * @param tree CommonTree node of type CONSTANT
	 * @return
	 */
	private static int intFromConstant(CommonTree tree) {
		if(tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}
		if(tree.getType() != TheLangParser.CONSTANT) {
			throw new IllegalArgumentException("The passed CommonTree was not of type \"CONSTANT\".");
		}
		ArrayList<CommonTree> children = getChildren(tree);
		
		return Integer.parseInt(children.get(0).getText());
	}
	
	/**
	 * Utility function, for extract the boolean value of a boolean constant as a boolean.
	 * @param tree CommonTree node of type BOOL_CONSTANT
	 * @return
	 */
	private static boolean booleanFromBooleanConstant(CommonTree tree) {
		if(tree == null) {
			throw new IllegalArgumentException("The passed CommonTree was null.");
		}
		if(tree.getType() != TheLangParser.BOOL_CONSTANT) {
			throw new IllegalArgumentException("The passed CommonTree was not of type \"BOOL_CONSTANT\".");
		}
		ArrayList<CommonTree> children = getChildren(tree);
		
		return Boolean.parseBoolean(children.get(0).getText());
	}
}
