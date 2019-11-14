package datastructure.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {

	public static int numMatchingSubseq(String S, String[] words) {
		char[] source = S.toCharArray();
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < source.length; i++) {
			if (!map.containsKey(source[i])) {
				map.put(source[i], new ArrayList<Integer>());
			}
			map.get(source[i]).add(i);
		}

		int wordMatches = 0;

		for (String str : words) {
			int sourcePos = -1;
			int prevPos = -1;
			boolean isMatch = true;
			char[] target = str.toCharArray();
			for (int j = 0; j < target.length; j++) {
				List<Integer> list = map.get(target[j]);
				if (list == null) {
					isMatch = false;
					break;
				}
				prevPos = sourcePos;
				sourcePos = findNext(list, sourcePos);
				if (sourcePos <= prevPos) {
					isMatch = false;
					break;
				}
			}
			if (isMatch) {
				wordMatches = wordMatches + 1;
			}
		}
		return wordMatches;

	}

	private static int findNext(List<Integer> list, int sourcePos) {
		int lo = 0;
		int hi = list.size() - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (list.get(mid) > sourcePos) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return list.get(lo);
	}
	
	public static void main(String[] args) {
		String s = "abcde";
		String[] words = {"bb"};
		numMatchingSubseq(s, words);
	}
}
