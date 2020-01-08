package graph;

import java.util.logging.LogManager;

public class LongestIncresingPathRepeat {

	 private int maxLip;
	    
	    public int longestIncreasingPath(int[][] matrix) {

			if (matrix == null || (matrix.length == 0)) {
				return 0;
			}

			int result = Integer.MIN_VALUE;
	        int maxLip = Integer.MIN_VALUE;
			int[][] memo = new int[matrix.length][matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					maxLip = Math.max(maxLip,dfs(matrix, Integer.MIN_VALUE, i, j, memo));
				}
			}
			return maxLip;
		}

		private final int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		public int dfs(int[][] matrix, int oldVal, int row, int col, int[][] memo) {
			if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[0].length - 1 || matrix[row][col] <= oldVal) {
				return 0;
			}

			if (memo[row][col] != 0) {
				return memo[row][col];
			}
	        
	        int tempMax=0;
	        
			for (int[] direction : directions) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				int currentLip = 1+dfs(matrix, matrix[row][col], newRow, newCol, memo);
				if(currentLip>tempMax) {
					tempMax = currentLip;
				}
			}
			memo[row][col] = tempMax;
			return tempMax;
		}

	public static void main(String[] args) {
		int matrix[][] = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };

		LongestIncresingPathRepeat longestIncresingPathRepeat = new LongestIncresingPathRepeat();
		System.out.println(longestIncresingPathRepeat.longestIncreasingPath(matrix));
	}

}
