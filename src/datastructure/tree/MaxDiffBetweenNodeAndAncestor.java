package datastructure.tree;

//Maximum difference between node and its ancestor in Binary Tree
public class MaxDiffBetweenNodeAndAncestor {
	
	static int result = Integer.MIN_VALUE;
	int val = Integer.MAX_VALUE;
	
	private int maxDiffUtil(TreeNode node) 
    {
		if(node == null){
			return Integer.MAX_VALUE;
		}
		
		int leftValue = maxDiffUtil(node.left);
		int rightValue = maxDiffUtil(node.right);
		
		val = node.data;
		
		if(node.left!=null){
			val = Math.min(leftValue, val);
		}
		if(node.right != null){
			val = Math.min(rightValue, val);
		}
		
		result = Math.max(node.data-val, result);
		
		return val;
		
    }
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		MaxDiffBetweenNodeAndAncestor maxDiffBetweenNodeAndAncestor = new MaxDiffBetweenNodeAndAncestor();
		maxDiffBetweenNodeAndAncestor.maxDiffUtil(root);
		System.out.println(result);
	
		
	}

}
