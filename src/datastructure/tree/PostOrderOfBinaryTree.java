package datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderOfBinaryTree {
	public static List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	 
	    if(root==null) {
	        return res;
	    }
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	 
	    while(!stack.isEmpty()) {
	        TreeNode temp = stack.peek();
	       
	        if(temp.left==null && temp.right==null) {
	            TreeNode pop = stack.pop();
	            res.add(pop.data);
	        }
	        
	            if(temp.right!=null) {
	                stack.push(temp.right);
	                temp.right = null;
	            }
	 
	            if(temp.left!=null) {
	                stack.push(temp.left);
	                temp.left = null;
	            }
	            
	            
	        
	    }
	 
	    return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		PostOrderOfBinaryTree postOrderOfBinaryTree = new PostOrderOfBinaryTree();
		System.out.println(postOrderOfBinaryTree.postorderTraversal(root));
	}
}

