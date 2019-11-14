package recursion.backtracking;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (canBePlaced(board, i, j, num)) {
							board[i][j] = num;
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.'; //backtracking 
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	boolean canBePlaced(char[][] board, int row, int col, char num) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.' && board[row][i] == num) {
				return false;
			}
			if (board[i][col] != '.' && board[i][col] == num) {
				return false;
			}
			if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
					board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
				return false; 
			}
		}
		return true;
	}

}
