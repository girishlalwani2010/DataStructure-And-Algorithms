package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

	List<Integer> topologicalOrder = new LinkedList<>();

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Set<Integer> setOfCourses = new HashSet<>();

		for (int i = 0; i < numCourses; i++) {
			setOfCourses.add(i);
		}

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[0]).add(prerequisite[1]);
			if (setOfCourses.contains(prerequisite[0])) {
				setOfCourses.remove(prerequisite[0]);
			}
			if (setOfCourses.contains(prerequisite[1])) {
				setOfCourses.remove(prerequisite[1]);
			}
		}
		Set<Integer> visited = new HashSet<>();
		Set<Integer> recStack = new HashSet<>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (!visited.contains(prerequisites[i][0])) {
				if (!dfs(prerequisites[i][0], graph, visited, recStack)) {
					return new int[0];
				}
			}
		}

		if (topologicalOrder.size() != numCourses) {
			for (int i : setOfCourses) {
				topologicalOrder.add(i);
			}
		}

		int[] topologicalOrderArr = topologicalOrder.stream().mapToInt(Integer::intValue).toArray();

		return topologicalOrderArr;
	}

	public boolean dfs(int source, List<List<Integer>> graph, Set<Integer> visited, Set<Integer> recStack) {
		visited.add(source);
		recStack.add(source);
		for (int nei : graph.get(source)) {
			if (!visited.contains(nei)) {
				if (!dfs(nei, graph, visited, recStack)) {
					return false;
				}
			} else if (recStack.contains(nei)) {
				return false;
			}
		}
		recStack.remove(source);
		topologicalOrder.add(source);
		return true;
	}
}