package array;

/**
 * @author girish_lalwani
 * can also be done 
 * using one method only trick is to first find the target number and , then find the target+1 if found then last occurrence for target will be found index -1, otherwise it will be foundIndex
 * look at the trick to return the low irrespective of -1;
 * 
 * public class Solution {
	public int[] searchRange(int[] A, int target) {
		int start = Solution.firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[]{-1, -1};
		}
		return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
	}

	//find the first number that is greater than or equal to target.
	//could return A.length if target is greater than A[A.length-1].
	//actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			//low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}
}
 */
public class SearchRange {
	
	public static int findBeginIndex(int []nums,int low, int high, int target) {
		if(low<=high) {
			int mid = low + (high-low)/2;
			if(nums[mid] == target) {
					if (mid-1>=0) {
						if(nums[mid-1]!= target) {
							return mid;
						}
					}else{
						return mid;
					}  
			}
			if(nums[mid]>target || ((mid-1>=0) && nums[mid-1] == target)) {
				return findBeginIndex(nums, low, mid-1, target);
			}
			if(nums[mid]<target) {
				return findBeginIndex(nums, mid+1, high, target);
			}
		}
		return -1;
	}
	
	public static int findEndIndex(int []nums,int low, int high, int target) {
		if(low<=high) {
			int mid = low + (high-low)/2;
			if(nums[mid] == target) {
				if (mid+1<=nums.length-1) {
					if(nums[mid+1]!= target) {
						return mid;
					}
				}else{
					return mid;
				}  
			}
			if(nums[mid]<target || ((mid+1<=nums.length-1) && nums[mid+1] == target)) {
				return findEndIndex(nums, mid+1, high, target);
			}
			if(nums[mid]>target) {
				return findEndIndex(nums, low, mid-1, target);
			}
		}
		return -1;
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int result[] = {-1,-1};
		result[0] = findBeginIndex(nums,0,nums.length-1,target);
		result[1] = findEndIndex(nums,0,nums.length-1,target);
		return result;
    }
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,5,5,5,5,6,7,8};
		//int[] nums = {5,7,7,8,8,10};
		int[] result = {-1,-1};
		result = searchRange(nums, 5);
		System.out.println(result);
	}

}
