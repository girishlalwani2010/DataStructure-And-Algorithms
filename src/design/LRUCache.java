
//LeetCode Problem Link : https://leetcode.com/problems/lru-cache/

class DLLNode{
    /*** These can be better encapsulated with private access specifier, and getter and setter can
         be implemented to access these variables, but here focusing more on logic more, then OOPS Concepts, 
         and it will be quick to code in interviews as well by just saying to the interviewer that to do it the time span, just omitting some OOPS Concept
         and specify those oraly***/
    public int key;
    public int val;
    public DLLNode prev;
    public DLLNode next;
    public DLLNode(int key, int val){
        this.key = key;
        this.val = val;
    }
    public DLLNode(){
    }
}

// DLL Order is from [leastRecentlyUsed ---------------> mostRecentlyUsed] item.

// head -->  [DLLNode-1] --> [DLLNode-2] --> [DLLNode-3] <-- tail
//      <--              <--             <--             -->

class LRUCache {
    private int capacity;
    private Map<Integer, DLLNode> map;
    private DLLNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;
    }
    
    private void remove(DLLNode node) {
        DLLNode next = node.next;
        DLLNode prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    
    private void removeFromHead() {
        DLLNode next = head.next;
        head.next = next.next;
        next.next.prev = head;
    }
    
    private void insertAtTail(DLLNode node) {
        DLLNode tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        tail.prev = node;
        node.next = tail;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        DLLNode nodeAccess = map.get(key);
        remove(nodeAccess);
        insertAtTail(nodeAccess);
        return nodeAccess.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
             DLLNode node = map.get(key);
             remove(node);
        }
        else if(map.size() == capacity) {
           //remove the least-recently used item, from map and DLL both
            map.remove(head.next.key);
            removeFromHead();
        }
        
        DLLNode newNode = new DLLNode(key, value);
        insertAtTail(newNode);
        map.put(key, newNode);
    }
}
