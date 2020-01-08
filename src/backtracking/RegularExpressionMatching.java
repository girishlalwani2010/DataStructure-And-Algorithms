package backtracking;

public class RegularExpressionMatching {

	public boolean isMatch(String text, String pattern) {
		if(pattern.isEmpty()) {
			return text.isEmpty();
		}
		boolean firstMatch = false;
		if(!text.isEmpty() && ((text.charAt(0) == pattern.charAt(0)) || pattern.charAt(0) == '.')) {
			firstMatch = true;
		}
		if(pattern.length()>=2 && pattern.charAt(1) == '*') {
			// estrick can act as zero occurrence or (||) many. happygirlzt video https://www.youtube.com/watch?v=bSdw9rJYf-I&t=603s
			return isMatch(text,pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
		}else {
			return firstMatch && isMatch(text.substring(1),pattern.substring(1));
		}
	}
	
	
	// DP solution as this contains isMatch(text,pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern)) 
	// overlapping subProblems
	
	enum Result {
	    TRUE, FALSE
	}

	class Solution {
	    Result[][] memo;

	    public boolean isMatch(String text, String pattern) {
	        memo = new Result[text.length() + 1][pattern.length() + 1];
	        return dp(0, 0, text, pattern);
	    }

	    public boolean dp(int i, int j, String text, String pattern) {
	        if (memo[i][j] != null) {
	            return memo[i][j] == Result.TRUE;
	        }
	        boolean ans;
	        if (j == pattern.length()){
	            ans = i == text.length();
	        } else{
	            boolean first_match = (i < text.length() &&
	                                   (pattern.charAt(j) == text.charAt(i) ||
	                                    pattern.charAt(j) == '.'));

	            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                ans = (dp(i, j+2, text, pattern) ||
	                       first_match && dp(i+1, j, text, pattern));
	            } else {
	                ans = first_match && dp(i+1, j+1, text, pattern);
	            }
	        }
	        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
	        return ans;
	    }
	}
	
}
