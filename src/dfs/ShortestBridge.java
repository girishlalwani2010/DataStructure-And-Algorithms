package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author girish_lalwani
 *
 *
 *DFS then BFS
 */
public class ShortestBridge {
	public int shortestBridge(int[][] A) {
		paint(A); // paint one island with int 2
		Queue<int[]> q = new LinkedList<>(); // queue contains coordinates to do bfs
		boolean[][] visited = new boolean[A.length][A[0].length];

		for (int i = 0; i < A.length; i++) {// initialize queue with all coordinates with number 2
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 2) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		int level = 0;
		while (!q.isEmpty()) {// level order bfs
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				if (A[x][y] == 1) {// found, then return
					return level - 1;
				}
				if (x - 1 >= 0 && !visited[x - 1][y]) {
					q.add(new int[] { x - 1, y });
					visited[x - 1][y] = true;
				}
				if (x + 1 < A.length && !visited[x + 1][y]) {
					q.add(new int[] { x + 1, y });
					visited[x + 1][y] = true;
				}
				if (y - 1 >= 0 && !visited[x][y - 1]) {
					q.add(new int[] { x, y - 1 });
					visited[x][y - 1] = true;
				}
				if (y + 1 < A[0].length && !visited[x][y + 1]) {
					q.add(new int[] { x, y + 1 });
					visited[x][y + 1] = true;
				}
			}
			level++; // next level
		}
		return -1;
	}

	public void paint(int[][] A) {// paint one island with int 2
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					dfs(i, j, A);
					return;
				}
			}
		}
	}

	public void dfs(int x, int y, int[][] A) {// helper function for paint function
		if (x < 0 || x > A.length - 1 || y < 0 || y > A[0].length - 1 || A[x][y] != 1) {
			return;
		}
		A[x][y] = 2;
		dfs(x - 1, y, A);
		dfs(x + 1, y, A);
		dfs(x, y - 1, A);
		dfs(x, y + 1, A);
	}
}
