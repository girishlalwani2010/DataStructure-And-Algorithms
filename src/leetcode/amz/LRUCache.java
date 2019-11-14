package leetcode.amz;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
	
	int capacity;
	Map<Integer,Integer> map = new HashMap<>();
	Deque<Integer> deque = new LinkedList<>();
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(map.get(key) == null)
    		return -1;
    	deque.remove(key);
    	deque.addLast(key);
    	return map.get(key);
    }
    
    public void put(int key, int value) {
    	boolean isPresent = map.containsKey(key);
    	if(deque.size()==capacity && !isPresent) {
    		map.remove(deque.removeFirst());
    	}
    	if(isPresent) {
    		deque.remove(key);
    	}
    	map.put(key, value);
    	deque.addLast(key);
    }
    
    public static void main(String[] args) {
    	LRUCache lruCache = new LRUCache(2);
    	lruCache.put(2, 1);
    	lruCache.put(1, 1);
    	lruCache.put(2, 3);
    	lruCache.put(4, 1);
    	
    	
		
	}
}
