package tree;

import java.util.LinkedList;
import java.util.Queue;

import array.FindZerosPosition;

public class OddEvenLevelDifference {

	private int findDifferenceInOddAndEvenLevelSum(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		int oddSum = 0, evenSum = 0;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				if (!queue.isEmpty()) {
					level++;
					queue.add(null);
				}
			} else {
				if (level % 2 == 1) {
					oddSum = oddSum + node.val;
				} else {
					evenSum = evenSum + node.val;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		return oddSum - evenSum;
	}

	/**
	 * @param node
	 * @return
	 * Awesome way
	 */
	int getLevelDiff(TreeNode node) {
		// Base case
		if (node == null)
			return 0;

		// Difference for root is root's data - difference for
		// left subtree - difference for right subtree
		return node.val - getLevelDiff(node.left) - getLevelDiff(node.right);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(22);
		OddEvenLevelDifference oddEvenLevelDifference = new OddEvenLevelDifference();
		System.out.println(oddEvenLevelDifference.findDifferenceInOddAndEvenLevelSum(root));

	}

}
