package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class AutocompleteSystem {

	class TrieNode {
		String sentence;
		int times;
		TrieNode[] children;
		PriorityQueue<TrieNode> hot;

		public TrieNode() {
			children = new TrieNode[27];
			sentence = null;
			times = 0;
			hot = new PriorityQueue<>(new Comparator<TrieNode>() {
				public int compare(TrieNode a, TrieNode b) {
					if (a.times == b.times) {
						return b.sentence.compareTo(a.sentence);
					}
					return a.times - b.times;
				}
			});
		}

		public void update(TrieNode node) {
			if (this.hot.size() >= 3) {
				int existingNodeTimes = this.hot.peek().times;
				int currentNodeTimes = node.times;
				if (existingNodeTimes < currentNodeTimes || ((existingNodeTimes == currentNodeTimes) && (node.sentence.compareTo(this.hot.peek().sentence) <= 0))) {
					this.hot.poll();
					this.hot.add(node);
				}
			}
			if (this.hot.size() < 3) {
				if (!this.hot.contains(node)) {
					this.hot.add(node);
				}
			}
		}
	}

	TrieNode root;
	StringBuilder sb;
	TrieNode curr;

	public AutocompleteSystem(String[] sentence, int[] times) {
		sb = new StringBuilder();
		root = new TrieNode();
		curr = root;
		for (int i = 0; i < sentence.length; i++) {
			add(sentence[i], times[i]);
		}
	}

	public void add(String sentence, int times) {
		TrieNode temp = root;
		List<TrieNode> visited = new ArrayList<>(); // in the end to put hot in this whole list
		for (char c : sentence.toCharArray()) {
			int idx = (c == ' ' ? 26 : c - 'a');
			if (temp.children[idx] == null) {
				temp.children[idx] = new TrieNode();
			}
			temp = temp.children[idx];
			visited.add(temp);
		}
		temp.sentence = sentence;
		temp.times = temp.times + times;

		for (TrieNode node : visited) {
			node.update(temp); // put curr in hot list of node
		}

	}

	public List<String> input(char c) {
		List<String> res = new LinkedList<>();
		if (c == '#') {
			add(sb.toString(), 1);
			sb = new StringBuilder();
			curr = root;
			return res;
		}
		sb.append(c);
		int idx = (c == ' ' ? 26 : c - 'a');
		if (curr != null) {
			curr = curr.children[idx];
		}
		if (curr == null)
			return res;
		PriorityQueue<TrieNode> tempQueue = new PriorityQueue<>(curr.hot);
		while(!curr.hot.isEmpty()) {
			res.add(0, curr.hot.poll().sentence);
		}
		curr.hot = tempQueue;
		return res;
	}

	public static void main(String[] args) {

		String[] sentence = {"i love you","island","iroman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentence, times);
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			char input = scan.nextLine().charAt(0);
			List<String> suggestions = autocompleteSystem.input(input);
			System.out.println("Suggestions: "+suggestions);
		}
		//[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]

	}

}
