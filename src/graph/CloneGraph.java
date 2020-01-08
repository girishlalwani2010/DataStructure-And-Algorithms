package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author girish_lalwani
 *Need to look clone tree and linked list plain and with random pointers.
 */
public class CloneGraph {
	 Map<Node,Node> nodeToCloneNode = new HashMap<Node,Node>(); 
	    
	 public Node cloneGraph(Node node) {
	        Set<Node> visited = new HashSet<Node>();
	        Node cloneNode = new Node(node.val, new ArrayList<Node>());
	        nodeToCloneNode.put(node,cloneNode);
	        dfs(node, visited);
	        return cloneNode;
		}
	    
	      
	    public void dfs(Node node, Set<Node> visited){
	        visited.add(node);
	        for(Node nei : node.neighbors){
	            if(!visited.contains(nei)){
	               nodeToCloneNode.put(nei,new Node(nei.val, new ArrayList<Node>()));
	               dfs(nei,visited); 
	            }
	            if(nodeToCloneNode.containsKey(nei)){
	               Node cloneNode = nodeToCloneNode.get(node);
	               Node cloneNodeNei = nodeToCloneNode.get(nei);
	               cloneNode.neighbors.add(cloneNodeNei);
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	    	Node node1 = new Node(1,new ArrayList<Node>());
			Node node2 = new Node(2, new ArrayList<Node>());
			Node node3 = new Node(3, new ArrayList<Node>());
			Node node4 = new Node(4, new ArrayList<Node>());
			
			node1.neighbors.add(node2);
			node1.neighbors.add(node4);
			node2.neighbors.add(node1);
			node2.neighbors.add(node3);
			node3.neighbors.add(node2);
			node3.neighbors.add(node4);
			node4.neighbors.add(node1);
			node4.neighbors.add(node3);
			
			CloneGraph cloneGraph = new CloneGraph();
			Node clone = cloneGraph.cloneGraph(node1);
			
			System.out.println("Recursive DFS Node:");
			DFS.recursiveDFS(node1);
			System.out.println("Recursive DFS Clone Node:");
			DFS.recursiveDFS(clone);
			
		}
	    
}
