package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author girish_lalwani Think can also be done using union find
 */
public class CriticalConnectionsInANetwork {
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
	 * @param source
	 * @param visited
	 * @param graph
	 * @param parent
	 * @param discoveredTime
	 * @param lowest
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
				// Run pending steps of parent recursion, if any lowest value is discovered in
				// its DFS. Then update parent's low value with low value of nei.
				lowest[source] = Math.min(lowest[source], lowest[nei]);
				// After returning from child recursion, parent will check if its discovered
				// value is less than low value of nei. Then its a bridge.
				// Why as if it is a nei and is strongly connected with parent, then for sure
				// nei's low value will be less than or equal to disc[source/parent], as it will
				// be connected to any ancestor.
				// So it will have lower or equal low[value] than disc[parent/source].
				// Otherwise this is not a back-edge and there is only one path from
				// source/parent to nei, and removing it will disconnect the graph into two
				// components.
				// Attached snap for it /DataStructureAlgorithms/src/graph/IMG-8226.jpg
				/**
				 * 0-----1
				 * |   / |
				 * | /   |
				 * 2-----3
				 * Consider above graph for above case if will go with (lowest[source] < lowest[nei])
				 * 2-3 will be the bridge. but ans should be black in this case, that's why we check discoveredTime[source] < lowest[nei]. 
				 * */
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
}
