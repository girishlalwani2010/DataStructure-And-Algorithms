package binarysearch;

import java.util.Arrays;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
 *binary search way , nice explanation in solution tab of leetcode, but above link is also good.
 *
 *Recursion : 
 *
 *dfs1: [[7, 2, 5, 10, 8],1,1,7,7]
dfs2: [[7, 2, 5, 10, 8],2,1,9,9]
dfs2: [[7, 2, 5, 10, 8],3,1,14,14]
dfs2: [[7, 2, 5, 10, 8],4,1,24,24]
dfs2: [[7, 2, 5, 10, 8],5,1,32,32]
dfs1: [[7, 2, 5, 10, 8],5,2,8,24]
ans till: 24
dfs1: [[7, 2, 5, 10, 8],4,2,10,14]
dfs2: [[7, 2, 5, 10, 8],5,2,18,18]
ans till: 18
dfs1: [[7, 2, 5, 10, 8],3,2,5,9]
dfs2: [[7, 2, 5, 10, 8],4,2,15,15]
dfs2: [[7, 2, 5, 10, 8],5,2,23,23]
ans till: 18
dfs1: [[7, 2, 5, 10, 8],2,2,2,7]
dfs2: [[7, 2, 5, 10, 8],3,2,7,7]
dfs2: [[7, 2, 5, 10, 8],4,2,17,17]
dfs2: [[7, 2, 5, 10, 8],5,2,25,25]
ans till: 18
18




dfs1: [[7, 2, 5, 10, 8],1,1,7,7]
dfs2: [[7, 2, 5, 10, 8],2,1,9,9]
dfs2: [[7, 2, 5, 10, 8],3,1,14,14]
dfs2: [[7, 2, 5, 10, 8],4,1,24,24]
dfs2: [[7, 2, 5, 10, 8],5,1,32,32]

from dfs2: [[7, 2, 5, 10, 8],4,1,24,24] : dfs1: [[7, 2, 5, 10, 8],5,2,8,24]

from dfs2: [[7, 2, 5, 10, 8],3,1,14,14] : dfs1: [[7, 2, 5, 10, 8],4,2,10,14]

dfs2: [[7, 2, 5, 10, 8],5,2,18,18]

from dfs1: [[7, 2, 5, 10, 8],4,2,10,14] : dfs1: [[7, 2, 5, 10, 8],5,3,8,14]
ans till: 14
dfs1: [[7, 2, 5, 10, 8],3,2,5,9]
dfs2: [[7, 2, 5, 10, 8],4,2,15,15]
dfs2: [[7, 2, 5, 10, 8],5,2,23,23]
dfs1: [[7, 2, 5, 10, 8],5,3,8,15]
ans till: 14
dfs1: [[7, 2, 5, 10, 8],4,3,10,10]
dfs2: [[7, 2, 5, 10, 8],5,3,18,18]
ans till: 14
dfs1: [[7, 2, 5, 10, 8],2,2,2,7]
dfs2: [[7, 2, 5, 10, 8],3,2,7,7]
dfs2: [[7, 2, 5, 10, 8],4,2,17,17]
dfs2: [[7, 2, 5, 10, 8],5,2,25,25]
dfs1: [[7, 2, 5, 10, 8],5,3,8,17]
ans till: 14
dfs1: [[7, 2, 5, 10, 8],4,3,10,10]
dfs2: [[7, 2, 5, 10, 8],5,3,18,18]
ans till: 14
dfs1: [[7, 2, 5, 10, 8],3,3,5,7]
dfs2: [[7, 2, 5, 10, 8],4,3,15,15]
dfs2: [[7, 2, 5, 10, 8],5,3,23,23]
ans till: 14
14


 */
class SplitArrayLargestSum {
	private int ans;
	private int n, m;

	private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {
		if (i == n && cntSubarrays == m) {
			ans = Integer.min(ans, curMax);
			return;
		}
		if (i == n) {
			return;
		}
		if (i > 0) {
			dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curSum, curSum + nums[i]));
		}
		if (cntSubarrays < m) {
			dfs(nums, i + 1, cntSubarrays+1, nums[i], Math.max(curMax, nums[i]));
		}
	}

	public int splitArray(int[] nums, int M) {
		ans = Integer.MAX_VALUE;
		n = nums.length;
		m = M;
		dfs(nums, 0, 0, 0, 0);
		return ans;
	}

	public int splitArrayDP(int[] nums, int m) {
		int n = nums.length;
		int[][] f = new int[n + 1][m + 1];
		int[] sub = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				f[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < n; i++) {
			sub[i + 1] = sub[i] + nums[i];
		}
		f[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 0; k < i; k++) {
					System.out.println(" ["+i+","+j+"] "+"Minimum of f[i][j] and max of f[k][j-1], sub[i] - sub[k] : "+"["+f[i][j]+","+f[k][j-1]+","+(sub[i] - sub[k])+"] is "+Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k])));
					f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
				}
			}
		}
		return f[n][m];
	}

	public static void main(String[] args) {
		int nums[] = { 7, 2, 5, 10, 8 };
		//int nums[] = {1,2,3,4,5,6,7,8,9,10};
		SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
		System.out.println(splitArrayLargestSum.splitArrayDP(nums, 2));
	}
}