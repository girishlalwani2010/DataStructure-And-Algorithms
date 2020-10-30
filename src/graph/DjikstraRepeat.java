package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DjikstraRepeat {
	
	private Map<Integer, List<NodeWithCost>> adjList;
	private int source;
	
	public DjikstraRepeat(int V, int[][] edges, int source) {
		adjList = new HashMap<>();
		for(int[] edge : edges) {
			List<NodeWithCost> neis = adjList.getOrDefault(edge[0], new ArrayList<NodeWithCost>());
			neis.add(new NodeWithCost(edge[1], edge[2]));
			adjList.put(edge[0], neis);
		}
		this.source=source;
		djikstraSPAlgo(source, adjList, V);
	}
	
	private void djikstraSPAlgo(int source, Map<Integer, List<NodeWithCost>> adjList, int vertices) {
		
		Queue<NodeWithCost> pq = new PriorityQueue<NodeWithCost>((a, b) -> {
			return a.cost - b.cost;
		});
		int[] dist = new int[vertices];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		NodeWithCost sourceNode = new NodeWithCost(source,0);
		pq.add(sourceNode);
		Set<NodeWithCost> visited = new HashSet<>();
		
		while(!pq.isEmpty()) {
			NodeWithCost u = pq.poll();
			visited.add(u);
			for(NodeWithCost v : adjList.getOrDefault(u.node, new ArrayList<NodeWithCost>())) {
				int costUV = v.cost;
				if(!visited.contains(v) && dist[u.node]+costUV<dist[v.node]) {
					dist[v.node] = dist[u.node]+costUV; 
					pq.add(new NodeWithCost(v.node, dist[v.node]));
				}
			}
		}
		
		System.out.println("Distance Array: "+Arrays.toString(dist));
	}
	
	public static void main(String[] args) {
		int V=5;
		int[][] edges = {{0,1,9},{0,2,6},{0,3,5},{0,4,3},{2,1,2},{2,3,4}};
		int source=0;
		DjikstraRepeat djikstraRepeat = new DjikstraRepeat(V, edges, source);
	}

}
