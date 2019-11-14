package binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author girish_lalwani
 *
	 Same as CountOfSmallerNumberAfterSelf, wrote again for practice
 *
 */
public class CountOfSmallerNumberAfterSelfII {
	int[] count;
	int[] indexes;
	public List<Integer> countSmaller(int[] nums) {
		indexes = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			indexes[i]=i;
		}
		count = new int[nums.length];
		mergeSort(nums,0,nums.length-1);
		return Arrays.stream(count).boxed().collect(Collectors.toList());
    }
	
	private void mergeSort(int[] nums,int low, int high) {
		if(low<high) {
			int mid = low+(high-low)/2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid+1, high);
			merge(nums, low, mid, high);
		}
	}
	
	private void merge(int[] nums, int low, int mid, int high) {
		int leftStart = low;
		int leftEnd = mid;
		int rightStart = mid+1;
		int rightEnd = high;
		int rightCount=0;
		int[] sortedIndexes = new int[high-low+1];
		int sortedIndexesIndex=0;
		
		while(leftStart<=leftEnd && rightStart<=rightEnd) {
			if(nums[indexes[rightStart]] < nums[indexes[leftStart]]) {
				sortedIndexes[sortedIndexesIndex] = indexes[rightStart];
				sortedIndexesIndex++;
				rightStart++;
				rightCount++;
			}else {
				sortedIndexes[sortedIndexesIndex] = indexes[leftStart];
				count[indexes[leftStart]] += rightCount;
				sortedIndexesIndex++;
				leftStart++;
			}
		}
		while(leftStart<=leftEnd) {
			sortedIndexes[sortedIndexesIndex] = indexes[leftStart];
			count[indexes[leftStart]] += rightCount;
			sortedIndexesIndex++;
			leftStart++;
		}
		while(rightStart<=rightEnd) {
			sortedIndexes[sortedIndexesIndex] = indexes[rightStart];
			sortedIndexesIndex++;
			rightStart++;
		}
		for(int i=low; i<=high; i++) {
			indexes[i] = sortedIndexes[i-low];
		}
	}

	public static void main(String[] args) {
		CountOfSmallerNumberAfterSelfII countOfSmallerNumberAfterSelf = new CountOfSmallerNumberAfterSelfII();
		int[] nums = {0,2,1};
		//0,1,2,3
		List<Integer> list = countOfSmallerNumberAfterSelf.countSmaller(nums);
		System.out.println(list.toString());
	}
}
