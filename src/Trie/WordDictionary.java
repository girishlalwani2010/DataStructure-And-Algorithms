package Trie;

/**
 * @author girish_lalwani
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */

public class WordDictionary {
	
	class TrieNode{
		TrieNode[] children;
		boolean isWord;
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}
	
	private TrieNode root;
	
	public WordDictionary() {
		root = new TrieNode();
	}
	
	private void buildTrie(String word) {
		TrieNode cur = root;
		char[] wordArray = word.toCharArray();
		for(char c : wordArray) {
			int index = c - 'a';
			if(cur.children[index] == null) {
				cur.children[index] = new TrieNode();
			}
			cur = cur.children[index];
		}
		cur.isWord = true;
	}
	
	public void addWord(String word) {
		buildTrie(word);
	}
	
	public boolean search(String word) {
		return find(word, 0, root);
	}
	
	private boolean find(String word, int index, TrieNode cur) {
		if(index == word.length()) {
			return cur.isWord;
		}
		char c = word.charAt(index);
		if(c == '.') {
			for(int i=0; i<26; i++) {
				if(cur.children[i]!=null) {
					if(find(word, index+1, cur.children[i]))
						return true;
				}
			}
			return false;
		}else {
			return cur.children[c-'a'] != null  && find(word, index+1, cur.children[c-'a']);
		}
	}
	
}
