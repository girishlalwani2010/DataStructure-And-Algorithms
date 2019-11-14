package datastructure.dp;

public class PerfectSquares {

	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		int nums[] = new int[n];
		dp[1] = 1;
		int j = 1;
		int nextSquare = 4;
		nums[j] = 1;
		for (int i = 2; i <= n; i++) {
			if (i == nextSquare) {
				j = j+1;
				nums[j] = nextSquare;
				nextSquare = (j + 1) * (j + 1);
			}
			dp[i] = Integer.MAX_VALUE;
			for (int k = j; k > 0; k--) {
				dp[i] = Integer.min(dp[i], 1 + dp[i - nums[k]]);
			}
System.out.println();
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
}
