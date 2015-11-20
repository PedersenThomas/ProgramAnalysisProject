package frameworks.detectionOfSigns;

import java.util.*;
import java.util.List;

import ast.*;
import frameworks.*;
import graph.*;

public class DetectionOfSigns extends MonotoneFramework {

    private FlowGraph flowGraph;
    private Set<Variable> variables;
    private List<IConstraint> constraints;

    public DetectionOfSigns(FlowGraph flowGraph) {
        this.flowGraph = flowGraph;
        this.variables = new HashSet<>(flowGraph.getFreeVariables());
        this.constraints = new ArrayList<>();
        constructConstraints();
    }

    private void constructConstraints() {
        int numberOfLabels = flowGraph.getLabelMapping().size();
        createInitialConstraint();
        createRecombinations(numberOfLabels);
        createTransferFunctions(numberOfLabels);

    }

    private void createTransferFunctions(int numberOfLabels) {
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
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void createVariableDeclarationConstraint(
            int inputIndex, VariableDeclaration variableDeclaration) {
        Variable variable = new Variable(variableDeclaration.getName(), VariableType.Variable);
        IConstraint exitConstraint = new DeclarationTransferFunction(inputIndex, variable);
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void createWriteStatementConstraint(int inputIndex, WriteStatement writeStatement) {
        ArithmeticExpression expression = writeStatement.getExpression();
        IConstraint exitConstraint = new WriteTransferFunction(inputIndex, expression);
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void createReadArrayStatementConstraint(int inputIndex, ReadArray readArrayStatement) {
        Variable readArray = new Variable(readArrayStatement.getArrayName(), VariableType.Array);
        ArithmeticExpression index = readArrayStatement.getIndex();
        IConstraint exitConstraint = new ArrayReadTransferFunction(inputIndex, readArray, index);
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void createReadStatementConstraint(int inputIndex, ReadVariable readStatement) {
        Variable readVariable = new Variable(readStatement.getName(), VariableType.Variable);
        IConstraint exitConstraint = new ReadTransferFunction(inputIndex, readVariable);
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void createArrayAssignmantConstraint(int inputIndex, ArrayAssignment arrayAssignment) {
        Variable array = new Variable(arrayAssignment.getArrayName(), VariableType.Array);
        ArithmeticExpression index = arrayAssignment.getIndex();
        ArithmeticExpression value = arrayAssignment.getValue();
        IConstraint exitConstraint =
                new ArrayAssignmentTransferFunction(inputIndex, array, index, value);
        addExitConstraint(inputIndex, exitConstraint);
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
            addExitConstraint(edge, exitConstraint);
        }
    }

    private void createRecombinations(int numberOfLabels) {
        for (int i = FlowGraph.StartLabel + 1; i < numberOfLabels + FlowGraph.StartLabel; i++) {
            constraints.add(new Recombination());
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
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void createVariableAssignmentConstraint(int inputIndex, VariableAssignment assignment) {
        IConstraint exitConstraint = new AssignmentTransferFunction(
                inputIndex, new Variable(assignment.getVariableName(), VariableType.Variable),
                assignment.getRight());
        addExitConstraint(inputIndex, exitConstraint);
    }

    private void addExitConstraint(int inputIndex, IConstraint exitConstraint) {
        constraints.add(exitConstraint);
        handleNonBooleanEdge(inputIndex + FlowGraph.StartLabel, constraints.size() - 1);
    }

    private void addExitConstraint(FlowGraphEdge outEdge, IConstraint exitConstraint) {
        constraints.add(exitConstraint);
        updateRecombinationConstraints(outEdge, constraints.size() - 1);
    }

    private void handleNonBooleanEdge(int originLabel, int newConstraintIndex) {
        List<FlowGraphEdge> outEdges = flowGraph.getNodeOutNodes(originLabel);
        if (!outEdges.isEmpty()) {
            assert (outEdges.size() == 1);
            updateRecombinationConstraints(outEdges.get(0), newConstraintIndex);
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
}
