package datastructures.linkedlist;

public class DeleteNodeAtAllOccurences {
	
	static void deleteKey(ListNode head, int key){
	
		ListNode ptr = head;
		ListNode prev = null;
		
		while(ptr != null){
			
			if(ptr.data == key){
				prev.next = ptr.next;
			}
			else{
				prev = ptr;
				ptr = ptr.next;
			}
		}
		
		System.out.println("Done");
		
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(5);
		
		deleteKey(head,2);
		
	}
	
}
