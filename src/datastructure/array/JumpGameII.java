package datastructure.array;

/**
 * @author girish_lalwani
 *	
 *	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.
 */
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
	
	public static void main(String[] args) {
		int nums[] = {1,5,0};
		System.out.println(jump(nums));
	}

}
