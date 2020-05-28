package tree;

public class IsBTBST {

	private static int getMaxinBinaryTree(TreeNode root) {

		if (root == null)
			return Integer.MIN_VALUE;

		int leftMax = getMaxinBinaryTree(root.left);
		int rightMax = getMaxinBinaryTree(root.right);

		return Math.max(root.val, Math.max(leftMax, rightMax));

	}

	private static int getMinInBinaryTree(TreeNode root) {

		if (root == null)
			return Integer.MAX_VALUE;

		int leftMax = getMinInBinaryTree(root.left);
		int rightMax = getMinInBinaryTree(root.right);

		return Math.min(root.val, Math.min(leftMax, rightMax));

	}

	private static boolean isBTBST(TreeNode root) {

		if (root == null) {
			return true;
		}

		if ((root.left != null && getMaxinBinaryTree(root.left) < root.val)
				|| (root.right != null && getMinInBinaryTree(root.right) > root.val)) {
			return false;
		}

		isBTBST(root.left);
		isBTBST(root.right);

		return true;
	}

	// Impl using in-order.
	TreeNode prev = null;

	public boolean isBTBSTUsingInorder(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = isBTBSTUsingInorder(root.left);
		if (prev != null && prev.val >= root.val) {
			return false;
		}
		prev = root;
		if (!left) {
			return false;
		}
		boolean right = isBTBSTUsingInorder(root.right);

		if (!right) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(22);

		System.out.println(isBTBST(root));

	}

}
