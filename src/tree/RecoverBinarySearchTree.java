package tree;

/**
 * @author girish_lalwani
 *
 *
 *Similar to https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
 *
 *For example {10, 20, 60, 40, 50, 30}, at max two pairs will be incorrect if the swapped elements are not adjacent.
 *otherwise there will be only one pair. 
 *https://www.youtube.com/watch?v=LR3K5XAWV5k 
 */
public class RecoverBinarySearchTree {
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
	      else return; // at max two pairs will be incorrect, if the swapped elements are not adjacent
	    }
	    pred = root;
	    findTwoSwapped(root.right);
	  }

	  public void recoverTree(TreeNode root) {
	    findTwoSwapped(root);
	    swap(x, y);
	  }
}
