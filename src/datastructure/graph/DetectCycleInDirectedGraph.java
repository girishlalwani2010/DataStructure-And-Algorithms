package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author girish_lalwani
 *
 *One more way of doing it using gray-set, black-set, white-set.
 *https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/CycleInDirectedGraph.java
 */
public class DetectCycleInDirectedGraph {

	private final int V;
	private final List<List<Integer>> adj;

	public DetectCycleInDirectedGraph(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	public boolean dfs(int i, boolean[] visited, boolean[] recStack) {
		recStack[i] = true;
		visited[i] = true;
		for (int neighbour : adj.get(i)) {
			if (!visited[neighbour] && dfs(neighbour, visited, recStack)) {
				return true;
			} else if (recStack[neighbour]) {
				return true;
			}
		}
		recStack[i] = false;// reset recStack so will not true in another DFS call for another vertex called
							// from isCyclic.
		return false;
	}

	/**
	 * @return
	 * 
	 * 		STACK to store the path of vertexes in DFS, if there is vertex again
	 *         found while exploring DFS then there is a cycle otherwise will
	 *         backtrack and remove that value from stack, and explore remaining
	 *         children of parent.
	 */
	private boolean isCyclic() {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		// Stack
		boolean[] recStack = new boolean[V];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++)
			if (!visited[i] && dfs(i, visited, recStack))
				return true;

		return false;
	}

	public static void main(String[] args) {
		DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}

}
