package dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author girish_lalwani
 *
 *         https://leetcode.com/problems/walls-and-gates/discuss/72748/Benchmarks-of-DFS-and-BFS
 *      	I like DFS but question is little bit more about BFS.
 */
public class WallsAndGate {

	public void dfs(int[][] rooms, int i, int j, int d) {

		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) {
			return;
		}

		rooms[i][j] = d;
		dfs(rooms, i + 1, j, d + 1);
		dfs(rooms, i - 1, j, d + 1);
		dfs(rooms, i, j + 1, d + 1);
		dfs(rooms, i, j - 1, d + 1);
	}

	public void wallsAndGatesBestDFSSolution(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j, 0);
				}
			}
		}
	}

	/**
	 * @param rooms
	 * 
	 *            BFS with O(n2) Complexity
	 */
	public void wallsAndGatesBFS(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0)
			return;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0)
					queue.add(new int[] { i, j });
			}
		}
		while (!queue.isEmpty()) {
			int[] top = queue.remove();
			int row = top[0], col = top[1];
			if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
				rooms[row - 1][col] = rooms[row][col] + 1;
				queue.add(new int[] { row - 1, col });
			}
			if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
				rooms[row + 1][col] = rooms[row][col] + 1;
				queue.add(new int[] { row + 1, col });
			}
			if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
				rooms[row][col - 1] = rooms[row][col] + 1;
				queue.add(new int[] { row, col - 1 });
			}
			if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
				rooms[row][col + 1] = rooms[row][col] + 1;
				queue.add(new int[] { row, col + 1 });
			}
		}
	}

	public static final int[] d = { 0, 1, 0, -1, 0 };

	public void wallsAndGatesBFSWithON2(int[][] rooms) {
		if (rooms.length == 0)
			return;
		for (int i = 0; i < rooms.length; ++i)
			for (int j = 0; j < rooms[0].length; ++j)
				if (rooms[i][j] == 0)
					bfs(rooms, i, j);
	}

	private void bfs(int[][] rooms, int i, int j) {
		int m = rooms.length, n = rooms[0].length;
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(i * n + j); // Put gate in the queue
		while (!queue.isEmpty()) {
			int x = queue.poll();
			i = x / n;
			j = x % n;
			for (int k = 0; k < 4; ++k) {
				int p = i + d[k], q = j + d[k + 1];
				if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] > rooms[i][j] + 1) {
					rooms[p][q] = rooms[i][j] + 1;
					queue.offer(p * n + q);
				}
			}
		}
	}

	public void wallsAndGatesBestImplementation(int[][] rooms) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					q.add(new int[] { i, j });
				}
			}
		}
		int[][] positions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int[] gatePosition = q.poll();
			int x = gatePosition[0];
			int y = gatePosition[1];
			for (int[] position : positions) {
				int newPosX = x + position[0];
				int newPosY = y + position[1];
				if (newPosX < 0 || newPosX > rooms.length - 1 || newPosY < 0 || newPosY > rooms[0].length - 1
						|| rooms[newPosX][newPosY] != Integer.MAX_VALUE) {
					continue;
				}
				rooms[newPosX][newPosY] = rooms[x][y] + 1;
				q.add(new int[] { newPosX, newPosY });
			}
		}

	}

	public static void main(String[] args) {

	}

}
