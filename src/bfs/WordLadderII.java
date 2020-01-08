package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {

	// Slow Solution: one directional bfs
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord))
			return res;
		Map<String, List<String>> map = new HashMap<>();
		Set<String> startSet = new HashSet<>();
		startSet.add(beginWord);
		bfs(startSet, endWord, map, dict);

		List<String> list = new ArrayList<>();
		list.add(beginWord);
		dfs(res, list, beginWord, endWord, map);
		return res;
	}

	/**
	 * @param res
	 * @param list
	 * @param word
	 * @param endWord
	 * @param map
	 * 
	 * Very important pattern of backtracing
	 */
	private void dfs(List<List<String>> res, List<String> list, String word, String endWord,
			Map<String, List<String>> map) {
		if (word.equals(endWord)) {
			res.add(new ArrayList(list));
			return;
		}

		if (map.get(word) == null)
			return;
		for (String next : map.get(word)) {
			list.add(next);
			dfs(res, list, next, endWord, map);
			list.remove(list.size() - 1);
		}

	}

	private void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> dict) {
		if (startSet.size() == 0)
			return;

		Set<String> tmp = new HashSet<>();
		dict.removeAll(startSet);
		boolean finish = false;

		for (String s : startSet) {
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				char old = chs[i];
				for (char c = 'a'; c <= 'z'; c++) {
					chs[i] = c;
					String word = new String(chs);

					if (dict.contains(word)) {
						if (word.equals(endWord)) {
							finish = true;
						} else {
							tmp.add(word);
						}

						if (map.get(s) == null) {
							map.put(s, new ArrayList<>());
						}

						map.get(s).add(word);
					}
				}

				chs[i] = old;
			}
		}

		if (!finish) {
			bfs(tmp, endWord, map, dict);
		}
	}

	// bi-directional bfs
	public List<List<String>> findLaddersUsingBidirectionalBFS(String beginWord, String endWord,
			List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord))
			return res;
		Map<String, List<String>> map = new HashMap<>();
		Set<String> startSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		endSet.add(endWord);
		startSet.add(beginWord);

		bfs(startSet, endSet, map, dict, false);

		List<String> list = new ArrayList<>();
		list.add(beginWord);
		dfs(res, list, beginWord, endWord, map);
		return res;
	}

	private void bfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> map, Set<String> dict,
			boolean reverse) {
		if (startSet.size() == 0)
			return;

		if (startSet.size() > endSet.size()) {
			bfs(endSet, startSet, map, dict, !reverse);
			return;
		}

		Set<String> tmp = new HashSet<>();
		dict.removeAll(startSet);
		boolean finish = false;

		for (String s : startSet) {
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				char old = chs[i];
				for (char c = 'a'; c <= 'z'; c++) {
					chs[i] = c;
					String word = new String(chs);

					if (dict.contains(word)) {
						if (endSet.contains(word)) {
							finish = true;
						} else {
							tmp.add(word);
						}

						String key = reverse ? word : s;
						String val = reverse ? s : word;

						if (map.get(key) == null) {
							map.put(key, new ArrayList<>());
						}

						map.get(key).add(val);
					}
				}

				chs[i] = old;
			}
		}

		if (!finish) {
			bfs(tmp, endSet, map, dict, reverse);
		}
	}
}
