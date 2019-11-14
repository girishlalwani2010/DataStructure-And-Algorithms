package datastructure.graph;

/**
 * @author girish_lalwani
 *
 *         https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *         Draw Recursion-Tree, for clear understanding.
 *         https://www.youtube.com/watch?v=ZAmxc4Qrqi8
 *
 */
public class LongestIncreasingPath {

	private static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private int m, n;
	int maxDist;

	public int longestIncreasingPath(int[][] matrix) {
	      if (matrix.length == 0) return 0;
	      m = matrix.length;
	      n = matrix[0].length;
	      int[][] cache = new int[m][n];
	      int ans = 1;
	      for (int i = 0; i < m; ++i)
	          for (int j = 0; j < n; ++j)
	              ans = Math.max(ans, dfs(matrix, i, j, cache));
	      return ans;
	  }

	  private int dfs(int[][] matrix, int i, int j, int[][] cache) {
		  if(cache[i][j] != 0) return cache[i][j];
		  int max = 1;
	      for (int[] d : dirs) {
	          int x = i + d[0], y = j + d[1];
	          if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
	              max = Math.max(max, 1 + dfs(matrix, x, y, cache));
	          }
	      }
	      cache[i][j] = max;
	      return max;
	  }

	public static void main(String[] args) {
		int[][] nums = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		LongestIncreasingPath lIP = new LongestIncreasingPath();
		System.out.println(lIP.longestIncreasingPath(nums));
	}

}
