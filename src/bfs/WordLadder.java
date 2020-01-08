package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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