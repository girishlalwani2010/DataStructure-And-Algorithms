package linkedlist.leetcode;

import linkedlist.ListNode;

/**
 * @author girish_lalwani
 *
 *Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:
 */
public class DeleteNode {
	
	  public void deleteNode(ListNode node) {
	        ListNode prev = null;
	        while(node.next!=null){
	            node.val = node.next.val;
	            prev = node;
	            node = node.next;
	        }
	       
	        if(prev!=null)
	            prev.next = null;
	       
	    }
	  
	  public void deleteNodeSecondWay(ListNode node) {
		    node.val = node.next.val;
		    node.next = node.next.next;
		}

}
