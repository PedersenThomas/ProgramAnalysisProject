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
	private int labelcount = StartLabel;
	private HashMap<Integer, ILabelable> labelMapping = new HashMap<Integer, ILabelable>();

	private Map<Integer, List<FlowGraphEdge>> flowForward  = new HashMap<Integer, List<FlowGraphEdge>>();
	private Map<Integer, List<FlowGraphEdge>> flowBackward = new HashMap<Integer, List<FlowGraphEdge>>();
	private ArrayList<Variable> freeVariables = new ArrayList<Variable>();

	public Map<Integer, ILabelable> getLabelMap() {
		return Collections.unmodifiableMap(labelMapping);
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
				AddFlowNode(lastLabel, label, BranchType.None);
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
		// WhileStatement) {
		// program.statements.add(new SkipStatement(null));
		// }

		List<FlowGraphBranchType> previous = new ArrayList<FlowGraphBranchType>();
		if (lastLabel != null) {
			previous.add(new FlowGraphBranchType(lastLabel, BranchType.None) );
		}

		// Statements
		convertStatements(previous, program.statements);
	}

	public List<FlowGraphEdge> getNodeOutNodes(int label) {
		if (flowForward.containsKey(label)) {
			return new ArrayList<FlowGraphEdge>(flowForward.get(label));
		} else {
			return new ArrayList<FlowGraphEdge>();
		}
	}
	
	public List<FlowGraphEdge> getNodeInNodes(int label) {
		if (flowBackward.containsKey(label)) {
			return new ArrayList<FlowGraphEdge>(flowBackward.get(label));
		} else {
			return new ArrayList<FlowGraphEdge>();
		}
	}

	private List<FlowGraphBranchType> convertStatement(List<FlowGraphBranchType> previous, Statement statement) {
		// Dispatching the statements
		if (statement instanceof WhileStatement) {
			return convertWhileStatement(previous, (WhileStatement) statement);

		} else if (statement instanceof IfStatement) {
			return convertIfStatement(previous, (IfStatement) statement);
		}

		// Base case where there are no special control flow
		int label = labelProgramPoint(statement);
		AddAllFlowNode(previous, label);
		List<FlowGraphBranchType> lastLabels = new ArrayList<FlowGraphBranchType>();
		lastLabels.add(new FlowGraphBranchType(label, BranchType.None));
		return lastLabels;
	}

	private List<FlowGraphBranchType> convertStatements(List<FlowGraphBranchType> previous, List<Statement> statements) {
		List<FlowGraphBranchType> prev = new ArrayList<FlowGraphBranchType>();
		if (!statements.isEmpty()) {
			prev = previous;
		}
		
		prev = convertStatement(prev, statements.get(0));
		
		for (int i = 1; i < statements.size(); i++) {
//			BranchType branchType = BranchType.None;
//			if(statements.get(i-1) instanceof WhileStatement) {
//				branchType = BranchType.False;
//			}
			Statement statement = statements.get(i);
			prev = convertStatement(prev, statement);
		}
		return prev;
	}

	private List<FlowGraphBranchType> convertWhileStatement(List<FlowGraphBranchType> previous, WhileStatement statement) {
		int conditionLabel = labelProgramPoint(statement);
		AddAllFlowNode(previous, conditionLabel);

		List<FlowGraphBranchType> conditionPrevious = new ArrayList<FlowGraphBranchType>();
		conditionPrevious.add(new FlowGraphBranchType(conditionLabel, BranchType.True));
		List<FlowGraphBranchType> prev = convertStatements(conditionPrevious, statement.getBody());

		// Loopback from while body to condition
		for (FlowGraphBranchType l : prev) {
//			BranchType type = BranchType.None;
//			if (labelMapping.get(l) instanceof WhileStatement) {
//				type = BranchType.False;
//			}
			AddFlowNode(l.label, conditionLabel, l.type);
		}
		
		List<FlowGraphBranchType> conditionFalsePrevious = new ArrayList<FlowGraphBranchType>();
		conditionFalsePrevious.add(new FlowGraphBranchType(conditionLabel, BranchType.False));
		return conditionFalsePrevious;
	}

	private List<FlowGraphBranchType> convertIfStatement(List<FlowGraphBranchType> previous, IfStatement statement) {
		int conditionLabel = labelProgramPoint(statement);
		AddAllFlowNode(previous, conditionLabel);

		//True branch
		List<FlowGraphBranchType> conditionTruePrevious = new ArrayList<FlowGraphBranchType>();
		conditionTruePrevious.add(new FlowGraphBranchType(conditionLabel, BranchType.True));
		List<FlowGraphBranchType> trueLabels = convertStatements(conditionTruePrevious, statement.getTrueBody());
		
		//False Branch
		List<FlowGraphBranchType> conditionFalsePrevious = new ArrayList<FlowGraphBranchType>();
		conditionFalsePrevious.add(new FlowGraphBranchType(conditionLabel, BranchType.False));
		List<FlowGraphBranchType> falseLabels = convertStatements(conditionFalsePrevious, statement.getFalseBody());

		// Join the two ends together to one set.
		List<FlowGraphBranchType> lastLabels = new ArrayList<FlowGraphBranchType>();
		lastLabels.addAll(trueLabels);
		lastLabels.addAll(falseLabels);
		return lastLabels;
	}

	private void AddAllFlowNode(List<FlowGraphBranchType> fromLabels, Integer toLabel) {
		for (FlowGraphBranchType l : fromLabels) {
			AddFlowNode(l.label, toLabel, l.type);
		}
	}

	private void AddFlowNode(Integer label1, Integer label2, BranchType type) {
		if (!flowForward.containsKey(label1)) {
			flowForward.put(label1, new ArrayList<FlowGraphEdge>());
		}
		flowForward.get(label1).add(new FlowGraphEdge(label1, label2, type));
		
		if (!flowBackward.containsKey(label2)) {
			flowBackward.put(label2, new ArrayList<FlowGraphEdge>());
		}
		flowBackward.get(label2).add(new FlowGraphEdge(label2, label1, type));
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
	
	@Override
	public String toString() {
		return  "FlowGraph{" +
				"freeVariables=" + freeVariables + "\n" +
				"          labelMapping=" + labelMapping + "\n" +
				"          flowForward=" + flowForward + "\n" +
				"		  flowBackward=" + flowBackward + "\n" +
				'}';
	}
	
	class FlowGraphBranchType {
		int label;
		BranchType type;
		FlowGraphBranchType(int label, BranchType type) {
			this.label = label;
			this.type = type;
		}
	}
}
