package dfs;

public class MaxAreaofIsland {
	
	public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
               if(grid[i][j]==1){
                   maxArea = Math.max(maxArea, getArea(grid,i,j)) ;                    
               } 
            }
        }
        return maxArea;
    }
    final int[][] positions = {{-1,0},{0,1},{1,0},{0,-1}};
    private int getArea(int[][] grid, int row, int col){
        if(row>(grid.length-1) || row<0 || col>(grid[0].length-1) || col<0 || grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;
        int area=0;
        for(int[] position : positions){
            area += getArea(grid, row+position[0], col+position[1]);
        }
        return area+1;
    } 
    
    public static void main(String[] args) {
		int[][] grid = {{0,1,0}, {1,1,1}, {0,1,0}};
		MaxAreaofIsland mA = new MaxAreaofIsland();
		System.out.println(mA.maxAreaOfIsland(grid));
	}

}
