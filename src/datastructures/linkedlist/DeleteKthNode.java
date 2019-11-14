package datastructures.linkedlist;

public class DeleteKthNode {
	
	private ListNode deleteKthNode(ListNode head, int k){
		ListNode ptr1 = new ListNode(0);
		ptr1.next = head;
		ListNode ptr = ptr1;
		int count = 1;
		while(ptr.next!=null){
			if(count == k){
				ptr.next = ptr.next.next;
				count = 0;
			}
			else{
				ptr = ptr.next;
			}
			count++;
		}
		return ptr1.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		DeleteKthNode deleteKthNode = new DeleteKthNode();
		ListNode modifiedList = deleteKthNode.deleteKthNode(head, 1);
		System.out.println(modifiedList.data);
		
	}

}
