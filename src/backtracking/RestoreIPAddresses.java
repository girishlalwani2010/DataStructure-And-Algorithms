package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	  public List<String> restoreIpAddresses(String s) {
	        List<String> result = new ArrayList<>();
	        restoreIpAddresses(s, new ArrayList<>(), 0, result);
	        return result;
	    }
	    
	    private void restoreIpAddresses(String s, List<String> list, int start, List<String> result){
	        
	        if(list.size() > 4){
	            return;
	        }
	        
	        if(list.size()==4 && start == s.length()){
	            StringBuilder sb = new StringBuilder();
	            int i=0;
	            for(String str : list){
	                sb.append(str);
	                if(i != list.size()-1){
	                    sb.append(".");
	                }
	                i++;
	            }
	            result.add(sb.toString());
	            return;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        for(int i=start; i<start+3 && i<s.length(); i++){
	            sb.append(s.charAt(i));
	            if(isValid(sb.toString())){
	                list.add(sb.toString());
	                restoreIpAddresses(s, list, i+1, result);
	                list.remove(list.size()-1);
	            }
	        }
	        
	    }
	    
	    public boolean isValid(String segment) {
	    /*
	    Check if the current segment is valid :
	    1. less or equal to 255      
	    2. the first character could be '0' 
	    only if the segment is equal to '0'
	    */
	    int m = segment.length();
	    if (m > 3)
	      return false;
	    return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
	  }
	
}
