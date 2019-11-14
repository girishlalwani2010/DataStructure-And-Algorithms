package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	int indexOf(int arr[], int num) {
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				arr[i]=-1;
				return i;
			}
		}
		return -1;
	}
	
//	public int[] twoSum(int[] nums, int target) {
//		int[] input = Arrays.copyOf(nums, nums.length);
//		Arrays.sort(nums);
//		int i=0, j=nums.length-1; 
//		int[] output = new int[2];
//		while(i<j) {
//			int sum = nums[i]+nums[j];
//			if(sum>target) {
//				j--;
//			}else if(sum<target) {
//				i++;
//			}else {
//				output[0]=indexOf(input,nums[i]);
//				output[1]=indexOf(input,nums[j]);
//				break;
//			}
//		}
//		return output;	
//	}
	
	public int[] twoSum(int[] nums, int target) {
		int []output = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int first_index=i;
			int second_num = target - nums[i];
			if(map.containsKey(nums[i])) {
				output[0] = map.get(nums[i]);
				output[1] = i;
				break;
			}
			else {
				map.put(second_num, first_index);
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		TwoSum twoSum = new TwoSum();
		int[] output = twoSum.twoSum(nums, target);
		for (int i=0; i<output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
