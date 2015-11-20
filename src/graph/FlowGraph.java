package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static final int StartLabel = 1;
	private static int labelcount = StartLabel;
	private HashMap<Integer, ILabelable> labelMapping = new HashMap<Integer, ILabelable>();

	private Map<Integer, List<Integer>> flowForward  = new HashMap<Integer, List<Integer>>();
	private Map<Integer, List<Integer>> flowBackward = new HashMap<Integer, List<Integer>>();
	private ArrayList<Variable> freeVariables = new ArrayList<Variable>();

	public HashMap<Integer, ILabelable> getLabelMapping() {
		return labelMapping;
	}

	public ArrayList<Variable> getFreeVariables() {
		return freeVariables;
	}

	public FlowGraph(Program program) {
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
		if (program.declarations.isEmpty() && program.statements.get(0) instanceof WhileStatement) {
			program.statements.add(0, new SkipStatement(null));
		}

		// // To make sure there are Isolated Exit
		// if (program.statements.get(program.statements.size() - 1) instanceof
		// IfStatement) {
		// program.statements.add(new SkipStatement(null));
		// }

		List<Integer> previous = new ArrayList<Integer>();
		if (lastLabel != null) {
			previous.add(lastLabel);
		}

		// Statements
		convertStatements(previous, program.statements);
	}

	public List<Integer> getNodeOutNodes(int label) {
		if (flowForward.containsKey(label)) {
			return Collections.unmodifiableList(flowForward.get(label));
		} else {
			return new ArrayList<Integer>();
		}
	}
	
	public List<Integer> getNodeInNodes(int label) {
		if (flowBackward.containsKey(label)) {
			return Collections.unmodifiableList(flowBackward.get(label));
		} else {
			return new ArrayList<Integer>();
		}
	}

	private List<Integer> convertStatement(List<Integer> previous, Statement statement) {
		// Dispatching the statements
		if (statement instanceof WhileStatement) {
			return convertWhileStatement(previous, (WhileStatement) statement);

		} else if (statement instanceof IfStatement) {
			return convertIfStatement(previous, (IfStatement) statement);
		}

		// Base case where there are no special control flow
		int label = labelProgramPoint(statement);
		AddAllFlowNode(previous, label);
		List<Integer> lastLabels = new ArrayList<Integer>();
		lastLabels.add(label);
		return lastLabels;
	}

	private List<Integer> convertStatements(List<Integer> previous, List<Statement> statements) {
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

	private List<Integer> convertWhileStatement(List<Integer> previous, WhileStatement statement) {
		int conditionLabel = labelProgramPoint(statement.getCondition());
		AddAllFlowNode(previous, conditionLabel);

		List<Integer> conditionPrevious = new ArrayList<Integer>();
		conditionPrevious.add(conditionLabel);
		List<Integer> prev = convertStatements(conditionPrevious, statement.getBody());

		// Loopback from while body to condition
		AddAllFlowNode(prev, conditionLabel);

		return conditionPrevious;
	}

	private List<Integer> convertIfStatement(List<Integer> previous, IfStatement statement) {
		int conditionLabel = labelProgramPoint(statement.getCondition());
		AddAllFlowNode(previous, conditionLabel);

		List<Integer> conditionPrevious = new ArrayList<Integer>();
		conditionPrevious.add(conditionLabel);
		List<Integer> trueLabels = convertStatements(conditionPrevious, statement.getTrueBody());
		List<Integer> falseLabels = convertStatements(conditionPrevious, statement.getFalseBody());

		// Join the two ends together to one set.
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
		System.out.println("Flow: (" + label1 + ","+label2+")");
		
		if (!flowForward.containsKey(label1)) {
			flowForward.put(label1, new ArrayList<Integer>());
		}
		flowForward.get(label1).add(label2);
		
		if (!flowBackward.containsKey(label2)) {
			flowBackward.put(label2, new ArrayList<Integer>());
		}
		flowBackward.get(label2).add(label1);
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
		labelMapping.put(label, point);
		return label;
	}

	private void AddFreeVariable(Declaration declaration) {
		if (declaration instanceof VariableDeclaration) {
			this.freeVariables.add(new Variable(((VariableDeclaration) declaration).getName(), VariableType.Variable));

		} else if (declaration instanceof ArrayDeclaration) {
			this.freeVariables.add(new Variable(((ArrayDeclaration) declaration).getName(), VariableType.Array));
		}
	}
}
