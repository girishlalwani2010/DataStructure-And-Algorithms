package binarysearch;

import java.util.TreeSet;

/**
 * @author girish_lalwani
 *
 *https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 */
public class MaxSumofRectangleNoLargerThanK {
	 private int[][] sum;
	    private int row;
	    private int col;
	    public int maxSumSubmatrix(int[][] matrix, int k) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return 0;
	        }
	        row = matrix.length;
	        col = matrix[0].length;
	        sum = new int[row + 1][col + 1];
	        for (int i = 1; i <= row; i++) {
	            for (int j = 1; j <= col; j++) {
	                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
	            }
	        }
	        int max = Integer.MIN_VALUE;
	        for (int i = 1; i <= row; i++) {
	            for (int j = 1; j <= col; j++) {
	                for (int h = 0; i + h <= row ; h++) {
	                    for (int w = 0; j + w <= col ; w++) {
	                        int area = sum[i + h][j + w] - sum[i - 1][j + w] - sum[i + h][j - 1] + sum[i - 1][j - 1];
	                        System.out.println("["+i+","+j+"] , area:"+area);
	                        if (area > max && area <= k) {
	                            max = area;
	                        }
	                    }
	                }
	            }
	        }
	        
	        TreeSet<Integer> treeset = new TreeSet<Integer>();
	        return max;
	    }
	    
	    /**
	     * @param matrix
	     * @param k
	     * @return
	     * Time Complexity O()
	     */
	    public int maxSumSubmatrixUsingKadanesAlgo(int[][] matrix, int k) {
	        //2D Kadane's algorithm + 1D maxSum problem with sum limit k
	        //2D subarray sum solution
	        
	        //boundary check
	        if(matrix.length == 0) return 0;
	        
	        int rows = matrix.length, cols = matrix[0].length;
	        int result = Integer.MIN_VALUE;
	        
	        //outer loop should use smaller axis
	        //now we assume we have more rows than cols, therefore outer loop will be based on cols 
	        for(int left = 0; left < cols; left++){
	            //array that accumulate sums for each row from left to right 
	            int[] sums = new int[rows];
	            for(int right = left; right < cols; right++){
	                //update sums[] to include values in curr right col
	                for(int i = 0; i < rows; i++){
	                    sums[i] += matrix[i][right];
	                }
	                
	                //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
	                //Keep on finding the gap between currentsum and k, then minimized the gap by calling ceiling of gap;
	                // and why use treeset as we know that if we keep the data in sorted order then it is easier to find the element 
	                // closest and greater then it, as treeset mantain the elements in sorted order. Tricky like it. 
	                //https://www.geeksforgeeks.org/find-closest-smaller-value-for-every-element-in-array/
	                TreeSet<Integer> set = new TreeSet<Integer>();
	                //add 0 to cover the single row case
	                set.add(0);
	                int currSum = 0;
	                
	                for(int sum : sums){
	                    currSum += sum;
	                    //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
	                    //therefore we need to look for the smallest sum >= currSum - k
	                    // take an example for if k is greater then currentSum easier to understand
	                    int gap = currSum - k;
						Integer minimumGap = set.ceiling(gap);
	                    if(minimumGap != null) result = Math.max(result, currSum - minimumGap);
	                    set.add(currSum);
	                }
	            }
	        }
	        
	        return result;
	    }
	    
	    public static void main(String[] args) {
			int matrix[][] = {{-1},{9},{1}};
			int k= 5;
			MaxSumofRectangleNoLargerThanK maxRectangle = new MaxSumofRectangleNoLargerThanK();
			System.out.println(maxRectangle.maxSumSubmatrixUsingKadanesAlgo(matrix, k));
		}
}
