package datastructure.dp;

/**
 * @author girish_lalwani
 *  
 *  Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *  
 * 
 */
public class BuyAndSellStockWithAtMostKTransactions {
	
	 public static int maxProfit(int K, int[] prices) {
		 
		 if(K==0 || prices.length==0) {
			 return 0;
		 }
		 
		 int[][] T = new int[K+1][prices.length];
		 for(int i=1; i<=K; i++) {
			 for(int j=1; j<prices.length; j++) {
				 int maxProfitForSellingAtIthDay=0;
				 for(int m=0; m<j; m++) {
				 /**calculating max profit by including that price as a sell in transaction
				  	finding bought price from 0 ---- j-1, to maximize the profit including that transaction
				  	prices[j] - prices[m] + T[i-1][m] -- profit if stock bought at m index price.
				  **/
					maxProfitForSellingAtIthDay = Math.max(maxProfitForSellingAtIthDay, prices[j] - prices[m] + T[i-1][m]);
				 }
				 //T[i][j-1] is the price of excluding this price from transaction, i.e. not selling at this price
				 T[i][j] = Integer.max(T[i][j-1], maxProfitForSellingAtIthDay);
			 }
		 }
		 return T[K][prices.length-1];
     }
	 
	 public static int maxProfitWithBigONKComplexity(int K, int[] prices) {
		 if(K==0 || prices.length==0) {
			 return 0;
		 }
		 int[][] T = new int[K+1][prices.length];
		 for(int i=1; i<=K; i++) {
			 int prevDiff = Integer.MIN_VALUE;
			 for(int j=1; j<prices.length; j++) {
				 prevDiff = Integer.max(prevDiff, T[i-1][j-1]-prices[j-1]);
				 T[i][j] =  Integer.max(prices[j] + prevDiff, T[i][j-1]);
			 }
		 }
		 return T[K][prices.length-1];
     }
	
//	 public static int maxProfitWithNSpace(int K, int[] prices) {
//		 //TODO: need to be implemented
//	 }
	 
	 
	
	public static void main(String[] args) {
		int []prices = {2,4,1};
		int K=2;
		System.out.println(maxProfitWithBigONKComplexity(K, prices));
	}

}
