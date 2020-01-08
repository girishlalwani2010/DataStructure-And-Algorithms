package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakProblem {

	/**
	 * @param s
	 * @param wordDict
	 * @return Visualisation of recursion --
	 *         https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
	 *         Also snap attached for it in mail very intutive.
	 */
	public static boolean wordBreakWithRecursion(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<String>(wordDict);
		return wordBreakWithRecursion(s, wordDictSet);
	}
	
	/**
	 * @param s
	 * @param wordDict
	 * @return
	 * 
	 * Recursion worst case example: 
	 * String s = "aaaab";
	   List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa");
	 */
	private static int recursionCalls=0;
	public static boolean wordBreakWithRecursion(String s, Set<String> wordDict) {
		recursionCalls++;
		int len = s.length();
		if (len == 0) {
			return true;
		}
		// perfect backtracking, that's again perfect 
		for (int i = 1; i <= len; i++) {
			if (wordDict.contains(s.substring(0, i))) {
				if (wordBreakWithRecursion(s.substring(i), wordDict)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * @param s
	 * @param wordDict
	 * @return
	 * 
	 * More Intutive then second one
	 */
	public boolean wordBreakUsingRecursionWithMemoizationII(String s, List<String> wordDict) {
        //convert list to set for O(1) lookup
		Set<String> wordDictSet = new HashSet<String>(wordDict);
        Map<String,Boolean> cache = new HashMap<String, Boolean>();
		return wordBreakUsingRecursionWithMemoizationII(s, wordDictSet, cache);
    }
    
    public boolean wordBreakUsingRecursionWithMemoizationII(String s, Set<String> wordDict, Map<String,Boolean> 
                                          cache){
        int len = s.length();
        
        if(len == 0){
            return true;
        }
        
        if(cache.containsKey(s)){
            return cache.get(s);
        }
        
        for(int i=1; i<=len; i++){
         if(wordDict.contains(s.substring(0,i))){
             if(wordBreakUsingRecursionWithMemoizationII(s.substring(i), wordDict, cache)){
                 cache.put(s,true);
                 return true;
             }
           }   
        }
        cache.put(s,false);
        return false;
    }
	

	public boolean wordBreakUsingRecursionWithMemoization(String s, List<String> wordDict) {
		return wordBreakUtil(s, wordDict, new Boolean[s.length() + 1]);
	}

	public boolean wordBreakUtil(String s, List<String> wordDict, Boolean[] memo) {
		int len = s.length();
		if (len == 0) {
			return true;
		}
		if (memo[len] != null) {
			return memo[len];
		}
		for (int l = 1; l <= len; l++) {
			if (wordDict.contains(s.substring(0, l))) {
				if (wordBreakUtil(s.substring(l), wordDict, memo)) {
					return memo[len] = true;
				}
			}
		}
		return memo[len] = false;
	}
	
	
	
	public static boolean wordBreakWithDP(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<String>(wordDict);
		return wordBreakWithDP(s, wordDictSet);
	}

	/**
	 * @param s
	 * @param wordDict
	 * @return
	 * 
	 * Supproblems will be less in compare to reccursion as we have to backtrack and again have to start from some point
	 * to differentiate with recursion look at https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
	 */
	public static boolean wordBreakWithDP(String s, Set<String> wordDict) {
		//dp[] starts with {T,F,F,F,F,F,F,F,F} for leetcode.
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				// example for str  "leetcode" it place of leet i=4, j starts with 4 it means it will check for leet is it already exist,
				// then checks for lee,t then for le,et then for l,eet then for "",leet it will mark true in dp[4], simlarly for length 8 i.e. leetcode
				// so it basically check by appending one character each time to back i.e. to s.substring(j, i)).
				
				// take example le, lee, leet, code
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		String s = "aaaab";
		List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa");
		System.out.println(wordBreakWithRecursion(s, dict));
		System.out.println("Recursion calls: "+recursionCalls);
	}

}
