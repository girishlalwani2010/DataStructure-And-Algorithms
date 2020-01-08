package linkedlist.leetcode;

import linkedlist.ListNode;

public class IntersectionofTwoLinkedLists {
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        
	        if(headA==null || headB==null){
	            return null;
	        }
	        
	        int headALength = 0;
	        ListNode p1=headA;
	        while(p1!=null){
	            headALength++;
	            p1 = p1.next;
	        }
	        
	        int headBLength = 0;
	        ListNode p2=headB;
	        while(p2!=null){
	            headBLength++;
	            p2 = p2.next;
	        }
	        
	        int diff = Math.abs(headALength-headBLength);
	        boolean advanceA = (headALength>headBLength)?true:false;
	        
	        if(advanceA){
	            while(diff!=0){
	                headA = headA.next;
	                diff--;
	            }
	        }else{
	            while(diff!=0){
	                headB = headB.next;
	                diff--;
	            }
	        }
	        
	        while(headA!=null){
	            if(headA == headB){
	                return headA;
	            }
	            headA = headA.next;
	            headB = headB.next;
	        }
	        
	        return null;
	    }

}
