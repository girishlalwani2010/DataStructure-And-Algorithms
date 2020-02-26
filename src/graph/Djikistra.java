package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Djikistra {
	
	class NodeWithCost implements Comparator<NodeWithCost> { 
		public int node; 
		public int cost; 

		public NodeWithCost() 
		{ 
		} 

		public NodeWithCost(int node, int cost) 
		{ 
			this.node = node; 
			this.cost = cost; 
		} 

		@Override
		public int compare(NodeWithCost node1, NodeWithCost node2) 
		{ 
			if (node1.cost < node2.cost) 
				return -1; 
			if (node1.cost > node2.cost) 
				return 1; 
			return 0; 
		} 
	} 
	
	// Java implementation of Dijkstra's Algorithm 
	// using Priority Queue 
		private int dist[]; 
		private Set<Integer> settled; 
		private PriorityQueue<NodeWithCost> pq; 
		private int V; // Number of vertices 
		List<List<NodeWithCost> > adj; 

		public Djikistra(int V) 
		{ 
			this.V = V; 
			dist = new int[V]; 
			settled = new HashSet<Integer>(); 
			pq = new PriorityQueue<NodeWithCost>(V, new NodeWithCost()); 
		} 

		// Function for Dijkstra's Algorithm 
		public void dijkstra(List<List<NodeWithCost> > adj, int src) 
		{ 
			this.adj = adj; 

			for (int i = 0; i < V; i++) 
				dist[i] = Integer.MAX_VALUE; 

			// Add source node to the priority queue 
			pq.add(new NodeWithCost(src, 0)); 

			// Distance to the source is 0 
			dist[src] = 0; 
			while (settled.size() != V) { 

				// remove the minimum distance node 
				// from the priority queue 
				int u = pq.remove().node; 

				// adding the node whose distance is 
				// finalized 
				settled.add(u); 

				e_Neighbours(u); 
			} 
		} 

		// Function to process all the neighbours 
		// of the passed node 
		private void e_Neighbours(int u) 
		{ 
			int edgeDistance = -1; 
			int newDistance = -1; 

			// All the neighbors of v 
			for (int i = 0; i < adj.get(u).size(); i++) { 
				NodeWithCost v = adj.get(u).get(i); 

				// If current node hasn't already been processed 
				if (!settled.contains(v.node)) { 
					edgeDistance = v.cost; 
					newDistance = dist[u] + edgeDistance; 

					// If new distance is cheaper in cost 
					if (newDistance < dist[v.node]) 
						dist[v.node] = newDistance; 

					// Add the current node to the queue 
					pq.add(new NodeWithCost(v.node, dist[v.node])); 
				} 
			} 
		} 

		// Driver code 
		public static void main(String arg[]) 
		{ 
			int V = 5; 
			int source = 0; 

			// Adjacency list representation of the 
			// connected edges 
			List<List<NodeWithCost> > adj = new ArrayList<List<NodeWithCost> >(); 

			// Initialize list for every node 
			for (int i = 0; i < V; i++) { 
				List<NodeWithCost> item = new ArrayList<NodeWithCost>(); 
				adj.add(item); 
			} 

			// Inputs for the DPQ graph 
			Djikistra djikistra = new Djikistra(V);
			

			// Calculate the single source shortest path 
			Djikistra dpq = new Djikistra(V); 
			adj.get(0).add(dpq.new NodeWithCost(1, 9)); 
			adj.get(0).add(dpq.new NodeWithCost(2, 6)); 
			adj.get(0).add(dpq.new NodeWithCost(3, 5)); 
			adj.get(0).add(dpq.new NodeWithCost(4, 3)); 

			adj.get(2).add(dpq.new NodeWithCost(1, 2)); 
			adj.get(2).add(dpq.new NodeWithCost(3, 4)); 
			dpq.dijkstra(adj, source); 

			// Print the shortest path to all the nodes 
			// from the source node 
			System.out.println("The shorted path from node :"); 
			for (int i = 0; i < dpq.dist.length; i++) 
				System.out.println(source + " to " + i + " is "
								+ dpq.dist[i]); 
		} 
	} 

	// Class to represent a node in the graph 
	

