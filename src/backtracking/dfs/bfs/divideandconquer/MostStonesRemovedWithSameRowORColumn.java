package backtracking.dfs.bfs.divideandconquer;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowORColumn {

	public int removeStones(int[][] stones) {
		Set<int[]> visited = new HashSet<int[]>();
		int numberOfIslands = 0;
		for(int[] s1 : stones) {
			if(!visited.contains(s1)) {
				dfs(stones,s1,visited);
				numberOfIslands++;
			}
		}
		return stones.length - numberOfIslands;
	}
	
	public void dfs(int[][] stones, int[] startingStone, Set<int[]> visited) {
		visited.add(startingStone);
		for(int[] s2 : stones) {
			if(!visited.contains(s2)) {
				if((startingStone[0] == s2[0]) || (startingStone[1] == s2[1])) {
					dfs(stones,s2,visited);
				}
			}
		}
	}


	//can be done using union-find as well.
	
    public int removeStonesUsingUF(int[][] stones) {
        int len = stones.length;
        int[] parent = new int[len];
        int[] size = new int[len];
        
        for (int i = 0; i < len; i++){
            parent[i] = i;
            size[i] =1;
        }
        
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j, parent, size);
                }
            }
        }
        
        int count = 0;
        
        // no of disconnected components are which have parent[i] == i
        for (int i = 0; i < len; i++){
            if (parent[i] == i) count++;
        }
        
        return len - count;
    }
    private void union(int x, int y, int[] parent,int[] size){
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) return;
        if(size[x]>size[y]) {
        	size[x] += size[y];
        	parent[y] = x;
        }else {
        	size[y] += size[x];
        	parent[x] = y;
        }
    }
    
    private int find(int x, int[] parent){
        while(x!=parent[x]) {
        	parent[x] = parent[parent[x]];
        	x=parent[x];
        }
        return x;
    }
	
}
