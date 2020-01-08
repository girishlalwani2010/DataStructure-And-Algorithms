package backtracking;

/**
 * @author girish_lalwani
 *
 *https://leetcode.com/problems/path-with-maximum-gold/
 */
public class PathWithMaxGold {
	

    private int maxGold;
    private int[][] positions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    private boolean[][] visited;
    public int getMaximumGold(int[][] grid) {
        maxGold = Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                visited = new boolean[grid.length][grid[0].length];
                int goldAmmount=0;
                dfs(i,j,grid,goldAmmount, visited);
            }
        }
        return maxGold;
    }
    
    public void dfs(int row, int col, int[][] grid, int goldAmmount, boolean[][] visited){
        
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1){
            return;
        }
        if(grid[row][col] == 0){
            return;
        }
        if(visited[row][col]){
            return;
        }
        
        visited[row][col] = true;
 
        goldAmmount = goldAmmount + grid[row][col];
        
        if(goldAmmount>maxGold){
            maxGold = goldAmmount;
        }
        
        for(int[] pos:positions){
            dfs(row+pos[0],col+pos[1], grid, goldAmmount,visited);
        }
        visited[row][col] = false;
        // variable those are local to recursion will take there previous state automatically from stack-frame when recursion will backtrack
        // hence gold-amount is not deducted.
    }
    
    

}
