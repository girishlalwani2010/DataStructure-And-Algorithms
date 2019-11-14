package datastructure.array;

public class LongestIncreasingSubArray {
	
	static int longestIncreasingSubarrayLength(int []arr) {
		int length=1,maxLength=1;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1]>arr[i]) {
				length++;
			}else {
				if(length>maxLength) {
					maxLength=length;
				}
				length=1;
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2};
		System.out.println(longestIncreasingSubarrayLength(arr));
	}

}
