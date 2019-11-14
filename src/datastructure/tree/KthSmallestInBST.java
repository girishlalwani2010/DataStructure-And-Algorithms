package datastructure.tree;

import java.util.Stack;

public class KthSmallestInBST {

	int getKthSmallestElement(TreeNode root, int k){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		int kthSmallest = 0;
		
		while(!stack.isEmpty() || p!=null){
			
			if(p!=null){
				stack.push(p);
				p=p.left;
			}
			else{
				TreeNode t = stack.pop();
				k--;
				if(k==0){
					kthSmallest = t.data;
					break;
				}
				p = t.right;
			}
			
			
		}
		
		return kthSmallest;
		
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);
		
		KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
		System.out.println(kthSmallestInBST.getKthSmallestElement(root, 3));
	}
	
}
