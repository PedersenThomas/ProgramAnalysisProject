package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ast.ArrayDeclaration;
import ast.Declaration;
import ast.ILabelable;
import ast.IfStatement;
import ast.Program;
import ast.SkipStatement;
import ast.Statement;
import ast.VariableDeclaration;
import ast.WhileStatement;

public class FlowGraph {
	private static int labelcount = 1;
	Program ast;
//	HashMap<ILabelable, Integer> Labels = new HashMap<ILabelable, Integer>();
	HashMap<Integer, ILabelable> labelToProgramPoint = new HashMap<Integer, ILabelable>();
	
	ArrayList<FlowGraphEdge> flowNodes = new ArrayList<FlowGraphEdge>();
	ArrayList<String> freeVariables = new ArrayList<String>();
	
	public HashMap<Integer, ILabelable> getLabelToProgramPoint() {
		return labelToProgramPoint;
	}

	public ArrayList<FlowGraphEdge> getFlowNodes() {
		return flowNodes;
	}

	public ArrayList<String> getFreeVariables() {
		return freeVariables;
	}
	
	public FlowGraph(Program program) {
		this.ast = program;

		Integer lastLabel = null;
		// Declarations
		if (!program.declarations.isEmpty()) {
			lastLabel = labelProgramPoint(program.declarations.get(0));
			AddFreeVariable(program.declarations.get(0));
			
			for (int i = 1; i < program.declarations.size(); i++) {
				Declaration declaration = program.declarations.get(i);
				int label = labelProgramPoint(declaration);
				AddFlowNode(lastLabel, label);
				lastLabel = label;
				
				// Store the name of the variable.
				AddFreeVariable(declaration);
			}
		}

		// To make sure there are Isolated Entry
		if(program.declarations.isEmpty() && program.statements.get(0) instanceof WhileStatement) {
			program.statements.add(0, new SkipStatement());
		}
		
		// To make sure there are Isolated Exit
		if(program.statements.get(program.statements.size() -1) instanceof IfStatement) {
			program.statements.add(new SkipStatement());
		}
		
		List<Integer> previous = new ArrayList<Integer>();
		if (lastLabel != null) {
			previous.add(lastLabel);
		}
		// Statements
		convertStatement(previous, program.statements);
	}

	private List<Integer> convertStatement(List<Integer> previous, Statement statement) {
		// Dispatching the statements
		if (statement instanceof WhileStatement) {
			return convertStatement(previous, (WhileStatement) statement);

		} else if (statement instanceof IfStatement) {
			return convertStatement(previous, (IfStatement) statement);
		}

		// Base case where there are no special control flow
		int label = labelProgramPoint(statement);
		AddAllFlowNode(previous, label);
		List<Integer> lastLabels = new ArrayList<Integer>();
		lastLabels.add(label);
		return lastLabels;
	}

	private List<Integer> convertStatement(List<Integer> previous, List<Statement> statements) {
		List<Integer> prev = new ArrayList<Integer>();
		if (!statements.isEmpty()) {
			prev = previous;
		}
		for (int i = 0; i < statements.size(); i++) {
			Statement statement = statements.get(i);
			prev = convertStatement(prev, statement);
		}
		return prev;
	}

	private List<Integer> convertStatement(List<Integer> previous, WhileStatement statement) {
		int conditionLabel = labelProgramPoint(statement.getCondition());
		AddAllFlowNode(previous, conditionLabel);

		List<Integer> conditionPrevious = new ArrayList<Integer>();
		conditionPrevious.add(conditionLabel);
		List<Integer> prev = convertStatement(conditionPrevious, statement.getBody());

		// Loopback from while body to condition
		AddAllFlowNode(prev, conditionLabel);

		return conditionPrevious;
	}

	private List<Integer> convertStatement(List<Integer> previous, IfStatement statement) {
		int conditionLabel = labelProgramPoint(statement.getCondition());
		AddAllFlowNode(previous, conditionLabel);

		List<Integer> conditionPrevious = new ArrayList<Integer>();
		conditionPrevious.add(conditionLabel);
		List<Integer> trueLabels = convertStatement(conditionPrevious, statement.getTrueBody());
		List<Integer> falseLabels = convertStatement(conditionPrevious, statement.getFalseBody());

		List<Integer> lastLabels = new ArrayList<Integer>();
		lastLabels.addAll(trueLabels);
		lastLabels.addAll(falseLabels);
		return lastLabels;
	}

	private void AddAllFlowNode(List<Integer> labels, Integer label) {
		for (Integer l : labels) {
			AddFlowNode(l, label);
		}
	}

	private void AddFlowNode(Integer label1, Integer label2) {
		flowNodes.add(new FlowGraphEdge(label1, label2));
	}

	/**
	 * Utility function for assigning a program point a label, and remembering
	 * it.
	 * 
	 * @param point
	 * @return
	 */
	private int labelProgramPoint(ILabelable point) {
		int label = labelcount++;
//		Labels.put(point, label);
		labelToProgramPoint.put(label, point);
		return label;
	}

	private void AddFreeVariable(Declaration declaration) {
		if (declaration instanceof VariableDeclaration) {
			this.freeVariables.add(((VariableDeclaration) declaration).getName());

		} else if (declaration instanceof ArrayDeclaration) {
			this.freeVariables.add(((ArrayDeclaration) declaration).getArrayName());
		}
	}
}
