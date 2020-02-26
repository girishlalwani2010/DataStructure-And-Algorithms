package array;

public class SearchIn2DMatrixII {
	
	public boolean searchMatrix(int[][] matrix, int target) {
	    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
	    if(matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
	    return helper(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
	}

	public boolean helper(int[][] matrix, int target, int rS, int rE, int cS, int cE) {
	    if(rS < 0 || rE >= matrix.length || cS < 0 || cE >= matrix[0].length || rS > rE || cS > cE) return false;
	    
	    int rM = rS + (rE-rS)/2, cM = cS + (cE-cS)/2;
	    
	    if(matrix[rM][cM] == target) return true;
	    else if(matrix[rM][cM] > target) {
	        return helper(matrix, target, rS, rM-1, cS, cM-1) || helper(matrix, target, rS, rM-1, cM, cE) || helper(matrix, target, rM, rE, cS, cM-1);
	    } else { // matrix[rM][cM] < target
	        return helper(matrix, target, rM+1, rE, cM+1, cE) || helper(matrix, target, rM+1, rE, cS, cM) || helper(matrix, target, rS, rM, cM+1, cE);
	    }
	}
	
	/**
	 * @param matrix
	 * @param target
	 * @return
	 * 
	 * Time complexity : O(n+m)
	 */
	public boolean searchMatrixInLinearTime(int[][] matrix, int target) {
        //left, down
        
        if(matrix.length==0){
            return false;
        }
        
        if(matrix.length==1 && matrix[0].length==1){
            if(matrix[0][0] == target){
                return true;
            }
            return false;
        }
        
        int down = 0;
        int left = matrix[0].length-1;
        while(left>=0 && down<matrix.length){
            int topCornerElement = matrix[down][left];
            if(topCornerElement == target){
                return true;
            }
            if(topCornerElement>target){
                left--;
            }else{
                down++;
            }
        }
        return false;
    }
	
}
