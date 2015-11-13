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
	private HashMap<Integer, ILabelable> labelMapping = new HashMap<Integer, ILabelable>();

	private ArrayList<FlowGraphEdge> flowEdges = new ArrayList<FlowGraphEdge>();
	private ArrayList<String> freeVariables = new ArrayList<String>();

	public HashMap<Integer, ILabelable> getLabelMapping() {
		return labelMapping;
	}

	public ArrayList<FlowGraphEdge> getFlowEdges() {
		return flowEdges;
	}

	public ArrayList<String> getFreeVariables() {
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
		List<Integer> result = new ArrayList<Integer>();

		for (FlowGraphEdge edge : getFlowEdges()) {
			if (edge.getLabel1() == label) {
				result.add(edge.getLabel2());
			}
		}

		return result;
	}
	
	public List<Integer> getNodeInNodes(int label) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (FlowGraphEdge edge : getFlowEdges()) {
			if (edge.getLabel2() == label) {
				result.add(edge.getLabel1());
			}
		}
		
		return result;
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
		flowEdges.add(new FlowGraphEdge(label1, label2));
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
			this.freeVariables.add(((VariableDeclaration) declaration).getName());

		} else if (declaration instanceof ArrayDeclaration) {
			this.freeVariables.add(((ArrayDeclaration) declaration).getName());
		}
	}
}
