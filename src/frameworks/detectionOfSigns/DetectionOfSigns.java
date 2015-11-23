package frameworks.detectionOfSigns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.*;
import frameworks.*;
import graph.*;
import org.apache.commons.lang3.StringUtils;

public class DetectionOfSigns extends MonotoneFramework {

    public DetectionOfSigns(FlowGraph flowGraph) {
        super(flowGraph);
    }

    @Override
    protected ILatticeValue getInitialLatticeValue() {
        Map<Variable, PowerSetOfSigns> initialState = new HashMap<Variable, PowerSetOfSigns>();
        for (Variable variable : getVariables()) {
            initialState.put(variable, Util.ALL);
        }
        return new DSLatticeValue(initialState);
    }

    @Override
    protected TransferFunction getArrayDeclarationTransferFunction(
            int inputIndex, Variable array, ArithmeticExpression size) {
        return new ArrayDeclarationTransferFunction(inputIndex, array, size);
    }

    @Override
    protected TransferFunction getDeclarationTransferFunction(int inputIndex, Variable variable) {
        return new DeclarationTransferFunction(inputIndex, variable);
    }

    @Override
    protected TransferFunction getWriteTransferFunction(int inputIndex, ArithmeticExpression expression) {
        return new WriteTransferFunction(inputIndex, expression);
    }

    @Override
    protected TransferFunction getArrayReadTransferFunction(
            int inputIndex, Variable readArray, ArithmeticExpression index) {
        return new ArrayReadTransferFunction(inputIndex, readArray, index);
    }

    @Override
    protected TransferFunction getReadTransferFunction(int inputIndex, Variable readVariable) {
        return new ReadTransferFunction(inputIndex, readVariable);
    }

    @Override
    protected TransferFunction getArrayAssignmentTransferFunction(
            int inputIndex, Variable array, ArithmeticExpression index, ArithmeticExpression value) {
        return new ArrayAssignmentTransferFunction(inputIndex, array, index, value);
    }

    @Override
    protected TransferFunction getFalseTransferFunction(int inputIndex, BooleanExpression condition) {
        return new FalseTransferFunction(inputIndex, condition);
    }

    @Override
    protected TransferFunction getTrueTransferFunction(int inputIndex, BooleanExpression condition) {
        return new TrueTransferFunction(inputIndex, condition);
    }

    @Override
    protected TransferFunction getSkipTransferFunction(int inputIndex) {
        return new SkipTransferFunction(inputIndex);
    }

    @Override
    protected AssignmentTransferFunction getAssignmentTransferFunction(
            int inputIndex, Variable variable, ArithmeticExpression right) {
        return new AssignmentTransferFunction(inputIndex, variable, right);
    }

    @Override
	public ILatticeValue getBottom() {
        return new DSLatticeValue(getVariables());
	}

    @Override
    public String formatResult(List<ILatticeValue> result) {

        int digitsInNumberOfLabels = 1 + (int) Math.log10(getNumberOfLabels());
        int numberOfVariables = getVariables().size();
        int widthOfTopSet = Util.ALL.toString().length();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sign States:\n");
        appendHeader(digitsInNumberOfLabels, numberOfVariables, widthOfTopSet, stringBuilder);
        appendSignStateTable(result, digitsInNumberOfLabels, widthOfTopSet, stringBuilder);
        return stringBuilder.toString();

    }

    private void appendSignStateTable(List<ILatticeValue> result, int digitsInNumberOfLabels,
                                      int widthOfTopSet, StringBuilder stringBuilder) {
        String formatString = "%" + digitsInNumberOfLabels + "d%1s: ";
        for (int i = FlowGraph.StartLabel; i < getNumberOfLabels() + FlowGraph.StartLabel; i++) {
            OutputConstraints outputConstraintsIndices = getOutputConstraintsMap().get(i);
            if (outputConstraintsIndices.getOutputConstraintIndex() != -1) {  // Non-branching
                appendSignStateLine(result, stringBuilder, widthOfTopSet, i,
                        outputConstraintsIndices.getOutputConstraintIndex(), formatString, "");
            } else {  // Branching
                assert (outputConstraintsIndices.getTrueConstraintIndex() != -1);
                appendSignStateLine(result, stringBuilder, widthOfTopSet, i,
                        outputConstraintsIndices.getTrueConstraintIndex(), formatString, "t");
                if (outputConstraintsIndices.getFalseConstraintIndex() != -1) {
                    appendSignStateLine(result, stringBuilder, widthOfTopSet, i,
                            outputConstraintsIndices.getFalseConstraintIndex(), formatString, "f");
                }
            }
        }
    }

    private void appendHeader(int digitsInNumberOfLabels, int numberOfVariables,
                              int widthOfTopSet, StringBuilder stringBuilder) {
        stringBuilder.append(StringUtils.repeat(' ', digitsInNumberOfLabels + 3));
        stringBuilder.append(StringUtils.center("Entry", (widthOfTopSet + 1) * numberOfVariables - 1));
        stringBuilder.append(StringUtils.repeat(' ', 3));
        stringBuilder.append(StringUtils.center("Exit", (widthOfTopSet + 1) * numberOfVariables - 1));
        stringBuilder.append("\n");
        stringBuilder.append(StringUtils.repeat(' ', digitsInNumberOfLabels + 3));
        appendVariables(stringBuilder, widthOfTopSet);
        stringBuilder.append("| ");
        appendVariables(stringBuilder, widthOfTopSet);
        stringBuilder.append("\n");
    }

    private void appendVariables(StringBuilder stringBuilder, int widthOfTopSet) {
        for (Variable variable : getVariables()) {
            String name = variable.getName();
            if (name.length() > 7) {
                name = name.substring(0, widthOfTopSet);
            }
            stringBuilder.append(StringUtils.center(name, widthOfTopSet) + " ");
        }
    }

    private void appendSignStateLine(
            List<ILatticeValue> result, StringBuilder stringBuilder,
            int columnWidth, int label, int outputConstraint,
            String labelColumnFormatString, String branchAnnotation) {
        appendLabelColumnEntry(stringBuilder, label, labelColumnFormatString, branchAnnotation);
        appendValues(result, stringBuilder, columnWidth, label - FlowGraph.StartLabel);
        stringBuilder.append("| ");
        appendValues(result, stringBuilder, columnWidth, outputConstraint);
        stringBuilder.append("\n");
    }

    private void appendValues(
            List<ILatticeValue> result, StringBuilder stringBuilder, int columnWidth, int constraint) {
        DSLatticeValue value = (DSLatticeValue) result.get(constraint);
        for (Variable variable : getVariables()) {
            stringBuilder.append(
                    StringUtils.center(
                            value.getSignState().get(variable).toString(),
                            columnWidth) + " ");
        }
    }

    private void appendLabelColumnEntry(
            StringBuilder stringBuilder, int label,
            String labelColumnFormatString, String branchAnnotation) {
        stringBuilder.append(String.format(labelColumnFormatString, label, branchAnnotation));
    }

    @Override
    public String toString() {
        return "Detection of Signs";
    }
}
