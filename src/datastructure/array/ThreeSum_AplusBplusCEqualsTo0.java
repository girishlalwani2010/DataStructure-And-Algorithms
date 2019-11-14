package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum_AplusBplusCEqualsTo0 {

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int j,k;
		Set<List<Integer>> uniqueSet = new HashSet<List<Integer>>();
		for(int i=0; i<nums.length; i++) {
			j=i+1;
			k=nums.length-1;
			if(i > 0  && nums[i] == nums[i-1])
	                continue;
			while (j<k) {
				if((nums[i]+nums[j]+nums[k]) == 0) {
					uniqueSet.add(Arrays.asList(nums[i],nums[j], nums[k]));
					j++;
					k--;
				}else if (nums[i]+nums[j]+nums[k] < 0){
					j++;
				}else {
					k--;
				}
			}
		}
		return new ArrayList<>(uniqueSet);
	}

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

}
