package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author girish_lalwani
 * Count pairs with given sum
   Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 
*	Input  :  arr[] = {1, 5, 7, -1}, 
	          sum = 6
	Output :  2
	Pairs with sum 6 are (1, 5) and (7, -1)
	
	Input  :  arr[] = {1, 5, 7, -1, 5}, 
	          sum = 6
	Output :  3
	Pairs with sum 6 are (1, 5), (7, -1) &
	                     (1, 5)         
	
	Input  :  arr[] = {1, 1, 1, 1}, 
	          sum = 2
	Output :  6
	There are 3! pairs with sum 2.
	
	Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
	                   5, 4, 2, 1, 1, 1}, 
	          sum = 11
	Output :  9
 */
public class CountPairsWithSum {

	private static int getPairCounts(int []arr, int sum) {
		int arrLength = arr.length; 
		Map<Integer, Integer> frequencyMap = new HashMap<Integer,Integer>();
		for(int i=0; i<arrLength; i++) {
			if(!frequencyMap.containsKey(arr[i])) {
				frequencyMap.put(arr[i], 1);
			}else {
				frequencyMap.put(arr[i], frequencyMap.get(arr[i])+1);
			}
		}
		
		int twiceCount =0;
		for(int i=0; i<arrLength; i++) {
			int firstNum = arr[i];
			int secondNum = sum-firstNum;
			if(frequencyMap.containsKey(secondNum)) {
				twiceCount = twiceCount + frequencyMap.get(secondNum);
			}
			if(firstNum == secondNum) {
				twiceCount--;
			}
		}
		return twiceCount/2;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,1,1,1};
		int sum = 2;
		System.out.println(getPairCounts(arr, sum));
	}
	
}
