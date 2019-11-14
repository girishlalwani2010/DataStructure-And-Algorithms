package datastructure.tree;

public class PrintNodeWithKLeaves {

	private static int getNoOfLeaves(TreeNode node, int k){
		
		if(node == null)
			return 0;
		
		if(node.left == null && node.right==null){
			return 1;
		}
		int noOfLeaves = getNoOfLeaves(node.left,k) + getNoOfLeaves(node.right,k);
		if(noOfLeaves == k){
			System.out.println(node.data);
		}
		return noOfLeaves;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(5);
		//getNoOfLeaves(root,2);
		//printNodeWithKLeaves(root,2);
	}

	
}
