package datastructure.dp;

public class Buy_and_Sell_Stock_with_Cooldown {

	public static int maxProfit(int[] prices) {
	    int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
	    for (int i=0; i<prices.length; ++i){
	        int prvSold = sold;
	        sold = hold + prices[i];
	        hold = Integer.max(hold, rest-prices[i]);
	        rest = Integer.max(rest, prvSold);
	    }
	    return Integer.max(sold, rest);
	}

	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}

}
