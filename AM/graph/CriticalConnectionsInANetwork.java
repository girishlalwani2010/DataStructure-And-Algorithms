package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 
 {
	List<List<Integer>> result = new ArrayList<>();
	int time = 0;
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> graph = new ArrayList<>();
		for (List<Integer> connection : connections) {
			graph.add(new ArrayList<>());
		}
		for (List<Integer> connection : connections) {
			graph.get(connection.get(0)).add(connection.get(1));
			graph.get(connection.get(1)).add(connection.get(0));
		}
		boolean[] visited = new boolean[graph.size()];
		int[] parent = new int[graph.size()];
		Arrays.fill(parent, -1);
		int[] dist = new int[graph.size()];
		int[] low = new int[graph.size()];
		for (int source = 0; source < graph.size(); source++) {
			if (!visited[source]) {
				dfs(source, visited, graph, parent, dist, low);
			}
		}
		return result;
	}
	public void dfs(int source, boolean[] visited, List<List<Integer>> graph, int[] parent, int[] dist, int[] low) {
		visited[source] = true;
		dist[source] = low[source] = ++time;
		for (int nei : graph.get(source)) {
			 // If v is not visited yet, then make it a child 
            // of u in DFS tree and recur for it. 
            // If v is not visited yet, then recur for it 
			if (!visited[nei]) {
				parent[nei] = source;
				dfs(nei, visited, graph, parent, dist, low);
				// Take u-v is a connection
				// Check if the subtree rooted with v has a 
                // connection to one of the ancestors of u 
				low[source] = Math.min(low[source], low[nei]);
				// If the lowest vertex reachable from subtree 
                // under v is below u in DFS tree, then u-v is 
                // a bridge 
				if (dist[source] < low[nei]) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(source);
					list.add(nei);
					result.add(list);
				}
			}
			// Update low value of u for parent function calls. 
			else if (nei != parent[source]) {
				low[source] = Math.min(low[source], dist[nei]);
			}
		}
	}
}
