package binarysearch;

import java.util.TreeSet;

/**
 * @author girish_lalwani
 * we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
   Keep on finding the gap between currentsum and k, then minimized the gap by calling ceiling of gap;
   and why use treeset as we know that if we keep the data in sorted order then it is easier to find the element 
   closest and greater then it, as treeset mantain the elements in sorted order. Tricky like it. 
   https://www.geeksforgeeks.org/find-closest-smaller-value-for-every-element-in-array/
 */
public class SuArrayWithSumLessThanEqualtok {
	
	public static void main(String[] args) {
		
		int[] sums = {-2,-3,-5,8,10}; 
		int k =18;
		int result = Integer.MIN_VALUE;
		TreeSet<Integer> set = new TreeSet<Integer>();
	     //add 0 to cover the single row case
	     set.add(0);
	     int currSum = 0;
	     
	     for(int sum : sums){
	         currSum += sum;
	         //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
	         //therefore we need to look for the smallest sum >= currSum - k
	         Integer num = set.ceiling(currSum - k);
	         if(num != null) result = Math.max( result, currSum - num );
	         set.add(currSum);
	         System.out.println("[currsum, currsum-k, num, set, result]: "+currSum+" ,"+(currSum - k)+" ,"+num+", "+set.toString()+", "+result);
	     }
	     
	     System.out.println(result);
		
	}
	
	 

}
