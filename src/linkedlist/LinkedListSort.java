package linkedlist;

//Sort linked list which is already sorted on absolute values.
public class LinkedListSort {

	private ListNode sortAlreadySortedLinkedList(ListNode head) {

		ListNode current = head.next;
		ListNode next = null;
		ListNode prev = head;

		while (current != null) {
			if (current.val < head.val) {
				next = current.next;
				current.next = head;
				head = current;
				current = next;
				
			} else {
				prev.next = current;
				prev = current;
				current = current.next;
			}
		}

		prev.next = null;
		
		return head;
	}

	private static void printList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		head.next = new ListNode(-2);
		 head.next.next = new ListNode(-3); 
		 head.next.next.next = new ListNode(4); 
		 head.next.next.next.next = new ListNode(-5);
		 

		LinkedListSort linkedListSort = new LinkedListSort();
		ListNode returnedHead = linkedListSort.sortAlreadySortedLinkedList(head);
		linkedListSort.printList(returnedHead);

	}

}
