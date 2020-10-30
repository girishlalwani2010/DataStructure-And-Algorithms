package dp;

import java.util.Arrays;

public class MinCoinChange {

	public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); 
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i){
                   dp[i] = Integer.min(dp[i],dp[i-coins[j]]+1); 
                }
            }
        }
        return dp[amount];
    }
	
	
	 public static int coinChangeTopDown(int[] coins, int amount) {
	        return coinChange(coins, amount, 0, new Integer[amount+1]);
	    }
	    
    private static int coinChange(int[] coins, int remaining, int start, Integer[] memo){
    	System.out.println("remaining:"+remaining+" ,start:"+start);
        if(remaining == 0){
            return 0; 
        }
        
        if(remaining<0){
            return -1;
        }
        
        if(memo[remaining]!=null){
            return memo[remaining];
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res = coinChange(coins, remaining-coins[i], i, memo);
            if(res>=0){
                min = Math.min(min, res+1);
            }
        }
        min = ((min == Integer.MAX_VALUE) ? -1:min);
        return memo[remaining] = min;
    }
	
	public static void main(String[] args) {
		int []coins = {5,1,3,2};
		int amount = 11;
		System.out.println(coinChangeTopDown(coins, amount));
	}
}
