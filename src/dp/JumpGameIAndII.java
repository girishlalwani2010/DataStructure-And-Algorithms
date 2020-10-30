package dp;

public class JumpGameIAndII {

	
	/**
	 * @param A
	 * @return
	 * jump game ii
	 */
	  public int jump(int[] nums) {
	        if(nums.length<2){
	            return 0;
	        }
	        int minJumps=1;
	        int currFarthest = 0+nums[0];
	        int currMax = 0;
	        for(int i=1; i<nums.length; i++){
	            if(i>currFarthest){
	                currFarthest = currMax;
	                minJumps++; 
	            }
	            currMax = Math.max(currMax, i+nums[i]);
	        }
	        return minJumps;
	    }
	
	public boolean canJump(int[] nums) {
	    int currFarthest  = nums[0];
	    for(int i = 0; i < nums.length-1; i++){
	        currFarthest=Math.max(currFarthest,i+nums[i]);
	        if(currFarthest>=nums.length-1) return true;
	    }
	    return false;
	}
	
	
}
