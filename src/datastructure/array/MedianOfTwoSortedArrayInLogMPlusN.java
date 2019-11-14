package datastructure.array;

import java.util.Arrays;

/**
 * @author girish_lalwani
 */
public class MedianOfTwoSortedArrayInLogMPlusN {

	public static double getMedian(int[] a) {
		if (a.length % 2 == 1) {
			return a[a.length / 2];
		} else {
			return (a[a.length / 2 - 1] + a[a.length / 2]) / 2.0;
		}
	}

	public static double medianOfSortedArraysOfSameSize(int[] nums1, int[] nums2) {
		if (nums1.length == 0) {
			return getMedian(nums2);
		}
		if (nums2.length == 0) {
			return getMedian(nums1);
		}
		if (nums1.length == 1 && nums2.length == 1) {
			return (nums1[0] + nums2[0]) / 2.0;
		}
		if (nums1.length == 2 && nums2.length == 2) {
			return (Math.max(nums1[0], nums2[0]) + Math.min(nums1[1], nums2[1])) / 2.0;
		}
		double m1 = getMedian(nums1);
		double m2 = getMedian(nums2);
		if (m1 < m2) {
			return medianOfSortedArraysOfSameSize(Arrays.copyOfRange(nums1, (nums1.length - 1) / 2, nums1.length),
					Arrays.copyOfRange(nums2, 0, (nums2.length) / 2 + 1));
		} else if (m1 >= m2) {
			return medianOfSortedArraysOfSameSize(Arrays.copyOfRange(nums2, (nums2.length - 1) / 2, nums2.length),
					Arrays.copyOfRange(nums1, 0, (nums1.length) / 2 + 1));
		} else {
			return m1;
		}
	}

	public static double medianOfSortedArrayOfDifferentSize(int nums1[], int nums2[]) {

		// if input1 length is greater than switch them so that input1 is smaller than
		// input2.
		if (nums1.length > nums2.length) {
			return medianOfSortedArrayOfDifferentSize(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
			
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			}
			
			if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException("Input Array is not sorted");
	}

	public static void main(String[] args) {
		int a[] = {1,3};
		int b[] = {2};
		System.out.println(medianOfSortedArrayOfDifferentSize(a, b));
	}

}
