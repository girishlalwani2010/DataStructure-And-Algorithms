package tree;

public class TwoFarthestNodesInTree {
	
	private int maxDistance;
	private int secondMaxDistance;
	private TreeNode firstFarthest;
	private TreeNode secondFarthest;
	private TreeNode[] arr = new TreeNode[2];

	public TreeNode[] farthestInBinaryTree(TreeNode root, int x){
		
		if(root == null)
			return null;
		
		
		if(maxDistance<=x){
				//secondMaxDistance = maxDistance;
				secondFarthest = firstFarthest;
				maxDistance = x;
				firstFarthest = root;
		}
			
		
		
		farthestInBinaryTree(root.left,x+1);
		farthestInBinaryTree(root.right, x+1);
		
		arr[0] = firstFarthest;
		arr[1] = secondFarthest;
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(10);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		
		TwoFarthestNodesInTree twoFarthestNodesInTree = new TwoFarthestNodesInTree();
		TreeNode[] arr = twoFarthestNodesInTree.farthestInBinaryTree(root, 0);
		System.out.println(arr[0].data+"  "+arr[1].data);
	}
	
}
