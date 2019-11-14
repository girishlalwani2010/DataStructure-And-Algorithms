package leetcode.amz;

public class NumberOfIslands {
	
	private static void dfs(char[][] grid, int i, int j) {
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') {
			return;
		}
		
		grid[i][j] = '0';
		
		dfs(grid,i-1,j);
		dfs(grid,i+1,j);
		dfs(grid,i,j-1);
		dfs(grid,i,j+1);
		
	}
	
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
		      return 0;
		    }
		int islands =0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					islands++;
					dfs(grid,i,j);
				}
			}
		}
		return islands;
    }

	public static void main(String[] args) {
		char[][] gridMap = {{'1','1','1','1','0'},
							{'1','1','0','1','0'},
							{'1','1','0','0','0'},
							{'0','0','0','0','0'}};	
		
		System.out.println(numIslands(gridMap));
	}

}
