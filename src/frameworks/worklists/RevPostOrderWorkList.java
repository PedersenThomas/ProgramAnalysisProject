package frameworks.worklists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import frameworks.IWorklist;
import frameworks.MonotoneFramework;
import graph.FlowGraph;

public class RevPostOrderWorkList implements IWorklist {
	private List<Integer> current = new ArrayList<Integer>();
	private List<Integer> pending = new ArrayList<Integer>();
	// Constraint -> Order
	private HashMap<Integer, Integer> order = new HashMap<Integer, Integer>();
	
	private int numberOfInserts = 0;
	private int numberOfExtracts = 0;
	
	public RevPostOrderWorkList(FlowGraph flowgraph, MonotoneFramework framework) {
		Stack<Integer> constraints = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		List<Set<Integer>> graph = framework.getInfluenceList();
		
		constraints.add(0);
		
		while(!constraints.isEmpty()) {
			Integer currentConstraint = constraints.pop();
			order.put(currentConstraint, order.size());
			
			ArrayList<Integer> constraintsIds = new ArrayList<Integer>(graph.get(currentConstraint));
			
			for (Integer constraintID : constraintsIds) {
				order.put(currentConstraint, order.size());
			}
			
//			for (Integer constraint : constraints) {
//				System.out.println("Label: " + currentLabel + " Constraint: " + constraint);
//				order.put(constraint, order.size());
//			}

			for(Integer constraint: constraintsIds) {
				if(!visited.contains(constraint)) {
					visited.add(constraint);
					constraints.push(constraint);
				}
			}
		}
		System.out.println("Order: " + this.order);
	}
	
	@Override
	public void insert(int index) {
		numberOfInserts += 1;
		pending.add(index);
	}

	private List<Integer> sort(List<Integer> data, HashMap<Integer, Integer> ordering) {
		List<Integer> result = new ArrayList<Integer>(data);
		Collections.sort(result, new Comparator<Integer>() {
	        @Override
	        public int compare(Integer c1, Integer c2) {
	        	Integer l1 = order.get(c1);
	        	Integer l2 = order.get(c2);
	            return l1 == l2 ? c1.compareTo(c2) : l1.compareTo(l2);
	        }
	    });
		
		return result;
	}
	
	@Override
	public int extract() {
		numberOfExtracts += 1;
		if(current.isEmpty()) {
			current = sort(this.pending, this.order);
			this.pending.clear();
		}
		
		return current.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return current.isEmpty() && pending.isEmpty();
	}

	@Override
	public String getName() {
		return "Reverse Post-Order Worklist";
	}

	@Override
	public int getNumberOfInsertions() {
		return numberOfInserts;
	}

	@Override
	public int getNumberOfExtracts() {
		return numberOfExtracts;
	}
}
