package Trie;

public class TrieImplementationII {

	// Alphabet size (# of symbols)
	static final int ALPHABET_SIZE = 26;

	// trie node
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;

		// for debugging
		char val;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};

	static TrieNode root;

	// If not present, inserts key into trie
	// If the key is prefix of trie node,
	// just marks leaf node
	static void insert(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode p = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (p.children[index] == null) {
				p.children[index] = new TrieNode();
				p.children[index].val = key.charAt(level);
			}
			p = p.children[index];
		}

		// mark last node as leaf
		p.isEndOfWord = true;
	}

	// Returns true if key presents in trie, else false
	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode p = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (p.children[index] == null)
				return false;

			p = p.children[index];
		}

		return (p != null && p.isEndOfWord);
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

	public TrieNode delete(String word, TrieNode currentNode, int level) {
		if (level == wordLength) {
			currentNode.isEndOfWord = false;// mark it as non-word in trie
			if (hasNoChildrens(currentNode)) { // check if other word is there that can be formed using this word as
												// prefix, if not mark it null
				currentNode = null;
			}
			return currentNode;
		}
		int index = word.charAt(level) - 'a';
		// this line is very imp. from i to r mark r as null then set r's i memory as
		// null, it means r's children TrieNode at i
		currentNode.children[index] = delete(word, currentNode.children[index], level + 1);
		if (hasNoChildrens(currentNode) && !currentNode.isEndOfWord) {
			currentNode = null;
		}
		return currentNode;
	}

	public void delete(String word) {
		wordLength = word.length();
		delete(word, root, 0);
	}

	// can be modified to print all the strings starting with certain prefix
	public static void printWordsInTrie(TrieNode node, StringBuilder sb) {

		if (node == null) {
			return;
		}

		if (node.isEndOfWord) {
			// if need to return list as a output then need to store clone object of stringbuilder, so running stringbuilder will not modify the stored result.
			System.out.println(sb.toString());
		}
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (node.children[i] != null) {
				sb.append(node.children[i].val);
				printWordsInTrie(node.children[i],sb);
				// backtracking
				sb.setLength(sb.length()-1);
			}
		}
	}

	// Driver
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", 
                "any", "by", "bye", "their" }; ; 

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

		System.out.println("----- Printing all words in Trie ----");
		printWordsInTrie(root, new StringBuilder());

		// Search for different keys
		if (search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		TrieImplementationII trieImplementationII = new TrieImplementationII();

		trieImplementationII.delete("their");

		if (search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

	}
}
