package frameworks.worklists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import frameworks.IMonotoneFramework;
import frameworks.IWorklist;
import graph.FlowGraph;

public class RevPostOrderWorkList implements IWorklist {
	private List<Integer> current = new ArrayList<Integer>();
	private List<Integer> pending = new ArrayList<Integer>();
	// Constraint -> Label
	private HashMap<Integer, Integer> order = new HashMap<Integer, Integer>();
	
	public RevPostOrderWorkList(FlowGraph flowgraph, IMonotoneFramework framework) {
		Stack<Integer> labels = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		labels.add(FlowGraph.StartLabel);
		labels.add(-1);
		while(!labels.isEmpty()) {
			Integer currentLabel = labels.pop();
			List<Integer> constraints = framework.LabelMapToConstraints(currentLabel);
			Collections.sort(constraints);
			for (Integer constraint : constraints) {
				order.put(constraint, currentLabel);
			}
			System.out.println("Order: " + this.order);
			for(Integer label: flowgraph.getNodeOutNodes(currentLabel)) {
				if(!visited.contains(label)) {
					visited.add(label);
					labels.push(label);
				}
			}
		}
	}
	
	@Override
	public void insert(int index) {
		pending.add(index);
	}

	private List<Integer> sort(List<Integer> data, HashMap<Integer, Integer> ordering) {
		List<Integer> result = new ArrayList<Integer>(data);
		Collections.sort(result, new Comparator<Integer>() {
	        @Override
	        public int compare(Integer c1, Integer c2) {
	        	Integer l1 = order.get(c1);
	        	Integer l2 = order.get(c2);
	            return l1 == l2 ? c1.compareTo(c2) : l1.compareTo(c2);
	        }
	    });
		
		return result;
	}
	
	@Override
	public int extract() {
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
}
