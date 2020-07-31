package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
	public static int snakesAndLadders(int[][] board) {
		int N = board.length;
		Queue<int[]> q = new LinkedList<>();
		int[] start = { 0, 0 };
		q.offer(start);
		int[] dirs = { 1, 2, 3, 4, 5, 6 };
		int moves = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currLoc = q.poll();
				if (currLoc[0] * N + currLoc[1] == (N * N - 1)) {
					return moves;
				}
				for (int dir : dirs) {
					int[] nextLoc = Arrays.copyOf(currLoc, 2);
					nextLoc[1] = currLoc[0] * N + currLoc[1] + dir;
					if (nextLoc[1] / N > 0) {
						int temp = nextLoc[1];
						nextLoc[0] = temp / N;
						if (nextLoc[0] % 2 == 0) {
							nextLoc[1] = temp % N;
						} else {
							nextLoc[1] = N - 1 - temp % N;
						}
					}
					System.out.println("Next Location --> " + "x:" + nextLoc[0] + ", " + "y:" + nextLoc[1]);
					if (nextLoc[0] * N + nextLoc[1] > (N * N - 1)) {
						continue;
					}
					if (board[nextLoc[0]][nextLoc[1]] != -1) {
						int temp = board[nextLoc[0]][nextLoc[1]] - 1;
						if (temp / N > 0) {
							nextLoc[0] = temp / N;
							if (nextLoc[0] % 2 == 0) {
								nextLoc[1] = temp % N;
							} else {
								nextLoc[1] = N - 1 - temp % N;
							}
						}else {
							nextLoc[0] = temp;
							nextLoc[1] = 0;
						}
						
					}
					q.offer(nextLoc);
				}
			}
			moves++;
		}
		return -1;
	}
	
	 public static void getBoardValue(int num) {
	        int n = 4;
	        int r = (num - 1) / n;
	        int x = n - 1 - r;
	        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
	        System.out.println("Next Location --> " + "x:" + x + ", " + "y:" + y);
	    }

	public static void main(String[] args) {
		int[][] board = { { -1, -1, -1, -1 }, { -1, -1, -1, -1 }, { -1, -1, -1, -1 }, { -1, -1, -1, -1 } };
		getBoardValue(6);
	}
}
