package tree;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36987/Straightforward-Java-Solution
 */
public class BinaryTreeToLL {
	
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
	    if (root == null)
	        return;
	    flatten(root.right);
	    flatten(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}

}
