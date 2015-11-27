package frameworks.worklists;

import java.util.*;
import java.util.List;

import frameworks.IConstraint;
import frameworks.IWorklist;
import graph.BranchType;
import org.apache.commons.lang3.ArrayUtils;

public class SCCWorklist implements IWorklist {

	private List<IConstraint> constraints;
	private List<Set<Integer>> influenceList;
	private List<Set<Integer>> reverseInfluenceList;

	Comparator<Integer> comparator;

	private int numberOfConstraints;
	private boolean[] marks;
	private int[] order;
	private int currentOrder;

	private int[] whichStronglyConnectedComponent;
	List<Set<Integer>> stronglyConnectedComponents;

	private Set<Integer> pending;
	private List<Integer> current;
	private Set<Integer> currentSCC;
	
	private int numberOfInsertions = 0;
	private int numberOfExtractions = 0;

	public SCCWorklist(List<IConstraint> constraints, List<Set<Integer>> influenceList) {

		this.constraints = constraints;
		this.influenceList = influenceList;

		comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer c1, Integer c2) {
				int o1 = order[c1];
				int o2 = order[c2];
				return Integer.compare(o1, o2);
			}
		};

		numberOfConstraints = influenceList.size();

		pending = new HashSet<Integer>();
		current = new LinkedList<Integer>();
		currentSCC = new HashSet<Integer>();

		initialize();

	}

	private void initialize() {

		/*
		System.out.println("Constraints (" + constraints.size() + "):");
		for (int i = 0; i < constraints.size(); i++) {
			System.out.println("" + i + ": " + constraints.get(i));
		}
		*/

		// Find the reverse post order
		marks = new boolean[numberOfConstraints];
		order = new int[numberOfConstraints];
		currentOrder = numberOfConstraints;
		findReversePostOrder(0);

		findStronglyConnectedComponents();

	}

	private void findStronglyConnectedComponents() {

		// Compute the reverse graph
		computeReverseInfluenceList();

		/*
		System.out.println("Original influence list:");
		System.out.println(influenceList);
		System.out.println("Reversed:");
		System.out.println(reverseInfluenceList);
		*/

		// Add all constraints to a list of constraints to be visited
		List<Integer> constraintsToBeVisited = new ArrayList<Integer>();
		for (int i = 0; i < numberOfConstraints; i++) {
			constraintsToBeVisited.add(i);
		}

		// Sort this list in ascending order
		Collections.sort(constraintsToBeVisited, comparator);

		/*
		System.out.println("Order of finishing times:");
		System.out.println(constraintsToBeVisited);
		*/

		// Find the strongly connected components
		marks = new boolean[numberOfConstraints];  // Set all marks to false
		whichStronglyConnectedComponent = new int[numberOfConstraints];
		stronglyConnectedComponents = new ArrayList<>();
		depthFirstSearchComponents(constraintsToBeVisited);

		/*
		System.out.println("whichStronglyConnectedComponent:");
		System.out.println(ArrayUtils.toString(whichStronglyConnectedComponent));
		System.out.println("Strongly connected components");
		System.out.println(stronglyConnectedComponents);
		*/

	}

	private void depthFirstSearchComponents(List<Integer> constraintsToBeVisited) {
		int currentComponentIndex = 0;
		for (int i = 0; i < constraintsToBeVisited.size(); i++) {
			int constraint = constraintsToBeVisited.get(i);
			if (!marks[constraint]) {
				Set<Integer> currentComponent = new HashSet<Integer>();
				stronglyConnectedComponents.add(currentComponent);
				depthFirstSearchVisit(constraint, currentComponentIndex, currentComponent);
				currentComponentIndex++;
				assert (currentComponentIndex == stronglyConnectedComponents.size());
			}
		}
	}

	private void depthFirstSearchVisit(
			int constraint, int currentComponentIndex, Set<Integer> currentComponent) {
		marks[constraint] = true;
		whichStronglyConnectedComponent[constraint] = currentComponentIndex;
		currentComponent.add(constraint);
		for (int incidentTo : reverseInfluenceList.get(constraint)) {
			if (!marks[incidentTo]) {
				depthFirstSearchVisit(incidentTo, currentComponentIndex, currentComponent);
			}
		}
	}

	private void computeReverseInfluenceList() {

		reverseInfluenceList = new ArrayList<Set<Integer>>();
		for (int i = 0; i < influenceList.size(); i++) {
			reverseInfluenceList.add(new HashSet<Integer>());
		}

		assert (influenceList.size() == reverseInfluenceList.size());

		for (int i = 0; i < influenceList.size(); i++) {
			for (int influenced : influenceList.get(i)) {
				reverseInfluenceList.get(influenced).add(i);
			}
		}

	}

	private void sortConstraintsBasedOnBranchTypes(List<Integer> constraintIndices) {
		Comparator<Integer> outTypeComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				BranchType o1 = constraints.get(i1).getBranchType();
				BranchType o2 = constraints.get(i2).getBranchType();
				if (o1.equals(o2)) {
					return 0;
				} else if (o1.equals(BranchType.False) || o2.equals(BranchType.True)) {
					return -1;
				} else {
					return 1;
				}
			}
		};
		Collections.sort(constraintIndices, outTypeComparator);
	}

	private void findReversePostOrder(int constraint) {
		marks[constraint] = true;
		List<Integer> incidentTos = new ArrayList<Integer>(influenceList.get(constraint));
		sortConstraintsBasedOnBranchTypes(incidentTos);
		for (int i = 0; i < incidentTos.size(); i++) {
			int incidentTo = incidentTos.get(i);
			if (!marks[incidentTo]) {
				findReversePostOrder(incidentTo);
			}
		}
		currentOrder--;
		order[constraint] = currentOrder;
	}
	
	@Override
	public void insert(int index) {
		numberOfInsertions += 1;
		// If we have considered all constraints in the current SCC
		// or if the current SCC does not contain the node to be inserted.
		if (!currentSCC.contains(index) || current.isEmpty()) {
			pending.add(index);
		}
	}

	@Override
	public int extract() {
		assert (!isEmpty());
		numberOfExtractions += 1;
		if(current.isEmpty()) {
			int minPending = Collections.min(pending, comparator);
			int SCCIndexOfMinPending = whichStronglyConnectedComponent[minPending];
			currentSCC = stronglyConnectedComponents.get(SCCIndexOfMinPending);
			current.addAll(currentSCC);
			Collections.sort(current, comparator);
			pending.removeAll(currentSCC);
		}
		return current.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return current.isEmpty() && pending.isEmpty();
	}

	@Override
	public String getName() {
		return "Strongly Connected Components Worklist";
	}

	@Override
	public int getNumberOfInsertions() {
		return numberOfInsertions;
	}

	@Override
	public int getNumberOfExtractions() {
		return numberOfExtractions;
	}

	@Override
	public String toString() {
		return "current=" + current + ", pending=" + pending + ", size=" + (current.size() + pending.size());
	}

	public int[] getOrder() {
		return order;
	}
}

