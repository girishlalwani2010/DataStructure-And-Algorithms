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

public class WordLadderIIRepeat {

	private List<List<String>> result = new ArrayList<>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return new ArrayList<>();
		}
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		Map<String, List<String>> graph = new HashMap<>();
		Set<String> visited = new HashSet<>();
		boolean levelFound = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String currentWord = q.poll();
				char[] currentWordArr = currentWord.toCharArray();
				for (int j = 0; j < currentWord.length(); j++) {
					char oldChar = currentWordArr[j];
					for (int k = 'a'; k <= 'z'; k++) {
						currentWordArr[j] = (char) k;
						String transformedWord = new String(currentWordArr);
						if (wordSet.contains(transformedWord) && !currentWord.equals(transformedWord)) {
							graph.putIfAbsent(currentWord, new ArrayList<>());
							List<String> neis = graph.get(currentWord);
							neis.add(transformedWord);
							graph.put(currentWord, neis);
							if (!visited.contains(transformedWord)) {
								q.offer(transformedWord);
								visited.add(transformedWord);
							}
							if (transformedWord.equals(endWord)) {
								levelFound = true;
							}
						}
					}
					currentWordArr[j] = oldChar;
				}
			}
			if (levelFound) {
				break;
			}
		}
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		dfs(graph, beginWord, endWord, path);
		return result;
	}

	private void dfs(Map<String, List<String>> graph, String stWord, String endWord, List<String> path) {
		if (stWord.equals(endWord)) {
			result.add(new ArrayList<String>(path));
			return;
		}
		for (String nei : graph.getOrDefault(stWord, new ArrayList<>())) {
			path.add(nei);
			dfs(graph, nei, endWord, path);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		WordLadderII wordLadderII = new WordLadderII();
		System.out.println(wordLadderII.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}
}
