package lowleveldesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheRepeat {
	
	class ListNode{
		int val;
		int key;
		ListNode prev;
		ListNode next;
		public ListNode() {
		}
		public ListNode(int key, int val){
			this.val = val;
			this.key = key;
		}
	}
	
	private Map<Integer,ListNode> map;
	private ListNode head;
	private ListNode tail;
	private int size;
	private int capacity;
	
	public LRUCacheRepeat(int capacity) {
        this.map = new HashMap<>();
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if(node!=null) {
        	moveToFront(node);
        	return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
    	 ListNode node = map.get(key);
    	 if(node!=null) {
    		 node.val = value;
    		 moveToFront(node);
    	 }else {
    		 ListNode newNode = new ListNode(key,value);
    		 //add to map
    		 map.put(key, newNode);
    		 //add to DLL
    		 addToHead(newNode);
    		 size++;
    		 if(size>capacity) {
    			 removeLeastRecentlyAccessed();
    		 }
    	 }
    }
    
    public void removeLeastRecentlyAccessed() {
    	ListNode tailItem = tail.prev;
    	map.remove(tailItem.key);
    	removeNode(tail.prev);
    	size--;
    }
    
    public void moveToFront(ListNode node) {
    	removeNode(node);
    	addToHead(node);
    }
	
    public void removeNode(ListNode node) {
    	ListNode prevOfNode = node.prev;
    	ListNode nextOfNode = node.next;
    	prevOfNode.next = nextOfNode;
    	nextOfNode.prev = prevOfNode;
    }
    
    public void addToHead(ListNode node) {
    	node.prev = head;
    	node.next = head.next;
    	head.next.prev = node;
    	head.next = node;
    	
    }

}
