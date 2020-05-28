package array;

public class MaximumContiguousSubarray {

	public static int maxSubArray(int[] nums) {
		int currMax=0, max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
        	currMax = currMax+nums[i];
        	if(max<currMax) {
        		max=currMax;
        	}
        	if(currMax<0) {
        		currMax=0;
        	}
        }
        
        return max;
    }
	
	 /**
	 * @param A
	 * @return
	 * https://leetcode.com/problems/maximum-sum-circular-subarray/submissions/
	 * in circular array. image for reference max_contiguous_sum_in_circular_array.png
	 * https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
	 */
	public int maxSubarraySumCircular(int[] A) {
	        int currMax=0, maxSum = Integer.MIN_VALUE, currMin=0, minSum = Integer.MAX_VALUE;
	        int total = 0;    
	        for(int i=0; i<A.length; i++){
	           currMax = currMax + A[i];
	           currMin = currMin + A[i]; 
	           maxSum = Math.max(maxSum, currMax);
	           minSum = Math.min(minSum, currMin); 
	           if(currMax<0){
	               currMax=0;
	           }
	           if(currMin>0){
	               currMin=0;
	           }
	           total += A[i]; 
	       }
	       return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	    }
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
}
