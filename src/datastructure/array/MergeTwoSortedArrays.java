package datastructure.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		int[] arr3 = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k++] = arr1[i++];
			} else {
				arr3[k++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			arr3[k++] = arr1[i++];
		}
		
		while (j < arr2.length) {
			arr3[k++] = arr2[j++];
		}
		
		return arr3;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {-1,1,3,5,7,9};
		int[] arr2 = {-2,2,3,4,5,6};
		System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
	}
}
