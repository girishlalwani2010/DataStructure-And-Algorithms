package tree;

public class MirrorOfBinaryTree {

	private TreeNode mirrorOfBinaryTree(TreeNode root){
		TreeNode temp;
		if(root!=null){
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);
			temp = root.left;
			root.left = root.right; 
			root.right = temp;		
		}
		
		return root;
	}
	
	private static void printBinaryTree(TreeNode root){
		
		if(root!=null){
			System.out.print(root.val+" ");
			printBinaryTree(root.left);
			printBinaryTree(root.right);
		}
		
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		MirrorOfBinaryTree mirrorOfBinaryTree = new MirrorOfBinaryTree();
		TreeNode mirror = mirrorOfBinaryTree.mirrorOfBinaryTree(root);
		
		printBinaryTree(mirror);
	}
	
	
}
