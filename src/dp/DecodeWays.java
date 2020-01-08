package dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	
	Map<String,Integer> memo = new HashMap<String, Integer>();
	
	public int numDecodingsTopDown(String s) {
        int len = s.length();
        
        if(len == 0){
            return 1;
        }
        if(len == 1){
            if(Integer.valueOf(s.charAt(0)+"") !=0){
                return 1;
            }
            return 0; 
        }
        
        if(memo.containsKey(s)) {
        	return memo.get(s);
        }
        //it is local as every subproblem is independent //try with case 16205 draw recursion tree
        int count = 0;
        
        if(Integer.valueOf(s.charAt(0)+"")!=0){
          count = numDecodingsTopDown(s.substring(1));
        }
        
        if(Integer.valueOf(s.substring(0,2))>=10 && Integer.valueOf(s.substring(0,2))<=26){
          count = count+numDecodingsTopDown(s.substring(2)); 
        }
        
        memo.put(s,count);
        return count;
    }
	
	static int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		if (s.length() == 1 && s.equals("0")) {
			return 0;
		}
		if (s.startsWith("0"))
			return 0;
		
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] =1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= n; i++) {
			int number = Integer.valueOf(s.substring(i-1, i));
			if (number > 0 && number <= 9) {
				dp[i] = dp[i-1];
			} 
			number = Integer.valueOf(s.substring(i-2, i));
			if (number >= 10 && number <= 26) {
				dp[i] = dp[i] + dp[i-2];
			}
		}

		return dp[n];
	}
	
	public static void main(String[] args) {
		DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodingsTopDown("16205"));
    }
}
