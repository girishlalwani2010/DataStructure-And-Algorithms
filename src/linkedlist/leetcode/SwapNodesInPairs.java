package linkedlist.leetcode;

import linkedlist.ListNode;

public class SwapNodesInPairs {
	
	/**
	 * @param head
	 * @return
	 * Example 1->2->3->4->null
	 */
	public static ListNode swapPairsWrongCode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode modifiedHead = head.next;
        ListNode prev = null;
        while(head!=null && head.next!=null){
              ListNode nextHead = head.next.next; // step 1
              ListNode prevHead = head;
              head.next.next = head;// as it will change the memory of head.next.next and everyone which is pointing to it will change, i.e. step one will change. 
              head.next.next.next = null;
              if(prev!=null){
                prev.next = prevHead.next;    
              }
              prev = prevHead;
              head = nextHead;
        }
        return modifiedHead;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		swapPairsWrongCode(head);
	}
	
	/**
	 * @param head
	 * @return
	 * 
	 * crux is 
	 * 
	 * prev.next = secondNode;
	 * firstNode.next = secondNode.next; // so 1's next will points to 2's next
	 * secondNode.next = firstNode;
	 */
	public static ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
        ListNode dummy = head.next;
        ListNode prev = null; // needed to point 2-1 to 4-3 and 2-1-4-3 to 6-5 , and so on.
        while(head!=null && head.next!=null){
        	ListNode firstNode = head;
        	ListNode secondNode = head.next;
        	if(prev!=null) {
        		prev.next = secondNode;
        	}
        	firstNode.next = secondNode.next; // so 1's next will points to 2's next
        	secondNode.next = firstNode;
        	prev = firstNode;
        	head = firstNode.next;
        }
        return dummy;
    }
	

}
