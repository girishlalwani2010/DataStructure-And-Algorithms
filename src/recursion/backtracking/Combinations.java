package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	private List<List<Integer>> combinations;

	public List<List<Integer>> combine(int n, int k) {
		combinations = new ArrayList<>();
		helper(n, k, 1, new ArrayList<>());
		return combinations;
	}

	public void helper(int n, int k, int start, List<Integer> combination) {
		if (k == combination.size()) {
			combinations.add(new ArrayList<>(combination));
			return;
		}
		for (int i = start; i <= n; i++) {
			combination.add(i);
			helper(n, k, i + 1, combination);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations cmb = new Combinations();
		System.out.println(cmb.combine(4, 2));
	}

}
