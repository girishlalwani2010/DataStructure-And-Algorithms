package linkedlist.leetcode;

import linkedlist.ListNode;

public class ReverseALinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null, curr = head, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public ListNode reverseListUsingRecursion(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curr = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return curr;
	}

}
