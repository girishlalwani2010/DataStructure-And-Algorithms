package linkedlist.leetcode;

import linkedlist.ListNode;

public class DeleteANodeFromLinkedList {
	//suppose head points to 1->2->3->4, and you have to delete 2
	ListNode head, prev;
	 public void deleteNode(ListNode node) {
	        ListNode iterator = head;
	        if(iterator!=null && node.val == iterator.val){
	            iterator = iterator.next;
	            head = iterator;
	            return;
	        }
	        while(iterator!=null && iterator.val!=node.val){
	            prev = iterator;
	            iterator = iterator.next;
	        }
	        
	        if(iterator == null) return;
	        
	        prev.next = iterator.next;
	        
	    }
}
