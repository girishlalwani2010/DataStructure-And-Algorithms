package datastructure.array;

public class MedianOfTwoSortedArray {

	static double getMedian(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		double m=0,m1=0,m2=0;
		if (totalLength % 2 == 0) {
			int size = (nums1.length == nums2.length) ? totalLength / 2 : totalLength / 2 + 1, i = 0, j = 0;
			for (int count = 0; count < size - 1; count++) {
				if (nums1[i] < nums2[j]) {
					m1 = nums1[++i];
				} else if (nums2[j] < nums1[i]) {
					m2 = nums2[++j];
				} else {
					m1 = nums1[++i];
					m2 = nums2[++j];
				}
			}
			return (m1 + m2) / 2;
		}
		else {
			int size = (nums1.length == nums2.length) ? totalLength / 2 : totalLength / 2 + 1, i = 0, j = 0;
			for (int count = 0; count < size - 1; count++) {
				if (nums1[i] < nums2[j]) {
					m = nums1[++i];
				} else {
					m = nums2[++j];
				} 
			}
			return m;
		}
	}

	public static void main(String[] args) {

		int ar1[] = {1};
		int ar2[] = { 2, 13, 17, 30, 45 };
		// 1,2,12,13,15,17,26,30,45
		int n1 = ar1.length;
		int n2 = ar2.length;
		System.out.println("Median is " + getMedian(ar1, ar2));

	}

}
