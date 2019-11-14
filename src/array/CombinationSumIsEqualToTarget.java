package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Find subarray with given sum | Set 1 (Nonnegative Numbers)
public class CombinationSumIsEqualToTarget {
	static boolean flag = false;
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> curr = new ArrayList<Integer>();
	    Arrays.sort(candidates);
	    helper(result, curr, 0, target, candidates);
	    return result;
	}
	 
	public static void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
	    if(target==0){
	        result.add(new ArrayList<Integer>(curr));
	        return;
	    }
	    if(target<0){
	    	flag = true;
	        return;
	    }
	 
	    int prev=-1;
	    for(int i=start; i<candidates.length; i++){
	        //Uncomment the comments if u want only one occurence of each number in each combination
	    	/*if(prev!=candidates[i]){*/ // each time start from different element
	    	    curr.add(candidates[i]);
	    	    //change i to i+1 because we have not to consider multiple occurences of same element.
	            helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
	            
	            curr.remove(curr.size()-1);
	            
	            
	            /*prev=candidates[i];
	        }*/
	        /*else{
	        	System.out.println("in else");
	        }*/
	    }
	}
	
	public static void main(String[] args) {
		
		int arr[] = {10,1,2,7,6,1,5};
		
		System.out.println(combinationSum2(arr,8));
	}
}

