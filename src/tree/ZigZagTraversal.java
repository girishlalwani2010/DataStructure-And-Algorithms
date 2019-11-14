package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

	
	private List<Integer> zigZagTraversal(TreeNode root){
		Stack<TreeNode> currentLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		List<Integer> zigZagOrderedList = new ArrayList<Integer>();
		currentLevel.push(root);
		while(!(currentLevel.isEmpty() && nextLevel.isEmpty())){
			while(!currentLevel.isEmpty()){
				TreeNode poppedItem = currentLevel.pop();
				zigZagOrderedList.add(poppedItem.data);
				if(poppedItem.right!=null)
					nextLevel.push(poppedItem.right);
				if(poppedItem.left!=null)
					nextLevel.push(poppedItem.left);
			}
			while(!nextLevel.isEmpty()){
				TreeNode poppedItem = nextLevel.pop();
				zigZagOrderedList.add(poppedItem.data);
				if(poppedItem.left!=null)
					currentLevel.push(poppedItem.left);
				if(poppedItem.right!=null)
					currentLevel.push(poppedItem.right);
			}
		}
		return zigZagOrderedList;
	}
	
	private static void printBinaryTree(TreeNode root){
		if(root!=null){
			System.out.print(root.data+" ");
			printBinaryTree(root.left);
			printBinaryTree(root.right);
		}
	}
	
	
	public static void main(String args[]){
		ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		
		System.out.println(zigZagTraversal.zigZagTraversal(root));
		//printBinaryTree(startingNodeForZigZag);
		
	}
	
}
