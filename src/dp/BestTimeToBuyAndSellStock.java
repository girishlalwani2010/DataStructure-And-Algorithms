package dp;

import tree.Max_Subarray;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		if(prices.length == 0) {
			return 0;
		}
		int profit=0, min=prices[0];
		for(int i=1;i<prices.length; i++) {
			if(prices[i]<min) {
				min = prices[i];
			}
			if(profit<(prices[i]-min)) {
				 profit = prices[i]-min;
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

}
