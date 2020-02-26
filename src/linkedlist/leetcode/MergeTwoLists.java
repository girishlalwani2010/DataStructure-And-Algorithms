package linkedlist.leetcode;

import linkedlist.ListNode;

public class MergeTwoLists {
	
	 /**
	 * @param l1
	 * @param l2
	 * @return
	 * 
	 * Whenever you need a new node to return create dummy-node, as it's next will be result's head.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode dummyNode = new ListNode(0);
	        ListNode curr = dummyNode;
	        while(l1!=null && l2!=null){
	            if(l1.val<l2.val){
	                curr.next = l1;
	                l1 = l1.next;
	            }else{
	                curr.next = l2;
	                l2 = l2.next;
	            }
	            curr = curr.next;
	            
	        }
	        
	       if(l1!=null){
	                curr.next = l1;
	        } 
	        
	         if(l2!=null){
	                curr.next = l2;
	        }
	        
	        return dummyNode.next;
	    }
	 
	 public ListNode mergeTwoListsUsingRecursion(ListNode l1, ListNode l2) {
	        if (l1 == null) {
	            return l2;
	        }
	        else if (l2 == null) {
	            return l1;
	        }
	        else if (l1.val < l2.val) {
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        }
	        else {
	            l2.next = mergeTwoLists(l1, l2.next);
	            return l2;
	        }

	    }

}
