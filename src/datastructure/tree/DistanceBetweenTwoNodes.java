package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DistanceBetweenTwoNodes {
	
	private int distanceMAx=-1;
	
	public int distanceBetweenRootAndNodeWithoutRecursion(TreeNode root, int item)
	{
		int distance = 0;
		
		if(root.data == item)
		{
			return distance;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty())
		{
			TreeNode currentNode = queue.poll();
			
			if(currentNode == null)
			{
				distance ++;
				if(!queue.isEmpty())
				queue.offer(null);
			}
			else
			{
				if(currentNode.data == item)
					return distance;
				
				else
				{
					if(currentNode.left != null)
						queue.offer(currentNode.left);
					
					if(currentNode.right != null)
						queue.offer(currentNode.right);
				}
				
			}
		}
		return distance;
		
	}
	
	
	/**
	 * Find the distance between root and given node using recursion.
	 * 
	 * @param root
	 * @param item
	 * @return
	 */
	public int pathLength(TreeNode root, int item, int distance)
	{
		if(root == null)
			return -1;
		
		distance++;
		
		if(root.data == item){
			distanceMAx = distance -1 ;
		}
			
		
		pathLength(root.left,item,distance);
		pathLength(root.right, item, distance);
		return distanceMAx;
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		DistanceBetweenTwoNodes d = new DistanceBetweenTwoNodes();
		System.out.println( d.pathLength(root,5,0));
	}

}
