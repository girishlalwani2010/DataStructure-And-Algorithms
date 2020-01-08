package tree;

import java.util.Stack;

public class InorderSucessor {

	private static TreeNode succesor;

	static TreeNode getLeftMostOfRight(TreeNode node) {

		while (node.left != null) {
			node = node.left;
		}

		return node;

	}

	/**
	 * @param root
	 * @param item
	 * @return
	 * 
	 * 		Inorder successor in BST time-complexity O(h), i.e. O(logn)
	 */
	static TreeNode findInorderSucessorINBST(TreeNode root, int item) {
		if (root == null)
			return null;

		if (root.val == item) {
			if (root.right != null)
				succesor = getLeftMostOfRight(root.right);
		}

		if (root.val > item) {
			succesor = root;
			findInorderSucessorINBST(root.left, item);
		}

		if (root.val < item) {
			findInorderSucessorINBST(root.right, item);
		}

		return succesor;
	}

	/**
	 * This method is more intuitive
	 * 
	 * @return 
	 * 		   Another approach: We will do a reverse inorder traversal and keep the
	 *         track of current visited node. Once we found the element, last
	 *         tracked element would be our answer.
	 * 
	 *         Same method can be applied for BST as well but it will take O(n)
	 *         TimeComplexity in case of BST as well, so above method is well suited
	 *         for BST ans that will take O(h) time-complexity.
	 */
	TreeNode prevNode = null;
	boolean isFound = false;
	TreeNode successor = null;

	public TreeNode inorderSuccessorINBinaryTree(TreeNode root, int item) {
		if (root == null) {
			return null;
		}
		inorderSuccessorINBinaryTree(root.right, item);
		if (root.val == item) {
			isFound = true;
			successor = prevNode;
		} else {
			prevNode = root;
		}
		inorderSuccessorINBinaryTree(root.left, item);
		if (isFound) {
			return successor;
		} else {
			return null;
		}
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		System.out.println(findInorderSucessorINBST(root, 8).val);
		// System.out.println(findInorderSucessorINBST(root, 10).val);
		// System.out.println(findInorderSucessorINBST(root, 14).val);

//		InorderSucessor inorderSucessor = new InorderSucessor();
//		System.out.println(inorderSucessor.inorderSuccessorINBinaryTree(root, 8).val);

	}

}
