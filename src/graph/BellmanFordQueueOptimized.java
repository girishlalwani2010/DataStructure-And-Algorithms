package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author girish_lalwani
 *         https://boplets.com/2019/07/27/queue-optimized-bellman-ford-algorithm/
 *        
 *         This is Queue Optimized, but simple one is at 
 *         https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/BellmanFordShortestPath.java
 *         
 */
public class BellmanFordQueueOptimized {

	private int[] dist;
	private boolean[] inQ;
	//cnt[i] stores the edges used to relax vertex i and it is used to detect negative cycle.
	private int[] countOfEdgesToVertex;
	private List<NodeWithCost>[] adjacencyList;
	private LinkedList<Integer> q;
	private int vertices;
	
	@SuppressWarnings("unchecked")
	public BellmanFordQueueOptimized(int[][] edges, int vertices, int source){
		this.vertices = vertices;
		this.dist = new int[vertices+1];
		this.inQ = new boolean[vertices+1];
		this.countOfEdgesToVertex = new int[vertices+1];
		this.q = new LinkedList<>();
		adjacencyList = new ArrayList[vertices+1];
		for(int i=1; i<vertices+1; i++) {
			adjacencyList[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int[] edge : edges) {
			adjacencyList[edge[0]].add(new NodeWithCost(edge[1], edge[2]));
		}
	}

	public void bellmanFordQueueBased(int source) {
		inQ[source] = true;
		dist[source] = 0;
		q.offer(source);
		while (!q.isEmpty()) {
			int relaxingVertex = q.poll();
			inQ[relaxingVertex] = false;
			for (NodeWithCost nei : adjacencyList[relaxingVertex]) {
				if (dist[nei.node] > nei.cost + dist[relaxingVertex]) {
					dist[nei.node] = nei.cost + dist[relaxingVertex];
					
					/****** For Negative Cycle Detection **********/
					countOfEdgesToVertex[nei.node] =  countOfEdgesToVertex[relaxingVertex]+1;
					if(countOfEdgesToVertex[nei.node]>this.vertices-1) {
						System.out.println("No Solution - Negative Cycle Detected");
						return;
					}
					/****** For Negative Cycle Detection **********/
					
					if (!inQ[nei.node]) {
						inQ[nei.node] = true;
						q.offer(nei.node);
					}
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}

	public static void main(String[] args) {
		int vertices = 4;
//		int[][] edges = {{1,2,1},{2,3,4},{1,3,10},{3,4,3}};
		int[][] edges = {{2,1,-10},{1,5,5},{1,4,-1},{5,2,2},{2,3,-1}};
		BellmanFordQueueOptimized bellmanFordQueueOptimized = new BellmanFordQueueOptimized(edges,5, 1);
		bellmanFordQueueOptimized.bellmanFordQueueBased(1);
	}

}
