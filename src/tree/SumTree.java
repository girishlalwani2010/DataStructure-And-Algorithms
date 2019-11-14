package tree;

/**
 * @author g09562357
 *
 *
 * Update root.data with left.data + right.data, but always return the sum of old value + left + right.
 */
public class SumTree {

	int makeSum(TreeNode root){

		if(root == null){
			return 0;
		}
		
		int temp = root.data;
		root.data = makeSum(root.left) + makeSum(root.right);
		return temp + root.data;
	}
	
	private static void printBinaryTree(TreeNode root){
		if(root!=null){
			System.out.print(root.data+" ");
			printBinaryTree(root.left);
			printBinaryTree(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = null;
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		
		SumTree sumTree = new SumTree();
		sumTree.makeSum(root);
		printBinaryTree(root);
		
		
	}
	
}
