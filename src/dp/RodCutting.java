package dp;

import java.util.HashMap;
import java.util.Map;

public class RodCutting {
	
	private int rodCutting(int length[], int[] prices, int rodLength){
		return rodCutting(length, prices, rodLength, new HashMap<>(), 0);
	}
	
	private int rodCutting(int[] length, int[] prices, int rodLength, Map<Integer, Integer> memo, int start) {
		if(rodLength == 0) {
			return 0;
		}
		if(rodLength<0) {
			return -1;
		}
		int key = rodLength;
		if(memo.containsKey(key)) {
			System.out.println(key);
			return memo.get(key);
		}
		int max = 0;
		for(int i=0; i<length.length; i++) {
			max = Math.max(max, rodCutting(length, prices,rodLength-length[i], memo, i));
		}
		max = max+prices[start];
		memo.put(key, max);
		return max;
	}
	
	public static void main(String[] args) {
		RodCutting rc = new RodCutting();
	    int[] lengths = {1,1,1};
	    int[] prices = {2,2,2};
	    int maxProfit = rc.rodCutting(lengths, prices, 3);
	    System.out.println(maxProfit);
	}
	
}
