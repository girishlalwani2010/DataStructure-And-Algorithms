package datastructure.dp;

public class LongestPalindromSubsequence {
	
	public static int longestPalindromeSubseq(String s) {
		
		if(s.isEmpty() || s==null) {
			return 0;
		}
		
		int dp[][] = new int[s.length()+1][s.length()+1];
		char[] charArray = s.toCharArray();
		for(int i=1; i<=charArray.length; i++) {
			dp[i][i] = 1;
		}
		for(int i=1; i<=charArray.length-1; i++) {
			if(charArray[i-1] == charArray[i]) {
				dp[i][i+1] = 2;
			}else {
				dp[i][i+1] = 1;
			}
		}
		
		for(int len=3; len<=charArray.length; len++) {
			for(int j=1; j<=charArray.length-len+1; j++) {
				int end = j+len-1;
				if(charArray[j-1] == charArray[end-1]) {
					dp[j][end] = dp[j+1][end-1] +2;
				}else {
					dp[j][end] = Integer.max(dp[j][end-1], dp[j+1][end]);
				}
			}
		}
		
		return dp[1][s.length()];
		
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("a"));
	}

}
