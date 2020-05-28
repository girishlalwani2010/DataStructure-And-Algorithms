package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author girish_lalwani
 *
 *         https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/SerializeDeserializeBinaryTree/SerializeDeserializeBinaryTree.java
 *
 *         https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *         
 *         https://www.youtube.com/watch?v=suj1ro8TIVY&t=731s 
 *         
 *         https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/164504/Java-concise-Solution.
 */
public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	final String DELIMETER = ",";

	public String serialize(TreeNode root) {
		if (root == null) {
			return "#";
		}
		String leftPart = serialize(root.left);
		String rightPart = serialize(root.right);
		return root.val + "," + leftPart + "," + rightPart;
	}

	public TreeNode deserialize(String data) {
		// looks like that we have to use global variable to iterate over data array one
		// by one to deserialize.
		// can also be done using Integer class.
		int[] start = { 0 };
		return deserialize(data.split(","), start);
	}

	private TreeNode deserialize(String[] data, int[] start) {
		if (data[start[0]].equals("#")) {
			start[0]++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(data[start[0]++]));
		root.left = deserialize(data, start);
		root.right = deserialize(data, start);
		return root;
	}

	// Another way in case of deserialization queue can be used
	// Decodes your encoded data to tree.
	public TreeNode deserializeAnotherWay(String data) {
		// queue just used as a data-structure to poll from front. As we need to poll
		// from front
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(data.split(DELIMETER)));
		return deserialize(queue);
	}

	public TreeNode deserialize(Queue<String> q) {
		String str = q.poll();
		if (str.equals("#")) {
			return null;
		}
		TreeNode newNode = new TreeNode(Integer.valueOf(str));
		newNode.left = deserialize(q);
		newNode.right = deserialize(q);
		return newNode;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = null;
		root.right.right = null;
		SerializeAndDeserializeBinaryTree sAndD = new SerializeAndDeserializeBinaryTree();
		String serializedData = sAndD.serialize(root);
		System.out.println(serializedData);
		root = sAndD.deserialize(serializedData);
		String serializedData2 = sAndD.serialize(root);
		System.out.println(serializedData2);

	}

}
