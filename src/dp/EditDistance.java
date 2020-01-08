package dp;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
	Map<String, Integer> cache = new HashMap<>();

	public int minDistance(String word1, String word2) {
		return minEditDistance(word1, word2, word1.length(), word2.length());
	}

	public int minEditDistance(String word1, String word2, int m, int n) {
		// if source is empty, so we have to append all characters in source of target,
		// to get the target, so n will be minimum cost or edit distance to convert
		// source to // target
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}

		String subProblem = word1.substring(0, m) + "|" + word2.substring(0, n);

		if (cache.containsKey(subProblem)) {
			return cache.get(subProblem);
		}
		int minDistance = -1;
		if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
			minDistance = minEditDistance(word1, word2, m - 1, n - 1);
		} else {
			// insert case -- minEditDistance(word1,word2,m,n-1)
			// delete case -- minEditDistance(word1,word2,m-1,n)
			// replace case -- minEditDistance(word1,word2,m-1,n-1)
			minDistance = 1 + Math.min(minEditDistance(word1, word2, m - 1, n - 1),
					Math.min(minEditDistance(word1, word2, m, n - 1), minEditDistance(word1, word2, m - 1, n)));
		}
		cache.put(subProblem, minDistance);
		return cache.get(subProblem);
	}
}
