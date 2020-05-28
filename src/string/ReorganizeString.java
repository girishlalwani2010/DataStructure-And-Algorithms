package string;

import java.util.PriorityQueue;

/**
 * @author girish_lalwani
 *         https://leetcode.com/problems/reorganize-string/discuss/232469/Java-No-Sort-O(N)-0ms-beat-100
 *
 *         Consider this example: "aaabbbcdd", we will construct the string in
 *         this way: a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4 a b a
 *         _ a _ b _ b // fill in "b" at position 6, 8, 1 a b a c a _ b _ b //
 *         fill in "c" at position 3 a b a c a d b d b // fill in "d" at
 *         position 5, 7
 */
public class ReorganizeString {

	public String reorganizeString(String S) {
		int[] hash = new int[26];
		for (int i = 0; i < S.length(); i++) {
			hash[S.charAt(i) - 'a']++;
		}
		int max = 0, letter = 0;
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > max) {
				max = hash[i];
				letter = i;
			}
		}
		if (max > (S.length() + 1) / 2) {
			return "";
		}
		char[] res = new char[S.length()];
		int idx = 0;
		while (hash[letter] > 0) {
			res[idx] = (char) (letter + 'a');
			idx += 2;
			hash[letter]--;
		}
		for (int i = 0; i < hash.length; i++) {
			while (hash[i] > 0) {
				if (idx >= res.length) {
					idx = 1;
				}
				res[idx] = (char) (i + 'a');
				idx += 2;
				hash[i]--;
			}
		}
		return String.valueOf(res);
	}

	 public String reorganizeStringUsingHeap(String S) {
	        int N = S.length();
	        int[] count = new int[26];
	        for (char c: S.toCharArray()) count[c-'a']++;
	        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
	            a.count == b.count ? a.letter - b.letter : b.count - a.count);

	        for (int i = 0; i < 26; ++i) if (count[i] > 0) {
	            if (count[i] > (N + 1) / 2) return "";
	            pq.add(new MultiChar(count[i], (char) ('a' + i)));
	        }

	        StringBuilder ans = new StringBuilder();
	        while (pq.size() >= 2) {
	            MultiChar mc1 = pq.poll();
	            MultiChar mc2 = pq.poll();
	            /*This code turns out to be superfluous, but explains what is happening
	            if (ans.length() == 0 || mc1.letter != ans.charAt(ans.length() - 1)) {
	                ans.append(mc1.letter);
	                ans.append(mc2.letter);
	            } else {
	                ans.append(mc2.letter);
	                ans.append(mc1.letter);
	            }*/
	            ans.append(mc1.letter);
	            ans.append(mc2.letter);
	            if (--mc1.count > 0) pq.add(mc1);
	            if (--mc2.count > 0) pq.add(mc2);
	            }

	        if (pq.size() > 0) ans.append(pq.poll().letter);
	        return ans.toString();
	    }
}

class MultiChar {
    int count;
    char letter;
    MultiChar(int ct, char ch) {
        count = ct;
        letter = ch;
    }
}
