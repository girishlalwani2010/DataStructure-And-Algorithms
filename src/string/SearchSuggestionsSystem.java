package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author girish_lalwani
 *         https://leetcode.com/problems/search-suggestions-system/discuss/436151/JavaPython-3-Simple-Trie-and-Binary-Search-codes-w-comment-and-brief-analysis.
 */

class TrieNode {
	public TrieNode[] childrens;
	private final int R = 26;
	public List<String> suggestions;

	public TrieNode() {
		this.childrens = new TrieNode[R];
		this.suggestions = new ArrayList<>();
	}
}

public class SearchSuggestionsSystem {

	/**
	 * @param products
	 * @param searchWord
	 * @return Sorting and searching cost O(n * m * log n) and O(L * m * logn),
	 *         respectively; Therefore, Time: O((n + L) * m * logn), space: O(L * m)
	 *         - - including return list ans, but excluding space cost of sorting,
	 *         where m = average length of products, n = products.length, L =
	 *         searchWord.length().
	 */
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> result = new ArrayList<>();
		Arrays.sort(products);
		for (int i = 1; i <= searchWord.length(); i++) {
			String prefix = searchWord.substring(0, i);
			int k = Arrays.binarySearch(products, prefix);
			while (k > 0 && products[k - 1].equals(prefix)) {
				k--;
			}
			if (k < 0) {
				k = -(k + 1);
			}
			List<String> suggestions = new ArrayList<>();
			for (int j = k; j < k + 3 && j < products.length && products[j].startsWith(prefix); j++) {
				suggestions.add(products[j]);
			}
			result.add(suggestions);
		}
		return result;
	}

	public List<List<String>> suggestedProductsBetterWay(String[] products, String searchWord) {
		TrieNode root = new TrieNode();
		Arrays.sort(products);
		for (String product : products) {
			TrieNode t = root;
			for (char c : product.toCharArray()) {
				if (t.childrens[c - 'a'] == null) {
					t.childrens[c - 'a'] = new TrieNode();
				}
				t = t.childrens[c - 'a'];
				if (t.suggestions.size() < 3) {
					t.suggestions.add(product);
				}
			}
		}

		TrieNode t = root;
		List<List<String>> result = new ArrayList<>();
		for (char c : searchWord.toCharArray()) {
			if (t != null) {
				t = t.childrens[c - 'a'];
			}
			if (t == null) {
				result.add(new ArrayList<>());
			} else {
				result.add(t.suggestions);
			}
		}
		return result;

	}

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "mouse", "moneypot", "monitor", "mousepad" };
		SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
		searchSuggestionsSystem.suggestedProductsBetterWay(products, "mouse");
	}
}
