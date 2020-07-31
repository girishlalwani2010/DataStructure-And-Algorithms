package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	private void addToResult(List<List<String>> result, char[][] board) {
		List<String> solution = new ArrayList<>();
		int n = board.length;
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(board[i][j]);
			}
			solution.add(sb.toString());
		}
		result.add(solution);
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		solveNQueens(result, board, 0);
		return result;
	}

	private boolean solveNQueens(List<List<String>> result, char[][] board, int row) {
		if (row == board.length) {
			return true;
		}
		for (int col = 0; col < board.length; col++) {
			if (canPlace(board, row, col)) {
				board[row][col] = 'Q';
				if (solveNQueens(result, board, row + 1)) {
					addToResult(result, board);
				}
				board[row][col] = '.';
			}
		}
		return false;
	}

	private boolean canPlace(char[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}
		int i = row;
		int j = col;
		while (i > 0) {
			if (j > 0 && board[i - 1][j - 1] == 'Q') {
				return false;
			}
			i = i - 1;
			j = j - 1;
		}
		int k = row;
		int l = col;
		while (k > 0) {
			if (l < board.length - 1 && board[k - 1][l + 1] == 'Q') {
				return false;
			}
			k = k - 1;
			l = l + 1;
		}
		return true;
	}

}
