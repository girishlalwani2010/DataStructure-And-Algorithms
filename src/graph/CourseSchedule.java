package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		Set<Integer> visited = new HashSet<>();
		Set<Integer> recStack = new HashSet<>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (!dfs(prerequisites[i][0], graph, visited, recStack)) {
				return false;
			}
		}
		return true;
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
		return true;
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(numCourses, prerequisites));
	}

}
