package stack;

import java.util.Stack;

/**
 * @author girish_lalwani
 *	see the solution as well of leetcode for O(n2).
 */
public class Pattern132 {
	 public static boolean find132pattern(int[] nums) {
			if (nums.length < 3) {
				return false;
			}
	        
	        int[] min = new int[nums.length];
	        min[0] = nums[0];
	        for(int i=1; i<nums.length; i++){
	            min[i] = Integer.min(min[i-1],nums[i]);
	        }
	       
	        Stack<Integer> stack = new Stack<>();
			for (int j = nums.length-1; j >= 0; j--) {
			    // as this could only be possible k if nums[j]>min[j] then only will push it into stack, 
				// as for these stack elements we have to find next greater from right to left, that could be j.
	            if(nums[j]>min[j]){
	                if(stack.isEmpty()){
	                    stack.push(nums[j]);
	                }
	                // pushing possible K's
	                if(stack.peek()>nums[j]){
	                    stack.push(nums[j]);
	                }
	                //check for K, as we found J because stack.peek()<nums[j], i.e. next greater in left from right.
	                while(!stack.isEmpty() && stack.peek()<nums[j]){
	                	//check for K
	                    if(stack.peek()>min[j]){
	                        return true;
	                    }else{
	                        stack.pop();
	                    }
	                }
	            }
			}
	       
	       return false;
	    }

	public static void main(String[] args) {
		int[] nums = { 2, 4, 3, 1 };
		System.out.println(find132pattern(nums));
	}
}
