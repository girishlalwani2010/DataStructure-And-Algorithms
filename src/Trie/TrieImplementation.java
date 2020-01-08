package Trie;

/**
 * @author girish_lalwani
 *
 *         https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 *         Prefix Tree
 */

class TrieNode {
	// R links to node children
	public TrieNode[] children;

	private final int R = 26;

	public boolean isWord;

	public TrieNode() {
		children = new TrieNode[R];
	}

}

public class TrieImplementation {

	private TrieNode root;

	public TrieImplementation() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (p.children[c - 'a'] == null) {
				p.children[c - 'a'] = new TrieNode();
			}
			p = p.children[c - 'a'];
		}
		p.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (p.children[c - 'a'] == null) {
				return false;
			}
			p = p.children[c - 'a'];
		}
		return p.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode p = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (p.children[c - 'a'] == null) {
				return false;
			}
			p = p.children[c - 'a'];
		}
		return true;
	}

	public boolean hasNoChildrens(TrieNode node) {
		for (TrieNode childNode : node.children) {
			if (childNode != null) {
				return false;
			}
		}
		return true;
	}

	private int wordLength;

	/**
	 * @param word
	 * @param currentNode
	 * @param level
	 * @return
	 * 
	 * First have to check word exist then will delete it, so first need to call search.
	 * 
	 * Delete Logic https://www.youtube.com/watch?v=_rjW8w89ju8&t=1796s
	 * 
	 * 
	 * Iterative Logic
	 *0). Create TrieNode with Occurences/in-place of isWord flag, 
	 *	  that represent how many times a word is occurred as there can be duplicate word exist in TRIE 
	 *1). Decrement its occurence i.e. of node which is return from search function.
	 *2). Delete the node if it has no children/ and its occurence is 0.	
	 *3). Move to the parent pointer and repeat. 
	 *Iterative Implementation:https://leetcode.com/problems/implement-trie-prefix-tree/discuss/156159/Java-solution-with-delete()-method 
	 */
	public TrieNode delete(String word, TrieNode currentNode, int level) {
		if (level == wordLength) {
			currentNode.isWord = false;// mark it as non-word in trie
			if (hasNoChildrens(currentNode)) { // check if other word is there that can be formed using this word as
												// prefix, if not mark it null
				currentNode = null;
			}
			return currentNode;
		}
		int index = word.charAt(level) - 'a';
		currentNode.children[index] = delete(word, currentNode.children[index], level + 1);
		if (hasNoChildrens(currentNode) && !currentNode.isWord) {
			currentNode = null;
		}
		return currentNode;
	}

	public void delete(String word) {
		wordLength = word.length();
		delete(word, root, 0);
	}

	public static void main(String[] args) {

	}
}
