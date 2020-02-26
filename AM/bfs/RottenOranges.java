package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	
	   public int orangesRotting(int[][] grid) {
	        
	        Queue<int[]> q = new LinkedList<>();
	        int freshOranges=0;
	        
	        for(int i=0; i<grid.length; i++){
	            for(int j=0; j<grid[0].length; j++){
	                if(grid[i][j] == 2){
	                    q.add(new int[]{i,j}); 
	                }if(grid[i][j] == 1){
	                    freshOranges++;
	                }
	            }
	        }
	        
	        if(freshOranges==0){
	            return 0;  
	        }
	        
	       int minutes = 0;
	       int[][] positions = {{1,0},{0,1},{-1,0},{0,-1}}; 
	        
	        while(!q.isEmpty()){
	            int qSize = q.size();
	            minutes++;
	            while(qSize>0){
	                int[] rottenPos = q.poll();
	                qSize--;
	                for(int[] position : positions){
	                    int adjacentPosX = rottenPos[0] + position[0];
	                    int adjacentPosY = rottenPos[1] + position[1];
	                    if(adjacentPosX<0 || (adjacentPosX>grid.length-1) || adjacentPosY<0 || (adjacentPosY>grid[0].length-1)){
	                        continue;
	                    }
	                    if(grid[adjacentPosX][adjacentPosY] == 1){
	                        grid[adjacentPosX][adjacentPosY]=2;
	                        q.add(new int[]{adjacentPosX,adjacentPosY});
	                        freshOranges--;
	                    }
	                }
	            }
	        }
	        
	       if(freshOranges==0){
	            return minutes-1;  
	       }else{
	           return -1;
	       }
	        
	        
	    }
}
