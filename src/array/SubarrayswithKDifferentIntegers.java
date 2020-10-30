package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
	private static int subarraysWithKDistinct(int[] A, int K) {
	    int res = 0, prefix = 0;
	    int start = 0;
	    int distinctCount = 0;
	    Map<Integer, Integer> countMap = new HashMap<>();
	
	    for (int right = 0; right < A.length; right++) {
	        int rightNum = A[right];
	
	        if (!countMap.containsKey(rightNum) || countMap.get(rightNum) == 0) {
	            distinctCount++;
	        }
	
	        countMap.put(rightNum, countMap.getOrDefault(rightNum, 0) + 1);
	
	        if (distinctCount > K) {
	            int startNum = A[start];
	            start++;
	            prefix = 0;
	            countMap.put(startNum, countMap.get(startNum) - 1);
	            distinctCount--;
	        }
	
	        while (countMap.get(A[start]) > 1) {
	            int startNum = A[start++];
	            countMap.put(startNum, countMap.get(startNum) - 1);
	            prefix++;
	        }
	
	        if (distinctCount == K) {
	            res += prefix + 1;
	        }
	
	    }
	    return res;
	} 
	
	
	public static void main(String[] args) {
		int[] A = {1,2,1};
		System.out.println(subarraysWithKDistinct(A,2));
	}
}

