package linkedlist;

public class IntersectionOfTwoSortedList {

	private ListNode head;
	
	private void pushDataToList(int data) {
		
		if(head == null){
			head = new ListNode(data);
			return;
		}
		ListNode t = head;
		while(t.next!=null){
			t = t.next;
		}
		t.next = new ListNode(data);
	}
	
	private void printList(ListNode head) {
		
		while(head != null){
			System.out.print(head.data+"-->");
			head = head.next;
		}
		
	}
	
	private ListNode intersection(ListNode L1, ListNode L2){
		
		while(L1 != null && L2 != null){
			if(L1.data<L2.data){
				L1 = L1.next;
			}
			else if(L2.data<L1.data){
				L2 = L2.next;
			}
			else{
				pushDataToList(L1.data);
				L1 = L1.next;
				L2 = L2.next;
			}
		}
		return head;
		
	}
	

	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(6);
		
		ListNode L2 = new ListNode(2);
		L2.next = new ListNode(4);
		L2.next.next = new ListNode(6);
		L2.next.next.next = new ListNode(8);
		
		IntersectionOfTwoSortedList intersectionOfTwoSortedList = new IntersectionOfTwoSortedList();
		ListNode L3 = intersectionOfTwoSortedList.intersection(L1, L2);
		intersectionOfTwoSortedList.printList(L3);
	}
	
}
