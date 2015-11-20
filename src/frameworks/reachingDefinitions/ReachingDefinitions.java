package frameworks.reachingDefinitions;

import frameworks.*;
import graph.FlowGraph;
import graph.FlowGraphEdge;
import graph.Variable;
import graph.VariableType;

import java.util.*;

import ast.ArrayAssignment;
import ast.ArrayDeclaration;
import ast.Declaration;
import ast.ILabelable;
import ast.ReadArray;
import ast.ReadVariable;
import ast.VariableAssignment;
import ast.VariableDeclaration;
import ast.WhileStatement;

/**
 * Created by PatrickKasting on 09/11/15.
 */
public class ReachingDefinitions extends MonotoneFramework {
	private List<IConstraint> constraints;
	private List<AssignmentTableEntry> assignmentTable;
	private Map<Integer, Integer> ConstraintToLabelsMapping = new HashMap<Integer, Integer>();
	
	public List<AssignmentTableEntry> getAssignmentTable() {
		return Collections.unmodifiableList(this.assignmentTable);
	}

	public ReachingDefinitions(FlowGraph flowGraph) {
		this.constraints = new ArrayList<IConstraint>(4);

		// example1();
		// example2();

		// Only used for not interfering with the examples. 
		// TODO REMOVE before shipping
		if (this.constraints.isEmpty()) { 
			BuildConstraints(flowGraph);
		}

		for (int i = 0; i < constraints.size(); i++) {
			System.out.println("" + i + " " + constraints.get(i));
		}
	}

	private void AddConstraintToLabelsMapping(Integer label, Integer constraint) {
		ConstraintToLabelsMapping.put(constraint, label);
	}
	
	private void BuildConstraints(FlowGraph flowgraph) {
		List<AssignmentTableEntry> assignmentTable = getAssignmentTable(flowgraph);
		Map<String, List<Integer>> killSets = new HashMap<String, List<Integer>>();

		for (int index = 0; index < assignmentTable.size(); index++) {
			AssignmentTableEntry entry = assignmentTable.get(index);
			String variable = entry.getVariable();
			if (!killSets.containsKey(variable)) {
				killSets.put(variable, new ArrayList<Integer>());
			}
			killSets.get(variable).add(index);
		}

		// TODO Remove when working!
		System.out.println("-------assignmentTable START------");
		for (int i = 0; i < assignmentTable.size(); i++) {
			AssignmentTableEntry assignmentTableEntry = assignmentTable.get(i);
			System.out.println("" + i + " " + assignmentTableEntry);
		}
		System.out.println("-------assignmentTable END------");

		System.out.println("-------KillSets START------");
		for (String key : killSets.keySet()) {
			System.out.println(key + " - " + killSets.get(key));
		}
		System.out.println("-------KillSets END------");

		BitSet initial = new BitSet();
		for (int index = 0; index < assignmentTable.size(); index++) {
			if (assignmentTable.get(index).getLabel() < 0) {
				initial.set(index);
			}
		}
		this.constraints.add(new InitialConstraint(new RDLatticeValue(initial)));
		AddConstraintToLabelsMapping(-1, 0);
		
		Map<Integer, ILabelable> flowGraphMapping = flowgraph.getLabelMapping();

		// TODO Still Good??? Don't construct for the initialNode. Therefore the size()-1
		for (int i = 1; i < flowGraphMapping.keySet().size(); i++) {
			IConstraint recombination = new Recombination();
			int constraintId = this.constraints.size();
			AddConstraintToLabelsMapping(i, constraintId);
			this.constraints.add(recombination);
		}

		for (int label : flowGraphMapping.keySet()) {
			// Construct Entering State
			List<FlowGraphEdge> edges = flowgraph.getNodeInNodes(label);
			
			for (FlowGraphEdge edge : edges) {
				int edgeLabel = edge.getLabel2();
				
				// Construct Leaving state
				int inputIndex = edgeLabel - 1;
				BitSet killSet = new BitSet();
				BitSet genSet = new BitSet();
				for (int i = 0; i < assignmentTable.size(); i++) {
					AssignmentTableEntry assignmentTableEntry = assignmentTable.get(i);
					if (assignmentTableEntry.getLabel() == edgeLabel) {
						// Build GetSet
						genSet.set(i);

						// Build up KillSet for variables
						if (assignmentTableEntry.getType() == VariableType.Variable || 
								flowgraph.getLabelMapping().get(assignmentTableEntry.getLabel()) instanceof ArrayDeclaration) {
							for (Integer index : killSets.get(assignmentTableEntry.getVariable())) {
								killSet.set(index);
							}
						}
					}
				}
				String message = "Edge (" + edge + "," + label + ")";
				IConstraint transferFunction = new KillGenTransferFunction(inputIndex, killSet, genSet, message);

				int constraintIndex = this.constraints.size();
				this.constraints.add(transferFunction);
				AddConstraintToLabelsMapping(edgeLabel, constraintIndex);
				((Recombination) this.constraints.get(label - 1)).insertFreeVariable(constraintIndex);
			}
		}

		int lastLabel = Collections.max(flowGraphMapping.keySet());
		BitSet killSet = new BitSet();
		BitSet genSet = new BitSet();
		for (int i = 0; i < assignmentTable.size(); i++) {
			AssignmentTableEntry assignmentTableEntry = assignmentTable.get(i);
			if (assignmentTableEntry.getLabel() == lastLabel) {
				// Build GetSet
				genSet.set(i);

				// Build up KillSet for variables
				if (assignmentTableEntry.getType() != VariableType.Array) {
					for (Integer index : killSets.get(assignmentTableEntry.getVariable())) {
						killSet.set(index);
					}
				}
			}
		}
		IConstraint transferFunction = new KillGenTransferFunction(lastLabel - 1, killSet, genSet);
		int constraintIndex = this.constraints.size();
		AddConstraintToLabelsMapping(lastLabel, constraintIndex);
		this.constraints.add(transferFunction);
		
		
		this.assignmentTable = assignmentTable;
	}

