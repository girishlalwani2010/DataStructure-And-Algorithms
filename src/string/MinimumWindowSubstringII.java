package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringII {
	Map<Character, Integer> characterToFreq = new HashMap<>();

	public String minWindow(String s, String t) {

		if (t == null || t.length() == 0 || t.length() > s.length()) {
			return "";
		}

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Map<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < tArray.length; i++) {
			if (freqMap.containsKey(tArray[i])) {
				freqMap.put(tArray[i], freqMap.get(tArray[i]) + 1);
			}else {
				freqMap.put(tArray[i], 1);
			}
		}

		for (int i = 0; i < sArray.length; i++) {
			if (freqMap.containsKey(sArray[i])) {
				freqMap.put(sArray[i], freqMap.get(sArray[i]) - 1);
			}
		}

		for (int value : freqMap.values()) {
			if (value > 0) {
				return "";
			}
		}

		for (int i = 0; i < tArray.length; i++) {
			if (characterToFreq.containsKey(tArray[i])) {
				characterToFreq.put(tArray[i], characterToFreq.get(tArray[i]) + 1);
			} else {
				characterToFreq.put(tArray[i], 1);
			}
		}

		int start = 0, end = 0;
		String minWindowString = new String(s);

		while (end < s.length() || end - start >= t.length()) {
			boolean shouldExpand = false;
			for (int value : characterToFreq.values()) {
				if (value > 0) {
					shouldExpand = true;
					break;
				}
			}
			if (shouldExpand) {
				if (end < s.length()) {
					if (characterToFreq.containsKey(sArray[end])) {
						characterToFreq.put(sArray[end], characterToFreq.get(sArray[end]) - 1);
					}
					end++;
				} else {
					break;
				}
			} else {
				if (minWindowString.length() > (end - start)) {
					minWindowString = s.substring(start, end);
				}
				if (characterToFreq.containsKey(sArray[start])) {
					characterToFreq.put(sArray[start], characterToFreq.get(sArray[start]) + 1);
				}
				start++;
			}
		}

		return minWindowString;

	}
	
	
	public static void main(String[] args) {
		MinimumWindowSubstringII minimumWindowSubstringII = new MinimumWindowSubstringII();
		minimumWindowSubstringII.minWindow("babb", "baba");
	}
}
