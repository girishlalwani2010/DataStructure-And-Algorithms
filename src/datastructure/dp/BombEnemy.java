package datastructure.dp;

public class BombEnemy {

	public int maxKilledEnemies(char[][] grid) {
        if(grid== null || grid.length == 0 || grid[0].length==0) return 0; 
        int rows = grid.length; 
        int cols = grid[0].length; 
        int max = 0; 
        int[][] dp = new int[rows][cols];
        //travel each column twice: from left and from right
        for(int i = 0; i<rows; i++){
            int cnt = 0; 
            for(int k = 0; k<cols; k++){
                if(grid[i][k]=='0'){
                    dp[i][k] += cnt;
                }else if(grid[i][k]=='E'){
                    cnt++;
                }else{
                    cnt = 0; 
                }
            }
            cnt = 0; 
            for(int k = cols-1; k>=0; k--){
                if(grid[i][k]=='0'){
                    dp[i][k] += cnt; 
                }else if(grid[i][k]=='E'){
                    cnt++;
                }else{
                    cnt = 0;
                }
            }
        }
        //travel each row twice: from top and from bottom
        for(int i = 0; i<cols; i++){
            int cnt = 0; 
            for(int k = 0; k<rows; k++){
                if(grid[k][i]=='0'){
                    dp[k][i] += cnt; 
                }else if(grid[k][i]=='E'){
                    cnt++;
                }else{
                    cnt = 0; 
                }
            }
            cnt = 0; 
            for(int k = rows-1; k>=0; k--){
                if(grid[k][i]=='0'){
                    dp[k][i] += cnt; 
                    max = Math.max(max, dp[k][i]); 
                }else if(grid[k][i]=='E'){
                    cnt++;
                }else{
                    cnt = 0;
                }
            }
        }
        return max; 
    }

	public static void main(String[] args) {
		
	}

}
