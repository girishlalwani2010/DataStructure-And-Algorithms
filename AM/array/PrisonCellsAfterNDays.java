package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {
	
	 public int[] prisonAfterNDays(int[] cells, int N) {
	        if(cells==null || cells.length==0 || N<=0) return cells;
	        Set<String> set = new HashSet<>();
	        boolean hasCycle = false;
	        int cycleLength=0;
	        for(int i=1; i<=N; i++){
	            int[] nextCells = getNextDayCells(cells);
	            String key = Arrays.toString(nextCells);
	            if(set.contains(key)){
	                hasCycle = true;
	                break;
	            }else{
	                set.add(key);
	                cycleLength++;
	            }
	            //stored in the end as the cells will be needed if there is cycle and need to start getNextDayCells calculation 
	            //from here only.
	            cells = nextCells;
	        }
	        
	        if(hasCycle){
	            N = N%cycleLength;
	            //cells = zerothCell, commented as cycle can start from any point not zero every time.
	            for(int j=1; j<=N; j++){
	                cells = getNextDayCells(cells);
	            }
	        }
	        
	        return cells;
	    }
	    
	   private int[] getNextDayCells(int[] cells){
	        int[] tmp = new int[cells.length];
	        for(int i=1; i<7; i++){
	            tmp[i] = (cells[i-1] == cells[i+1])?1:0;
	        }
	        return tmp;
	    }

}
