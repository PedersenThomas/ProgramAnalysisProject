package frameworks.detectionOfSigns;

import java.util.*;
import java.util.List;

import ast.*;
import frameworks.*;
import graph.*;
import org.apache.commons.lang3.StringUtils;

public class DetectionOfSigns extends MonotoneFramework {

    private FlowGraph flowGraph;
    private Set<Variable> variables;
    private List<IConstraint> constraints;
    private int numberOfLabels;
    private Map<Integer, OutputConstraintsInfo> outputConstraintsMap;

    public DetectionOfSigns(FlowGraph flowGraph) {
        this.flowGraph = flowGraph;
        this.variables = new HashSet<>(flowGraph.getFreeVariables());
        this.constraints = new ArrayList<>();
        this.numberOfLabels = flowGraph.getLabelMapping().size();
        this.outputConstraintsMap = new HashMap<>();
        constructConstraintMap();
        constructConstraints();
    }

    private void constructConstraintMap() {
        for (int i = FlowGraph.StartLabel; i < numberOfLabels + FlowGraph.StartLabel; i++) {
            outputConstraintsMap.put(i, new OutputConstraintsInfo());
        }
    }

    private void constructConstraints() {
        createInitialConstraint();
        createRecombinations();
        createTransferFunctions();

    }

    private void createRecombinations() {
        for (int i = FlowGraph.StartLabel + 1; i < numberOfLabels + FlowGraph.StartLabel; i++) {
            constraints.add(new Recombination());
        }
    }

    private void createTransferFunctions() {
        HashMap<Integer, ILabelable> labelMapping = flowGraph.getLabelMapping();
        for (int i = FlowGraph.StartLabel; i < numberOfLabels + FlowGraph.StartLabel; i++) {
            ILabelable block = labelMapping.get(i);
            int inputIndex = i - FlowGraph.StartLabel;
            if (block instanceof VariableAssignment) {
                createVariableAssignmentConstraint(inputIndex, (VariableAssignment) block);
            } else if (block instanceof SkipStatement) {
                createSkipConstraint(inputIndex);
            } else if (block instanceof IfStatement) {
                createIfStatementConstraint(inputIndex, (IfStatement) block);
            } else if (block instanceof WhileStatement) {
                createWhileStatementConstraint(inputIndex, (WhileStatement) block);
            } else if (block instanceof ArrayAssignment) {
                createArrayAssignmantConstraint(inputIndex, (ArrayAssignment) block);
            } else if (block instanceof ReadVariable) {
                createReadStatementConstraint(inputIndex, (ReadVariable) block);
            } else if (block instanceof ReadArray) {
                createReadArrayStatementConstraint(inputIndex, (ReadArray) block);
            } else if (block instanceof WriteStatement) {
                createWriteStatementConstraint(inputIndex, (WriteStatement) block);
            } else if (block instanceof VariableDeclaration) {
                createVariableDeclarationConstraint(inputIndex, (VariableDeclaration) block);
            } else if (block instanceof ArrayDeclaration) {
                createArrayDeclarationConstraint(inputIndex, (ArrayDeclaration) block);
            } else {
                throw new IllegalArgumentException("Unexpected program block.");
            }
        }
    }

