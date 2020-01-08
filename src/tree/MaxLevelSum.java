package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

	private static int getMaxLevelSum(TreeNode node){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		queue.offer(null);
		int sum = 0,maxSum = 0;
		
		while(!queue.isEmpty()){
			TreeNode currentNode = queue.poll();
			
			if(currentNode == null){
				if(sum>maxSum){
					maxSum = sum;
				}
				sum = 0;
				if(!queue.isEmpty())
				queue.offer(null);
			}
			else{
			
			if(currentNode.left!=null){
				sum = sum + currentNode.left.val;
				queue.offer(currentNode.left);
			}
			
			if(currentNode.right != null){
				sum = sum + currentNode.right.val;
				queue.offer(currentNode.right);
			}
			}
			
		}
		
		return maxSum;
		
	}
	
	public static void main(String args[]){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		System.out.println(getMaxLevelSum(root));
		
	}
	
}
