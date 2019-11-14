package algo.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author girish_lalwani
 * 
 * https://leetcode.com/problems/time-based-key-value-store/
 *
 *Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.
2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").
 *
 */
public class TimeMap {
	
	Map<String, List<TimeMapNode>> timeMap;
	
    /** Initialize your data structure here. */
    public TimeMap() {
    	timeMap=new HashMap<String,List<TimeMapNode>>();
    }
    
    public void set(String key, String value, int timestamp) {
    	timeMap.putIfAbsent(key, new ArrayList<TimeMapNode>());
    	timeMap.get(key).add(new TimeMapNode(key,value,timestamp));
    }
    
    public String get(String key, int timestamp) {
    	if(!timeMap.containsKey(key)){
            return "";
        }
        List<TimeMapNode> timeMapNodeList = timeMap.get(key);
        int index = Collections.binarySearch(timeMapNodeList,new TimeMapNode(key,"",timestamp) , new Comparator<TimeMapNode>() {
			@Override
			public int compare(TimeMapNode o1, TimeMapNode o2) {
				return Integer.compare(o1.timestamp, o2.timestamp);
			}
        	
		});
        if (index >= 0)
            return timeMapNodeList.get(index).getValue();
        else if (index == -1)
            return "";
        else
            return timeMapNodeList.get(-index-2).getValue();
    }
    
    public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1);
		timeMap.set("foo", "bar2", 2);
		System.out.println(timeMap.get("foo",1));
		System.out.println(timeMap.get("foo",3));
	}
}

