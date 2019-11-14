package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author girish_lalwani
 *
 *         https://www.geeksforgeeks.org/bipartite-graph/
 *
 *         Two Color Graph Problem.
 */
public class IsGraphBipartite {

	/**
	 * @param graph
	 * @return
	 * 
	 * 		Using BFS as it looks first way
	 */
	public boolean isBipartite(int[][] graph) {
		List<Integer>[] adjList = new ArrayList[graph.length];

		for (int i = 0; i < graph.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int[] color = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				adjList[i].add(graph[i][j]);
			}
		}

		for (int i = 0; i < graph.length; i++) {

			if (color[i] != 0 || graph[i].length == 0) // same like visited to avoid stack overflow
				continue;

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(i);
			color[i] = 1; // Blue: 1; Red: -1.

			while (!queue.isEmpty()) {
				int polledNode = queue.poll();
				for (int j : adjList[polledNode]) {
					if (color[j] == color[polledNode]) {
						return false;
					}
					if (color[j] == 0) { // If this node hasn't been colored;
						color[j] = -color[polledNode]; // Color it with a different color;
						queue.add(j);
					}
				}
			}
		}

		return true;
	}

	// dfs way need to be implemented
	// Recursive Implementation at
	// https://www.geeksforgeeks.org/check-if-a-given-graph-is-bipartite-using-dfs/
	public boolean isBipartiteUsingDFS(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		Arrays.fill(color, -1);

		for (int start = 0; start < n; ++start) {
			if (color[start] == -1) {
				Stack<Integer> stack = new Stack();
				stack.push(start);
				color[start] = 0;

				while (!stack.empty()) {
					Integer node = stack.pop();
					for (int nei : graph[node]) {
						if (color[nei] == -1) {
							stack.push(nei);
							color[nei] = color[node] ^ 1;
						} else if (color[nei] == color[node]) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public boolean isBipartiteRecursive(int[][] graph) {
		List<Integer>[] adjList = new ArrayList[graph.length];

		for (int i = 0; i < graph.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int[] color = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				adjList[i].add(graph[i][j]);
			}
		}
		boolean[] visited = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				if (!dfs(adjList, color, i, visited, color[i]))
					return false;
			}
		}

		return true;
	}

	public boolean dfs(List<Integer>[] adjList, int[] color, int source, boolean[] visited, int parentColor) {
		visited[source] = true;
		if (color[source] == 0) {
			color[source] = -parentColor;
		}
		for (int neighBour : adjList[source]) {
			if (!visited[neighBour] && !dfs(adjList, color, neighBour, visited, color[source])) {
				return false;
			} else {
				if (color[neighBour] == color[source])
					return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {

	}

}
