package array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	
	 public List<String> topKFrequent(String[] words, int k) {
	        
	        Map<String,Integer> map = new HashMap<>();
	        
	        for(int i=0; i<words.length; i++){
	            if(map.containsKey(words[i])){
	                map.put(words[i],map.get(words[i])+1);
	            }else{
	                 map.put(words[i],1);
	            }
	        }
	        
	        
	        Queue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
	            public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
	                if(entry2.getValue() == entry1.getValue()){
	                    return entry2.getKey().compareTo(entry1.getKey());
	                }else{
	                     return entry1.getValue() - entry2.getValue();
	                }
	            }
	        });
	        
	        for(Map.Entry<String,Integer> entry : map.entrySet()){
	            pq.offer(entry);
	            if(pq.size()>k){
	                    pq.poll();
	                }
	         }
	            
	        
	        List<String> result = new LinkedList<>();
	        while(k>0 && !pq.isEmpty()){
	            result.add(0,pq.poll().getKey());
	            k--;
	        }
	        return result;
	    }
	
}
