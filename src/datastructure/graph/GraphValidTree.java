package datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

	private List<List<Integer>> adj;

	public boolean validTree(int n, int[][] edges) {

		adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		boolean[] visited = new boolean[n];

		if (!dfs(0, -1, visited)) {
			return false;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	public boolean dfs(int start, int parent, boolean[] visited) {

		visited[start] = true;
		for (int nei : adj.get(start)) {
			if (!visited[nei]) { // if not visited
				if (!dfs(nei, start, visited)) { // if parent!=nei
					return false;
				}
			} else if (nei != parent) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		GraphValidTree gvt = new GraphValidTree();
		int n = 2;
		int[][] edges = { { 1, 0 } };
		System.out.println(gvt.validTree(n, edges));

	}

}