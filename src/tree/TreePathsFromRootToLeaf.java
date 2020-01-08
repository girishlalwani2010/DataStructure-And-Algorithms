package tree;

import java.util.ArrayList;
import java.util.List;

public class TreePathsFromRootToLeaf {

	private static void printPath(int[] path, int pathLength) {
		for (int i = 0; i < pathLength; i++) {
			System.out.println(path[i]);
		}
		System.out.println();
	}

	private static void printPaths(TreeNode root, int[] path, int pathLength) {
		if (root == null)
			return;

		path[pathLength] = root.val;
		pathLength++;

		if (root.left != null && root.right != null) {
			printPath(path, pathLength);
		}

		else {
			printPaths(root.left, path, pathLength);
			printPaths(root.right, path, pathLength);
		}

	}

	// Another way using backtracking. Awesome
	public static void printAllRootToLeafPaths(TreeNode root, List<Integer> currentPath) {

		if (root == null) {
			return;
		}

		currentPath.add(root.val);

		if (root.left == null && root.right == null) {
			System.out.println(new ArrayList<Integer>(currentPath));
		}

		printAllRootToLeafPaths(root.left, currentPath);
		printAllRootToLeafPaths(root.right, currentPath);
		currentPath.remove(currentPath.size() - 1);

	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		int[] path = new int[256];
		//printPaths(root, path, 0);
		printAllRootToLeafPaths(root,new ArrayList<Integer>());
	}

}
