package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {
	 List<List<String>> result;
	    
	    public List<List<String>> partition(String s) {
	        result = new ArrayList<>();
	        partition(s, new ArrayList<>(),0);
	        return result;
	    }
	    
	    public void partition(String s, List<String> palindroms, int start){
	        
	        if(start == s.length()){
	            result.add(new ArrayList<>(palindroms));
	            return;  
	        }
	        
	        //choose
	        //explore
	        //unchoose
	        for(int i=start; i<s.length(); i++){
	            String str = s.substring(start,i+1);
	            if(isPalindrom(str)){
	                palindroms.add(str);
	                partition(s,palindroms,i+1);
	                palindroms.remove(palindroms.size()-1);
	            }
	        }
	    }
	    
	    
	    public boolean isPalindrom(String s){
	        for(int i=0; i<s.length()/2; i++){
	            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
	                return false;
	            }
	        }
	        return true;
	    }
}
