package frameworks;

import ast.*;
import frameworks.detectionOfSigns.AssignmentTransferFunction;
import frameworks.detectionOfSigns.DSLatticeValue;
import frameworks.detectionOfSigns.PowerSetOfSigns;
import frameworks.detectionOfSigns.Util;
import graph.*;

import java.util.*;

public abstract class MonotoneFramework {

	private FlowGraph flowGraph;
	private Set<Variable> variables;
	private final List<IConstraint> constraints;
	private int numberOfLabels;
	private Map<Integer, OutputConstraintsInfo> outputConstraintsMap;
	private ArrayList<Set<Integer>> influenceList;

	public MonotoneFramework(FlowGraph flowGraph) {
		this.outputConstraintsMap = new HashMap<>();
		this.constraints = new ArrayList<>();
		this.numberOfLabels = flowGraph.getLabelMapping().size();
		this.flowGraph = flowGraph;
		this.variables = new HashSet<>(flowGraph.getFreeVariables());
		constructConstraintMap();
		constructConstraints();
	}

	public Set<Variable> getVariables() {
		return Collections.unmodifiableSet(variables);
	}

	public int getNumberOfLabels() {
		return numberOfLabels;
	}

	public Map<Integer, OutputConstraintsInfo> getOutputConstraintsMap() {
		return Collections.unmodifiableMap(outputConstraintsMap);
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

	private void createInitialConstraint() {
        Map<Variable, PowerSetOfSigns> initialState = new HashMap<>();
        for (Variable variable : variables) {
            initialState.put(variable, Util.ALL);
        }
        InitialConstraint initial = new InitialConstraint(new DSLatticeValue(initialState));
        constraints.add(initial);
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
        IConstraint exitConstraint = getArrayDeclarationTransferFunction(inputIndex, array, size);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getArrayDeclarationTransferFunction(
			int inputIndex, Variable array, ArithmeticExpression size);

	private void createVariableDeclarationConstraint(
            int inputIndex, VariableDeclaration variableDeclaration) {
        Variable variable = new Variable(variableDeclaration.getName(), VariableType.Variable);
        IConstraint exitConstraint = getDeclarationTransferFunction(inputIndex, variable);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getDeclarationTransferFunction(int inputIndex, Variable variable);

	private void createWriteStatementConstraint(int inputIndex, WriteStatement writeStatement) {
        ArithmeticExpression expression = writeStatement.getExpression();
        IConstraint exitConstraint = getWriteTransferFunction(inputIndex, expression);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getWriteTransferFunction(int inputIndex, ArithmeticExpression expression);

	private void createReadArrayStatementConstraint(int inputIndex, ReadArray readArrayStatement) {
        Variable readArray = new Variable(readArrayStatement.getArrayName(), VariableType.Array);
        ArithmeticExpression index = readArrayStatement.getIndex();
        IConstraint exitConstraint = getArrayReadTransferFunction(inputIndex, readArray, index);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getArrayReadTransferFunction(
			int inputIndex, Variable readArray, ArithmeticExpression index);

	private void createReadStatementConstraint(int inputIndex, ReadVariable readStatement) {
        Variable readVariable = new Variable(readStatement.getName(), VariableType.Variable);
        IConstraint exitConstraint = getReadTransferFunction(inputIndex, readVariable);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getReadTransferFunction(int inputIndex, Variable readVariable);

	private void createArrayAssignmantConstraint(int inputIndex, ArrayAssignment arrayAssignment) {
        Variable array = new Variable(arrayAssignment.getArrayName(), VariableType.Array);
        ArithmeticExpression index = arrayAssignment.getIndex();
        ArithmeticExpression value = arrayAssignment.getValue();
        IConstraint exitConstraint =
                getArrayAssignmentTransferFunction(inputIndex, array, index, value);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getArrayAssignmentTransferFunction(
			int inputIndex, Variable array, ArithmeticExpression index, ArithmeticExpression value);

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
                    exitConstraint = getTrueTransferFunction(inputIndex, condition);
                    break;
                case False:
                    exitConstraint = getFalseTransferFunction(inputIndex, condition);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected type of edge.");
            }
            addBooleanExitConstraint(edge, exitConstraint);
        }
    }

	protected abstract TransferFunction getFalseTransferFunction(int inputIndex, BooleanExpression condition);

	protected abstract TransferFunction getTrueTransferFunction(int inputIndex, BooleanExpression condition);

	private void createSkipConstraint(int inputIndex) {
        IConstraint exitConstraint = getSkipTransferFunction(inputIndex);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract TransferFunction getSkipTransferFunction(int inputIndex);

	private void createVariableAssignmentConstraint(int inputIndex, VariableAssignment assignment) {
        Variable variable = new Variable(assignment.getVariableName(), VariableType.Variable);
        ArithmeticExpression right = assignment.getRight();
        IConstraint exitConstraint = getAssignmentTransferFunction(inputIndex, variable, right);
        addNonBooleanExitConstraint(inputIndex, exitConstraint);
    }

	protected abstract AssignmentTransferFunction getAssignmentTransferFunction(
			int inputIndex, Variable variable, ArithmeticExpression right);

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

	public abstract ILatticeValue getBottom();
	public final List<IConstraint> getConstraints() {
		return Collections.unmodifiableList(this.constraints);
	}

	public abstract String formatResult(List<ILatticeValue> result);
	
	public ArrayList<Set<Integer>> getInfluenceList() {
		if (influenceList == null) {
			List<IConstraint> constraints = getConstraints();
			this.influenceList = new ArrayList<Set<Integer>>(constraints.size());
	
			for (int i = 0; i < constraints.size(); i++) {
				this.influenceList.add(new HashSet<Integer>());
			}
	
			for (int i = 0; i < constraints.size(); i++) {
				Set<Integer> freeVariables = constraints.get(i).getFreeVariables();
	            for (Integer n : freeVariables) {
	                influenceList.get(n).add(i);
	            }
			}
		}
		return this.influenceList;
	}

	protected String labelsTable() {

		int digitsInNumberOfLabels = 1 + (int) Math.log10(numberOfLabels);
		StringBuilder result = new StringBuilder();

        Map<Integer, ILabelable> lableMap = flowGraph.getLabelMapping();
		result.append("Labels:\n");
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
			result.append(String.format(formatString, i, block));
        }

		return result.toString();

    }

}
