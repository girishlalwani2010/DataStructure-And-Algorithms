package dp;

import java.util.Currency;

/**
 * @author girish_lalwani
 * 
 * 
 * Another Solution 
 * Expand Around Center best video https://www.youtube.com/watch?v=y2BD4MJqV20
 * 
 *
 */
public class LongestPalindromSubstring {
	
	public static String longestPalindrome(String s) {
		
		if(s.isEmpty() || s==null) {
			return "";
		}
        
		boolean [][]palindrom = new boolean[s.length()][s.length()];
		int lengthOfString = s.length();
		int start = 0,end = 0;
		
		for(int i=0; i<s.length(); i++) {
			palindrom[i][i] = true;
			start=i;
			end=i;
		}
		
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				palindrom[i][i+1] = true;
				start=i;
				end=i+1;
			}
			
		}
		for(int currLength=3; currLength<=lengthOfString; currLength++) {
			for(int i=0; i<lengthOfString-currLength+1; i++) {
				int j=i+currLength-1;
				if(s.charAt(i) == s.charAt(j)) {
					if(palindrom[i+1][j-1] == true) {
						palindrom[i][j] = true;
						start = i;
						end = j;
					}
				}
			}
			
			
		}
		
		return s.substring(start, end+1);
		
    }
	
	
	/**
	 * @param s
	 * @return
	 * 
	 * Expand Around Center best video https://www.youtube.com/watch?v=y2BD4MJqV20
	 * 
	 * best way that is intutive.
	 * 
	 * one more intutive way using top-down memo recursion
	 * https://www.techiedelight.com/longest-palindromic-subsequence-using-dynamic-programming/
	 * 
	 */
	public String longestPalindromeExpandArroundCenter(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("banana"));
	}
	

}
