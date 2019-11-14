package backtracking.dfs.bfs.divideandconquer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindEventualSafeStates {
	
	Set<Integer> result =  new TreeSet<>();
	public List<Integer> eventualSafeNodes(int[][] graph) {
		Set<Integer> visited = new TreeSet<>();
		for(int i=0; i<graph.length; i++) {
			dfs(i,graph,new HashSet<Integer>());
		}
		return new ArrayList<Integer>(result);
    }
	
	private boolean dfs(int source,int[][] graph, Set<Integer> visited) {
		
		visited.add(source);
		if(graph[source].length == 0) {
			result.add(source);
			return true;
		}
		
		for(int neighbour: graph[source]) {
			if(!visited.contains(neighbour)) {
				 if(dfs(neighbour,graph,visited)) {
					 result.add(source);
				 }
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
	}

}
