package dp;

public class UnboundedKnapsack {
	
	private int unboundedknapsack(int[] weights, int[] profits, int capacity, int start, Integer[][] memo) {
		
		if(capacity == 0) {
			return 0;
		}
		
		if(memo[start][capacity]!=null) {
			return memo[start][capacity];
		}
		
		int maxProfit=0;
		for(int i=start; i<weights.length; i++) {
			if(weights[i]<=capacity) {
				maxProfit = Math.max(maxProfit,profits[i]+unboundedknapsack(weights, profits, capacity-weights[i], i, memo));
			}
		}
		
		return memo[start][capacity] = maxProfit;
	}
	
	public static void main(String[] args) {
		UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
		int[] profits = {15, 50, 60, 90};
	    int[] weights = {1, 3, 4, 5};
	    int capacity = 6;
		System.out.println(unboundedKnapsack.unboundedknapsack(weights, profits, capacity, 0, new Integer[profits.length+1][capacity+1]));
	}

}
