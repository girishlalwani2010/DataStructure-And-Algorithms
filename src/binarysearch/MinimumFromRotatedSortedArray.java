package binarysearch;

/**
 * @author girish_lalwani
 *
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2] 
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
 *
 */
public class MinimumFromRotatedSortedArray {

	/**
	 * @param integer array
	 * @return minimum element index
	 * 
	 * If array is ascending-rotated k times then minimum element will be present at k index.
	 * 
	 * recurence in the left or right is based on the check that nums[mid] is less than or greater than nums[right]
	 * if nums[mid]<nums[right] then we are sure that right part is not rotated that is it is strictly increasing, so we have 
	 * to check for minimum in first half.
	 * And if nums[mid]>nums[right] then we are sure that mid to right part that is right half of array is rotated and 
	 * left half is not. So will check in second half.
	 * 
	 * and we know that minimum element is the only element in the array,  **which is lesser than its previous element**.
	 *  
	 * 
	 */
	public int findMin(int[] nums) {
        if(nums.length == 1) {
			return nums[0];
		}
        int left = 0, right = nums.length-1;
        if(nums[left]<nums[right]){
            return nums[0];
        }
	    //4,5,6,7,0,1,2
        // 3,4,5,1,2
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid-1>=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]<nums[right]){
                right = mid-1;
            }else{
                left = mid+1;
            }    
        }
        
        return -1;}

	public static void main(String[] args) {

	}

}
