package datastructure.recursion.backtracking.dfs.bfs.divideandconquer;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		int numberOfIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					numberOfIslands++;
					dfs(grid, i, j);
				}
			}
		}
		return numberOfIslands;
	}

	public void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
			return;
		}
		//needed for internal dfs recursion
		// with four steps dfs(grid, i + 1, j); dfs(grid, i - 1, j); dfs(grid, i, j + 1); dfs(grid, i, j - 1);
		if (grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

	public static void main(String[] args) {

	}

}
