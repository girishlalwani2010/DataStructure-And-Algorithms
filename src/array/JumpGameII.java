package array;

import java.util.HashMap;

/**
 * @author girish_lalwani
 *	
 *	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.
 */

//	{2,3,1,1,4}
public class JumpGameII {
	
	public static  int jump(int[] nums) {
		int maxPossibiltyToReachFromCurrStep = 0,probableMax=0;
		int jumps=0;
		for(int i=0; i<nums.length-1; i++) {
			probableMax = Math.max(i+nums[i], probableMax);
			if(i == maxPossibiltyToReachFromCurrStep) {
				jumps++;
				maxPossibiltyToReachFromCurrStep = probableMax;
			}
		}
		return jumps;
    }
	
	private int findJumps(int[] arr, int startIndex) {
        //if reached to the end...we are done'

        if(startIndex==arr.length-1){
            return 0;
        }
        int size = arr.length;

        int remainingLength = size-startIndex;

        if(remainingLength<=arr[startIndex]){
            //means no further recursion is required
            return 1;
        }
        if(arr[startIndex]==0){
            System.out.println("Cannot move further");
            return Integer.MAX_VALUE;
        }
        int jumps = Integer.MAX_VALUE;
        for (int i = 1; i <=arr[startIndex]; i++) {
            int temp = findJumps(arr, startIndex+i);
            if(temp!=Integer.MAX_VALUE){// check if path from jumps[j] is not blocked, means arr[startIndex]!=0
                jumps = Math.min(jumps, 1 + temp);
            }else{
                //ignore...cannot pass through 0
            }
        }
        return jumps;
    }
	
	
	// Using Top-Down DP
	// [2,3,1,1,4]
	 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	    private int findJumpsTopDownDP(int[] arr, int startIndex) {

	        //if reached to the end...we are done
	        if(startIndex==arr.length-1){
	            return 0;
	        }

	        if(map.containsKey(startIndex)){
	            return map.get(startIndex);
	        }
	        int size = arr.length;

	        int remainingLength = size-startIndex;

	        if(remainingLength<=arr[startIndex]){
	            //means no further recursion is required
	            return 1;
	        }
	        if(arr[startIndex]==0){
//	            System.out.println("Cannot move further");
	            return Integer.MAX_VALUE;
	        }
	        int jumps = Integer.MAX_VALUE;
	        for (int i = 1; i <=arr[startIndex]; i++) {
	            int temp = findJumpsTopDownDP(arr, startIndex+i);
	            if(temp!=Integer.MAX_VALUE){// check if path from jumps[j] is not blocked, means arr[startIndex]!=0
	                jumps = Math.min(jumps, 1 + findJumpsTopDownDP(arr, startIndex+i));
	            }else{
	                //ignore...cannot pass through 0
	            }
	        }
	        map.put(startIndex,jumps);
	        return jumps;
	    }
	
	
	public static void main(String[] args) {
		int nums[] = {2,3,1,1,4};
		System.out.println(jump(nums));
	}

}
