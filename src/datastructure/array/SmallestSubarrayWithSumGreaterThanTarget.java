package datastructure.array;

public class SmallestSubarrayWithSumGreaterThanTarget {

	private static int smallestSubArrayWithSum(int arr[], int target) {
		int arrLength = arr.length, sum=0, subArrLength=0, j=0, minSubArrLength=Integer.MAX_VALUE;
		for(int i=0; i<arrLength; i++) {
			sum = sum+arr[i];
			subArrLength++;
			while(sum-arr[j]>target) {
				subArrLength--;
				sum = sum - arr[j++];
			}
			if(sum>target && minSubArrLength>subArrLength){
				minSubArrLength = subArrLength;
			}
		}
		if(minSubArrLength == Integer.MAX_VALUE) {
			return -1;
		}
		return minSubArrLength;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1, -2, 4};
		
		System.out.println(smallestSubArrayWithSum(arr, 1));
	}
	
}
