package randomnumbers;

import java.util.Arrays;
import java.util.Random;

public class HeadTail {
	public static void main(String[] args) {
		char[] headTail = {'H','T'};
		int[] w = {2,1};
		Random random = new Random();
		int[] wSum = new int[2];
		wSum[0] = w[0];
		for(int i=1; i<wSum.length; i++) {
			wSum[i] = wSum[i-1]+w[i];
		}
		
		
		for(int i=0; i<9; i++) {
			int randIdx = random.nextInt(wSum[wSum.length-1]+1);
			int coinSideIdx = Arrays.binarySearch(wSum, randIdx);
			coinSideIdx = (coinSideIdx>=0)?coinSideIdx:-(coinSideIdx+1);
			System.out.println(headTail[coinSideIdx]);
			
//			System.out.println(headTail[random.nextInt(headTail.length)]);
		}
	}
}
