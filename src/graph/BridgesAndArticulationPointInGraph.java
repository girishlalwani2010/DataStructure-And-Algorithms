package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author girish_lalwani
 *         https://leetcode.com/problems/sentence-similarity-ii/solution/
 */
public class BridgesAndArticulationPointInGraph {

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

	/**
	 * @param parent,
	 *            make it for back edge check
	 * @param discoveredTime,
	 *            time at which node is discovered.
	 * @param lowest,
	 *            lowest node discovered time reachable from this node.
	 */
	public void dfs(int source, boolean[] visited, List<List<Integer>> graph, int[] parent, int[] discoveredTime,
			int[] lowest) {
		visited[source] = true;
		discoveredTime[source] = time;
		lowest[source] = time;
		time++;
		for (int nei : graph.get(source)) {
			parent[nei] = source;
			if (!visited[nei]) {
				// Explore the node and assign new low and discovery time to it with
				// dist[source] = time, low[source] = time;
				dfs(nei, visited, graph, parent, discoveredTime, lowest);
				/*
				 * Run pending steps of parent recursion, if any lowest value is discovered in
				 * its DFS. Then update parent's low value with low value of nei.
				 */ lowest[source] = Math.min(lowest[source], lowest[nei]);
				/*
				 * After returning from child recursion, parent will check if its discovered
				 * value is greater than low value of nei. Then its a bridge. 
				 * Why as if it is a nei and is strongly connected with parent, then for sure nei's low value will
				 * be less than or equal to disc[source/parent], as it will be connected to any ancestor.
				 * So it will have lower or equal low[value] than disc[parent/source].
				 * Otherwise this is not a back-edge and there is only one path from
				 * source/parent to nei, and removing it will disconnect the graph into two
				 * components.Attached snap for it /DataStructureAlgorithms/src/graph/IMG-8226.jpg
				 */
				if (discoveredTime[source] < lowest[nei]) {
					List<Integer> bridge = new ArrayList<>();
					bridge.add(source);
					bridge.add(nei);
					result.add(bridge);
				}
			} else if (parent[source] != nei) {
				lowest[source] = Math.min(lowest[source], discoveredTime[nei]);
			}
		}

	}
	
	/*findArticulationPoints(){
			same as above just need to replace two conditions  
			 if (parent[u] == NIL && children > 1) 
                    ap[u] = true; 
  
                // (2) If u is not root and low value of one of its child 
                // is more than discovery value of u. 
                if (parent[u] != NIL && low[v] >= disc[u]) 
                    ap[u] = true; 
                    
           Why as parent of node is null, then we started DFS from it so it must have two children.
           As we know articulation point is a point whose removal, will disconnect the graph into two components.
           and second condition will be same as bridge, above one.
           
           https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/            
                    
	}*/
}
