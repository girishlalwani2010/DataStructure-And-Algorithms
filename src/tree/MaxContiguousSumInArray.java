package tree;

import java.util.Scanner;

public class MaxContiguousSumInArray {

	/**
	 * For Example : arr = {-2,-3,4,-1,-2,1,5,-3}
	 * 
	 * max_ending_here = {-2,-3, 4, 3, 1, 2, 7, 4}
	 * max_so_far      = {-2,-2, 4, 4, 4, 4, 7, 7}
	 * 
	 * @param arr
	 * @return
	 */
	private static int calculateMaxContiguousSum(int[] arr) {
		
		int size = arr.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
	}
	
	public static void main(String args[]){
		
		int [] arr = {-5,-7,-1,-10};
		System.out.println(calculateMaxContiguousSum(arr));
		
	}

	
	
	
}
