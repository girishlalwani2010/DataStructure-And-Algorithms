package graph.unionfind;

public class NumberOfIslands {
	
	class QuickUnionWeighted{
		private int[] parent;
		private int[] size;
		public int noOfDisConnectedComponents;
		
		public QuickUnionWeighted(char[][] grid) {
			 int rows = grid.length;
			 int cols = grid[0].length;
			 parent = new int[cols*rows];
			 size = new int[cols*rows];
			 noOfDisConnectedComponents=0;
			 for(int i=0; i<grid.length; i++) {
				 for(int j=0; j<grid[0].length; j++) {
					 if(grid[i][j] == '1') {
						 parent[i*cols + j] = i*cols + j;
						 size[i*cols + j] = 1;
						 noOfDisConnectedComponents++;
					 }
				 }
			 }
		}
		
		public int root(int node) {
			while(node!=parent[node]) {
				node = parent[node];
				//for path compression
				//parent[node] = parent[parent[node]];
				//node = parent[node];
			}
			return node;
		}
		
		public void union(int p, int q) {
			int pRoot = root(p);
			int qRoot = root(q);
			
			
			if(pRoot == qRoot) return;
			
			System.out.println("Connecting :"+"P{"+p+"to Q{"+q);

			if(size[pRoot] < size[qRoot]) {
				parent[pRoot] = qRoot;
				size[pRoot] += size[qRoot];
			}else {
				parent[qRoot] = pRoot;
				size[pRoot] += size[qRoot];
			}
			noOfDisConnectedComponents--;
		}
		
	}
	
	public int numIslands(char[][] grid) {
		
		if(grid.length ==0) {
			 return 0;
		}
		
		QuickUnionWeighted quickUnionWeighted = new QuickUnionWeighted(grid);
		int cols = grid[0].length;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<cols; j++) {
				if(grid[i][j] == '1') {
					if(i-1>=0 && grid[i-1][j]=='1') {
						quickUnionWeighted.union(i*cols + j, (i-1)*cols + j);
					}
					if(i+1<grid.length && grid[i+1][j]=='1') {
						quickUnionWeighted.union(i*cols + j, (i+1)*cols + j);
					}
					if(j-1>=0 && grid[i][j-1]=='1') {
						quickUnionWeighted.union(i*cols + j, i*cols + (j-1));
					}
					if(j+1<grid[0].length && grid[i][j+1]=='1') {
						quickUnionWeighted.union(i*cols + j, i*cols + (j+1));
					}
				}
			}
		}
		return quickUnionWeighted.noOfDisConnectedComponents;
	}
	
	
	
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1'},
						 {'0','1','0'},
						 {'1','1','1'}};
		
		NumberOfIslands numberOfIslands = new NumberOfIslands();
		System.out.println(numberOfIslands.numIslands(grid));
		
	}

}
