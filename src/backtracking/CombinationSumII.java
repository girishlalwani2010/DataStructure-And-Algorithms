package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	List<List<Integer>> result = null;
	boolean[] used;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		result = new ArrayList<>();
		Arrays.sort(candidates);
		int sum = 0;
		used = new boolean[candidates.length];
		combinationSum2(candidates, target, sum, new ArrayList<>(), 0);
		return result;
	}

	public void combinationSum2(int[] candidates, int target, int sum, List<Integer> currList, int start) {

		if (sum == target) {
			result.add(new ArrayList<>(currList));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			// choose
			// explore
			// unchoose
			if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
				continue;
			}
			sum = sum + candidates[i];
			if (sum > target) {
				return;
			}
			currList.add(candidates[i]);
			used[i] = true;
			combinationSum2(candidates, target, sum, currList, i + 1);
			sum = sum - candidates[i];
			currList.remove(currList.size() - 1);
			used[i] = false;

		}

	}
}