package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/permutations-ii/ permutation of array contain duplicates
 */
public class PermutationsII {

	 List<List<Integer>> result = new ArrayList<>();
	    boolean[] used;
	    
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        used = new boolean[nums.length];
	        Arrays.sort(nums);
	        permuteUnique(nums, new ArrayList<>());
	        return result;
	    }
	    
	    public void permuteUnique(int[] nums, List<Integer> currentPermutation){
	        
	        if(currentPermutation.size() == nums.length){
	            result.add(new ArrayList<>(currentPermutation));
	            return ;
	        }
	        
	        for(int i=0; i<nums.length; i++){
	            if(used[i]){
	                continue;
	            }
	            if(i>0 && nums[i-1] == nums[i] && !used[i-1]){
	                continue;
	            }
	            currentPermutation.add(nums[i]);
	            used[i] = true;
	            permuteUnique(nums,currentPermutation);
	            used[i] = false;
	            currentPermutation.remove(currentPermutation.size()-1);
	        }
	        
	    }

}
