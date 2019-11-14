package datastructure.dp;

public class IntegerBreak {
	
	public int integerBreak(int n) {
		int dp[] = new int[n];
		for(int i=2; i<=n; i++) {
			for(int j=1; j<i; j++) {
				dp[i] = Integer.max(dp[i], Integer.max(dp[i-j]*j,(i-j)*j));
			}
		}
		return dp[n-1];
    }
	
	public static void main(String[] args) {
		
	}

}
