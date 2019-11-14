package algo.randomnumbers;

import java.util.Random;

/**
 * @author girish_lalwani
 *
 * https://leetcode.com/problems/random-pick-index/
 * Reservoir Sampling Algorithm
 */
public class RandomPickIndex {
	 int[] nums;
	    Random rand;
	    public RandomPickIndex(int[] nums) {
	        this.nums = nums;
	        this.rand = new Random();
	    }
	    /**
	     * @param target
	     * @return
	     * 
	     * i=2, rand = [0,1), res =2
	     * 
	     * 						 + ----	0 --- res=3		
	     *						 |	 
	     * i=3, rand = [0,1,2)---|------1 --- res=2
	     * so for getting 2 or 3 probability is 50% that is 1/2
	     * 
	     * 
	      * 					   + ---- 0 --- res=4		
	     *						   |	 
	     * i=4, rand = [0,1,2,3)---|----- 1 --- res=2,3 from prev i (i.e.50%)
	     * 						   +
	     *                         |
	     *                         |------2 --- res=2,3 from prev i  (i.e.50%)
	     *So for getting 4 probability is 1/3 and probablity of not getting it is 2/3*(probability of previous stage if that i is not present i.e. 1/2) so 2/3*1/2 = 1/3 of each item                         
	     */
	    public int pick(int target) {
	        int total = 0;
	        int res = -1;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == target) {
	                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
	                int x = rand.nextInt(++total); 
	                res = x == 0 ? i : res;
	            }
	        }
	        return res;
	    }
    
    public static void main(String[] args) {
    	int nums[] = {1,2,3,3,3};
		RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
		System.out.println(randomPickIndex.pick(3));
		System.out.println(randomPickIndex.pick(3));
		System.out.println(randomPickIndex.pick(3));
	}
    
}
