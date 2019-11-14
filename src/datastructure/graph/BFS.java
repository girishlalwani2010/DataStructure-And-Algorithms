package datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class BFS {
	
	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Set<Integer> visited = new HashSet<Integer>();
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			System.out.println(currentNode.val);
			for(Node neighbor : currentNode.neighbors) {
				if(!visited.contains(neighbor.val) && !queue.contains(neighbor)) {
					queue.add(neighbor);
				}
			}
			visited.add(currentNode.val);
		}
	}
	
	public static void main(String args[]) {
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
		
		bfs(node1);
		
		
	}

}
