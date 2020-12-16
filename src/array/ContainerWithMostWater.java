package array;

public class ContainerWithMostWater {

	/**
	 * @param height
	 * @return
	 * 
	 * 		Try to implement it using left[] and right[], leftMax rightMax
	 *         boundaries for calculating water corresponding to each height, then
	 *         calculate max from result array.
	 */
	public static int maxArea(int A[]) {
		int l = 0;
		int r = A.length - 1;
		int area = 0;

		while (l < r) {
			// Calculating the max area
			area = Math.max(area, Math.min(A[l], A[r]) * (r - l));
			if (A[l] < A[r])
				l += 1;
			else
				r -= 1;
		}
		return area;
	}

	
	public static int maxAreaRepeat(int[] A) {
		
		int left=0;
		int right=A.length-1;
		int maxArea=0;
		while(left<=right) {
			maxArea = Math.max(maxArea, Math.min(A[left], A[right])*(right-left));
			if(A[left]<A[right]) {
				left++;
			}else if(A[right]<A[left]) {
				right--;
			}else {
				left++;
				right--;
			}
		}
		return maxArea;
	}
	
	
	public static void main(String[] args) {
		int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxAreaRepeat(height));
	}

}
