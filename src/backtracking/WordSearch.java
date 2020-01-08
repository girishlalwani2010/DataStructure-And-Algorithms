package backtracking;

public class WordSearch {
	
	private final int[][] positions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	public boolean exist(char[][] board, String word) {
        if(word.isEmpty()){
            return true;
        }
        boolean wordExist = false;
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		 if(dfs(i,j,board,word)) {
        			 wordExist = true;
        		 }
        	}
        }
       return wordExist; 
    }
    
    public boolean dfs(int row, int col, char[][] grid, String word){
    	
    	if(word.isEmpty()){
            return true;
        }
        
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1){
            return false;
        }
        
        if(grid[row][col] == '.'){
            return false;
        }
        
        char temp = grid[row][col];
        
        if(grid[row][col] == word.charAt(0)) {
        	grid[row][col] = '.';
        	for(int[] pos:positions){
                if(dfs(row+pos[0],col+pos[1], grid, word.substring(1))){
                	return true;
                }
            }
        }
        
        grid[row][col] = temp;
        return false;
    }
	
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(ws.exist(board, "SEE"));
	}

}
