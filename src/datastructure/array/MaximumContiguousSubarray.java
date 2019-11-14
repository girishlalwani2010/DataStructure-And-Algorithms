package datastructure.array;

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
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
}
