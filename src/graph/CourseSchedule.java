package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<>();
            
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private static boolean dfs(List<Integer>[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }
    
    public static void main(String[] args) {
    	int numCourses = 2;
    	int[][] prerequisites = {{1,0},{0,1}};
		System.out.println(canFinish(numCourses, prerequisites));
	}

}
