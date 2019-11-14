package datastructure.graph;

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

	private Map<Node, Node> visited = new HashMap<Node, Node>();
	
	public Node cloneGraph(Node node) {
		
		if(node == null) {
			return node;
		}
		
		if(visited.containsKey(node)) {
			return visited.get(node);
		}
		
		Node cloneNode = new Node(node.val, new ArrayList<>());
		visited.put(node, cloneNode);
		
		for(Node nei:node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(nei));
		}
		
		return cloneNode;
	}
	
	private static void recursiveDFS(Node node, Set<Integer> visited) {
		System.out.println(node.val);
		for(Node neighbour : node.neighbors) {
			if(!visited.contains(neighbour.val)) {
				visited.add(neighbour.val);
				recursiveDFS(neighbour, visited);
			}
		}
	}
	
	private static void recursiveDFS(Node node) {
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(node.val);
		recursiveDFS(node,visited);
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1, new ArrayList<>());
		Node node2 = new Node(2, new ArrayList<>());
		Node node3 = new Node(3, new ArrayList<>());
		Node node4 = new Node(4, new ArrayList<>());
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		
		CloneGraph cg = new CloneGraph();
		
		recursiveDFS(cg.cloneGraph(node1));
		
		
		

	}

}
