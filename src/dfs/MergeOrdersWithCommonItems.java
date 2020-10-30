package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergeOrdersWithCommonItems {

	private static void dfs(String source, Map<String, Set<String>> graph, Set<String> visited, Set<String> mergeSet) {
		visited.add(source);
		mergeSet.add(source);
		for (String nei : graph.getOrDefault(source, new HashSet<>())) {
			if (!visited.contains(nei)) {
				dfs(nei, graph, visited, mergeSet);
			}
		}
	}

	public static void main(String[] args) {
//		List<List<String>> orders = Arrays.asList(Arrays.asList("i1","i2"),Arrays.asList("i3","i4"),Arrays.asList("i1","i3","i5"),Arrays.asList("i6","i7"));
		List<List<String>> orders = Arrays.asList(Arrays.asList("z", "x", "y"), Arrays.asList("y", "g", "e"),
				Arrays.asList("z"), Arrays.asList("x", "p"), Arrays.asList("a", "b"), Arrays.asList("a", "y"), Arrays.asList("d", "g"));
		Set<String> visited = new HashSet<>();
		Map<String, Set<String>> graph = new HashMap<>();
		for (List<String> items : orders) {
			for (String item : items) {
				graph.computeIfAbsent(item, x -> new HashSet<>()).addAll(items);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (String source : graph.keySet()) {
			if (!visited.contains(source)) {
				Set<String> connectedItems = new HashSet<>();
				dfs(source, graph, visited, connectedItems);
				List<String> connectedItemsList = new ArrayList<>(connectedItems);
				Collections.sort(connectedItemsList);
				result.add(connectedItemsList);
			}
		}

		System.out.println(result);
	}

}
