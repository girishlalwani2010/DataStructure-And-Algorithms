package dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
	 /**
	 * @param text1
	 * @param text2
	 * @return
	 * 
	 * 26 ms Runtime on Leetcode.
	 */
	public int longestCommonSubsequence(String text1, String text2) {
	        int m = text1.length();
	        int n = text2.length();
	        return longestCommonSubsequenceUsingTopDownMemoization(text1, text2, m-1, n-1, new Integer[m][n]);
	    }
	    
	    public int longestCommonSubsequenceUsingTopDownMemoization(String text1, String text2, int m, int n,Integer dp[][]){
	        if(m<0 || n<0){
	            return 0;
	        }
	        
	        if(dp[m][n]!=null){
	            return dp[m][n]; // or map.get(i+"|"+j);
	        }
	        
	        if(text1.charAt(m) == text2.charAt(n)){
	            // or map.put(i+"|"+j, 1+longestCommonSubsequence(text1, text2, i-1, j-1));
	            dp[m][n] = 1+longestCommonSubsequenceUsingTopDownMemoization(text1, text2, m-1, n-1, dp);
	        }else{
	            dp[m][n] = Math.max(longestCommonSubsequenceUsingTopDownMemoization(text1, text2, m-1, n, dp),longestCommonSubsequenceUsingTopDownMemoization(text1, text2, m, n-1, dp));
	        }
	        
	        return dp[m][n];
	    }
	
	
	public static int LCSLengthWithDPNaive(String s1, String s2, int m, int n) {
		int dp[][] = new int[m][n];
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		if(cs1[0] == cs2[0]) {
			dp[0][0]=1;
		}
		
		for(int i=1; i<cs1.length; i++) {
			dp[i][0]=(cs1[i] == cs2[0])?1:dp[i-1][0];
		}
		
		for(int i=1; i<cs2.length; i++) {
			dp[0][i]=(cs1[0] == cs2[i])?1:dp[0][i-1];
		}
		
		
		for(int i=1; i<cs1.length; i++) {
			for(int j=1; j<cs2.length; j++) {
				if(cs2[j] == cs1[i]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m-1][n-1];
		
	}
	
	
	/**
	 * @param s1
	 * @param s2
	 * @param m
	 * @param n
	 * @return
	 * 6ms Runtime on Leetcode.
	 */
	public static int LCSLengthWithDP(String s1, String s2, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		for(int i=1; i<=cs1.length; i++) {
			for(int j=1; j<=cs2.length; j++) {
				if(cs2[j-1] == cs1[i-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	
	
	public static String LCSWithDP(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m+1][n+1];
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		for(int i=1; i<=cs1.length; i++) {
			for(int j=1; j<=cs2.length; j++) {
				if(cs2[j-1] == cs1[i-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int i=m,j=n;
		String lcs = "";
		while(i>0 && j>0)
		{
			if(cs1[i-1] == cs2[j-1]) {
				lcs = cs1[i-1] + lcs;
				i--;
				j--;
			}
			else {
				if(dp[i-1][j] > dp[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		System.out.println("Longest Common Subsequence is : "+lcs);
		return lcs;
	}
	
	
	public static int LCSLengthWithDPWithNSpace(String s1, String s2) {
		
		int n = s2.length();
		
		int[] prevRow = new int[n+1]; 
		int[] currRow = new int[n+1];
		
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		for(int i=1; i<=cs1.length; i++) {
			for(int j=1; j<=cs2.length; j++) {
				if(cs2[j-1] == cs1[i-1]) {
					currRow[j] = prevRow[j-1] +1;
				}else {
					currRow[j] = Math.max(prevRow[j], currRow[j-1]);
				}
			}
			prevRow = Arrays.copyOf(currRow, n+1);
		}
		return currRow[n];
	}

	
	public static void main(String[] args) {
		String s1 = "ACB";
		String s2 = "ABC";
		//System.out.println(LCSLengthWithRecursion(s1, s2, s1.length(), s2.length()));
		//System.out.println(LCSLengthWithRecursionAndMemoization(s1, s2, s1.length(), s2.length(), new int[s1.length()][s2.length()]));
		System.out.println(LCSWithDP(s1, s2));
	}

}
