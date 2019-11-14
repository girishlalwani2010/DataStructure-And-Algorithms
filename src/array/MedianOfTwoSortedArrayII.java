package array;

public class MedianOfTwoSortedArrayII {

	private static double getMedian(int nums1[], int nums2[]) {
		int i = 0; /* Current index of input array ar1[] */
		int j = 0; /* Current index of input array ar2[] */
		int count;
		int m1 = -1, m2 = -1;
		int n = nums1.length, m = nums2.length;
		if ((m + n) % 2 == 1) {
			for (int index = 0; index <= (n + m) / 2; index++) {
				if (i != n && j != m) {
					m1 = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
				} else if (i < n) {
					m1 = nums1[i++];
				} else {
					m1 = nums2[j++];
				}
			}
			return m1;
		} else {
			for (int index = 0; index <= (n + m) / 2; index++) {
				m2 = m1;
				if (i != n && j != m) {
					m1 = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
				} else if (i < n) {
					m1 = nums1[i++];
				} else {
					m1 = nums2[j++];
				}
			}
			return (m1 + m2) / 2.0;
		}
	}

	public static void main(String[] args) {
		int a[] = {1,3,5,7,9};
		int b[] = {2,4,6,8,10};
		System.out.println(getMedian(a, b));
	}

}
