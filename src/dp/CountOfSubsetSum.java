	package dp;
	
	import java.util.HashMap;
	import java.util.Map;
	
	public class CountOfSubsetSum {
		
		private int countSubsetsRecursive(int[] num, int rem, int start, Map<String, Integer> memo) {
			if(rem == 0) {
				return 1;
			}
			String key = start+"#"+rem;
			if(memo.containsKey(key)) {
				System.out.println(key);
				return memo.get(key);
			}
			int count=0;
			for(int i=start; i<num.length; i++) {
				count+=countSubsetsRecursive(num, rem-num[i], i+1, memo);
			}
			memo.put(key, count);
			return count;
		}
	
		public int countSubsets(int[] num, int sum) {
			return countSubsetsRecursive(num, sum, 0, new HashMap<>());
		}
	
		public static void main(String[] args) {
			CountOfSubsetSum countOfSubsetSum = new CountOfSubsetSum();
			int[] num = { 1, 1, 2, 3 };
			System.out.println(countOfSubsetSum.countSubsets(num, 4));
			num = new int[] { 1, 2, 7, 1, 5 };
			System.out.println(countOfSubsetSum.countSubsets(num, 9));
		}
	}
