package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {

		Map<Character, Integer> characterToFrequency = new HashMap<>();
		char[] s1Array = s1.toCharArray();

		for (int i = 0; i < s1Array.length; i++) {
			if (characterToFrequency.containsKey(s1Array[i])) {
				characterToFrequency.put(s1Array[i], characterToFrequency.get(s1Array[i]) + 1);
			} else {
				characterToFrequency.put(s1Array[i], 1);
			}
		}

		char[] s2Array = s2.toCharArray();
		int start = 0;
		for (int end = 0; end < s2Array.length; end++) {
			if (characterToFrequency.containsKey(s2Array[end])) {
				characterToFrequency.put(s2Array[end], characterToFrequency.get(s2Array[end]) - 1);
			}
			if (Collections.max(characterToFrequency.values()) == 0) {
				while (end - start + 1 > s1.length()) {
					if (characterToFrequency.containsKey(s2Array[start])) {
						characterToFrequency.put(s2Array[start], characterToFrequency.get(s2Array[start]) + 1);
					}
					start++;
				}
				if(Collections.max(characterToFrequency.values()) == 0 && (end - start + 1) == s1.length()) {
					return true;
				}
			}
		}
		return false;
	}

}
