package linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

import linkedlist.ListNode;

public class LinkedListCycleIandII {

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public ListNode detectCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<ListNode>();
		while (head != null) {
			if (visited.contains(head)) {
				return head;
			}
			visited.add(head);
			head = head.next;
		}
		return null;
	}

	// Floyd's Method
	/**
	 * L1 is the distance covered by slow and fast pointer outside the loop. L2 is
	 * the distance covered inside the loop, intersection point in cycle. N is some
	 * integer, x+L2 is the length of cycle.
	 * 
	 * L1+N*(x+L2)+L2 will be intersection point
	 * 
	 * Consider a case for N=1, and suppose fast pointer covered one cycle more from
	 * slow when they meet Suppose Slow pointer covered L1+L2 till intersection
	 * point. and Fast Pointer covered L1+L2+x+L2.
	 * 
	 * then we know that - distance covered by fast = 2*(distance covered by slow).
	 * L1+L2+x+L2 = 2*(L1+L2). x=L1;
	 * 
	 * Hence the distance covered from intersection point to start of cycle is equal
	 * to the distance covered from start of cycle to intersection point
	 * 
	 * 
	 * 
	 * 
	 */
	public ListNode detectCycleUsingFloydMethod(ListNode head) {
		ListNode p2 = getIntersectionPoint(head);
		if (p2 == null) {
			return null;
		}
		ListNode p1 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	private ListNode getIntersectionPoint(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// mark it if is there after moving the pointers
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}
}
