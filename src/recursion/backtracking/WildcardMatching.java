package recursion.backtracking;

public class WildcardMatching {

	public boolean isMatchUsingDP(String s, String p) {
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		// replace multiple * with one *
		// e.g a**b***c --> a*b*c
		int writeIndex = 0;
		boolean isFirst = true;
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[writeIndex++] = pattern[i];
					isFirst = false;
				}
			} else {
				pattern[writeIndex++] = pattern[i];
				isFirst = true;
			}
		}

		boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

		if (writeIndex > 0 && pattern[0] == '*') {
			T[0][1] = true;
		}

		T[0][0] = true;

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				}
			}
		}

		return T[str.length][writeIndex];
	}

	public static boolean isMatch(String s, String p) {
		int sLen = s.length(), pLen = p.length();
		int sIdx = 0, pIdx = 0;
		int starIdx = -1, sTmpIdx = -1;

		while (sIdx < sLen) {
			// If the pattern character = string character
			// or pattern character = '?'
			if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
				++sIdx;
				++pIdx;
			}
			// If pattern character = '*'
			else if (pIdx < pLen && p.charAt(pIdx) == '*') {
				// Check the situation
				// when '*' matches no characters
				starIdx = pIdx;
				sTmpIdx = sIdx;
				++pIdx;
			}
			// If pattern character != string character
			// or pattern is used up
			// and there was no '*' character in pattern
			else if (starIdx == -1) {
				return false;
			}
			// If pattern character != string character
			// or pattern is used up
			// and there was '*' character in pattern before
			else {
				// Backtrack: check the situation
				// when '*' matches one more character
				pIdx = starIdx + 1;
				sIdx = sTmpIdx + 1;
				sTmpIdx = sIdx;
			}
		}

		// The remaining characters in the pattern should all be '*' characters
		for (int i = pIdx; i < pLen; i++)
			if (p.charAt(i) != '*')
				return false;
		return true;
	}

	public static void main(String[] args) {
		String text = "abefcdgiescdfimde";
		String pattern = "ab*cd?i*de";
		System.out.println(isMatch(text, pattern));
	}

}
