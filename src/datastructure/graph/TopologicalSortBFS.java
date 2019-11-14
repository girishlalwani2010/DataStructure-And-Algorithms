//package datastructure.graph;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class TopologicalSortBFS {
//	/**
//	 * Definition for Directed graph.
//	 * class DirectedGraphNode {
//	 *     int label;
//	 *     ArrayList<DirectedGraphNode> neighbors;
//	 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
//	 * };
//	 */
//	    /**
//	     * @param graph: A list of Directed graph node
//	     * @return: Any topological order for the given graph.
//	     */    
//	    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
//	        // write your code here
//	        if (graph == null || graph.size() == 0) {
//	            return graph;
//	        }
//	        
//	        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
//	        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
//	        
//	        //calculate indegree of all the nodes
//	        for (DirectedGraphNode node : graph) {
//	            for (DirectedGraphNode neighbor : node.neighbors) {
//	                if (map.containsKey(neighbor)) {
//	                    map.put(neighbor, map.get(neighbor) + 1);
//	                } else {
//	                    map.put(neighbor, 1);
//	                }
//	            }
//	        }
//	        
//	        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
//	        
//	        //get the node with 0 indegree
//	        for (DirectedGraphNode node : graph) {
//	            if (!map.containsKey(node)) {
//	                queue.offer(node);
//	                result.add(node);
//	            }
//	        }
//	        
//	        //BFS to other nodes
//	        while (!queue.isEmpty()) {
//	            DirectedGraphNode node = queue.poll();
//	            for (DirectedGraphNode neighbor : node.neighbors) {
//	                map.put(neighbor, map.get(neighbor) - 1);
//	                if (map.get(neighbor) == 0) {
//	                    queue.offer(neighbor);
//	                    result.add(neighbor);
//	                } 
//	            }
//	        }
//	        
//	        return result;
//	    }
//	    
//	}
//}
