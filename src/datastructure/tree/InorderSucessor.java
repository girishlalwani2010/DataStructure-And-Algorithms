package datastructure.tree;

import java.util.Stack;

public class InorderSucessor {
	
	private static TreeNode succesor;

	static TreeNode getLeftMostOfRight(TreeNode node){
		
		while(node.left!=null){
			node = node.left;
		}
			
		return node;
		
	}
	
	static TreeNode findInorderSucessor(TreeNode root, int item) {
		if(root == null)
			return null;
		
		if(root.data == item){
			if(root.right!=null)
			succesor = getLeftMostOfRight(root.right);
		}
		
		if(root.data>item){
			succesor = root;
			findInorderSucessor(root.left, item);
		}

		if(root.data < item){
			findInorderSucessor(root.right, item);
		}
		
		return succesor;
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		System.out.println(findInorderSucessor(root, 8).data);
		System.out.println(findInorderSucessor(root, 10).data);
		System.out.println(findInorderSucessor(root, 14).data);

	}

}
