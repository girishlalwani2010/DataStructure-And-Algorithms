package leetcode.amz;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
	
	    public String[] reorderLogFiles(String[] logs) {
	        
	        Arrays.sort(logs, new Comparator<String>(){
	            
	            public int compare(String s1, String s2){
	                boolean isDigit1 = Character.isDigit(s1.split(" ")[1].charAt(0));
	                boolean isDigit2 = Character.isDigit(s2.split(" ")[1].charAt(0));                                      
	                if(!isDigit1 && !isDigit2){
	                  int cmp = s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")));
	                    if(cmp == 0){
	                        return s1.compareTo(s2);
	                    }
	                    else{
	                        return cmp;
	                    }
	                }else{
	                    return isDigit1?(isDigit2?0:1):-1;
	                }
	            }
	            
	        });
	        
	        return logs;
	    }
	
	/**
	 * @param logs
	 * @return
	 * Best one
	 */
	public static String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
        	// function will be efficient for long strings,as it apply the pattern 1 time, as pewr java-docs it used to apply the 
        	// pattern n-1 times. for string[] of length n.
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
	

	public static void main(String[] args) {
		//String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String[] logs = {"t kvr", "r 3 1", "i 403", "7 so", "t 54"};
		System.out.println(reorderLogFiles2(logs));
	}

}
