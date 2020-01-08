package linkedlist.leetcode;

import linkedlist.ListNode;

public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		ListNode evenHead = evenNode;
		while (evenNode != null && evenNode.next != null) {
			oddNode.next = evenNode.next;
			oddNode = oddNode.next;
			evenNode.next = oddNode.next;
			evenNode = evenNode.next;
		}
		oddNode.next = evenHead;
		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		oddEvenList(head);
	}

}
