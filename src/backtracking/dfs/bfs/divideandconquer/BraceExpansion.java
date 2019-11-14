package backtracking.dfs.bfs.divideandconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author girish_lalwani Snippet Attached in mail
 *         https://leetcode.com/problems/brace-expansion/
 */
public class BraceExpansion {
	public String[] expand(String S) {
		List<String> list = new ArrayList<String>();
		int n = S.length();
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '{') {
				int j = i + 1;
				StringBuilder sb = new StringBuilder();
				while (j < n && S.charAt(j) != '}') {
					if (S.charAt(j) == ',') {
						j++;
						continue;
					}
					sb.append(S.charAt(j));
					j++;
				}
				list.add(sb.toString());
				i = j;
			} else {
				list.add(S.charAt(i) + "");
			}
		}
		
		List<String> res = new ArrayList<String>();
		dfs(list, res, new StringBuilder(), 0);
		String[] resStrings = res.toArray(new String[res.size()]);
		Arrays.sort(resStrings);
		return resStrings;
	}
	
	
	private void dfs(List<String> list, List<String> res, StringBuilder sb, int pos) {
		if(sb.length() == list.size()) {
			res.add(sb.toString());
			return;
		}
		for(char c : list.get(pos).toCharArray()) {
			sb.append(c);
			dfs(list, res, sb, pos+1);
			sb.setLength(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		String S = "{a,b}c{d,e}f";
		BraceExpansion braceExpansion = new BraceExpansion();
		braceExpansion.expand(S);
	}
}
