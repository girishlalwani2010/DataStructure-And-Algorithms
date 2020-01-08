package tree;

import java.util.HashMap;
import java.util.Map;

class TreeNodeWithRandom {
	int val;
	TreeNodeWithRandom left;
	TreeNodeWithRandom right;
	TreeNodeWithRandom random;

	public TreeNodeWithRandom(int data) {
		this.val = data;
	}
}

public class CloneBinaryTreeWithRandom {
	
	Map<TreeNodeWithRandom, TreeNodeWithRandom> nodeToCloneNode = new HashMap<>();

	public TreeNodeWithRandom cloneBinaryTree(TreeNodeWithRandom node) {
		TreeNodeWithRandom cloneNode = copyLeftRightNode(node);
		copyRandomPointerToCloneNode(node,cloneNode);
		return cloneNode;
	}
	
	public TreeNodeWithRandom copyLeftRightNode(TreeNodeWithRandom node) {
		if(node == null) {
			return null;
		}
		TreeNodeWithRandom cloneNode = new TreeNodeWithRandom(node.val);
		nodeToCloneNode.put(node, cloneNode);
		cloneNode.left = copyLeftRightNode(node.left);
		cloneNode.right = copyLeftRightNode(node.right);
		return cloneNode;
	}
	
	public void copyRandomPointerToCloneNode(TreeNodeWithRandom cloneNode, TreeNodeWithRandom node) {
		if(cloneNode == null) {
			return;
		}
		cloneNode.random = nodeToCloneNode.get(node.random);
		copyRandomPointerToCloneNode(cloneNode.left,node.left);
		copyRandomPointerToCloneNode(cloneNode.right,node.right);
	}
	
	

	public void printInorder(TreeNodeWithRandom node) {
		if (node == null)
			return;

		/* First recur on left sutree */
		printInorder(node.left);

		/* then print data of Node and its random */
		System.out.print(node.val + "[");
		if (node.random == null)
			System.out.print("null" + "],");
		else
			System.out.print(node.random.val + "],");

		/* now recur on right subtree */
		printInorder(node.right);
	}

	public static void main(String[] args) {

		TreeNodeWithRandom root = new TreeNodeWithRandom(1);
		root.left = new TreeNodeWithRandom(2);
		root.right = new TreeNodeWithRandom(3);
		root.left.left = new TreeNodeWithRandom(4);
		root.left.right = new TreeNodeWithRandom(5);

		root.random = root.left.left;
		root.left.random = root.left;
		root.right.random = root.left.right;
		root.left.left.random = root.right.left;
		root.left.right.random = root;

		CloneBinaryTreeWithRandom cloneBinaryTreeWithRandom = new CloneBinaryTreeWithRandom();
		TreeNodeWithRandom cloneNode = cloneBinaryTreeWithRandom.cloneBinaryTree(root);
		cloneBinaryTreeWithRandom.copyRandomPointerToCloneNode(cloneNode, root);
		cloneBinaryTreeWithRandom.printInorder(root);
		System.out.println();
		cloneBinaryTreeWithRandom.printInorder(cloneNode);

	}

}
