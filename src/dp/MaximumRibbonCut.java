package dp;

import java.util.HashMap;
import java.util.Map;

public class MaximumRibbonCut {
	
	private int countRibbonPieces(int[] ribbons, int ribbonLength) {
		return countRibbonPieces(ribbons, ribbonLength , new HashMap<>(), 0);  
	}
	
	private int countRibbonPieces(int[] ribbons, int ribbonLength, Map<Integer, Integer> memo, int start) {
		if(ribbonLength==0) {
			return 0;
		}
		if(ribbonLength<0) {
			return -1;
		}
		int key = ribbonLength;
		if(memo.containsKey(key)) {
			System.out.println("Key: "+key);
			return memo.get(key);
		}
		int max = -1;
		for(int i=0; i<ribbons.length; i++) {
			max = Math.max(max, countRibbonPieces(ribbons, ribbonLength-ribbons[i] , memo, i));
		}
		max = (max == -1)?-1:(max+1);
		memo.put(key, max);
		return max;
	}

	public static void main(String[] args) {
		MaximumRibbonCut cr = new MaximumRibbonCut();
	    int[] ribbonLengths = {2,3,5};
	    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
	    ribbonLengths = new int[]{2,3};
	    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
	    ribbonLengths = new int[]{3,5,7};
	    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
	    ribbonLengths = new int[]{3,5};
	    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
	  }
	
}
