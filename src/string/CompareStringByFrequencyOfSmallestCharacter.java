package string;

import java.util.Arrays;

/**
 * @author girish_lalwani
 *
 *https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * Hint1 : For each string from words calculate the leading count and store it in an array, then sort the integer array.
   Hint2 : For each string from queries calculate the leading count "p" and in base of the sorted array calculated on the step 1 do a binary search to count the number of items greater than "p". 
 */
public class CompareStringByFrequencyOfSmallestCharacter {
	
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length], w = new int[words.length];
        for (int i = 0; i < q.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < w.length; i++) {
            w[i] = f(words[i]);
        }
        Arrays.sort(w);
        int[] ans = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int l = 0, r = w.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (w[mid] <= q[i]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            ans[i] = w.length - l;
        }
        return ans;
    }
    
    private int f(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray())
            arr[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return arr[i];
        }
        return 0;
    }
	
}
