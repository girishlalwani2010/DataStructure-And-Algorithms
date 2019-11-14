package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import datastructure.array.FindZerosPosition;

public class OddEvenLevelDifference {

	private int findDifferenceInOddAndEvenLevelSum(TreeNode root){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		int oddSum = 0, evenSum = 0;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node==null){
				if(!queue.isEmpty()){
					level++;
					queue.add(null);
				}
			}
			else{
				if(level%2 == 1){
					oddSum = oddSum + node.data;
				}
				else{
					evenSum = evenSum + node.data;
				}
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
		}
		
		return oddSum - evenSum;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(22);
		OddEvenLevelDifference oddEvenLevelDifference = new OddEvenLevelDifference();
		System.out.println(oddEvenLevelDifference.findDifferenceInOddAndEvenLevelSum(root));
		
	}
	
}
