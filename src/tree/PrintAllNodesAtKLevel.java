package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllNodesAtKLevel {

	private static List<Integer> printNodesAtKLevel(TreeNode root, int k) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		List<Integer> list = new ArrayList<Integer>();
		int level = 0;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node == null) {
				if (k == level) {
					return list;
				}
				level++;
				list = new ArrayList<Integer>();
				queue.add(null);
			}

			if (node != null)
				list.add(node.val);

			if (node != null && node.left != null) {
				queue.add(node.left);
			}

			if (node != null && node.right != null) {
				queue.add(node.right);
			}

		}
		return list;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(printNodesAtKLevel(root, 1));

	}

}
