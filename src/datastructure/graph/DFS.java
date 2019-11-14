package datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DFS {
	
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
	
	
	//Reverse order dfs https://algs4.cs.princeton.edu/41graph/NonrecursiveDFS.java.html
	private static void reverseOrderDFS(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(node.val);
		while(!stack.isEmpty()) {
			Node currentNode = stack.peek();
			for(Node neighbour : currentNode.neighbors){
				if(!visited.contains(neighbour.val)) {
					stack.push(neighbour);
					visited.add(neighbour.val);
				}
			}
			System.out.println(stack.pop().val);
		}
	}
	
	
	
	
	private static void dfs(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(node.val);
		while(!stack.isEmpty()) {
			Node currentNode = stack.pop();
			System.out.println(currentNode.val);
			for(Node neighbour : currentNode.neighbors){
				if(!visited.contains(neighbour.val)) {
					stack.push(neighbour);
					visited.add(neighbour.val);
				}
			}
		}
	}
	
	
	
	/**
	 * @param node
	 * 
	 * Look at BFS https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
	 * Before adding to queue mark node as visited
	 */
	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(node.val);
		while(!queue.isEmpty()) {
			Node currNode = queue.poll();
			System.out.println(currNode.val);
			for(Node neighbour : currNode.neighbors){
				if(!visited.contains(neighbour.val)) {
					queue.add(neighbour);
					visited.add(neighbour.val);
				}
			}
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
		
//		1--2
//		|  |
//		4--3 
//		
		//recursiveDFS(node1);
		System.out.println("DFS : ");
		reverseOrderDFS(node1);
		System.out.println("BFS : ");
		bfs(node1);
	}


}
