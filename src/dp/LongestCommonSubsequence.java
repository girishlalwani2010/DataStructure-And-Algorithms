package dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
	public static int LCSLengthWithRecursion(String s1, String s2, int m, int n) {
		if(m==0 || n==0) {
			if(s1.indexOf(s2.charAt(n))>=0 || s2.indexOf(s1.charAt(m))>=0)
				return 1;
			return 0;
		}
//		if(m<0 || n<0) {
//			return 0;
//		}
		else {
			if(s1.charAt(m-1) == s2.charAt(n-1)) {
				return LCSLengthWithRecursion(s1, s2, m-2, n-2) + 1;
			}else {
				return Math.max(LCSLengthWithRecursion(s1, s2, m-2, n-1), LCSLengthWithRecursion(s1, s2, m-1, n-2));
			}
			
		}
	}
	
	public static int LCSLengthWithRecursionAndMemoization(String s1, String s2, int m, int n, int[][] memoForRecursion) {
		if(m<0 || n<0) {
			return 0;
		}
		if(memoForRecursion[m][n] == 0) {
			if(s1.charAt(m) == s2.charAt(n)) {
				memoForRecursion[m][n] = LCSLengthWithRecursionAndMemoization(s1, s2, m-1, n-1,memoForRecursion) + 1;
			}else {
				memoForRecursion[m][n] = Math.max(LCSLengthWithRecursionAndMemoization(s1, s2, m-1, n,memoForRecursion), LCSLengthWithRecursionAndMemoization(s1, s2, m, n-1,memoForRecursion));
			}
		}
		return memoForRecursion[m][n];
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
