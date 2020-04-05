package tree;

public class DistanceBetweenTwoNodesInBinaryTree {

	public TreeNode lca(TreeNode root, int A, int B) {
		if(root==null)
			return null;
		if(root.val == A || root.val == B) {
			return root;
		}
		TreeNode left = lca(root.left, A, B);
		TreeNode right = lca(root.right, A, B);
		if(left==null) {
			return right;
		}if(right==null) {
			return left;
		}
		return root;
	}
	int maxDistance=0;
	public int distanceBetweenTwoNodes(TreeNode lca, int item, int distance) {
		if(lca ==null) {
			return -1;
		}
		if(lca.val == item) {
			return distance;
		}
		int leftDistance = distanceBetweenTwoNodes(lca.left, item, distance+1);
		if(leftDistance!=-1) {
			return leftDistance;
		}

		int rightDist = distanceBetweenTwoNodes(lca.right, item, distance+1);
		if(rightDist!=-1) {
			return rightDist;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		DistanceBetweenTwoNodesInBinaryTree d = new DistanceBetweenTwoNodesInBinaryTree();
		TreeNode lca = d.lca(root, 8, 5);
		System.out.println(d.distanceBetweenTwoNodes(lca,8,0)+d.distanceBetweenTwoNodes(lca,5,0));
		
	}
	
}
