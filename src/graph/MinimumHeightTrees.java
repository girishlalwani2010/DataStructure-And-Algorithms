package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		if (edges.length == 0) {
			return Arrays.asList(0);
		}

		List<Integer> mHTRoots = new ArrayList<Integer>();
		if (edges.length == 1) {
			return Arrays.stream(edges[0]) // IntStream
					.boxed() // Stream<Integer>
					.collect(Collectors.toList());
		}

		int[] maxDist = new int[n];

		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			int[] dist = new int[n];
			if (adj.get(i).size() > 1) {
				bfs(i, adj, dist, visited, maxDist);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < maxDist.length; i++) {
			if (maxDist[i] != 0 && maxDist[i] < min) {
				min = maxDist[i];
			}
		}

		for (int i = 0; i < maxDist.length; i++) {
			if (maxDist[i] == min && maxDist[i] != 0) {
				mHTRoots.add(i);
			}
		}

		return mHTRoots;
	}

	public void bfs(int source, List<List<Integer>> adj, int[] dist, boolean[] visited, int[] maxDistFromSource) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : adj.get(node)) {
				if (!visited[i]) {
					dist[i] = 1 + dist[node];
					queue.add(i);
					visited[i] = true;
				}
			}
		}

		int max = dist[0];
		for (int i = 1; i < dist.length; i++) {
			if (max < dist[i]) {
				max = dist[i];
			}
		}
		maxDistFromSource[source] = max;
	}

	public List<Integer> findMinHeightTreesInONTime(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0);

		List<List<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; ++i)
			adj.add(new ArrayList<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();

		for (int i = 0; i < adj.size(); i++) {
			if (adj.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		while (n > 2) {
			n = n - leaves.size();
			List<Integer> nextLevelLeaves = new ArrayList<>();
			for (int i : leaves) {
				int j = adj.get(i).get(0);
				adj.get(j).remove(Integer.valueOf(i));
				if (adj.get(j).size() == 1) {
					nextLevelLeaves.add(j);
				}
			}
			leaves = nextLevelLeaves;
		}

		return leaves;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		// int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
		// int[][] edges = {{0,1},{0,2}};
		int n = 6;
		MinimumHeightTrees mHT = new MinimumHeightTrees();
		List<Integer> roots = mHT.findMinHeightTreesInONTime(n, edges);
		System.out.println(roots);
	}

}
