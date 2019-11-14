package algo.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author girish_lalwani
 *
 *The basic idea is to do merge sort to nums[]. To record the result, we need to keep the index of each number in the original array. So instead of sort the number in nums, 
 *we sort the indexes of each number.
Example: nums = [5,2,6,1], indexes = [0,1,2,3]
After sort: indexes = [3,1,0,2]

While doing the merge part, say that we are merging left[] and right[], left[] and right[] are already sorted.

We keep a rightcount to record how many numbers from right[] we have added and keep an array count[] to record the result.

When we move a number from right[] into the new sorted array, we increase rightcount by 1.

When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.
 *
 *
 *Similar Questions https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 */
public class CountOfSmallerNumberAfterSelf {
	
	int[] count;
	public List<Integer> countSmaller(int[] nums) {	
	    List<Integer> res = new ArrayList<Integer>();     

	    count = new int[nums.length];
	    int[] indexes = new int[nums.length];
	    for(int i = 0; i < nums.length; i++){
	    	indexes[i] = i;
	    }
	    mergesort(nums, indexes, 0, nums.length - 1);
	    for(int i = 0; i < count.length; i++){
	    	res.add(count[i]);
	    }
	    return res;
	}
	private void mergesort(int[] nums, int[] indexes, int start, int end){
		if(end <= start){
			return;
		}
		int mid = (start + end) / 2;
		mergesort(nums, indexes, start, mid);
		mergesort(nums, indexes, mid + 1, end);
		merge(nums, indexes, start, end);
	}
	private void merge(int[] nums, int[] indexes, int start, int end){
		int mid = (start + end) / 2;
		int left_index = start;
		int right_index = mid+1;
		int rightcount = 0;    	
		int[] new_indexes = new int[end - start + 1];

		int sort_index = 0;
		while(left_index <= mid && right_index <= end){
			if(nums[indexes[right_index]] < nums[indexes[left_index]]){
				new_indexes[sort_index] = indexes[right_index];
				rightcount++;
				right_index++;
			}else{
				new_indexes[sort_index] = indexes[left_index];
				count[indexes[left_index]] += rightcount;
				left_index++;
			}
			sort_index++;
		}
		while(left_index <= mid){
			new_indexes[sort_index] = indexes[left_index];
			count[indexes[left_index]] += rightcount;
			left_index++;
			sort_index++;
		}
		while(right_index <= end){
			new_indexes[sort_index++] = indexes[right_index++];
		}
		for(int i = start; i <= end; i++){
			indexes[i] = new_indexes[i - start];
		}
	}
	
	public static void main(String[] args) {
		CountOfSmallerNumberAfterSelf countSmalls = new CountOfSmallerNumberAfterSelf();
		int[] nums = {0,2,1};
		System.out.println(countSmalls.countSmaller(nums).toString());
	}

}
