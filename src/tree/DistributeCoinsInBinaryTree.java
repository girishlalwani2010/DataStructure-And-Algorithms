package tree;

/**
 * @author girish_lalwani
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * Perfect explanation: https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
 */
public class DistributeCoinsInBinaryTree {

	public int distributeCoins(TreeNode root) {
		int[] ans = new int[1];
		distributeCoins(root, ans);
		return ans[0];
	}

	private int distributeCoins(TreeNode root, int[] ans) {
		if (root == null) {
			return 0;
		}
		int left = distributeCoins(root.left, ans);
		int right = distributeCoins(root.right, ans);
		ans[0] += Math.abs(left) + Math.abs(right);
		return left + right + root.val - 1;
	}
	
	/*Can also be done using primitive global just we have not to roll the global variable in recursion frame, 
	i.e. will not overload the method.*/
	
	private int ans = 0;
    public int distributeCoinsIIway(TreeNode root){
        distributeCoin(root);
        return ans;
    }
    public int distributeCoin(TreeNode root) {
        if(root == null){
            return 0;
        }
        int rightVal = distributeCoin(root.right);
        int leftVal = distributeCoin(root.left);
        ans += Math.abs(rightVal) + Math.abs(leftVal);
        return rightVal + leftVal + root.val-1;
    }

}
