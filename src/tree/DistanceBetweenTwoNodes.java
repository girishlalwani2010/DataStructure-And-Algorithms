package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DistanceBetweenTwoNodes {

	private int distanceMAx = -1;

	public int distanceBetweenRootAndNodeWithoutRecursion(TreeNode root, int item) {
		int distance = 0;

		if (root.val == item) {
			return distance;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();

			if (currentNode == null) {
				distance++;
				if (!queue.isEmpty())
					queue.offer(null);
			} else {
				if (currentNode.val == item)
					return distance;

				else {
					if (currentNode.left != null)
						queue.offer(currentNode.left);

					if (currentNode.right != null)
						queue.offer(currentNode.right);
				}

			}
		}
		return distance;

	}

	/**
	 * Find the distance between root and given node using recursion.
	 * 
	 * @param root
	 * @param item
	 * @return
	 */
	public int pathLength(TreeNode root, int item, int distance) {
		if (root == null)
			return -1;

		distance++;

		if (root.val == item) {
			distanceMAx = distance - 1;
		}

		pathLength(root.left, item, distance);
		pathLength(root.right, item, distance);
		return distanceMAx;

	}

	// Distance between two nodes --- We first find LCA of two nodes. Then we find
	// distance from LCA to two nodes.
	public int distanceBetweenTwoNodes(TreeNode root, int n1, int n2) {
		TreeNode lca = findLCA(root, n1, n2);
		int distance1 = distance(lca, n1, 0);
		int distance2 = distance(lca, n2, 0);
		return distance1 + distance2;
	}

	
	public int distance(TreeNode lca, int nodeVal, int level) {
		if(lca == null) {
			return -1;
		}
		if(lca.val == nodeVal) {
			return level;
		}
		int dist = distance(lca.left, nodeVal, level+1);
		if(dist!=-1) {
			return dist;
		}
		dist = distance(lca.right, nodeVal, level+1);
		if(dist!=-1) {
			return dist;
		}else {
			return -1;
		}
	}
	
	
	
	
	
	
	public TreeNode findLCA(TreeNode root, int n1, int n2) {
		if(root==null) {
			return null;
		}
		if(root.val == n1 || root.val == n2) {
			return root;
		}
		TreeNode left = findLCA(root.left, n1, n2);
		TreeNode right = findLCA(root.right, n1, n2);
		if(left!=null && right!=null) {
			return root;
		}
		if(left==null) {
			return right;
		}else {
			return left;
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

		DistanceBetweenTwoNodes d = new DistanceBetweenTwoNodes();
		System.out.println(d.distanceBetweenTwoNodes(root, 4, 7));
	}

}
