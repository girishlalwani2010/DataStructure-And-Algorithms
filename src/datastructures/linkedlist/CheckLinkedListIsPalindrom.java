package datastructures.linkedlist;

public class CheckLinkedListIsPalindrom {

	ListNode head;
	ListNode slowPtr, fastPtr, secondHalf;
	
	 boolean compareLists(ListNode head1, ListNode head2) 
	 {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
 
        while (temp1 != null && temp2 != null) 
        {
            if (temp1.data == temp2.data) 
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }
 
        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return true;
 
        /* Will reach here when one is NULL
           and other is not */
        return false;
	  }
	 
	
	void reverse(ListNode second_half) 
    {
		ListNode prev = null;
		ListNode current = second_half;
		ListNode next;
        while (current != null) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }
	
	boolean isPalindrom(ListNode head){
		
		slowPtr = head;
		fastPtr = head;
		ListNode prevOfSlowPtr = head;
		ListNode midNode = null;
		boolean result = true;
		
		if(head != null && head.next != null){
			while(fastPtr!=null && fastPtr.next != null){
				fastPtr = fastPtr.next.next;
				prevOfSlowPtr = slowPtr;
				slowPtr = slowPtr.next;
			}
			
			if(fastPtr!=null){
				midNode = slowPtr;
				slowPtr = slowPtr.next;
			}
			
			secondHalf = slowPtr;
			prevOfSlowPtr = null;
			reverse(secondHalf);
			result = compareLists(head, secondHalf);
		}
		
		
		return true;
		
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		
		CheckLinkedListIsPalindrom checkLinkedListIsPalindrom = new CheckLinkedListIsPalindrom();
		System.out.println(checkLinkedListIsPalindrom.isPalindrom(head));
	}
	
}
