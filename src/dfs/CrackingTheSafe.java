package dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author girish_lalwani
 *Snippet attached in mail
 */
public class CrackingTheSafe {

	private static Set<String> seen;
	private static StringBuilder ans;

	public static String crackSafe(int n, int k) {
		if (n == 1 && k == 1)
			return "0";
		seen = new HashSet();
		ans = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; ++i)
			sb.append("0");
		String start = sb.toString();
		dfs(start, k);
		ans.append(start);
		return new String(ans);
	}

	public static void dfs(String node, int k) {
		for (int x = 0; x < k; ++x) {
			String nei = node + x;
			if (!seen.contains(nei)) {
				// 00,01,10 
				seen.add(nei);
				dfs(nei.substring(1), k);
				//if thinks will generated all its combination then add this state as its work completed
				ans.append(x);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(crackSafe(2, 2));
	}

}
