package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> setOfCourses = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			setOfCourses.add(i);
		}
        
		Map<Integer, List<Integer>> graph = new HashMap<>();
        
		for (int[] prerequisite : prerequisites) {
			List<Integer> currentVertexAdjLst = graph.getOrDefault(prerequisite[0], new ArrayList<>());
            currentVertexAdjLst.add(prerequisite[1]);
            graph.put(prerequisite[0], currentVertexAdjLst);
			if (setOfCourses.contains(prerequisite[0])) {
				setOfCourses.remove(prerequisite[0]);
			}
			if (setOfCourses.contains(prerequisite[1])) {
				setOfCourses.remove(prerequisite[1]);
			}
		}
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        List<Integer> topologicalOrder = new ArrayList<>();
        for(int[] prerequisite : prerequisites){
            if(!visited[prerequisite[0]]){
                if(!dfs(graph, prerequisite[0], visited, recStack, topologicalOrder)){
                    return new int[0];
                }
            }
        }
        
        if(topologicalOrder.size() != numCourses){
            for(int i : setOfCourses){
                topologicalOrder.add(i);
            }
        }
        
        int[] topologicalArr = topologicalOrder.stream().mapToInt(Integer::intValue).toArray();
        return topologicalArr;
    }

	 private boolean dfs(Map<Integer, List<Integer>> graph, int source, boolean[] visited, boolean[] recStack, List<Integer> topologicalOrder){
	        visited[source] = true;
	        recStack[source] = true;
	        for(int nei : graph.getOrDefault(source, new ArrayList<>())){
	            if(!visited[nei]){
	                if(!dfs(graph, nei, visited, recStack, topologicalOrder)){
	                    return false;
	                }
	            }else if(recStack[nei]){
	                return false;
	            }
	        }
	        recStack[source] = false;
	        topologicalOrder.add(source);
	        return true;
	    }
	 
	 // using color method, one int[] for both recStack and visited 
	 //initialize color array with int[] color = new int[numCourses];
	 // submitted code on leetcode.
	  private boolean dfs(Map<Integer, List<Integer>> graph, int source, int[] color, List<Integer> topologicalOrder){
	        color[source] = 1;
	        color[source] = 2;
	        for(int nei : graph.getOrDefault(source, new ArrayList<>())){
	            if(color[nei] == 0){
	                if(!dfs(graph, nei, color, topologicalOrder)){
	                    return false;
	                }
	            }else if(color[nei] == 2){
	                return false;
	            }
	        }
	        color[source] = 1;
	        topologicalOrder.add(source);
	        return true;
	    }
	 
}