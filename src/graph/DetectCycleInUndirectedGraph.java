package graph;

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list 
// representation 
class DetectCycleInUndirectedGraph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation

	// Constructor
	DetectCycleInUndirectedGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * @param v
	 * @param visited
	 * @param parent
	 * @return
	 * // A recursive function that uses visited[] and parent to detect
	// cycle in subgraph reachable from vertex v.
	 * 
	 *  In case of example graph 0---1
	 *  						 |	 |
			                     3---2	
			                     
	*	when will be in DFS at 1 we already visited 0, so will not do DFS, for 0 again, and simply check parent of 1, 
	*	as we have not DFS for 1-0 , So check is (parent of 1) i.e. 0 is equal to i (i.e. 0) it returns false.
	*   it means from where we are coming at 1 (i.e. 0-1), we are checking that path only, and hence this is not the cyclic condition
	*   and if this is not the case, then there is cycle, i.e. (i != parent), for example while doing DFS of 3, we know that 
	*   0 is already visited, so will not call it's DFS will simply check that i (i.e. 0) is equal to 2 (i.e. parent of 3), 
	*   ans is not, that means we can reach to three from more than one places in a graph, hence it has cycle.  
	*	 	                     
	 */
	boolean isCyclicUtil(int v, boolean[] visited, int parent) {
		visited[v] = true;
		for (int i : adj[v]) {
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v))// v = parent, parent will be same for all its neighbours
					return true;
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	boolean isCyclic() {
		// Mark all the vertices as not visited and not part of
		// recursion stack
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to detect cycle in
		// different DFS trees	
		for (int u = 0; u < V; u++)
			if (!visited[u]) // Don't recur for u if already visited
				if (isCyclicUtil(u, visited, -1))
					return true;

		return false;
	}

	// Driver method to test above methods
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		DetectCycleInUndirectedGraph g1 = new DetectCycleInUndirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		DetectCycleInUndirectedGraph g2 = new DetectCycleInUndirectedGraph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
