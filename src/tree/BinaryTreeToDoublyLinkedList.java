package tree;

import linkedlist.ListNode;

public class BinaryTreeToDoublyLinkedList {

	TreeNode head;
	TreeNode prev = null;

	private void createDoublyLinkedList(TreeNode root) {
		if (root == null) {
			return;
		}
		createDoublyLinkedList(root.left);
		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		createDoublyLinkedList(root.right);
	}

	public void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);

		// convert to DLL
		BinaryTreeToDoublyLinkedList binaryTreeToDoublyLinkedList = new BinaryTreeToDoublyLinkedList();
		binaryTreeToDoublyLinkedList.createDoublyLinkedList(root);

		// Print the converted List
		binaryTreeToDoublyLinkedList.printList(binaryTreeToDoublyLinkedList.head);

	}

}
