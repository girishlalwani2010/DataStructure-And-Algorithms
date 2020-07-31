package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author girish_lalwani
 *
 *         Word Ladder -II Reference
 *         https://www.youtube.com/watch?v=vZNFOBEfib4&t=265s main basic
 *         approach is to do bfs to construct the map of connected nodes,
 *         map(i.e. adjacency list representation of words) and it is of type
 *         <String,List<String>>
 *
 *
 *         Optimized Approach is to do bidirectional-bfs, one from start and
 *         other from end for both Word-Ladder-I, and Word-Ladder-II
 *
 *         https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 *         for word-ladder-I
 */
public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		if(!wordList.contains(endWord)) {
			return 0;
		}
		
		Set<String> wordSet = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int level=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size>0) {
				String word = queue.remove();
				if(word.equals(endWord)) {
					return level+1;
				}
				for(int i=0; i<word.length(); i++) {
					char[] wordArray = word.toCharArray();
					for(char c='a'; c<='z'; c++) {
						wordArray[i]=c;
						String stringWord = new String(wordArray);
						if(wordSet.contains(stringWord) && !word.equals(stringWord)) {
							queue.add(stringWord);
							wordSet.remove(stringWord);
						}
					}
				}
				size--;
			}
			level++;
		}
		return 0;
	}
	
	public int ladderLengthInOMN2(String beginWord, String endWord, List<String> wordList) {

	    // Since all words are of same length.
	    int L = beginWord.length();

	    // Dictionary to hold combination of words that can be formed,
	    // from any given word. By changing one letter at a time.
	    Map<String, List<String>> allComboDict = new HashMap<>();

	    wordList.forEach(
	        word -> {
	          for (int i = 0; i < L; i++) {
	            // Key is the generic word
	            // Value is a list of words which have the same intermediate generic word.
	            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
	            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
	            transformations.add(word);
	            allComboDict.put(newWord, transformations);
	          }
	        });

	    // Queue for BFS
	    Queue<Pair<String, Integer>> Q = new LinkedList<>();
	    Q.add(new Pair(beginWord, 1));

	    // Visited to make sure we don't repeat processing same word.
	    Map<String, Boolean> visited = new HashMap<>();
	    visited.put(beginWord, true);

	    while (!Q.isEmpty()) {
	      Pair<String, Integer> node = Q.remove();
	      String word = node.getKey();
	      int level = node.getValue();
	      for (int i = 0; i < L; i++) {

	        // Intermediate words for current word
	        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

	        // Next states are all the words which share the same intermediate state.
	        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
	          // If at any point if we find what we are looking for
	          // i.e. the end word - we can return with the answer.
	          if (adjacentWord.equals(endWord)) {
	            return level + 1;
	          }
	          // Otherwise, add it to the BFS Queue. Also mark it visited
	          if (!visited.containsKey(adjacentWord)) {
	            visited.put(adjacentWord, true);
	            Q.add(new Pair(adjacentWord, level + 1));
	          }
	        }
	      }
	    }

	    return 0;
	  }

	/**
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 * 
	 * 		Bi-Directional BFS
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();

		set1.add(start);
		set2.add(end);

		return helper(dict, set1, set2, 1);
	}

	/**
	 * @param dict
	 * @param set1
	 * @param set2
	 * @param level
	 * @return
	 */
	int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
		if (set1.isEmpty())
			return 0;

		// done to minimize the complexity, idea is to traverse the level in direction first which has lesser nodes.
		if (set1.size() > set2.size())
			return helper(dict, set2, set1, level);

		// remove words from both ends
		dict.removeAll(set1);
		dict.removeAll(set2);

		// the set for next level
		Set<String> set = new HashSet<String>();

		// for each string in the current level
		for (String str : set1) {
			for (int i = 0; i < str.length(); i++) {
				char[] chars = str.toCharArray();

				// change letter at every position
				for (char ch = 'a'; ch <= 'z'; ch++) {
					chars[i] = ch;
					String word = new String(chars);

					// found the word in other end(set)
					if (set2.contains(word)) {
						return level + 1;
					}

					// if not, add to the next level
					if (dict.contains(word)) {
						set.add(word);
					}
				}
			}
		}

		return helper(dict, set2, set, level + 1);
	}

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(wl.ladderLength("hit", "cog", wordList));
	}
}