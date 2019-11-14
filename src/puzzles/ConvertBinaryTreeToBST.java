package puzzles;
import java.util.Arrays;
import java.util.LinkedList;

public class ConvertBinaryTreeToBST {
	int index;
	class QueueNode {
		TreeNode treeNode;
		int level;

		QueueNode(TreeNode node, int level) {
			this.treeNode = node;
			this.level = level;
		}
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int value;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	TreeNode root;
	int treeSize;

	private TreeNode createTree() {
		this.root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);

		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;

		n3.right = n6;

		n5.right = n7;

		n6.right = n8;

		treeSize = 9;

		return root;
	}

	public void printTreeLevelOrder() {
		if (root == null)
			return;

		LinkedList queue = new LinkedList();
		queue.add(new QueueNode(root, 0));

		int maxLevelVisited = -1;

		while (!queue.isEmpty()) {
			QueueNode currentNode = (QueueNode) queue.remove();

			if (currentNode.level > maxLevelVisited) {
				maxLevelVisited = currentNode.level;
				System.out.print("\nlevel-" + currentNode.level + " nodes: ");
			}
			System.out.print(" " + currentNode.treeNode.value);

			if (currentNode.treeNode.left != null) {
				queue.add(new QueueNode(currentNode.treeNode.left, currentNode.level + 1));
			}

			if (currentNode.treeNode.right != null) {
				queue.add(new QueueNode(currentNode.treeNode.right, currentNode.level + 1));
			}
		}
	}

	private void createInorderArray(TreeNode currentNode, int[] inorder) {
		
		if (currentNode == null) {
			return;
		}

		createInorderArray(currentNode.left, inorder);

		inorder[index++] = currentNode.value;

		createInorderArray(currentNode.right, inorder);
	}

	private void changeNodeValues(TreeNode currentNode, int[] inorder) {
		
		if (currentNode == null) {
			return;
		}

		changeNodeValues(currentNode.left, inorder);

		currentNode.value = inorder[index++];

		changeNodeValues(currentNode.right, inorder);
	}

	public void changeTreeToBST() {
		int[] inorder = new int[treeSize];

		createInorderArray(root, inorder);

		Arrays.sort(inorder);

		index = 0;

		changeNodeValues(root, inorder);
	}

	public static void main(String[] args) {
		ConvertBinaryTreeToBST solution = new ConvertBinaryTreeToBST();

		solution.createTree();

		solution.changeTreeToBST();

		System.out.print("Modified tree to BST: \n");

		solution.printTreeLevelOrder();
	}
}
