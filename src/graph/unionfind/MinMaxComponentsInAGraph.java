package graph.unionfind;

import java.util.Arrays;

/**
 * @author girish_lalwani
 * https://www.hackerrank.com/challenges/components-in-graph/problem
 */

class UnionFind{
	
	private int[] id;
	public int[] size;
	
	public UnionFind(int n){
		id = new int[n+1];
		size = new int[n+1];
		for(int i=1; i<n+1; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int i) {
		while(i!=id[i]) {
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if(rootP == rootQ) {
			return;
		}
		if(size[p]<size[q]) {
			id[rootP] = rootQ;
			size[rootQ]+=size[rootP];
		}else {
			id[rootQ] = rootP;
			size[rootP]+=size[rootQ];
		}
	}
	
}

public class MinMaxComponentsInAGraph {
	
	public static void main(String[] args) {
		int[][] gb = {{1,6},{2,7},{3,8},{4,9},{2,6}};
		int[] minMax = componentsInGraph(gb);
		System.out.println(Arrays.toString(minMax));
	}
	
	private static int[] componentsInGraph(int[][] gb) {
		UnionFind uf = new UnionFind(gb.length*2);
		for(int i=0; i<gb.length; i++) {
			uf.union(gb[i][0], gb[i][1]);
		}
		
		int end = uf.size.length;
		
		int min=gb.length*2+1, max=0;
		for(int i=1; i<end; i++) {
			if(uf.size[i] <=1) {
				continue;
			}
			min = Math.min(uf.size[i], min);
			max = Math.max(uf.size[i], max);
		}
		
		int[] result = {min, max};
		return result;
    }
		

}
