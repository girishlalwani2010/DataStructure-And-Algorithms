package tree;

import linkedlist.ListNode;

public class BinaryTreeToDoublyLinkedListPracticeAgain {

	ListNode head, prev;
	
	private void createDoublyLinkedList(TreeNode root) {
		if(root == null)
			return;
		createDoublyLinkedList(root.left);
		if(prev!=null) {
			ListNode next = new ListNode(root.val);
			next.prev = prev;
			prev.next = next;
			prev = next;
		}else {
			head = new ListNode(root.val);
			prev = head;
		}
		createDoublyLinkedList(root.right);
	}

	public void printList() {
		ListNode p = head;
		while(p!=null) {
			System.out.print(p.val+"-->");
			p = p.next;
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
		BinaryTreeToDoublyLinkedListPracticeAgain binaryTreeToDoublyLinkedList = new BinaryTreeToDoublyLinkedListPracticeAgain();
		binaryTreeToDoublyLinkedList.createDoublyLinkedList(root);

		// Print the converted List
		binaryTreeToDoublyLinkedList.printList();

	}

}
