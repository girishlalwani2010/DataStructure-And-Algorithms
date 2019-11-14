package array;

public class MaxSumSubArray {
	
	static int maxContiguousSum(int []arr) {
		
		int currentSum = 0, maxSum = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			currentSum = currentSum + arr[i];
			if(currentSum>maxSum) {
				maxSum = currentSum;
			}
			if(currentSum<0) {
				currentSum = 0;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int []arr = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(maxContiguousSum(arr));
	}

}