    private void createArrayDeclarationConstraint(
            int inputIndex, ArrayDeclaration arrayDeclaration) {
        Variable array = new Variable(arrayDeclaration.getName(), VariableType.Array);
        ArithmeticExpression size = new Constant(arrayDeclaration.getSize());
        IConstraint exitConstraint = new ArrayDeclarationTransferFunction(inputIndex, array, size);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createVariableDeclarationConstraint(
            int inputIndex, VariableDeclaration variableDeclaration) {
        Variable variable = new Variable(variableDeclaration.getName(), VariableType.Variable);
        IConstraint exitConstraint = new DeclarationTransferFunction(inputIndex, variable);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createWriteStatementConstraint(int inputIndex, WriteStatement writeStatement) {
        ArithmeticExpression expression = writeStatement.getExpression();
        IConstraint exitConstraint = new WriteTransferFunction(inputIndex, expression);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createReadArrayStatementConstraint(int inputIndex, ReadArray readArrayStatement) {
        Variable readArray = new Variable(readArrayStatement.getArrayName(), VariableType.Array);
        ArithmeticExpression index = readArrayStatement.getIndex();
        IConstraint exitConstraint = new ArrayReadTransferFunction(inputIndex, readArray, index);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createReadStatementConstraint(int inputIndex, ReadVariable readStatement) {
        Variable readVariable = new Variable(readStatement.getName(), VariableType.Variable);
        IConstraint exitConstraint = new ReadTransferFunction(inputIndex, readVariable);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createArrayAssignmantConstraint(int inputIndex, ArrayAssignment arrayAssignment) {
        Variable array = new Variable(arrayAssignment.getArrayName(), VariableType.Array);
        ArithmeticExpression index = arrayAssignment.getIndex();
        ArithmeticExpression value = arrayAssignment.getValue();
        IConstraint exitConstraint =
                new ArrayAssignmentTransferFunction(inputIndex, array, index, value);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createWhileStatementConstraint(int inputIndex, WhileStatement whileStatement) {
        BooleanExpression condition = whileStatement.getCondition();
        List<FlowGraphEdge> outEdges = flowGraph.getNodeOutNodes(inputIndex + FlowGraph.StartLabel);
        assert (0 < outEdges.size() && outEdges.size() <= 2);
        createBooleanConstraints(inputIndex, condition, outEdges);
    }

    private void createIfStatementConstraint(int inputIndex, IfStatement ifStatement) {
        BooleanExpression condition = ifStatement.getCondition();
        List<FlowGraphEdge> outEdges = flowGraph.getNodeOutNodes(inputIndex + FlowGraph.StartLabel);
        assert (outEdges.size() == 2);
        createBooleanConstraints(inputIndex, condition, outEdges);
    }

    private void createBooleanConstraints(
            int inputIndex, BooleanExpression condition, List<FlowGraphEdge> outEdges) {
        for (FlowGraphEdge edge : outEdges) {
            IConstraint exitConstraint;
            switch (edge.getType()) {
                case True:
                    exitConstraint = new TrueTransferFunction(inputIndex, condition);
                    break;
                case False:
                    exitConstraint = new FalseTransferFunction(inputIndex, condition);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected type of edge.");
            }
            addBooleanExitConstraint(edge, exitConstraint);
        }
    }

    private void createInitialConstraint() {
        Map<Variable, PowerSetOfSigns> initialState = new HashMap<>();
        for (Variable variable : variables) {
            initialState.put(variable, Util.ALL);
        }
        InitialConstraint initial = new InitialConstraint(new DSLatticeValue(initialState));
        constraints.add(initial);
    }

    private void createSkipConstraint(int inputIndex) {
        IConstraint exitConstraint = new SkipTransferFunction(inputIndex);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void createVariableAssignmentConstraint(int inputIndex, VariableAssignment assignment) {
        IConstraint exitConstraint = new AssignmentTransferFunction(
                inputIndex, new Variable(assignment.getVariableName(), VariableType.Variable),
                assignment.getRight());
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

    private void addNonBooleanExitConstraint(int inputIndex, IConstraint exitConstraint) {
        constraints.add(exitConstraint);
        int outputConstraintIndex = constraints.size() - 1;
        List<FlowGraphEdge> outEdges = flowGraph.getNodeOutNodes(inputIndex + FlowGraph.StartLabel);
        if (!outEdges.isEmpty()) {
            assert (outEdges.size() == 1);
            updateRecombinationConstraints(outEdges.get(0), outputConstraintIndex);
        }
        outputConstraintsMap.get(inputIndex + FlowGraph.StartLabel)
                .setOutputConstraintIndex(outputConstraintIndex);
    }

    private void addBooleanExitConstraint(FlowGraphEdge outEdge, IConstraint exitConstraint) {
        constraints.add(exitConstraint);
        int outputConstraintIndex = constraints.size() - 1;
        updateRecombinationConstraints(outEdge, outputConstraintIndex);
        assert (!outEdge.getType().equals(EdgeType.None));
        if (outEdge.getType().equals(EdgeType.True)) {
            outputConstraintsMap.get(outEdge.getLabel1())
                    .setTrueConstraintIndex(outputConstraintIndex);
        } else {
            outputConstraintsMap.get(outEdge.getLabel1())
                    .setFalseConstraintIndex(outputConstraintIndex);
        }
    }

    private void updateRecombinationConstraints(FlowGraphEdge edge, int newConstraintIndex) {
        int destinationConstraintIndex = edge.getLabel2() - FlowGraph.StartLabel;
        Recombination destinationRecombination = (Recombination) constraints.get(destinationConstraintIndex);
        destinationRecombination.insertFreeVariable(newConstraintIndex);
    }

    @Override
	public ILatticeValue getBottom() {
        return new DSLatticeValue(this.variables);
	}

	@Override
	public List<IConstraint> getConstraints() {
		return this.constraints;
	}

	@Override
	public Integer ConstraintsMapToLabel(Integer label) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public String formatResult(List<ILatticeValue> result) {

        int digitsInNumberOfLabels = 1 + (int) Math.log10(numberOfLabels);
        int numberOfVariables = variables.size();
        int widthOfTopSet = Util.ALL.toString().length();

        StringBuilder stringBuilder = new StringBuilder();

        appendLabelsTable(digitsInNumberOfLabels, stringBuilder);

        stringBuilder.append("\nSign States:\n");

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

        String formatString = "%" + digitsInNumberOfLabels + "d%1s: ";
        for (int i = FlowGraph.StartLabel; i < numberOfLabels + FlowGraph.StartLabel; i++) {
            OutputConstraintsInfo outputConstraintsIndices = outputConstraintsMap.get(i);
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

        return stringBuilder.toString();

    }

    private void appendVariables(StringBuilder stringBuilder, int widthOfTopSet) {
        for (Variable variable : variables) {
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
        for (Variable variable : variables) {
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

    private void appendLabelsTable(int digitsInNumberOfLabels, StringBuilder stringBuilder) {
        Map<Integer, ILabelable> lableMap = flowGraph.getLabelMapping();
        stringBuilder.append("Labels:\n");
        for (int i = FlowGraph.StartLabel; i < numberOfLabels + FlowGraph.StartLabel; i++) {
            String block;
            ILabelable astObject = lableMap.get(i);
            if (astObject instanceof IfStatement) {
                block = ((IfStatement) astObject).getCondition().toString();
            } else if (astObject instanceof WhileStatement) {
                block = ((WhileStatement) astObject).getCondition().toString();
            } else {
                block = astObject.toString();
            }
            String formatString = "%" + digitsInNumberOfLabels + "d: %s\n";
            stringBuilder.append(String.format(formatString, i, block));
        }
    }

    @Override
    public String toString() {
        return "Detection of Signs";
    }
}
