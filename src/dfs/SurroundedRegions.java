package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author girish_lalwani
 *
 */

public class SurroundedRegions {
	
	public void solve(char[][] board) {
		
		if(board.length == 0) {
			return;
		}
		
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		for(int i=0; i<rows; i++) {
			if(board[i][0] == 'O') {
				dfs(board,i,0,visited);
			}
			if(board[i][cols-1] == 'O') {
				dfs(board,i,cols-1,visited);
			}
		}
		
		for(int i=0; i<cols; i++) {
			if(board[0][i] == 'O') {
				dfs(board,0,i,visited);
			}
			if(board[rows-1][i] == 'O') {
				dfs(board,rows-1,i,visited);
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(board[i][j] == 'O' && !visited[i][j]) {
					board[i][j] = 'X';
				}
			}
		}
    }
	
	public void dfs(char[][] board, int rowNo, int colNo, boolean[][] visited) {
		if(rowNo<0 || rowNo>board.length-1 || colNo<0 || colNo>board[0].length-1) {
			return;
		}
		if(visited[rowNo][colNo])
			return;
		if(board[rowNo][colNo]!='O') {
			return;
		}
		visited[rowNo][colNo] = true;
		dfs(board,rowNo+1,colNo, visited);
		dfs(board,rowNo-1,colNo, visited);
		dfs(board,rowNo,colNo+1, visited);
		dfs(board,rowNo,colNo-1, visited);
	}
	
	public void solveWithoutExtraSpace(char[][] board) {
		if(board.length == 0) {
			return;
		}
		int rows = board.length;
		int cols = board[0].length;
		
		for(int i=0; i<rows; i++) {
			if(board[i][0] == 'O') {
				dfsForSolveWithoutExtraSpace(board,i,0);
			}
			if(board[i][cols-1] == 'O') {
				dfsForSolveWithoutExtraSpace(board,i,cols-1);
			}
		}
		
		for(int i=0; i<cols; i++) {
			if(board[0][i] == 'O') {
				dfsForSolveWithoutExtraSpace(board,0,i);
			}
			if(board[rows-1][i] == 'O') {
				dfsForSolveWithoutExtraSpace(board,rows-1,i);
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if(board[i][j] == '1') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	/**
	 * @param board
	 * @param rowNo
	 * @param colNo
	 * 
	 * Not used Visited here, 
	 
	 First, check the four border of the matrix. If there is a element is
	'O', alter it and all its neighbor 'O' elements to '1'.

	 Then ,alter all the 'O' to 'X'

	 At last,alter all the '1' to 'O'

	 For example:

         X X X X           X X X X             X X X X
         X X O X  ->       X X O X    ->       X X X X
         X O X X           X 1 X X             X O X X
         X O X X           X 1 X X             X O X X
         
         1 will work as marking nodes visited, and corner connected nodes
	 */
	public void dfsForSolveWithoutExtraSpace(char[][] board, int rowNo, int colNo) {
		
		if(rowNo<0 || rowNo>board.length-1 || colNo<0 || colNo>board[0].length-1)
			return;
		if(board[rowNo][colNo]!='O')
			return;
		
		board[rowNo][colNo] = '1';
		
		dfsForSolveWithoutExtraSpace(board,rowNo+1,colNo);
		dfsForSolveWithoutExtraSpace(board,rowNo-1,colNo);
		dfsForSolveWithoutExtraSpace(board,rowNo,colNo+1);
		dfsForSolveWithoutExtraSpace(board,rowNo,colNo-1);
		
	}
	
	
	public void solveWithBFS(char[][] board) {
		if(board.length == 0) {
			return;
		}
		int rows = board.length;
		int cols = board[0].length;
		
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<rows; i++) {
			if(board[i][0] == 'O') {
				queue.add(new int[] {i,0});
			}
			if(board[i][cols-1] == 'O') {
				queue.add(new int[] {i, cols-1});
			}
		}
		
		for(int i=0; i<cols; i++) {
			if(board[0][i] == 'O') {
				queue.add(new int[] {0, i});
			}
			if(board[rows-1][i] == 'O') {
				queue.add(new int[] {rows-1, i});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			if(point[0]<0 || point[0]>board.length-1 || point[1]<0 || point[1]>board[0].length-1)
				continue;
			if(board[point[0]][point[1]]!='O')
				continue;
			board[point[0]][point[1]] ='1';
			queue.add(new int[] {point[0]+1,point[1]});
			queue.add(new int[] {point[0]-1,point[1]});
			queue.add(new int[] {point[0],point[1]+1});
			queue.add(new int[] {point[0],point[1]-1});
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if(board[i][j] == '1') {
					board[i][j] = 'O';
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		sr.solveWithBFS(board);
	}

}
