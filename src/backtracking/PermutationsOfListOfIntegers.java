package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author girish_lalwani
 * 
 * 	https://leetcode.com/problems/permutations/
 *	Same as https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *
 *	Design Images attached in mail.
 */
public class PermutationsOfListOfIntegers {
	
	    private List<List<Integer>> result = new ArrayList<>();
	    
	    private List<Integer> swap(List<Integer> list, int i, int j){
	        int temp = list.get(i);
	        list.set(i,list.get(j));
	        list.set(j,temp);
	        return list;
	    }
	    
	    private void permute(List<Integer> nums, int i){
	        
	        if(i==nums.size()){
	            result.add(new ArrayList<>(nums));
	        }
	        
	        for(int j=i; j<nums.size(); j++){
	            Collections.swap(nums, i, j);
	            permute(nums,i+1);
	            //BackTracking
	            Collections.swap(nums, i, j);
	        }
	    }
	    
	    public List<List<Integer>> permute(int[] nums) {
	        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
	        permute(numList,0);
	        return result;
	    }
	    
	    public static void main(String[] args) {
			PermutationsOfListOfIntegers permutationsOfListOfIntegers = new PermutationsOfListOfIntegers();
			int[] nums = {1,2,3};
			System.out.println(permutationsOfListOfIntegers.permute(nums));
		}
	}

