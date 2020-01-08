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
				zigZagOrderedList.add(poppedItem.val);
				if(poppedItem.right!=null)
					nextLevel.push(poppedItem.right);
				if(poppedItem.left!=null)
					nextLevel.push(poppedItem.left);
			}
			while(!nextLevel.isEmpty()){
				TreeNode poppedItem = nextLevel.pop();
				zigZagOrderedList.add(poppedItem.val);
				if(poppedItem.left!=null)
					currentLevel.push(poppedItem.left);
				if(poppedItem.right!=null)
					currentLevel.push(poppedItem.right);
			}
		}
		return zigZagOrderedList;
	}
	
	 /**
	 * @param root
	 * @return
	 * 
	 * Using BFS as stated in question https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        if(root == null){
	            return new ArrayList<>();
	        }
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        boolean needToBeReversed = false;
	        List<List<Integer>> result = new ArrayList<>();
	        while(!q.isEmpty()){
	            int size = q.size();
	            List<Integer> levelResult = new ArrayList<Integer>();
	            for(int i=0; i<size; i++){
	                TreeNode node = q.poll();
	                if(!needToBeReversed){
	                    levelResult.add(node.val);
	                }else{
	                    levelResult.add(0,node.val);
	                }
	                if(node.left!=null){
	                    q.add(node.left);
	                }if(node.right!=null){
	                    q.add(node.right);
	                }
	            }
	            result.add(levelResult);
	            needToBeReversed = !needToBeReversed;
	        }
	     return result;  
	    }
	
	private static void printBinaryTree(TreeNode root){
		if(root!=null){
			System.out.print(root.val+" ");
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
