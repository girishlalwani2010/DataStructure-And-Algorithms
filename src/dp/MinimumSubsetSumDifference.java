package dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubsetSumDifference {
	
	private int minimumSubsetSumDiff(int[] nums) {
		Map<String,Integer> memo = new HashMap<>();
		int rem = 0;
		for(int i=0; i<nums.length; i++) {
			rem+=nums[i];
		}
		return minimumSubsetSumDiff(nums, 0, rem, 0, memo);
	}
	
	private int minimumSubsetSumDiff(int[] nums, int total, int rem, int start, Map<String,Integer> memo) {
		if(rem==0) {
			return Integer.MAX_VALUE;
		}
		String key = start+"#"+rem;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int min = Math.abs(total-rem);
		for(int i=start; i<nums.length; i++) {
			min = Math.min(min, minimumSubsetSumDiff(nums, total+nums[i], rem-nums[i], i+1, memo));
		}
		memo.put(key, min);
		return min;
	}

	public static void main(String[] args) {
		MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
	    int[] num = {1, 2, 3, 9};
	    System.out.println(ps.minimumSubsetSumDiff(num));
	    num = new int[]{1, 2, 7, 1, 5};
	    System.out.println(ps.minimumSubsetSumDiff(num));
	    num = new int[]{1, 3, 100, 4};
	    System.out.println(ps.minimumSubsetSumDiff(num));
	}

}
