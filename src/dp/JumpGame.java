package dp;

public class JumpGame {
	
	public static boolean canJump(int[] A) {
	    int max = 0;
	    for(int i=0;i<A.length;i++){
	        if(i>max) {return false;}
	        max = Math.max(A[i]+i,max);
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		int nums[] = {1,0,1,0};
		System.out.println(canJump(nums));
	}

}
