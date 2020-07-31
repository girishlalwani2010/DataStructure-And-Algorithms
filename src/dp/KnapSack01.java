package dp;

import java.util.HashMap;
import java.util.Map;

public class KnapSack01 {
	
	private int solveKnapsack(int[] profit, int[] weight, int maxProfit, int capacity, int start, Map<String, Integer> memo) {
		if(capacity==0) {
			return maxProfit;
		}
		if(capacity<0) {
			return -1;
		}
		String key = capacity+"#"+start;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int max = Integer.MIN_VALUE;
		for(int i=start; i<weight.length; i++){
			int res = solveKnapsack(profit, weight, maxProfit+profit[i], capacity-weight[i], i+1, memo);
			if(res>=0 && res>max) {
				max=res;
			}
		}
		max = (max == Integer.MIN_VALUE) ? -1 : max;
		memo.put(key, max);
		return max;
	}
	
	public static void main(String[] args) {
		int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    KnapSack01 knapSack01 = new KnapSack01();
	    System.out.println(knapSack01.solveKnapsack(profits, weights,0, 7, 0, new HashMap<>()));
	}

}
