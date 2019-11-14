package linkedlist;

public class LinkedListUtil {

	private static void printList(ListNode head) {
		
		while(head != null){
			System.out.print(head.data+"-->");
			head = head.next;
		}
		
	}
	
	private static ListNode deleteNode(ListNode head, int x){
		
		ListNode ptr = head;
		ListNode prev = null;
		boolean deleteFromBegin = false;
		
		while(ptr!=null){
			if( ptr.data == x){
					prev.next = ptr.next;
					//ptr = prev;
			}
				else{prev = ptr;
				ptr = ptr.next;
				}
			
		}
		
		if(deleteFromBegin){
			head = head.next;
		}
		
		return head;
		
	}
	
private static ListNode deleteNode2(ListNode head, int x){
		
		ListNode ptr = head;
		
		while(ptr.next!=null){
			if( ptr.next.data == x){
					ptr.next = ptr.next.next;
			}
			else{
				ptr = ptr.next;
			}
			
		}
		
		return head;
		
	}
	
	public static ListNode removeElements(ListNode head, int val) {
	    ListNode helper = new ListNode(0);
	    helper.next = head;
	    ListNode p = helper;
	 
	    while(p.next != null){
	        if(p.next.data == val){
	            p.next = p.next.next;
	        }else{
	            p = p.next;
	        }
	    }
	 
	    return helper.next;
	}
	
	public static ListNode removePairs(ListNode head) {
	    ListNode helper = new ListNode(0);
	    helper.next = head;
	    ListNode p = helper;
	 
	    while(p.next.next != null){
	    	
	        if(p.next.data == p.next.next.data){
	            p.next = p.next.next.next;
	        }else{
	            p = p.next;
	        }
	    }
	 
	    return helper.next;
	}
	
	public static void main(String[] args) {
		ListNode firstNode = new ListNode(1);
		ListNode secondNode = new ListNode(1);
		ListNode thirdNode = new ListNode(5);
		ListNode fourthNode = new ListNode(7);
		ListNode fifthNode = new ListNode(7);
		ListNode sixthNode = new ListNode(1);
		ListNode seventhNode = new ListNode(3);
		
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = fifthNode;
		fifthNode.next = sixthNode;
		sixthNode.next = seventhNode;
		
		System.out.println("List Before Deleting : ");
		printList(firstNode);
		
		ListNode head = removeElements(firstNode, 1);
		
		System.out.println();
		System.out.println("List After Deleting : ");
		printList(head);
		
		
	}

	
}
