package datastructure.array;

public class JumpGame {
	
	public boolean canJumpUsingDP(int[] nums) {
        
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for(int i = 1; i < n; i++)
        {
            for(int j = i - 1; j >= 0; j--)
            {
                if(dp[j] && (j + nums[j] >= i))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n - 1];
        
    }
	
	public static boolean canJump(int[] nums) {
		if(nums.length == 0) {
			return false;
		}
		if(nums.length ==1) {
			return true;
		}
		int maxStepsCanBeJumpFromThisPos = 0;
		int probableMaxStepsCanBeJumpFromThisPos=0;
		int jumpsLength = 0; 
		boolean isFound = false;
		for(int i=0; i<nums.length-1; i++) {
			if(nums[i]+i > probableMaxStepsCanBeJumpFromThisPos) {
				probableMaxStepsCanBeJumpFromThisPos = nums[i]+i;
				isFound = true;
			}
			if(i==maxStepsCanBeJumpFromThisPos && isFound) {
				maxStepsCanBeJumpFromThisPos = probableMaxStepsCanBeJumpFromThisPos;
				jumpsLength = probableMaxStepsCanBeJumpFromThisPos;
				if(jumpsLength >= (nums.length-1)) {
					return true;
				}
				isFound=false;
			}
		}
		return false;
	}
	
	public static boolean canJump2(int[] nums) {
		int max=0;
		for(int i=0; i<nums.length; i++) {
			if(i>max) {
				return false;
			}
			else {
				max = Math.max(max, nums[i]+i);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,0};
		System.out.println(canJump(nums));
	}

}
