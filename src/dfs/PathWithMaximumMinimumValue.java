package dfs;

import java.util.PriorityQueue;

/**
 * @author girish_lalwani
 *         https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/457525/JAVA-A-Summery-of-All-Current-Solutions
 */
public class PathWithMaximumMinimumValue {

	private int maxScore = Integer.MIN_VALUE;
	private int[][] positions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int maximumMinimumPath(int[][] A) {
		return orderedDFS(A);
	}

	/**
	 * @param A
	 * @return Time: O(Vlog(V) + E). Because the maximum number of element in the
	 *         queue cannot be larger than V so pushing and popping from queue is
	 *         O(log(V)). Also we only push each vertex to the queue once, so at
	 *         maximum we do it V times. Thats Vlog(V). The E bit comes from the for
	 *         loop inside the while loop. Space: O(V) where V is the maximum depth
	 *         of our search tree.
	 */
	private int orderedDFS(int[][] A) {
		PriorityQueue<int[]> heap = new PriorityQueue<>((b, a) -> A[a[0]][a[1]] - A[b[0]][b[1]]);
		int cols = A[0].length;
		int rows = A.length;
		boolean[][] visited = new boolean[rows][cols];
		heap.offer(new int[] { 0, 0, A[0][0] });
		while (!heap.isEmpty()) {
			int[] curr = heap.poll();
			// remove sysout to pass the time-limit.
			System.out.println("Processing [X,Y]: " + "[" + curr[0] + "," + curr[1] + "]");
			visited[curr[0]][curr[1]] = true;
			// or A[curr[0]][curr[1]] = -1;
			for (int[] pos : positions) {
				int nr = curr[0] + pos[0];
				int nc = curr[1] + pos[1];
				if (nr == rows - 1 && nc == cols - 1) {
					return Math.min(curr[2], A[nr][nc]);
				}
				if (nr < 0 || nr > rows - 1 || nc < 0 || nc > cols - 1 || visited[nr][nc]) {
					continue;
				}
				int ns = A[nr][nc];
				heap.offer(new int[] { nr, nc, Math.min(curr[2], ns) });
			}
		}
		return 0;
	}

	/**
	 * @param row
	 * @param col
	 * @param grid
	 * @param min
	 *            Time Limit Exceeded Complexity: Time: (4 ^ V) Let R(x) denotes the
	 *            time complexity for our algorithm. We know that R(1) = 1. Also,
	 *            R(n) <= 4R(n-1) since we have four directions and we never revisit
	 *            any nodes when traversing over a certain path. Easily, we can get
	 *            that R(n) <= 4^n and since we have V nodes, the time complexity
	 *            for this algorithm should be O(4^V); Space: O(V) where V is the
	 *            maximum depth of the search tree.
	 * 
	 * 
	 */
	private void normaldfs(int row, int col, int[][] grid, int min) {

		if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == -1) {
			return;
		}

		min = Math.min(min, grid[row][col]);

		if (row == grid.length - 1 && col == grid[0].length - 1) {
			maxScore = Math.max(maxScore, min);
			return;
		}

		int temp = grid[row][col];
		grid[row][col] = -1;

		for (int[] position : positions) {
			normaldfs(row + position[0], col + position[1], grid, min);
		}
		grid[row][col] = temp;
	}

	public static void main(String[] args) {
		PathWithMaximumMinimumValue pathWithMaximumMinimumValue = new PathWithMaximumMinimumValue();
		int[][] A = { { 5, 4, 3 }, { 1, 2, 1 }, { 7, 1, 6 } };
		System.out.println(pathWithMaximumMinimumValue.maximumMinimumPath(A));
	}

}
