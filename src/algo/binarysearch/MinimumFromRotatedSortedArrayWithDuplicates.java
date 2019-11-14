package algo.binarysearch;

public class MinimumFromRotatedSortedArrayWithDuplicates {
	
	public static int findMin(int[] nums) {
        if(nums.length == 1) {
			return nums[0];
		}
        int left = 0, right = nums.length-1;
        if(nums[left]<nums[right]){
            return nums[0];
        }
	    //4,5,6,7,0,1,2
        // 3,4,5,1,2
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[right]){
            	//As left part including mid could contain mimimum, because we are not applying below condition
            	//as in Minimum of Rotated Sorted Array without duplicates.
                right = mid;
            }else if(nums[mid]>nums[right]){
            	// In this case we are very much sure that nums[mid]>nums[right], so we have to search in right half, and it will
            	// not start from mid as we know that there is something in the right that is definately lesser than mid
                left = mid+1;
            }else{
            	//check to find the minimum value pivot index, i.e. pivot point is whose either side, left or right part 
            	//of it will be strictly increasing
            	//Consider this case: 1 1 1 1 1 1 1 1 2 1 1
            	//the min index returned is 0, while actually it should be 9, hence the condition
            	if (nums[right - 1] > nums[right]) {
            		left = right;
            	    break;
            	}
                right--;
            }    
        }
        return nums[left];
    }
	
	public static void main(String[] args) {
		int nums[] = {10,0,10,10,10,10};
		System.out.println(findMin(nums));
	}

}
