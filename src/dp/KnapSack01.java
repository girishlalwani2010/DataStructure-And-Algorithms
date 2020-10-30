package dp;

import java.util.HashMap;
import java.util.Map;

public class KnapSack01 {
	
	private int solveKnapsack(int[] profit, int[] weight, int capacity, int start, Map<String, Integer> memo) {
		
		if(capacity==0) {
			return 0;
		}
		if(capacity<0) {
			return -1;
		}
		String key = capacity+"#"+start;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int maxProfit=0;
		for(int i=start; i<weight.length; i++){
//			System.out.println("[start,i] "+"["+start+","+i+"]");
			System.out.println("Subproblems: [capacity,start] "+"["+capacity+","+start+"]");
			if(capacity-weight[i]>=0) {
				maxProfit=Math.max(maxProfit, profit[i]+solveKnapsack(profit, weight,capacity-weight[i], i+1, memo));	
			}
		}
		memo.put(key, maxProfit);
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    KnapSack01 knapSack01 = new KnapSack01();
	    System.out.println(knapSack01.solveKnapsack(profits, weights,7, 0, new HashMap<>()));
	}

}
