package datastructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {

	private Stack<Character> stack = new Stack<>();
	Set<Character> charNotExistInGraph = new HashSet<Character>();
	
	public String alienOrder(String[] words) {
		
		Map<Character, Set<Character>> graph = new LinkedHashMap<>();
		getCharSet(words);
		for(int i=0; i<words.length-1; i++) {
			int j=0, k=0;
			String firstWord = words[i];
			String secondWord = words[i+1];
			while(j<firstWord.length() && k<secondWord.length()) {
				if(firstWord.charAt(j) != secondWord.charAt(k)) {
					graph.computeIfAbsent(firstWord.charAt(j), t -> new HashSet<>()).add(secondWord.charAt(k));
					charNotExistInGraph.remove(firstWord.charAt(j));
					charNotExistInGraph.remove(secondWord.charAt(j));
					break;
				}
				j++;
				k++;
			}
		}
		
		return topologicalSort(graph);
	}
	
	private Set<Character> getCharSet(String[] words) {
		for (String word : words) {
			for (char c : word.toCharArray()) {
				charNotExistInGraph.add(c);
			}
		}
		return charNotExistInGraph;
	}
	
	public boolean dfs(char letter, Map<Character, Set<Character>> graph, Set<Character> visited, Set<Character> recStack) {
		visited.add(letter);
		recStack.add(letter);
		for(char nei : graph.getOrDefault(letter,Collections.emptySet())) {
			if (nei == letter) continue;
			if(!visited.contains(nei) && !dfs(nei, graph, visited, recStack)) {
				return false;
			}
			else if(recStack.contains(nei)) {
				return false;
			}
		}
		recStack.remove(letter);
		stack.push(letter);
		return true;
	}
	
	public String topologicalSort(Map<Character, Set<Character>> graph) {
		Set<Character> visited = new HashSet<>();
		Set<Character> recStack = new HashSet<>();
		for(Character character: graph.keySet()) {
			if(!visited.contains(character)) {
				if(!dfs(character, graph, visited, recStack)) {
					return "";
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Character c : charNotExistInGraph) {
			sb.append(c);
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = {"zy", "zx"};
		AlienDictionary alienDictionary = new AlienDictionary();
		System.out.println(alienDictionary.alienOrder(words));
	}

}
