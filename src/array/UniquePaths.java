package array;

/**
 * @author girish_lalwani
 *
 *
 *Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
public class UniquePaths {
	
	public static int uniquePaths(int m, int n, int i, int j, int [][] memo, int[][] obstacleGrid) {
		if(i>m || j>n) {
			return 0;
		}
		if(obstacleGrid[i][j] == 1) {
			return 0;
		}
		if(i==m && j==n) {
			return 1;
		}
		if(memo[j][i]>0) {
			return memo[j][i];
		}
		memo[j][i] = uniquePaths(m, n, i+1, j, memo, obstacleGrid) + uniquePaths(m, n, i, j+1, memo, obstacleGrid);
		return memo[j][i];
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		//return uniquePaths(m-1,n-1,0,0,new int[n][m], obstacleGrid);
		return uniquePathsWithDP(n,m,obstacleGrid);
	}
	
	public static int uniquePathsWithDP(int m, int n, int [][]obstacleGrid) {
        int []curr = new int[m];
        int []prev = new int[m];
        for(int i = 0; i<m;i++){
        	curr[i]=1;	
        	prev[i]=1;
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
            	if(obstacleGrid[i][j] ==1) {
            		curr[j] = 0;
            	}else {
            		curr[j] = curr[j-1]+prev[j];
            	}
            }
            prev=curr;
        }
        return curr[m-1];
    }
	
	//| 1 | 1 | 1 |
	//| 1 | 1 | 2 |
	//| 1 | 2 | 4 |
	
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

}
