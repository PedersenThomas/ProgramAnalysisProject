package frameworks.reachingDefinitions;

import ast.*;
import frameworks.*;
import frameworks.detectionOfSigns.AssignmentTransferFunction;
import graph.FlowGraph;
import graph.FlowGraphEdge;
import graph.Variable;
import graph.VariableType;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class ReachingDefinitions extends MonotoneFramework {

	private List<AssignmentTableEntry> assignmentTable;
	private Map<Integer, Integer> labelToAssignmentTableMap;
	private Map<Variable, BitSet> killSets;

	public ReachingDefinitions(FlowGraph flowGraph) {
		super(flowGraph);
		constructAssignmentTable();
		constructKillSets();
	}

	// Constructs a table for knowing where label a variable is assigned at.
	private void constructAssignmentTable() {

		assignmentTable = new ArrayList<>();
		labelToAssignmentTableMap = new HashMap<>();

		for (Variable variable : getVariables()) {
			assignmentTable.add(new AssignmentTableEntry(variable.getName(), variable.getType(), -1));
		}

		for (int label = FlowGraph.StartLabel;
			 label < getFlowGraphLabelMap().size() + FlowGraph.StartLabel;
			 label++) {
			labelToAssignmentTableMap.put(label, -1);
		}

		Map<Integer, ILabelable> mapping = getFlowGraphLabelMap();
		for (Integer label : mapping.keySet()) {
			ILabelable astObj = mapping.get(label);
			if (astObj instanceof ArrayDeclaration) {
				addAssignmentTableEntry(
						((Declaration) astObj).getName(), VariableType.Array, label);
			} else if (astObj instanceof VariableDeclaration){
				addAssignmentTableEntry(
						((Declaration) astObj).getName(), VariableType.Variable, label);
			} else if (astObj instanceof ArrayAssignment) {
				addAssignmentTableEntry(
						((ArrayAssignment) astObj).getArrayName(), VariableType.Array, label);
			} else if (astObj instanceof VariableAssignment) {
				addAssignmentTableEntry(
						((VariableAssignment) astObj).getVariableName(), VariableType.Variable, label);
			} else if (astObj instanceof ReadArray) {
				addAssignmentTableEntry(
						((ReadArray) astObj).getArrayName(), VariableType.Array, label);
			} else if (astObj instanceof ReadVariable) {
				addAssignmentTableEntry(
						((ReadVariable) astObj).getName(), VariableType.Variable, label);
			}
		}

	}

	private void addAssignmentTableEntry(String name, VariableType type, int label) {
		labelToAssignmentTableMap.put(label, assignmentTable.size());
		assignmentTable.add(new AssignmentTableEntry(name, type, label));
	}


	private void constructKillSets() {

		killSets = new HashMap<>();
		for (Variable variable : getVariables()) {
			killSets.put(variable, new BitSet());
		}

		for (int i = 0; i < assignmentTable.size(); i++) {
			AssignmentTableEntry entry = assignmentTable.get(i);
			killSets.get(entry.getVariable()).set(i);
		}

	}

	@Override
	protected ILatticeValue getInitialLatticeValue() {
		BitSet initial = new BitSet();
		for (int i = 0; i < getVariables().size(); i++) {
			initial.set(i);
		}
		return new RDLatticeValue(initial);
	}

	@Override
	protected TransferFunction getArrayDeclarationTransferFunction(
			int inputIndex, Variable array, ArithmeticExpression size) {
		return new KillGenTransferFunction(
				inputIndex, killSets.get(array),
				labelToAssignmentTableMap.get(inputIndex + FlowGraph.StartLabel));
	}

	@Override
	protected TransferFunction getDeclarationTransferFunction(
			int inputIndex, Variable variable) {
		return new KillGenTransferFunction(
				inputIndex, killSets.get(variable),
				labelToAssignmentTableMap.get(inputIndex + FlowGraph.StartLabel));
	}

	@Override
	protected TransferFunction getWriteTransferFunction(
			int inputIndex, ArithmeticExpression expression) {
		return new KillGenTransferFunction(inputIndex, new BitSet(), new BitSet());
	}

	@Override
	protected TransferFunction getArrayReadTransferFunction(
			int inputIndex, Variable readArray, ArithmeticExpression index) {
		return new KillGenTransferFunction(
				inputIndex, new BitSet(),
				labelToAssignmentTableMap.get(inputIndex + FlowGraph.StartLabel));
	}

	@Override
	protected TransferFunction getReadTransferFunction(
			int inputIndex, Variable readVariable) {
		return new KillGenTransferFunction(
				inputIndex, killSets.get(readVariable),
				labelToAssignmentTableMap.get(inputIndex + FlowGraph.StartLabel));
	}

	@Override
	protected TransferFunction getArrayAssignmentTransferFunction(
			int inputIndex, Variable array, ArithmeticExpression index, ArithmeticExpression value) {
		return new KillGenTransferFunction(
				inputIndex, new BitSet(),
				labelToAssignmentTableMap.get(inputIndex + FlowGraph.StartLabel));
	}

	@Override
	protected TransferFunction getFalseTransferFunction(
			int inputIndex, BooleanExpression condition) {
		return new KillGenTransferFunction(inputIndex, new BitSet(), new BitSet());
	}

	@Override
	protected TransferFunction getTrueTransferFunction(int inputIndex, BooleanExpression condition) {
		return new KillGenTransferFunction(inputIndex, new BitSet(), new BitSet());
	}

	@Override
	protected TransferFunction getSkipTransferFunction(int inputIndex) {
		return new KillGenTransferFunction(inputIndex, new BitSet(), new BitSet());
	}

	@Override
	protected TransferFunction getAssignmentTransferFunction(
			int inputIndex, Variable variable, ArithmeticExpression right) {
		return new KillGenTransferFunction(
				inputIndex, killSets.get(variable),
				labelToAssignmentTableMap.get(inputIndex + FlowGraph.StartLabel));
	}

	@Override
	public ILatticeValue getBottom() {
		return new RDLatticeValue();
	}

	@Override
	public String formatResult(List<ILatticeValue> result) {
		return result.toString();
	}

	@Override
	public String toString() {
		return "Reaching Definitions";
	}

}