	// Constructs a table for knowing where label a variable is assigned at.
	private List<AssignmentTableEntry> getAssignmentTable(FlowGraph flowgraph) {
		List<AssignmentTableEntry> labels = new ArrayList<AssignmentTableEntry>();

		for (Variable variable : flowgraph.getFreeVariables()) {
			labels.add(new AssignmentTableEntry(variable.getName(), variable.getType(), -1));
		}

		Map<Integer, ILabelable> mapping = flowgraph.getLabelMapping();
		for (Integer label : mapping.keySet()) {
			ILabelable astObj = mapping.get(label);

			if (astObj instanceof ArrayDeclaration) {
				labels.add(new AssignmentTableEntry(((Declaration) astObj).getName(), VariableType.Array, label));

			} else if (astObj instanceof VariableDeclaration){
				labels.add(new AssignmentTableEntry(((Declaration) astObj).getName(), VariableType.Variable, label));
				
			} else if (astObj instanceof ArrayAssignment) {
				labels.add(new AssignmentTableEntry(((ArrayAssignment) astObj).getArrayName(), VariableType.Array, label));

			} else if (astObj instanceof VariableAssignment) {
				labels.add(new AssignmentTableEntry(((VariableAssignment) astObj).getVariableName(), VariableType.Variable, label));

			} else if (astObj instanceof ReadArray) {
				labels.add(new AssignmentTableEntry(((ReadArray) astObj).getArrayname(), VariableType.Array, label));

			} else if (astObj instanceof ReadVariable) {
				labels.add(new AssignmentTableEntry(((ReadVariable) astObj).getName(), VariableType.Variable, label));
			}
		}

		return labels;
	}

	// TODO REMOVE
	private void example2() {

		BitSet initial = new BitSet();
		initial.set(0);
		this.constraints.add(new InitialConstraint(new RDLatticeValue(initial))); // 0

		BitSet kill = new BitSet();
		kill.set(0, 5);

		BitSet gen1 = new BitSet();
		gen1.set(1);

		BitSet gen2 = new BitSet();
		gen2.set(2);

		BitSet gen3 = new BitSet();
		gen3.set(3);

		BitSet gen4 = new BitSet();
		gen4.set(4);

		this.constraints.add(new KillGenTransferFunction(0, kill, gen1)); // 1
		this.constraints.add(new Recombination(1)); // 2
		this.constraints.add(new KillGenTransferFunction(2, kill, gen2)); // 3
		int[] merge4 = { 3, 7 };
		this.constraints.add(new Recombination(merge4)); // 4
		this.constraints.add(new KillGenTransferFunction(0, kill, gen1)); // 5
		this.constraints.add(new Recombination(5)); // 6
		this.constraints.add(new KillGenTransferFunction(6, kill, gen3)); // 7
		this.constraints.add(new KillGenTransferFunction(4, kill, gen4)); // 8

	}

	// TODO REMOVE
	private void example1() {

		BitSet initial = new BitSet();
		initial.set(0);
		this.constraints.add(new InitialConstraint(new RDLatticeValue(initial)));

		BitSet kill1 = new BitSet();
		kill1.set(0);
		kill1.set(1);
		BitSet gen1 = new BitSet();
		gen1.set(1);
		this.constraints.add(new KillGenTransferFunction(0, kill1, gen1));

		Set<Integer> free2 = new HashSet<>();
		free2.add(1);
		this.constraints.add(new Recombination(free2));

		BitSet kill2 = new BitSet();
		kill2.set(0);
		kill2.set(1);
		kill2.set(2);
		BitSet gen2 = new BitSet();
		gen2.set(2);
		this.constraints.add(new KillGenTransferFunction(2, kill2, gen2));

	}

	@Override
	public ILatticeValue getBottom() {
		return new RDLatticeValue();
	}

	@Override
	public List<IConstraint> getConstrains() {
		return Collections.unmodifiableList(this.constraints);
	}

	@Override
	public Integer ConstraintsMapToLabel(Integer label) {
		return ConstraintToLabelsMapping.get(label);
	}

}
