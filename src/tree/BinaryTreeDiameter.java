package tree;

public class BinaryTreeDiameter {

	public int getHeight(TreeNode root){
		if(root!=null){
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}
	
	public int getMax(int A,int B, int C){
		return Math.max(Math.max(A, B),C);
	}
	
	
	public int findDiameter(TreeNode root)
	{
		if(root!=null){
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			
			int leftDiameter = findDiameter(root.left);
			int rightDiameter = findDiameter(root.right);
			
			return getMax(leftHeight+rightHeight+1,leftDiameter,rightDiameter);
		}
		return 0;
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

		BinaryTreeDiameter d = new BinaryTreeDiameter();
		System.out.println("Diameter of Tree: " + d.findDiameter(root));
	}
	
}
