package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllParanthesis {

	List<String> wellFormedParanthesis = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		dfs("", 0, 0, n);
		return wellFormedParanthesis;
	}

	public void dfs(String formedParanthesis, int openBraces, int closeBraces, int paranthesisLength) {
		if (formedParanthesis.length() == 2 * paranthesisLength) {
			wellFormedParanthesis.add(formedParanthesis);
			return;
		}
		if (openBraces < paranthesisLength) {
			dfs(formedParanthesis + "(", openBraces + 1, closeBraces, paranthesisLength);
		}

		if (closeBraces < openBraces) {
			dfs(formedParanthesis + ")", openBraces, closeBraces + 1, paranthesisLength);
		}
	}
	
	
	public List<String> generateParenthesisPerfectBacktracking(int n) {
	     List<String> res = new ArrayList<>();
	     helper(res, new StringBuilder(), 0, 0, n);
	     return res;
	}

	private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
	    if(open == n && close == n) {
	        res.add(sb.toString());
	        return;
	    }		
	    
	    if(open < n) {
	        sb.append("(");
	        helper(res, sb, open+1, close, n);
	        sb.setLength(sb.length()-1);
	    } 
	    if(close < open) {
	        sb.append(")");
	        helper(res, sb, open, close+1, n);
	        sb.setLength(sb.length()-1);
	    }
	}
}
