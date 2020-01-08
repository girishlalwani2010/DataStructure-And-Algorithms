package linkedlist.leetcode;

import linkedlist.ListNode;

public class ReverseInKGroups {

	public ListNode reverseKGroupAccordingToGeekForGeeks(ListNode head, int k) {
		ListNode prev = null, curr = head, next = null;
		int count = 0;
		while (count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null) {
			head.next = reverseKGroupAccordingToGeekForGeeks(next, k);
		}
		return prev;
	}
	
    /**
     * @param head
     * @param k
     * @return
     *      
     * According to LeetCode.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
    	 
        ListNode prev = null, curr = head, next = null;
        ListNode p = head;
        int remainingLen = 0;
        while(p!=null){
            remainingLen++;
            p = p.next;
        }
        if(remainingLen<k){
            return head;
        } 
        int count=0;
        while(count<k && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next!=null){
            head.next = reverseKGroup(next,k);  
        }
        return prev;
    }
}
