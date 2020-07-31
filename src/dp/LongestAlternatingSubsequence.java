package dp;

public class LongestAlternatingSubsequence {

	private int findLASLength(int[] nums) {
		return 1 + Math.max(findLASLength(nums, 1, nums.length, true),
				findLASLength(nums, 1, nums.length, false));
	}

	private int findLASLength(int[] nums, int start, int end, boolean asc) {
		if (start == end) {
			return 0;
		}
		int res = 0;
		if (nums[start] > nums[start - 1] && asc) {
			asc = false;
			res = Math.max(res, 1 + findLASLength(nums, start + 1, end, asc));
		} else if (nums[start] < nums[start - 1] && !asc) {
			asc = true;
			res = Math.max(res, 1 + findLASLength(nums, start + 1, end, asc));
		}
		return Math.max(res, findLASLength(nums, start + 1, end, asc));
	}

	public static void main(String[] args) {
		LongestAlternatingSubsequence las = new LongestAlternatingSubsequence();
	    int[] nums = {1,2,3,4};
	    System.out.println(las.findLASLength(nums));
	    nums = new int[]{3,2,1,4};
	    System.out.println(las.findLASLength(nums));
	    nums = new int[]{1,3,2,4};
	    System.out.println(las.findLASLength(nums));
	}

}
