package Trie;

public class LongestWordInDictionary {
	
	class TrieNode{
		TrieNode[] children;
		String word;
		char val;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.word = "";
		}
	}
	
	public void insert(String[] words) {
		for(String word : words) {
			TrieNode curr = root;
			for(char c : word.toCharArray()) {
				if(curr.children[c-'a'] == null) {
					curr.children[c-'a'] = new TrieNode();
					curr.val = c;
				}
				curr = curr.children[c-'a'];
			}
			curr.word = word;
		}
	}
	
	TrieNode root;
	public String longestWord(String[] words) {
		if(words == null || words.length == 0) return "";
		root = new TrieNode();
		insert(words);
		return dfs(root);
	}
	
	/**
	 * @param node
	 * @return
	 * Looks like chain pattern moving answer i.e. result upwards
	 */
	public String dfs(TrieNode node) {
		String res = node.word;
		for(TrieNode child : node.children) {
			if(child!=null && child.word.length()!=0) {
				String childWord = dfs(child);
				if(childWord.length()>res.length() || (childWord.length()==res.length() && childWord.compareTo(res)<0)) {
					res = childWord;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
		String[] words = {"w","wo","wor","worl", "world"};
		longestWordInDictionary.longestWord(words);
	}

}
