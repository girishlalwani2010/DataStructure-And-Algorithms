package tree;

public class TwoFarthestNodesInTreePractice {

	private int maxDistance = Integer.MIN_VALUE;
	private int secondMaxDistance = Integer.MIN_VALUE;
	private TreeNode farthestNode;
	private TreeNode secondFarthestNode;

	public void farthestInBinaryTree(TreeNode root, int x) {
		if (root == null) {
			return;
		}
		if (maxDistance < x) {
			maxDistance = x;
			secondFarthestNode = farthestNode;
			farthestNode = root;
		} else {
			if (x > secondMaxDistance) {
				secondFarthestNode = root;
				secondMaxDistance = x;
			}
		}
		farthestInBinaryTree(root.left, x + 1);
		farthestInBinaryTree(root.right, x + 1);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);

		TwoFarthestNodesInTreePractice twoFarthestNodesInTree = new TwoFarthestNodesInTreePractice();
		twoFarthestNodesInTree.farthestInBinaryTree(root, 0);
		System.out.println(twoFarthestNodesInTree.farthestNode.val + "  " + twoFarthestNodesInTree.secondFarthestNode.val);
	}

}
