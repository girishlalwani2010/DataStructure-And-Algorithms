package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
	       if(s==null || s.length()==0){
	            return 0;
	       }
	       Set<Character> set = new HashSet<>();
	       int start = 0, end = 1;
	       set.add(s.charAt(start));
	       int maxLen=1; 
	       while(end<s.length()){
	            if(set.contains(s.charAt(end))){
	                set.remove(s.charAt(start));
	                start++;
	            }else{
	                set.add(s.charAt(end));
	                end++;
	            }
	           if(end-start>maxLen){
	               maxLen = end-start;
	           }
	       }
	        return maxLen;
	    }
	
	 /**
	 * @param s
	 * @return
	 * 
	 * To optimize the start movement in above solution it is moving by one now it is moving 
	 * according to its early occurence. 
	 */
	public int lengthOfLongestSubstringUsingMap(String s) {
	       if(s==null || s.length()==0){
	            return 0;
	       }
	        
	       Map<Character,Integer> charToPos = new HashMap<>();
	       int start = 0, end = 1;
	       charToPos.put(s.charAt(start),0);
	       int maxLen=1; 
	       while(end<s.length()){
	           if(charToPos.containsKey(s.charAt(end))){
	                int pos = charToPos.get(s.charAt(end));
	                start = Math.max(pos+1,start);
	           }
	           charToPos.put(s.charAt(end),end);
	           end++;
	           if(end-start>maxLen){
	               maxLen = end-start;
	           }
	       }
	        return maxLen;
	    }
	
	 public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
