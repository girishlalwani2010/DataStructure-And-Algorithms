package datastructure.tree;

public class IsBTBST {

	private static int getMaxinBinaryTree(TreeNode root){
		
		if(root == null)
			return Integer.MIN_VALUE;
		
		int leftMax = getMaxinBinaryTree(root.left);
		int rightMax = getMaxinBinaryTree(root.right);	
		
		return Math.max(root.data, Math.max(leftMax,rightMax));
		
	}
	
	private static int getMinInBinaryTree(TreeNode root){
		
		if(root == null)
			return Integer.MAX_VALUE;
		
		int leftMax = getMinInBinaryTree(root.left);
		int rightMax = getMinInBinaryTree(root.right);	
		
		return Math.min(root.data, Math.min(leftMax,rightMax));
		
	}
	
	
	private static boolean isBTBST(TreeNode root){
		
		if(root == null || root.left == null || root.right == null ){
			return true;
		}

		if(getMaxinBinaryTree(root.left) < root.data || getMinInBinaryTree(root.right) > root.data){
			return false;
		}
		
		isBTBST(root.left);
		isBTBST(root.right); 
		
		return true;	
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(22);
	
		System.out.println(isBTBST(root));
		
	}
	
}
