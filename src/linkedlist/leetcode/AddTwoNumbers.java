package linkedlist.leetcode;

import linkedlist.ListNode;

public class AddTwoNumbers {

	/**
	 * https://leetcode.com/problems/add-two-numbers/
	 */
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		ListNode dummyHead = new ListNode(0);
//		ListNode resultNode = dummyHead;
//		int sum = 0;
//		int carry = 0;
//		while (l1 != null || l2 != null) {
//			int x = (l1 != null) ? l1.val : 0;
//			int y = (l2 != null) ? l2.val : 0;
//			sum = x + y + carry;
//			carry = sum / 10;
//			sum = sum % 10;
//			dummyHead.next = new ListNode(sum);
//			dummyHead = dummyHead.next;
//			if (l1 != null)
//				l1 = l1.next;
//			if (l2 != null)
//				l2 = l2.next;
//		}
//
//		if (carry > 0) {
//			dummyHead.next = new ListNode(carry);
//		}
//
//		return resultNode.next;
//	}
	
	
	/**
	 * @param l1
	 * @param l2
	 * @return
	 *  Most important start resultNode from memory reference, as this is the actual thing in memory.
		as if dummy node is not taken, then l3 will iterate and create node till end but we nothing as return head and dummy here will
		act as return head. 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        // why L3 = dummy not dummy.next as dummy.next is null and null is not the memory location.
        // so when appending the new node to l3, will not append it to dummy. Hence L3=dummy.  
        ListNode l3 = dummy;
        int a=0,b=0,sum=0,carry=0;
        while(l1!=null || l2!=null){
            a = (l1==null)?0:l1.val;
            b = (l2==null)?0:l2.val;
            sum = (a+b+carry);
            sum = sum%10;
            l3.next = new ListNode(sum);
            carry = sum/10;
            l3 = l3.next;
            
            if(l1!=null){
                l1 = l1.next;    
            }
            
            if(l2!=null){
                l2 = l2.next;    
            }
            
        }
        
        if(carry>=1){
            l3.next = new ListNode(carry);
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		addTwoNumbers.addTwoNumbers(l1, l2);
	}
	
	/**
	 * https://leetcode.com/problems/add-two-numbers-ii/
	 */
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry 
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }

}
