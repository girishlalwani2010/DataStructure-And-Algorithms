package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Djikistra {

	// Java implementation of Dijkstra's Algorithm
	// using Priority Queue
	private int dist[];
	private Set<Integer> visited;
	private PriorityQueue<NodeWithCost> pq;
	private int V; // Number of vertices
	List<List<NodeWithCost>> adj;

	public Djikistra(int V) {
		this.V = V;
		dist = new int[V];
		visited = new HashSet<Integer>();
		pq = new PriorityQueue<NodeWithCost>(V, new NodeWithCost());
	}

	// Function for Dijkstra's Algorithm
	public void dijkstra(List<List<NodeWithCost>> adj, int src) {
		this.adj = adj;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		pq.add(new NodeWithCost(src, 0));
		dist[src] = 0;
		while (!pq.isEmpty()) {
			int u = pq.poll().node;
			visited.add(u);
			traverseNeighbours(u);
		}
	}

	// Function to process all the neighbours
	// of the passed node
	private void traverseNeighbours(int source) {
		for (NodeWithCost nodeWithCost : adj.get(source)) {
			if (!visited.contains(nodeWithCost.node)) {
				int edgeDistance = nodeWithCost.cost;
				int newDistance = dist[source] + edgeDistance;
				// If new distance is cheaper in cost
				if (newDistance < dist[nodeWithCost.node]) {
					dist[nodeWithCost.node] = newDistance;
					// need to use decreaseKey operation in custom implementation of Min Heap as priority does not allow to change its object, as if it allowed we will corrupt its get implementation
					// as it also runs based on hashcode, it used to set the entry based on hashcode.
					pq.add(new NodeWithCost(nodeWithCost.node, dist[nodeWithCost.node]));
				}
				
			}
		}
	}

	// Driver code
	public static void main(String arg[]) {
		int V = 5;
		int source = 0;

		// Adjacency list representation of the
		// connected edges
		List<List<NodeWithCost>> adj = new ArrayList<List<NodeWithCost>>();

		// Initialize list for every node
		for (int i = 0; i < V; i++) {
			List<NodeWithCost> item = new ArrayList<NodeWithCost>();
			adj.add(item);
		}

		// Inputs for the DPQ graph
		Djikistra djikistra = new Djikistra(V);

		// Calculate the single source shortest path
		Djikistra dpq = new Djikistra(V);
		adj.get(0).add(new NodeWithCost(1, 9));
		adj.get(0).add(new NodeWithCost(2, 6));
		adj.get(0).add(new NodeWithCost(3, 5));
		adj.get(0).add(new NodeWithCost(4, 3));

		adj.get(2).add(new NodeWithCost(1, 2));
		adj.get(2).add(new NodeWithCost(3, 4));
		dpq.dijkstra(adj, source);

		// Print the shortest path to all the nodes
		// from the source node
		System.out.println("The shorted path from node :");
		for (int i = 0; i < dpq.dist.length; i++)
			System.out.println(source + " to " + i + " is " + dpq.dist[i]);
	}
}

// Class to represent a node in the graph
