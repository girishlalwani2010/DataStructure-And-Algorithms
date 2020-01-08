package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	List<List<Integer>> result;

	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		subsets(nums, new ArrayList<>(), 0);
		return result;
	}

	public void subsets(int[] nums, List<Integer> currList, int start) {
		result.add(new ArrayList<>(currList));
		for (int i = start; i < nums.length; i++) {
			currList.add(nums[i]);
			subsets(nums, currList, i + 1);
			currList.remove(currList.size() - 1);
		}
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums,new ArrayList<>(),0);
        return result;
    }
    
    public void subsetsWithDup(int[] nums, List<Integer> currList, int start){
        result.add(new ArrayList<>(currList));
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1])
                continue;
            currList.add(nums[i]);
            subsetsWithDup(nums,currList,i+1);
            currList.remove(currList.size()-1);            
        }
    }

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Subsets subsets = new Subsets();
		subsets.subsets(nums);
	}

}
