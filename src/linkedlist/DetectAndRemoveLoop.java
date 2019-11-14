package linkedlist;

public class DetectAndRemoveLoop {
	
	int detectAndRemoveLoop(ListNode node) {
        ListNode slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
 
    // Function to remove loop
    void removeLoop(ListNode loop, ListNode curr) {
        ListNode ptr1 = null, ptr2 = null;
 
        /* Set a pointer to the beging of the Linked List and
         move it one by one to find the first node which is
         part of the Linked List */
        ptr1 = curr;
        while (true) {
 
            /* Now start a pointer from loop_node and check if it ever
             reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
 
            /* If ptr2 reahced ptr1 then there is a loop. So break the
             loop */
            if (ptr2.next == ptr1) {
                break;
            }
 
            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }
 
        /* After the end of loop ptr2 is the last node of the loop. So
         make next of ptr2 as NULL */
        ptr2.next = null;
    }
 
    // Function to print the linked list
    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

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
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = head.next.next.next;
		
		DetectAndRemoveLoop detectAndRemoveDuplicates = new DetectAndRemoveLoop();
		detectAndRemoveDuplicates.detectAndRemoveLoop(head);
		
		
	}
}
