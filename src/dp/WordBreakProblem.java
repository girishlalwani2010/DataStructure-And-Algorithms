package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblem {

	/**
	 * @param s
	 * @param wordDict
	 * @return
	 * Visualisation of recursion -- https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
	 */
	public static boolean wordBreakWithRecursion(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<String>(wordDict);
		return wordBreakWithRecursion(s, wordDictSet);
	}

	public static boolean wordBreakWithRecursion(String s, Set<String> wordDict) {
		int len = s.length();
		if (len == 0) {
			return true;
		}
		for (int i = 1; i <= len; i++) {
			if (wordDict.contains(s.substring(0, i)) && wordBreakWithRecursion(s.substring(i), wordDict)) {
				return true;
			}
		}
		return false;

	}
	
	
	public static boolean wordBreakWithDP(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<String>(wordDict);
		return wordBreakWithDP(s, wordDictSet);
	}
	
	public static boolean wordBreakWithDP(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1; i<=s.length(); i++) {
			for(int j=i; j>=0; j--) {
				if(dp[j] && wordDict.contains(s.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> dict = Arrays.asList("leet", "code");
		System.out.println(wordBreakWithDP(s, dict));
	}

}
