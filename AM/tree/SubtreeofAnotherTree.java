package tree;

public class SubtreeofAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		return treeMatch(s, t) || (s.left != null && isSubtree(s.left, t))
				|| (s.right != null && isSubtree(s.right, t));
	}

	private boolean treeMatch(TreeNode s, TreeNode t) {
		if (t == null && s == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		return t.val == s.val && treeMatch(s.left, t.left) && treeMatch(s.right, t.right);
	}

}
