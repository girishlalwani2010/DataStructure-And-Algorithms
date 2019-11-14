package datastructures.linkedlist;

public class LinkedListMultiplication {

	private ListNode multiplyTwoLinkedList(ListNode listNode){
		return listNode;
		
	}
	
	public static void main(String[] args) {
		ListNode list1= new ListNode(3);
		ListNode list2 = new ListNode(6);
		ListNode list3 = new ListNode(5);
		list3.next = list2;
		list2.next = list1;
		
	}
	
}
