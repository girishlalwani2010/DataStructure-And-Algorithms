package datastructure.dp;

public class LongestCommonSubstring {
	
	public static String longestCommonSubstring(String s1, String s2) {
		
		char cs1[] = s1.toCharArray();
		char cs2[] = s2.toCharArray();
		int [][]dp = new int[cs1.length][cs2.length];
		
		for(int i=0; i<cs1.length; i++) {
			if(cs2[0] == cs1[i]) {
				dp[i][0] = 1;
			}
		}
		
		for(int i=0; i<cs2.length; i++) {
			if(cs1[0] == cs2[i]) {
				dp[0][i] = 1;
			}
		}
		int maxLength=0;
		int endIndex = 0;
		for(int i=1; i<cs1.length; i++) {
			for(int j=1; j<cs2.length; j++) {
				if(cs1[i] == cs2[j]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				if(dp[i][j] > maxLength) {
					maxLength = dp[i][j];
					endIndex = i;
				}
			}
		}
		return s1.substring(endIndex-maxLength+1, maxLength);
	}
	
	
	public static void main(String[] args) {
		
		String A = "tutorialhorizon";
		String B = "dynamictutorialProgramming";
		System.out.println(longestCommonSubstring(A, B));
		
		
	}
}
