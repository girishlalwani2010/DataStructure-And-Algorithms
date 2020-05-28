package graph;

import java.util.Arrays;

class WeightedUnionFind{
	private int[] parent;
	private int[] size;
	
	WeightedUnionFind(int vertices){
		parent= new int[vertices];
		size = new int[vertices];
		for(int i=0; i<vertices; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	// it will give me ancestor's ancestor's root 
	
	public int find(int i) {
		while(i != parent[i]) {
			parent[i]=parent[parent[i]];// path compression
			i = parent[i];
		}
		return i;
	}
	
	public boolean union(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);
		if(rootU == rootV) {
			return true;
		}
		if(size[rootU]>size[rootV]) {
			parent[rootV] = rootU;
			size[rootU] += size[rootV];
		}else {
			parent[rootU] = rootV;
			size[rootV] += size[rootU];
		}
		return false;
	}
	
}

public class RedundantConnection {
	public static int[] findRedundantConnection(int[][] edges) {
		WeightedUnionFind weightedUnionFind = new WeightedUnionFind(edges.length+1);
		for(int i=0; i<edges.length; i++) {
			boolean isAlreadyConnected = weightedUnionFind.union(edges[i][0],edges[i][1]);
			if(isAlreadyConnected) {
				return edges[i];
			}
		}
		return new int[]{-1,-1};
	}

	public static void main(String[] args) {
		//int edges[][] = {{1,2}, {1,3}, {2,3}};
		int edges[][] = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}

}
