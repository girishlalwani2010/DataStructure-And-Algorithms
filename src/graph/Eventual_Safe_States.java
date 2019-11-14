package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Eventual_Safe_States {
	
	 public List<Integer> eventualSafeNodesWithWhiteGrayAndBlack(int[][] graph) {
	        List<Integer> res = new ArrayList<>();
	        if(graph == null || graph.length == 0)  return res;
	        
	        int nodeCount = graph.length;
	        int[] color = new int[nodeCount];
	        
	        for(int i = 0;i < nodeCount;i++){
	            if(dfs(graph, i, color))    res.add(i);
	        }
	        
	        return res;
	    }
	 //color0 = white, color2 = grey, color1 = black.
	    public boolean dfs(int[][] graph, int start, int[] color){
	        if(color[start] != 0)   return color[start] == 1;
	        
	        color[start] = 2;
	        for(int newNode : graph[start]){
	            if(!dfs(graph, newNode, color))    return false;
	        }
	        color[start] = 1;
	        
	        return true;
	    }
	
	 public static List<Integer> eventualSafeNodes(int[][] G) {
		 
		 List<List<Integer>> graph = new ArrayList<>();
		 List<List<Integer>> rGraph = new ArrayList<>();
		 for(int i=0; i<G.length; i++) {
			 graph.add(new ArrayList<Integer>());
			 rGraph.add(new ArrayList<Integer>());
		 }
		 
		 Queue<Integer> queue = new LinkedList<Integer>();
		 
		 for(int i=0; i<G.length; i++) {
			 if(G[i].length == 0){
				 queue.add(i);
			 }
			 for(int j : G[i]) {
				 //0-1-2-3
				 graph.get(i).add(j);
				 //3-2-1-0
				 rGraph.get(j).add(i);
			 }
		 }
		 
		 boolean safe[] = new boolean[G.length];
		 
		 while(!queue.isEmpty()) {
			 int i = queue.poll();
			 safe[i] = true;
			 for(int j : rGraph.get(i)) {
				 graph.get(j).remove(new Integer(i));
				 if(graph.get(j).isEmpty()) {	
					 queue.add(j);
				 }
			 }
		 }
		 
		 List<Integer> safeNodes = new ArrayList<Integer>();
		 for(int i=0; i<G.length; i++) {
			 if(safe[i]) {
				 safeNodes.add(i);
			 }
		 }
		 
		 return safeNodes;
	 }
	
	
	public static void main(String[] args) {
		int graph[][] = {{1},{2},{3},{}}; 
		System.out.println(eventualSafeNodes(graph));
	}

}
