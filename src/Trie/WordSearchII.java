package Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	private int[][] positions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	class TrieNode {
		TrieNode[] children;
		String word;

		public TrieNode() {
			this.children = new TrieNode[26];
			this.word = null;
		}
	}

	public void buildTrie(String[] words, TrieNode root) {
		for (String word : words) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				int idx = c - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode();
				}
				curr = curr.children[idx];
			}
			curr.word = word;
		}

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();

		if (board.length == 0 || board == null) {
			return res;
		}

		TrieNode root = new TrieNode();
		buildTrie(words, root);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char c = board[i][j];
				if (root.children[c - 'a'] != null) {
					dfs(board, i, j, root, res);
				}
			}
		}

		return res;
	}

	private void dfs(char[][] board, int i, int j, TrieNode curr, List<String> res) {

		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
			return;
		}

		if (board[i][j] == '#') {
			return;
		}

		char temp = board[i][j];

		curr = curr.children[temp - 'a'];

		if (curr == null) {
			return;
		}
		if (curr.word != null) {
			res.add(curr.word);
			curr.word = null; // to avoid duplicate searching of word stored in Trie.
		}

		board[i][j] = '#';
		for (int[] position : positions) {
			dfs(board,i+position[0],j+position[1], curr, res);
		}
		board[i][j] = temp;
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = {"oath","pea","eat","rain"};
		WordSearchII ws = new WordSearchII();
		System.out.println(ws.findWords(board, words));
	}

}
