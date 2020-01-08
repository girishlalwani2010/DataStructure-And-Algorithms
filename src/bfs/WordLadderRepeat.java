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

public class WordLadderRepeat {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Map<String, List<String>> graph = new HashMap<>();

		graph.put(beginWord, new ArrayList<>());

		for (String str : wordList) {
			if (charDiff(str, beginWord) == 1) {
				List<String> transformations = graph.get(beginWord);
				transformations.add(str);
				graph.put(beginWord, transformations);
			}
		}

		for (String str1 : wordList) {
			for (String str2 : wordList) {
				if (charDiff(str1, str2) == 1) {
					graph.putIfAbsent(str1, new ArrayList<>());
					List<String> transformations = graph.get(str1);
					transformations.add(str2);
					graph.put(str1, transformations);
					graph.putIfAbsent(str2, new ArrayList<>());
					transformations = graph.get(str2);
					transformations.add(str1);
					graph.put(str2, transformations);
				}
			}
		}

		return transform(graph, beginWord, endWord);

	}

	public int transform(Map<String, List<String>> graph, String beginWord, String endWord) {
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				if (word.equals(endWord)) {
					return level;
				}
				for (String nei : graph.get(word)) {
					if (!visited.contains(nei)) {
						q.add(nei);
						visited.add(nei);
					}

				}
			}
			level++;
		}
		return 0;
	}

	int charDiff(String str1, String str2) {
		int i = 0, j = 0;
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();

		if (str1Arr.length == 1 && str2Arr.length == 0) {
			return 1;
		}
		int charDiff = 0;
		while (i < str1Arr.length || j < str2Arr.length) {
			if (str1Arr[i] != str2Arr[j]) {
				charDiff++;
			}
			i++;
			j++;
		}
		return charDiff;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		WordLadderRepeat wordLadderRepeat = new WordLadderRepeat();
		System.out.println(wordLadderRepeat.ladderLength(beginWord, endWord, wordList));
	}

}
