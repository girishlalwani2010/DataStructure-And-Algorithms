package dp;

public class MinimumPathSum {

	// Bigger to smaller problem Recursion with memoization.
	private int minPathSum = Integer.MAX_VALUE;
	private int[][] memo;

	public int minPathSum(int[][] grid, int m, int n) {
		if (m == 0 && n == 0) {
			return grid[0][0];
		}

		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}

		if (memo[m][n] != -1) {
			return memo[m][n];
		}

		int topCost = minPathSum(grid, m - 1, n);
		int leftCost = minPathSum(grid, m, n - 1);

		memo[m][n] = Math.min(topCost, leftCost) + grid[m][n];
		return memo[m][n];
	}

	public int minPathSum(int[][] grid) {
		memo = new int[grid.length][grid[0].length];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = -1;
			}
		}
		return minPathSum(grid, grid.length - 1, grid[0].length - 1);
	}
	
	
	//DP way
	public int minPathSumUSingDP(int[][] grid) {

		for (int i = 1; i < grid.length; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			grid[0][i] = grid[0][i] + grid[0][i - 1];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j] = grid[i][j] + Integer.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

}
