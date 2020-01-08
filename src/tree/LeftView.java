package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

	public static void printLeftView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		boolean isFirstOfLevel = true;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (isFirstOfLevel) {
				System.out.println(node.val);
				isFirstOfLevel = false;
			}
			if (node == null) {
				if (!q.isEmpty()) {
					q.add(null);
				}
				isFirstOfLevel = true;
			} else {
				if (node.left != null) {
					q.add(node.left);
				} if (node.right != null) {
					q.add(node.right);
				}
			} 
		}
	}
	
	
	static int maxLevel = -1;
	
	public static void printLeftViewUsingRecursion(TreeNode root, int level) {
		
		if(maxLevel<level) {
			System.out.println(root.val);
			maxLevel = level;
		}
		
		if(root.left!=null)
		printLeftViewUsingRecursion(root.left, level+1);
		
		if(root.right!=null)
		printLeftViewUsingRecursion(root.right, level+1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(1);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);

		printLeftViewUsingRecursion(root,0);
	}

}
