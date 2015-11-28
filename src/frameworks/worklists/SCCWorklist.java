package frameworks.worklists;

import java.util.*;
import java.util.List;

import frameworks.IConstraint;
import frameworks.IWorklist;
import graph.BranchType;

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
	private List<Integer> currentAsList;
	private Set<Integer> currentAsSet;
	
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
		currentAsList = new LinkedList<Integer>();
		currentAsSet = new HashSet<Integer>();

		initialize();

	}

	private void initialize() {

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

		// Add all constraints to a list of constraints to be visited
		List<Integer> constraintsToBeVisited = new ArrayList<Integer>();
		for (int i = 0; i < numberOfConstraints; i++) {
			constraintsToBeVisited.add(i);
		}

		// Sort this list in ascending order
		Collections.sort(constraintsToBeVisited, comparator);

		// Find the strongly connected components
		marks = new boolean[numberOfConstraints];  // Set all marks to false
		whichStronglyConnectedComponent = new int[numberOfConstraints];
		stronglyConnectedComponents = new ArrayList<>();
		depthFirstSearchComponents(constraintsToBeVisited);

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
		if (!currentAsSet.contains(index)) {
			pending.add(index);
		}
	}

	@Override
	public int extract() {
		assert (!isEmpty());
		numberOfExtractions += 1;
		if(currentAsList.isEmpty()) {
			int minPending = Collections.min(pending, comparator);
			int SCCIndexOfMinPending = whichStronglyConnectedComponent[minPending];
			currentAsSet = new HashSet<>(stronglyConnectedComponents.get(SCCIndexOfMinPending));
			currentAsList.addAll(currentAsSet);
			Collections.sort(currentAsList, comparator);
			pending.removeAll(currentAsSet);
		}
		int removed = currentAsList.remove(0);
		currentAsSet.remove(removed);
		return removed;
	}

	@Override
	public boolean isEmpty() {
		return currentAsList.isEmpty() && pending.isEmpty();
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
		return "current=" + currentAsList + ", pending=" + pending + ", size=" + (currentAsList.size() + pending.size());
	}

	public int[] getOrder() {
		return order;
	}
}

