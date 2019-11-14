package binarysearch;

public class SearchInRotatedSortedArrayWithDuplicates {
	
	static int binarySearch(int[] nums, int low, int high, int target) {
		int mid;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(nums[mid] == target) {
				return mid;
			}
			if(target<nums[mid]) {
				return binarySearch(nums, low, mid-1, target);
			}else {
				return binarySearch(nums, mid+1, high, target);
			}
		}
		return -1;
	}
	
	static int findPivot(int[] nums){
        if(nums.length == 0) {
			return -1;
		}
		if(nums.length == 1) {
			return 0;
		}
		int low=0, high=nums.length-1;
		if(nums[low]<nums[high]) {
			return 0;
		}
		int mid=0;
		while(low<high) {
			mid = low+(high-low)/2;
			if(nums[mid]>nums[high]) {
				low = mid+1;
			}else if(nums[mid]<nums[high]){
				high=mid;
			}else {
				if(nums[high-1] > nums[high]) {
					low=high;
					break;
				}
				high--;
			}
		}
		return low;
	}
	
	public static boolean search(int[] nums, int target) {
		int pivot = findPivot(nums);
        int index=-1;
		if(pivot != -1) {
			if(nums[pivot] == target){
				return true;
			}if(target>nums[nums.length-1]){
				index=binarySearch(nums,0,pivot-1,target);
			}else {
				index=binarySearch(nums,pivot+1,nums.length-1,target);
			}
		}
		if(index>=0 && index<=nums.length-1) {
			return true;
		}else {
			return false;
		}
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(search(nums, 1));
	}

}
