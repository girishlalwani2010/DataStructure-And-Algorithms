package array;

/**
 * @author girish_lalwani 
 */
public class TrappingRainWater {

	public static int trap(int[] height) {

		if (height.length == 0) {
			return 0;
		}

		int trapArea = 0;
		int max = height[0];
		int maxIndex = 0;
		int currHeight = height[0];

		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxIndex = i;
			}
		}

		for (int i = 1; i < maxIndex; i++) {
			if (currHeight < height[i]) {
				currHeight = height[i];
			} else {
				trapArea = trapArea + (currHeight - height[i]);
			}
		}

		currHeight = height[height.length - 1];
		for (int i = height.length - 1; i > maxIndex; i--) {
			if (currHeight < height[i]) {
				currHeight = height[i];
			} else {
				trapArea = trapArea + (currHeight - height[i]);
			}
		}
		return trapArea;
	}

	/**
	 * @param arr
	 * @param n
	 * @return
	 * 
	 * we have to decrease right pointer till a[left] is less than or equal to a[right]
	 */
	static int findWater(int arr[], int n) {
		// initialize output
		int result = 0;

		// maximum element on left and right
		int left_max = 0, right_max = 0;

		// indices to traverse the array
		int lo = 0, hi = n - 1;

		while (lo <= hi) {
			if (arr[lo] < arr[hi]) {
				if (arr[lo] > left_max)

					// update max in left
					left_max = arr[lo];
				else

					// water on curr element =
					// max - curr
					result += left_max - arr[lo];
				lo++;
			} else {
				if (arr[hi] > right_max)

					// update right maximum
					right_max = arr[hi];

				else
					result += right_max - arr[hi];
				hi--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(findWater(height, height.length));
	}

}
