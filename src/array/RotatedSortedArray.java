package array;

public class RotatedSortedArray {
	
	static int findPivot(int arr[], int low, int high) {
		if(low<=high) {
			int mid = low+(high-low)/2;
			if(high-low<=1) {
				if(arr[high] > arr[low]){
					return low;
				}else {
					return high;
				}
			}
			if(arr[low]>=arr[mid]) {
				return findPivot(arr, low, mid);
			}
			else {
				return findPivot(arr, mid, high);
			}
		}
		return -1;
	}
	
	static int search(int nums[], int target) {
		if(nums.length==0) {
			return -1;
		}
		if(nums[0] <= nums[nums.length-1]) {
			return binarySearch(nums, 0, nums.length-1, target);
		}
		int pivot = findPivot(nums, 0, nums.length-1);
		if(nums[pivot] == target) {
			return pivot;
		}
		if(nums[0]<=target) {
			return binarySearch(nums, 0, pivot-1, target);
		}else {
			return binarySearch(nums, pivot+1, nums.length-1, target);
		}
	}
	
	static int binarySearch(int arr[], int low, int high, int key) {
		if(low<=high) {
			int mid = low + (high-low)/2;
			if(arr[mid] == key) {
				return mid;
			}
			if(arr[mid]>key) {
				return binarySearch(arr, low, mid-1, key);
			}else {
				return binarySearch(arr, mid+1, high, key);
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8};
		//int arr[] = {8,7,6,5,4,3,2,1};
		//int arr[] = {5,6,7,8,1,2,3,};
		//int arr[] = {4,3,2,1,7,6,5};
		//int arr[] = {1};
		//int arr[] = {5,1,3};
		//int arr[] = {5,1,2,3,4};
		//int arr[] = {4,5,6,7,0,1,2};
		//System.out.println(findPivot(arr, 0, arr.length-1));
		System.out.println(search(arr, 1));
	}

}
