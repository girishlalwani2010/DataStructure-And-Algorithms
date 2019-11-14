package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintExtremeNodes {
	
	private void printExtremeNodes(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		System.out.println(root.data);
		queue.add(root);
		queue.add(null);
		int count=0,levelCount = 0;
		boolean flag = true;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node == null){
				if(!queue.isEmpty()){
					levelCount = count;
					count = 0;
					flag = !flag;
					queue.add(null);
				}
			}
			else{
				if(!flag && count == 0){
					System.out.println(node.data);
				}
				
				if(flag && levelCount == count){
					System.out.println(node.data);
				}
				count++;
				
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.right.right.right = new TreeNode(15);
		PrintExtremeNodes printExtremeNodes = new PrintExtremeNodes();
		printExtremeNodes.printExtremeNodes(root);
	}

}
