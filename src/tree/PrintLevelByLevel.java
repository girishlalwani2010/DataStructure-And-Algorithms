package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelByLevel {

	private static void printTreeLevelByLevel(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			stack.push(node);
			if (node == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				if (node.right != null) {
					queue.add(node.right);

				}

				if (node.left != null) {
					queue.add(node.left);
				}

			}
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node == null) {
				System.out.println();
			} else {
				System.out.print(node.data);
			}
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printTreeLevelByLevel(root);

	}

}
