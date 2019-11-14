package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

	private List<List<String>> nQueensPlacements;
	
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		nQueensPlacements = new ArrayList<>();
		
		canPlace(board, 0);
		
		return nQueensPlacements;
	}

	public boolean canPlace(char[][] board, int row) {
		if (row >= board.length) {
			List<String> nQueensPlacement = new ArrayList<String>();
			for (int i=0; i < board.length; i++) {
				String rowStr = new String(board[i]);
				nQueensPlacement.add(rowStr);
			}
			nQueensPlacements.add(nQueensPlacement);
			return false;
		}
		for (int col = 0; col < board[0].length; col++) {
			board[row][col] = 'Q';
			if (isValidMove(board, row, col)) {
				if (canPlace(board, row + 1)) {
					return true;
				} else {
					board[row][col] = '.';
				}
			}
			board[row][col] = '.';
		}
		return false;
	}

	private boolean isValidMove(char[][] board, int row, int col) {
		
		for (int i = 0; i < board.length; i++) {
			if (i != row && board[i][col] == 'Q') {
				return false;
			}
		}

		int i = row - 1;
		int j = col - 1;
		while (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
			if (board[i][j] == 'Q') {
				return false;
			}
			i = i - 1;
			j = j - 1;
		}

		i = row - 1;
		j = col + 1;
		while (i >=0  && i < board.length && j >=0  && j < board[0].length) {
			if (board[i][j] == 'Q') {
				return false;
			}
			i = i - 1;
			j = j + 1;
		}

		i = row + 1;
		j = col + 1;
		while (i >=0  && i < board.length && j >=0  && j < board[0].length) {
			if (board[i][j] == 'Q') {
				return false;
			}
			i = i + 1;
			j = j + 1;
		}

		i = row + 1;
		j = col - 1;
		while (i >=0  && i < board.length && j >=0  && j < board[0].length) {
			if (board[i][j] == 'Q') {
				return false;
			}
			i = i + 1;
			j = j - 1;
		}

		return true;
	}

	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		System.out.println(nQueen.solveNQueens(4));
	}

}
