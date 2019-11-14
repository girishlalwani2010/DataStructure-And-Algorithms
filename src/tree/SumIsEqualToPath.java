package tree;

public class SumIsEqualToPath {

	private static boolean isAnyPathPossible(TreeNode node, int sum){
		if(node == null){
			return (sum == 0);
		}
		sum = sum - node.data;
		return isAnyPathPossible(node.left,sum)||isAnyPathPossible(node.right,sum);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(isAnyPathPossible(root,10));
	}

}
