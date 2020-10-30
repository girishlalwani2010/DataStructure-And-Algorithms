	package dp;
	
	import java.util.HashMap;
	import java.util.Map;
	
	public class CountOfSubsetSum {
		
		private int countSubsets(int[] nums, int remaining, int start, Integer[][] memo) {
			
			if(remaining==0) {
				return 1;
			}
			if(remaining<0) {
				return 0;
			}
			if(start == nums.length) {
				return 0;
			}
			if(memo[start][remaining]!=null) {
				return memo[start][remaining];
			}
			int count=0;
			for(int i=start; i<nums.length; i++) {
				count+=countSubsets(nums, remaining-nums[i], i+1, memo);
			}
			return memo[start][remaining] = count;
		}
	
		public int countSubsets(int[] nums, int remaining) {
			return countSubsets(nums, remaining, 0, new Integer[nums.length][remaining+1]);
		}
	
		public static void main(String[] args) {
			CountOfSubsetSum countOfSubsetSum = new CountOfSubsetSum();
			int[] num = { 1, 1, 2, 3 };
			System.out.println(countOfSubsetSum.countSubsets(num, 4));
			num = new int[] { 1, 2, 7, 1, 5 };
			System.out.println(countOfSubsetSum.countSubsets(num, 9));
		}
	}
