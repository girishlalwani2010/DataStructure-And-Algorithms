package linkedlist.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import linkedlist.ListNode;

public class MergeKSortedList {
	
	 public ListNode mergeKLists(List<ListNode> lists) {
	        if (lists==null||lists.size()==0) return null;
	        
	        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
	            @Override
	            public int compare(ListNode o1,ListNode o2){
	               return o1.val-o2.val;
	            }
	        });
	        
	        ListNode dummy = new ListNode(0);
	        ListNode tail=dummy;
	        
	        for (ListNode node:lists)
	            if (node!=null)
	                queue.add(node);
	            
	        while (!queue.isEmpty()){
	            tail.next=queue.poll();
	            tail=tail.next;
	            
	            if (tail.next!=null)
	                queue.add(tail.next);
	        }
	        return dummy.next;
	    }

}
