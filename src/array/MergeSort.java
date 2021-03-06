package array;

import java.util.HashSet;

public class MergeSort {
	
		// Merges two subarrays of arr[]. 
		// First subarray is arr[l..m] 
		// Second subarray is arr[m+1..r] 
		void merge(int arr[], int l, int m, int r) 
		{ 
			// Find sizes of two subarrays to be merged 
			int n1 = m - l + 1; 
			int n2 = r - m; 

			/* Create temp arrays */
			int L[] = new int [n1]; 
			int R[] = new int [n2]; 

			/*Copy data to temp arrays*/
			for (int i=0; i<n1; ++i) 
				L[i] = arr[l + i]; 
			for (int j=0; j<n2; ++j) 
				R[j] = arr[m + 1+ j]; 


			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays 
			int i = 0, j = 0; 

			// Initial index of merged subarry array 
			int k = l; 
			while (i < n1 && j < n2) 
			{ 
				if (L[i] <= R[j]) 
				{ 
					arr[k] = L[i]; 
					i++; 
				} 
				else
				{ 
					arr[k] = R[j]; 
					j++; 
				} 
				k++; 
			} 

			/* Copy remaining elements of L[] if any */
			while (i < n1) 
			{ 
				arr[k] = L[i]; 
				i++; 
				k++; 
			} 

			/* Copy remaining elements of R[] if any */
			while (j < n2) 
			{ 
				arr[k] = R[j]; 
				j++; 
				k++; 
			} 
		} 

		// Main function that sorts arr[l..r] using 
		// merge() 
		void sort(int arr[], int l, int r) 
		{ 
			if (l < r) 
			{ 
				// Find the middle point 
				int m = (l+r)/2; 

				// Sort first and second halves 
				sort(arr, l, m); 
				sort(arr , m+1, r); 
				
				// if arr[m] < arr[m+1]	return; for case array is already sorted, 
				// to improve the best case complexity to O(n)
				
				// Merge the sorted halves 
				merge(arr, l, m, r); 
			} 
		} 

		/* A utility function to print array of size n */
		static void printArray(int arr[]) 
		{ 
			int n = arr.length; 
			for (int i=0; i<n; ++i) 
				System.out.print(arr[i] + " "); 
			System.out.println(); 
		} 

		// Driver method 
		public static void main(String args[]) 
		{ 
			int arr[] = {12, 11, 13, 5, 6, 7}; 

			System.out.println("Given Array"); 
			printArray(arr); 

			MergeSort ob = new MergeSort(); 
			ob.sort(arr, 0, arr.length-1); 

			System.out.println("\nSorted array"); 
			printArray(arr); 
			
			HashSet<Integer> set = new HashSet<>();
			int[] arr1 = {26,78,27,100,33
			             ,67,90,23,66
			             ,5,38,7,35,
			             23,52,22,83
			             ,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,41};
			for(int i:arr1) {
				set.add(i);
			}
			System.out.println(set);
		} 
	} 

