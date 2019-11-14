package dp;

import java.util.Arrays;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * @author girish_lalwani
 *
 *https://leetcode.com/problems/longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int dp[] = new int[nums.length];
		Arrays.fill(dp, 1);
		int maxLength = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					dp[i] = Integer.max(dp[i], dp[j]+1);
				}
				maxLength = Integer.max(dp[i], maxLength);
			}
		}
		return maxLength;
	}

    public int lengthOfLISSecondWay(int[] nums) {
        if(nums.length==0){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int maxLengthOfLIS = 1;
        Arrays.fill(dp,1);
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    dp[j] = Integer.max(dp[j], dp[i]+1);
                }
                if(maxLengthOfLIS<dp[j]){
                    maxLengthOfLIS=dp[j];
                }
            }
        }
        return maxLengthOfLIS;
    }
    
    /**
     * Very well Explained in https://leetcode.com/problems/longest-increasing-subsequence/solution/
     * Maintaing sorted DP array, while inserting elements into it.
     * So the crux is if the element is not found in dp array, we have to return insertion index of element from dp array, as if 
     * supppose there is one element in dp i.e. [3] and in nums we have [3,2,....] then if we are in loop and searching for 2,
     * will return its insertion index that is nothing but -1 nothing but -(index+1) i.e. 0, so will replace nums[0] with it.
     * And why we are doing this as it will not impact the length in future, however it will increase the probably to maximize 
     * the length of LIS, but it will not impact in decreasing the length of LIS, as we are increasing the length in case 
     * we found the insersion index equal to previous length of filled element in dp, inserted while searching started with length 1.
     * 
     * @param nums
     * @return
     */
    public static int lengthOfLISUsingBinarySearch(int[] nums) {
    	if(nums.length==0){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxLength=1;
        for(int i=1; i<nums.length; i++) {
        	int index = Arrays.binarySearch(dp,0,maxLength,nums[i]);
        	if(index<0) {
        		index = -(index+1);
        	}
        	dp[index] = nums[i];
        	if(index == maxLength) {
        		maxLength++;
        	}
        }
        return maxLength;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLISUsingBinarySearch(nums));
	}
}
