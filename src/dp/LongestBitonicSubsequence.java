package dp;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	
	private int longestBitonicSuqsequence(int[] nums) {
		
		int[] lis = new int[nums.length];
		Arrays.fill(lis, 1);
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				if(nums[i]>nums[j]) {
					lis[i] = Math.max(lis[i], lis[j]+1);	
				}
			}
		}
		
		int[] lds = new int[nums.length];
		Arrays.fill(lds, 0);
		int lBSLength = 0;
		for(int i=nums.length-1; i>=0; i--) {
			for(int j=nums.length-1; j>i; j--) {
				if(nums[i]>nums[j]) {
					lds[i] = Math.max(lds[i], lds[j]+1);
				}
			}
			lBSLength = Math.max(lis[i]+lds[i], lBSLength);
		}
		
		return lBSLength;
	}
	
	public static void main(String[] args) {
		LongestBitonicSubsequence lBS = new LongestBitonicSubsequence();
		int[]nums = {80, 60, 30, 40, 20, 10};
		System.out.println(lBS.longestBitonicSuqsequence(nums));
	}

}
