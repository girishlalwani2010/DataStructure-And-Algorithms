package graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {
	
	private int V;
	private List<List<Integer>> adj;
	
	public UndirectedGraph(int V){
		this.V = V;
		this.adj = new ArrayList<>(V);
		for(int i=0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	public List<Integer> adj(int V) {
		return adj.get(V);
	}
	
	public int V() {
		return V;
	}

}
