package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromSubsequence {
	
	public static int longestPalindromeSubseq(String s) {
		
		if(s.isEmpty() || s==null) {
			return 0;
		}
		
		int dp[][] = new int[s.length()+1][s.length()+1];
		char[] charArray = s.toCharArray();
		for(int i=1; i<=charArray.length; i++) {
			dp[i][i] = 1;
		}
		for(int i=1; i<=charArray.length-1; i++) {
			if(charArray[i-1] == charArray[i]) {
				dp[i][i+1] = 2;
			}else {
				dp[i][i+1] = 1;
			}
		}
		
		for(int len=3; len<=charArray.length; len++) {
			for(int j=1; j<=charArray.length-len+1; j++) {
				int end = j+len-1;
				if(charArray[j-1] == charArray[end-1]) {
					dp[j][end] = dp[j+1][end-1] +2;
				}else {
					dp[j][end] = Integer.max(dp[j][end-1], dp[j+1][end]);
				}
			}
		}
		
		return dp[1][s.length()];
		
	}
	
	
	
	 /**
	 * @param s
	 * @return
	 * Perfect Intuitive for this problem.
	 * 
	 * i.e. start from both ends
	 */
	public int longestPalindromeSubseqTopDownMemo(String s) {
	        Map<String, Integer> memo = new HashMap<String, Integer>();
	        return longestPalindromeSubseq(s, 0, s.length()-1,  memo);
	    }
	    
	    private int longestPalindromeSubseq(String S,int i,int j,Map<String,Integer> memo){
	        if(i>j || S.length() == 0){
	            return 0;
	        }
	        
	        if(i==j){
	            return 1;
	        }
	        
	        String key = i+"|"+j;
	        
	        if(memo.containsKey(key)){
	            return memo.get(key);
	        }
	        else{
	            if(S.charAt(i) == S.charAt(j)){
	                memo.put(key,2+longestPalindromeSubseq(S,i+1,j-1,memo));
	                return memo.get(key);
	            }else{
	                memo.put(key,Math.max(longestPalindromeSubseq(S,i+1,j,memo),
	                                     longestPalindromeSubseq(S,i,j-1,memo)));
	                return memo.get(key);      
	            }     
	        }
	    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("a"));
	}

}
