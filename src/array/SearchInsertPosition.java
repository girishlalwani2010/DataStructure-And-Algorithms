package array;

public class SearchInsertPosition {
	
	public static int binarySearch(int []arr, int low, int high, int target) {
		if(low<=high) {
			int mid = low+(high-low)/2;
			if(arr[mid] == target) {
				return mid;
			}
			if(arr[mid]>target) {
				return binarySearch(arr, low, mid-1, target);
			}else {
				return binarySearch(arr, mid+1, high, target);
			}
			
		}
		return low;
	}
	
	public static int searchInsert(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length-1, target);
    }
	
	public static void main(String[] args) {
		int nums[] = {1,3,5,6};
		int target=2;
		System.out.println(searchInsert(nums, target));
	}

}
