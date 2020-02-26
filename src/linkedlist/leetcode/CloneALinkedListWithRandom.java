package linkedlist.leetcode;

import java.util.HashMap;
import java.util.Map;

import linkedlist.ListNode;

public class CloneALinkedListWithRandom {

	/**
	 * @param head
	 * @return
	 * 
	 * in O(n) Time and O(n) space
	 */
	public ListNode copyRandomList(ListNode head) {
		ListNode headItr = head;
		ListNode clone = new ListNode(headItr.val);
		ListNode cloneItr = clone;
		
		Map<ListNode, ListNode> nodeToCloneNode = new HashMap<>();
		nodeToCloneNode.put(head, clone);
		
		while(headItr.next!=null) {
			cloneItr.next = new ListNode(headItr.next.val);
			cloneItr = cloneItr.next;
			headItr = headItr.next;
			nodeToCloneNode.put(headItr, cloneItr);
		}
		cloneItr = clone;
		headItr = head;
		while(headItr != null) {
			cloneItr.random = nodeToCloneNode.get(headItr.random);
			cloneItr = cloneItr.next;
			headItr = headItr.next;
		}
		
		return clone;
	}
	
	//Can also be done in O(1) space and linear time
	// 7->2->3->null will convert it to // 7->7->2->2->3->3->null, so clone will be next to it.
	// head.next.random = head.random.next;
	
	
}
