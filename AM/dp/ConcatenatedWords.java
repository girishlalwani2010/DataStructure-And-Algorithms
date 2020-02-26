package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
	
	 public List<String> findAllConcatenatedWordsInADict(String[] words) {
	        
	        if(words.length<=2){
	            return new ArrayList<String>();
	        }
	        
	        Arrays.sort(words, new Comparator<String>(){
	            public int compare(String s1, String s2){
	                return s1.length() - s2.length();
	            }
	        });
	        
	        Set<String> preword = new HashSet<>();
	        
	        preword.add(words[0]);
	        
	        List<String> result = new ArrayList<>();
	        
	        for(int i=1; i<words.length; i++){
	            if(wordBreak(words[i],preword,0,new Boolean[words[i].length()])){
	                 result.add(words[i]);       
	            }
	            preword.add(words[i]);
	        }
	        
	        return result;
	    }
	    
	    
	    public boolean wordBreak(String word, Set<String> wordDict, int start, Boolean[] memo){
	        
	        if(start == word.length()){
	            return true;
	        }
	        
	       if(memo[start]!=null){
	            return memo[start];
	        }
	        
	        for(int i=start; i<word.length(); i++){
	            if(wordDict.contains(word.substring(start,i+1))){
	                if(wordDict.contains(word.substring(i+1,word.length())) || wordBreak(word,wordDict,i+1, memo)){
	                    memo[start] = true;
	                    return memo[start];
	                }
	            }    
	        }
	        
	        memo[start] = false;
	        return memo[start]; 
	    }
	    

}
