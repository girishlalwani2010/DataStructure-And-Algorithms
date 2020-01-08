package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author girish_lalwani
 *Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
 */
public class WordBreakII {

	private List<String> result;
	Map<String, String> memo;

	public List<String> wordBreak(String s, List<String> wordDict) {
		result = new ArrayList<>();
		memo = new HashMap<String, String>();
		wordBreak(s, wordDict, new StringBuilder());
		return result;
	}

	/**
	 * @param s
	 * @param wordDict
	 * @param sb
	 *            Need to be improve 27/39 cases passed.
	 */
	public void wordBreak(String s, List<String> wordDict, StringBuilder sb) {
		int len = s.length();

		if (len == 0) {
			result.add(sb.toString());
			return;
		}

		if (memo.containsKey(s)) {
			result.add(sb.toString() + " " + memo.get(s));
			return;
		}

		for (int l = 1; l <= len; l++) {
			// backtracking for another greater length substring for parent recursion,
			// in below case for answer "pineapple pen apple"
			if (wordDict.contains(s.substring(0, l))) {
				StringBuilder newSb = new StringBuilder(sb.toString());
				if (newSb.length() == 0) {
					newSb.append(s.substring(0, l));
				} else {
					newSb.append(" " + s.substring(0, l));
				}
				wordBreak(s.substring(l), wordDict, newSb);
			}
		}
		memo.put(sb.toString().replaceAll("\\s", ""), s);
	}
	
	
	public List<String> wordBreakUsingBackTracking(String s, List<String> wordDict) {
		result = new ArrayList<>();
		wordBreak(s, new HashSet<>(wordDict), new ArrayList<>(),0);
		return result;
	}

	/**
	 * @param s
	 * @param wordDict
	 * @param sb
	 *            Need to be improve 27/39 cases passed.
	 */
    
    public String convertListToString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str+" ");
        }
       return sb.toString().trim();
    }
    
	public void wordBreak(String s, Set<String> wordDict, List<String> currentSentence, int start) {

		if (start == s.length()) {
			result.add(convertListToString(currentSentence));
			return;
		}

		for (int i=start ; i < s.length(); i++) {
			// backtracking for another greater length substring for parent recursion,
			// in below case for answer "pineapple pen apple"
			if (wordDict.contains(s.substring(start, i+1))) {
				currentSentence.add(s.substring(start, i+1));
                wordBreak(s,wordDict, currentSentence, i+1);
                currentSentence.remove(currentSentence.size()-1);
			}
		}
	}

	// dp[] will be [[], [], [], [cat], [cats], [], [], [cats and, cat sand], [], [], [cats and dog, cat sand dog]]
	
	public List<String> wordBreakUsingDP(String s, Set<String> wordDict) {
		LinkedList<String>[] dp = new LinkedList[s.length() + 1];
		LinkedList<String> initial = new LinkedList<>();
		initial.add(""); // this is main case to pass whole length of string is in dictionary ,same as dp[0] = true in WordBreak-1 
		dp[0] = initial;
		for (int i = 1; i <= s.length(); i++) {
			LinkedList<String> list = new LinkedList<>();
			for (int j = i-1; j >= 0; j--) {
				if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
					for (String l : dp[j]) {
						list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
					}
				}
			}
			dp[i] = list;
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		//
		System.out.println(wb.wordBreakUsingDP(s, new HashSet<>(wordDict)));
	}

}
