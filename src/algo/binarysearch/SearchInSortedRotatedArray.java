package algo.binarysearch;

public class SearchInSortedRotatedArray {
	
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
		if(nums.length == 1) {
			return 0;
		}
		int low=0, high=nums.length-1;
		if(nums[low]<nums[high]) {
			return 0;
		}
		int mid=0;
		while(low<=high) {
			mid = low+(high-low)/2;
			if((mid-1)>=0 && nums[mid]<nums[mid-1]) {
				return mid;
			}if(nums[mid]>nums[high]) {
				low = mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;
	}
	
	public static int search(int[] nums, int target) {
		int pivot = findPivot(nums);
		System.out.println("pivot: "+pivot);
		if(pivot != -1) {
			if(nums[pivot] == target){
				return pivot;
			}if(target>nums[nums.length-1]){
				return binarySearch(nums,0,pivot-1,target);
			}
			return binarySearch(nums,pivot+1,nums.length-1,target);
		}
		return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3};
		System.out.println(search(nums, 3));
	}

}
