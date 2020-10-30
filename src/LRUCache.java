import java.util.HashMap;
import java.util.Map;

class Node{
    public int value;
    public int key;
    public Node prev;
    public Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
 // default constructor
    public Node(){
       
    }
}

class DoublyLinkedList{
    public Node head;
    public Node tail;
    
    public DoublyLinkedList(){
    }
    
    public void add(Node node){
        if(head==null && tail==null){
            head = node;
            tail = node;
            return;
        }
        Node prev = tail;
        prev.next = node;
        node.prev = prev;
        tail = node;
    }
    
    public void delete(){
        if(head == null){
            return;
        }
        Node next = head.next;
        if(next!=null) {
        	next.prev = head;
        }
        head = next;
    }
    
    public void delete(Node node){
        Node next = node.next;
        Node prev = node.prev;
        node.next = null;
        if(next==null && prev==null){
            head = null;
            tail = null;
            return;
        }
        next.prev = prev;
    }
}

public class LRUCache {

    private Map<Integer, Node> map;
    private DoublyLinkedList dll; 
    private int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        dll = new DoublyLinkedList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        dll.delete(node);
        dll.add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if(!map.containsKey(key)){
            Node node1 = new Node(key, value);
            if(map.size() == capacity){
                map.remove(dll.head.key);
                dll.delete();
            }
            map.put(key,node1);
            dll.add(node1);
        }else{
            Node node = map.get(key);
            node.value = value;
             dll.delete(node);
             dll.add(node);
        }
        
    }
    
    public static void main(String[] args) {
    	LRUCache lruCache = new LRUCache(2);
    	lruCache.put(1, 1);
    	lruCache.put(2, 2);
    	System.out.println(lruCache.get(1));
    	lruCache.put(3, 3);
	}
}

