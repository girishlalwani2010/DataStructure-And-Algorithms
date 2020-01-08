package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
 */
public class LongestRepeatingCharacterReplacement {

	public static int characterReplacement(String s, int k) {
		int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(characterReplacement("AABABBA", 1));

	}

}
