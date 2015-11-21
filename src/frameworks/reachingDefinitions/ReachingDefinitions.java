package frameworks.reachingDefinitions;

import ast.*;
import frameworks.*;
import graph.FlowGraph;
import graph.Variable;
import graph.VariableType;

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

		int digitsInNumberOfLabels = 1 + (int) Math.log10(getNumberOfLabels());

		StringBuilder stringBuilder = new StringBuilder();
		String formatString = "%" + digitsInNumberOfLabels + "d: ";

		appendEntries(result, stringBuilder, formatString);
		appendExits(result, stringBuilder, formatString);

		return stringBuilder.toString();

	}

	private void appendExits(List<ILatticeValue> result, StringBuilder stringBuilder, String formatString) {
		stringBuilder.append("\nReaching Definitions at Exits:\n");
		for (int i = 0; i < getNumberOfLabels(); i++) {
			OutputConstraints outputConstraints = getOutputConstraintsMap().get(i + FlowGraph.StartLabel);
			int outputConstraint;
			if (outputConstraints.getOutputConstraintIndex() != -1) {
				outputConstraint = outputConstraints.getOutputConstraintIndex();
			} else {
				assert (outputConstraints.getTrueConstraintIndex() != -1);
				outputConstraint = outputConstraints.getTrueConstraintIndex();
			}
			appendLine(result, stringBuilder, formatString, i + FlowGraph.StartLabel, outputConstraint);
		}
	}

	private void appendEntries(List<ILatticeValue> result, StringBuilder stringBuilder, String formatString) {
		stringBuilder.append("Reaching Definitions at Entries:\n");
		for (int i = 0; i < getNumberOfLabels(); i++) {
			appendLine(result, stringBuilder, formatString, i + FlowGraph.StartLabel, i);
		}
	}

	private void appendLine(
			List<ILatticeValue> result, StringBuilder stringBuilder, String formatString,
			int label, int constrintIndex) {
		stringBuilder.append(String.format(formatString, label));
		appendBitSetAsString(stringBuilder, result.get(constrintIndex));
		stringBuilder.append("\n");
	}

	private void appendBitSetAsString(StringBuilder stringBuilder, ILatticeValue value) {

		BitSet bitSet = ((RDLatticeValue) value).getBitSet();
		if (bitSet.isEmpty()) {
			stringBuilder.append("{}");
		}

		stringBuilder.append("{");
		for (int i = bitSet.nextSetBit(0); i != -1; i = bitSet.nextSetBit(i + 1)) {
			stringBuilder.append(assignmentTable.get(i) + ", ");
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		stringBuilder.append("}");
	}

	@Override
	public String toString() {
		return "Reaching Definitions";
	}

}
