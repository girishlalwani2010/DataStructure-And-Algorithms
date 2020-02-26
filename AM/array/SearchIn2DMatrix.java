package array;

public class SearchIn2DMatrix {
	
	  public boolean searchMatrix(int[][] matrix, int target) {
	        
	        int nRows = matrix.length;
	        if(nRows==0){
	            return false;
	        }
	        int nCols = matrix[0].length;    
	        int low = 0; 
	        int high = nRows*nCols-1;
	        
	        while(low<=high){
	            int mid = (low+high)/2;
	            int midElement = matrix[mid/nCols][mid%nCols];
	            if(midElement == target){
	                return true;
	            }else{
	                if(midElement>target){
	                    high = mid-1;
	                }else{
	                    low = mid+1;
	                }
	            }
	        }
	        return false;
	    }

}
