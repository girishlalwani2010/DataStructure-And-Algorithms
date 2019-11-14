package string;

import java.util.Arrays;

/**
 * @author girish_lalwani
 *
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * Since the size of a word is small (<= 10), we can do a technique similar to Counting Sort 
 * to maintain the order of the word scores.
 * 
 * 
 *
 */
public class CompareStringByFrequencyOfSmallestCharacterInON {
	
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordScores = new int[words.length];
        //will store the count corresponding to frequency of smallest character in words array 
        int[] scoreMap = new int[11];
        for (int i = 0;i < words.length;i++) {
            wordScores[i] = f(words[i]);
            scoreMap[wordScores[i]]++;
        }
        // Acccumlate the sum 
        // if suppose scoreMap = [0 1 2 0 3 0 0 0 0 0 0]
        // then prefixSumScore = [0 1 3 3 6 6 6 6 6 6 6], why we did that as we know that any i+1th frequency will contains the count sum of i to 0 as well,
        // as if any frequency for queries is m, we just look for that frequency count m in prefixSumScore, and found that these number words will have frequency equal to query's smallest character frequency
        // so the ans is total words - prefixSumScore[m] 
        int[] prefixSumScore = new int[11];
        prefixSumScore[0] = scoreMap[0];
        for (int i = 1;i < 11;i++) {
            prefixSumScore[i] = prefixSumScore[i - 1] + scoreMap[i];
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0;i < queries.length;i++) {
            String query = queries[i];
            int score = f(query);
            ans[i] = words.length - prefixSumScore[score];
        }
        
        return ans;
    }
    
    /**
     * @param word
     * @return
     * like it 
     */
    private static int f(String word) {
        int[] freq = new int[26];
        char minChar = 'z';
        for (char c : word.toCharArray()) {
            if (c <= minChar) {
                freq[c - 'a']++;
                minChar = c;
            }
        }
        return freq[minChar - 'a'];
    }
	
    public static void main(String[] args) {
    	String []queries = {"bbb","cc"};
    	String []words = {"a","aa","aaa","aaaa"};
    	System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
	}
}
