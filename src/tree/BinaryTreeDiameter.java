package tree;

public class BinaryTreeDiameter {

	public int getHeight(TreeNode root) {
		if (root != null) {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public int findDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		int lDiameter = findDiameter(root.left);
		int rDiameter = findDiameter(root.right);

		return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
	}

	// Second better way return object pattern from recursion, to avoid redundant
	// calls to height function.
	
	public int diameterOfBinaryTree(TreeNode root) {
		return diameter(root).diameter;
	}
	public TreeInfo diameter(TreeNode root) {
		if(root == null) {
			return new TreeInfo(0,0);
		}
		TreeInfo leftInfo = diameter(root.left);
		TreeInfo rightInfo = diameter(root.right);
		int diameter = Math.max(leftInfo.height+rightInfo.height+1, 
				Math.max(leftInfo.diameter, rightInfo.diameter));
		int height = Math.max(leftInfo.height,rightInfo.height)+1;
		return new TreeInfo(height, diameter);
	}

	class TreeInfo {
		public int height;
		public int diameter;

		TreeInfo(int height, int diamter) {
			this.height = height;
			this.diameter = diamter;
		}
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
		System.out.println("Diameter of Tree: " + d.diameterOfBinaryTree(root));
	}

}
