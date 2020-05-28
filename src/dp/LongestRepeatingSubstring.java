package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author girish_lalwani
 *
 *         https://leetcode.com/problems/longest-repeating-substring/discuss/332506/Java-2-O(n3)-greater-2-O(n2-logn)-greater-2*O-(n2)-greater-O-(n-logn)-greater-O(n)
 */
public class LongestRepeatingSubstring {

	public int longestRepeatingSubstringOn3(String S) {
		Set<String> set = new HashSet<>();
		int max = S.length() - 1, i = 0;
		for (; i <= S.length(); i++) {
			int j = i;
			if (j + max > S.length()) {
				if (--max == 0)
					break;
				i = -1;
				set.clear();
				continue;
			}
			String k = S.substring(j, j + max);
			if (!set.add(k)) {
				return max;
			}
		}
		return max;
	}

	/**
	 * @param S
	 * @return O (n^2 log n) Approach 2 binary search -> if length 3 have duplicate
	 *         pattern, length 2 must have. so if we can search the answer,s = mid +
	 *         1. if not , e = mid - 1. max is 's - 1';
	 */
	public int longestRepeatingSubstringOn2logn(String S) {
		char[] cs = S.toCharArray();
		int s = 1, e = cs.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (search(cs, mid)) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return s - 1;
	}

	boolean search(char[] cs, int k) {
		Set<String> s = new HashSet<>();
		for (int i = 0; i <= cs.length - k; i++) {
			if (!s.add(new String(cs, i, k)))
				return true;
		}
		return false;
	}

	/**
	 * @param S
	 * @return O (n^2 ) Approach 1 dp[i][j] means end with i, end with j , what's
	 *         max length of common string.
	 *         same pattern like longest common substring
	 */
	public int longestRepeatingSubstringOn2(String S) {
		int n = S.length();
		int[][] dp = new int[n + 1][n + 1];// dp[i][j] means # of repeated chars for substrings ending at i and j
		int res = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				if (S.charAt(i - 1) == S.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}
	
	
	//This problem can also be done using rabin-karp rolling hash function algorithm with binary search.
	//length decision will be done by binary search, that will be pass to rabin karp method, to calculate first the initial hash of that length (same as pattern in general rabin-karp).
	// then after that for all substrings of that length by slicing one-character at a time will calculate its hash using rolling hash-function, and check if some string of that length found again, 
	// will use hashset to store previous strings. 
	
	
}
