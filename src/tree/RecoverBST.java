package tree;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBST {
	
		  TreeNode x = null, y = null, pred = null;

		  public void swap(TreeNode a, TreeNode b) {
		    int tmp = a.val;
		    a.val = b.val;
		    b.val = tmp;
		  }

		  public void findTwoSwapped(TreeNode root) {
		    if (root == null) return;
		    findTwoSwapped(root.left);
		    if (pred != null && root.val < pred.val) {
		      y = root;
		      if (x == null) x = pred;
		      else return;
		    }
		    pred = root;
		    findTwoSwapped(root.right);
		  }

		  public void recoverTree(TreeNode root) {
		    findTwoSwapped(root);
		    swap(x, y);
		  }

}
