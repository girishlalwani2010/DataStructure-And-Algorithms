package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author girish_lalwani
 *https://www.techiedelight.com/check-string-interleaving-two-given-strings/
 *
 */
public class InterleavingString {
	
	/**
	 * @param X
	 * @param Y
	 * @param S
	 * @return
	 * COMPLEXITY WILL BE O(2^mn) as tree with two childs and its keep on growing. Hence the recursive function will 
	 * be of form T(n,m) = T(n-1,m)+T(m-1,n)+C, that will be similar to T(n) = 2T(n-1)+c;
	 */
	public static boolean interleaved(String X, String Y, String S)
    {
        // return true if we have reached end of all Strings
        if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
            return true;
        }
 
        // return false if we have reached the end of String S
        // but String X or Y are not empty
 
        if (S.length() == 0) {
            return false;
        }
 
        // if String X is not empty and its first character matches with
        // first character of S, recur for remaining substring
 
        boolean x = (X.length() != 0 && S.charAt(0) == X.charAt(0)) &&
                interleaved(X.substring(1), Y, S.substring(1));
 
        // if String Y is not empty and its first character matches with
        // first character of S, recur for remaining substring
 
        boolean y = (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) &&
                interleaved(X, Y.substring(1), S.substring(1));
 
        return x || y;
    }
	
	
	/*** DP FUNCTION ***/
	 public boolean isInterleave(String X, String Y, String S) {
	        if (S.length() != X.length() + Y.length()) {
	            return false;
	        }
	        Map<String, Boolean> cache = new HashMap<>();
	        return areInterleaved(X, Y, S, cache);
	    }
	    
	    private boolean areInterleaved(String s1, String s2, String s3, Map<String, Boolean> cache){
	        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()){
	            return true;
	        }
	        if(s3.isEmpty()){
	            return false;
	        }
	        
	        String key = s1+"|"+s2+"|"+s3;
	        
	        if(!cache.containsKey(key)){
	            
	            boolean x = s1.length()!=0 && s1.charAt(0) == s3.charAt(0) && areInterleaved(s1.substring(1), s2, s3.substring(1), cache);
	            boolean y = s2.length()!=0 && s2.charAt(0) == s3.charAt(0) && areInterleaved(s1, s2.substring(1), s3.substring(1), cache);
	            cache.put(key,x||y);
	        }
	        
	        return cache.get(key);
	    }
 
    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "ACD";
        String S = "ACDABC";
 
        if (interleaved(X, Y, S)) {
            System.out.print("Given String is interleaving of X and Y");
        } else {
            System.out.print("Given String is not interleaving of X and Y");
        }
    }

}
