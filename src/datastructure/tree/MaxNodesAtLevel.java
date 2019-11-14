package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNodesAtLevel {
	
	private int maxWidth(TreeNode root){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		int maxWidth = 0,currentWidth=0;
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp!=null){
				if(temp.left!=null){
					currentWidth++;
					queue.offer(temp.left);
				}
				if(temp.right!=null){
					currentWidth++;
					queue.offer(temp.right);
				}
			}
			else{
				if(maxWidth<currentWidth){
					maxWidth=currentWidth;
				}
				currentWidth=0;
				if(!queue.isEmpty())
				queue.offer(null);
			}
		}
		return maxWidth;
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		
		MaxNodesAtLevel maxNodesAtLevel = new MaxNodesAtLevel();
		System.out.println(maxNodesAtLevel.maxWidth(root));
	}

}
