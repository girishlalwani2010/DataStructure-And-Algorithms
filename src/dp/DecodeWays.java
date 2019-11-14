package dp;

public class DecodeWays {
	static int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		if (s.length() == 1 && s.equals("0")) {
			return 0;
		}
		if (s.startsWith("0"))
			return 0;
		
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] =1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 1; i < n; i++) {
			int number = Integer.valueOf(s.substring(i, i + 1));
			if (number > 0 && number <= 9) {
				dp[i+1] = dp[i];
			} else {
				dp[i+1] = 0;
			}
			number = Integer.valueOf(s.substring(i-1, i + 1));
			if (number >= 10 && number <= 26) {
				dp[i+1] = dp[i+1] + dp[i-1];
			}
		}

		return dp[n];
	}
	
	public static void main(String[] args) {
        System.out.println(numDecodings("2123"));
    }
}
