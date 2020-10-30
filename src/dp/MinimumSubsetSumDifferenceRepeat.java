package dp;

public class MinimumSubsetSumDifferenceRepeat {
	
	private int min = Integer.MAX_VALUE;
	
	public int minSubsetSumDiff(int[] nums, int start, int currSum, int remaining) {
		
		if(start == nums.length) {
			return Integer.MAX_VALUE;
		}
		
		int min = Math.abs(currSum-remaining);
		for(int i=start; i<nums.length; i++) {
			min = Math.min(min, minSubsetSumDiff(nums, i+1, currSum+nums[i], remaining-nums[i]));
		}
		return min;
	}
	
	public static int getSum(int[] nums, int start, int end) {
		int total=0;
		for(int i=start; i<end; i++) {
			total+=nums[i];
		}
		return total;
	}
	
	public static void main(String[] args) {
		MinimumSubsetSumDifferenceRepeat ps = new MinimumSubsetSumDifferenceRepeat();
	    int[] nums = {1, 2, 7, 1, 5};//{1, 3, 100, 4};
	    int[] min = {Integer.MAX_VALUE};
	    System.out.println(ps.minSubsetSumDiff(nums, 0, 0, getSum(nums, 0, nums.length)));
//	    System.out.println(min[0]);
	}
}
