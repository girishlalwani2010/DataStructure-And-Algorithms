package array;

public class JumpGame {

	public boolean canJumpUsingDP(int[] nums) {

		int n = nums.length;
		boolean[] dp = new boolean[n];
		dp[0] = true;

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] && (j + nums[j] >= i)) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n - 1];

	}

	////////////// Bactracking Method Start/////////////////////
	
	enum Position{
        GOOD,BAD,UNKNOWN
    }
    
    public boolean canJump(int[] nums) {
       Position[] memoPosition = new Position[nums.length];
       for(int i=0; i<nums.length; i++){
            memoPosition[i] = Position.UNKNOWN;  
       } 
       return canJump(memoPosition,nums,0);
    }
    
    public boolean canJump(Position[] memo, int[] nums, int position) {
       
        if(position == nums.length-1){
            memo[position] = Position.GOOD;
            return true;
        }
        
        if(memo[position]!=Position.UNKNOWN){
            return memo[position] == Position.GOOD?true:false;
        }
        
        int farthestMove = Math.min(position+nums[position], nums.length-1);
        
        for(int nextPosition = position+1; nextPosition<=farthestMove; nextPosition++){
            if(canJump(memo,nums,nextPosition)){
                memo[position] = Position.GOOD;
                return true;
            }
        }
        memo[position] = Position.BAD;
        return false;
    }
    
    //////////////Bactracking Method End /////////////////////
    
	public static boolean canJump2(int[] nums) {
		int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 0 };
		JumpGame jg  = new JumpGame();
		System.out.println(jg.canJump(nums));
	}

}
