package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author girish_lalwani
 *Implemented Using Topological Sort
 */
public class SequenceReconstruction {

	Stack<Integer> stack = new Stack<>();
	
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		
		List<Set<Integer>> adj = new ArrayList<>();
		for(int i=0; i<org.length+1; i++) {
			adj.add(new HashSet<Integer>());
		}
		
		int noOfEdges=0;
		for(List<Integer> intList: seqs) {
			int i=0;
			while(i<intList.size()-1) {
				int v = intList.get(i);
				int u = intList.get(i+1);
				adj.get(v).add(u);
				noOfEdges++;
				i++;
			}
		}
		
		if(noOfEdges != org.length) {
			return false;
		}
		
		Set<Integer> visited = new HashSet<>();
		for(int i:org) {
			if(!visited.contains(i)) {
				dfs(i, adj, visited);
			}
		}
		
		int i=0;
		while(!stack.isEmpty()) {
			if(stack.pop() != org[i]) {
				return false;
			}
				i++;
		}
		
		return true;
	}
	
	public void dfs(int source, List<Set<Integer>> adj, Set<Integer> visited){
		visited.add(source);
		for(int i:adj.get(source)) {
			if(!visited.contains(i)) {
				dfs(i, adj, visited);
			}
		}
		stack.push(source);
	}
	
	public static void main(String[] args) {
		SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
		int[] org = {4,1,5,2,6,3};
		List<List<Integer>> seqs = new ArrayList<>();
		seqs.add(Arrays.asList(5,2,6,3));
		seqs.add(Arrays.asList(4,1,5,2));
		System.out.println(sequenceReconstruction.sequenceReconstruction(org, seqs));
	}

}
