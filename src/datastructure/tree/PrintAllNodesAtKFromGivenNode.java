package datastructure.tree;
public class PrintAllNodesAtKFromGivenNode {

	public void printAllNodes(TreeNode root, int node, int distance) {
		int pl = Pathlength(root, node) - 1;
		Path(root, node, pl, distance);
	}

	public void print(TreeNode root, int node, TreeNode prev, int k,
			boolean searchingDown) {
		if (root != null) {
			if (k == 0 && root.data != node) {
				System.out.print(" " + root.data);
			}
			if (searchingDown) {
				print(root.left, node, prev, --k, searchingDown);
				print(root.right, node, prev, k, searchingDown);
			} else {
				if (root.left != prev) {
					print(root.left, node, prev, --k, searchingDown);
				}
				if (root.right != prev) {
					print(root.right, node, prev, --k, searchingDown);
				}
			}
		}
	}

	public TreeNode Path(TreeNode root, int dest, int k, int n) {
		if (root == null)
			return null;
		TreeNode x = null;
		if (root.data == dest || (x = Path(root.left, dest, k - 1, n)) != null
				|| (x = Path(root.right, dest, k - 1, n)) != null) {
			if (k == 0) {
				print(root, dest, x, n - k, true);
			} else {
				print(root, dest, x, n - k, false);
			}

			return root;
		}
		return null;
	}

	public int Pathlength(TreeNode root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public static void main(String[] args) throws java.lang.Exception {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(9);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		root.left.right.right.right = new TreeNode(10);
		root.left.right.right.right.left = new TreeNode(11);
		root.right.right = new TreeNode(8);
		PrintAllNodesAtKFromGivenNode i = new PrintAllNodesAtKFromGivenNode();
		System.out.print("Nodes at distance '3' from Node '5' are : ");
		i.printAllNodes(root, 5, 3);
	}
}


