package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import graph.unionfind.WeightedQuickUnionUFWithPathCompression;

class Edge {
	public int source;
	public int dest;
	public int weight;

	Edge(int source, int dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", dest=" + dest + ", weight=" + weight + "]";
	}

}

public class KruskalAlgorithm {

	public List<Edge> kruskalMST(List<Edge> edges, int V) {
		List<Edge> mst = new ArrayList<>();
		Queue<Edge> q = new PriorityQueue<>((a,b) -> a.weight-b.weight)  ;
		for (Edge e : edges) {
			q.offer(e);
		}
		WeightedQuickUnionUFWithPathCompression weightedQuickUnionUFWithPathCompression = 
				new WeightedQuickUnionUFWithPathCompression(V);
		while (!q.isEmpty() && mst.size() < V - 1) {
			Edge edge = q.poll();
			if(weightedQuickUnionUFWithPathCompression.connected(edge.source, edge.dest)) {
				continue;
			}
			weightedQuickUnionUFWithPathCompression.union(edge.source, edge.dest);
			mst.add(edge);
		}
		return mst;
	}

	public static void main(String[] args) {
		// input preparation input to the function will be List<Edge> or graph[][3], 3
		// is or src, dest, and weight.
		Edge edge1 = new Edge(0, 1, 10);
		Edge edge2 = new Edge(1, 3, 15);
		Edge edge3 = new Edge(3, 2, 4);
		Edge edge4 = new Edge(2, 0, 6);
		Edge edge5 = new Edge(0, 3, 5);

		List<Edge> edges = new ArrayList<>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);

		KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
		List<Edge> mst = kruskalAlgorithm.kruskalMST(edges, 4);
		for (Edge edge : mst) {
			System.out.println(edge);
		}
	}
}
