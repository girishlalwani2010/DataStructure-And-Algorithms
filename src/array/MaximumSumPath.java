package array;

public class MaximumSumPath {

	static int maxPathSum(int arr1[], int arr2[]) {
		// initialize indexes for ar1[] and ar2[]
		int i = 0, j = 0;

		// Initialize result and current sum through ar1[] and ar2[].
		int result = 0, sum1 = 0, sum2 = 0;
		
		// Below 3 loops are similar to merge in merge sort
		while (i < arr1.length && j < arr2.length) {
			// Add elements of ar1[] to sum1
			if (arr1[i] < arr2[j])
				sum1 += arr1[i++];

			// Add elements of ar2[] to sum2
			else if (arr1[i] > arr2[j])
				sum2 += arr2[j++];

			// we reached a common point
			else {
				// Take the maximum of two sums and add to result
				result += Math.max(sum1, sum2);

				// Update sum1 and sum2 for elements after this
				// intersection point
				sum1 = 0;
				sum2 = 0;

				// Keep updating result while there are more common
				// elements
				while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
					result = result + arr1[i++];
					j++;
				}
			}
		}

		// Add remaining elements of ar1[]
		while (i < arr1.length)
			sum1 += arr1[i++];

		// Add remaining elements of ar2[]
		while (j < arr2.length)
			sum2 += arr2[j++];

		// Add maximum of two sums of remaining elements
		result += Math.max(sum1, sum2);

		return result;
	}

	public static void main(String[] args) {

		int arr1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int arr2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

		System.out.println(maxPathSum(arr1, arr2));
	}

}
