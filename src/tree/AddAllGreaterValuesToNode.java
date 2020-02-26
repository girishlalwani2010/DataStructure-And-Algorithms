package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
 *https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 */
public class AddAllGreaterValuesToNode {
	
	private int sumOfAllNodes(TreeNode root){
		if(root == null) {
			return 0;
		}
		return root.val + sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
	}
	
	// can be done using reverse inorder in that case sumOfAllNodes is not needed
	private TreeNode addAllGreaterValuesToNode(TreeNode root){
		int sum = sumOfAllNodes(root);
		TreeNode p = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		int prevVal;
		while(!stack.isEmpty() || p!=null) {
			if(p!=null) {
				stack.push(p);
				p = p.left;
			}else {
				TreeNode t = stack.pop();
				prevVal = t.val;
				t.val = sum;
				sum = sum - prevVal;
				p = t.right;
			}
		}
		return root;
	}
	
	
	//second way 
	int sum=0;
	private TreeNode convertBSTToGreaterTree(TreeNode root) {
		if(root != null) {
			convertBSTToGreaterTree(root.right);
			sum = sum + root.val;
			root.val = sum;
			convertBSTToGreaterTree(root.left);
		}
		return root;
			
	}
	
	//thirdway
	private TreeNode convertBST(TreeNode root){
		TreeNode p = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		int sum=0;
		while(!stack.isEmpty() || p!=null) {
			if(p!=null) {
				stack.push(p);
				p = p.right;
			}else {
				TreeNode t = stack.pop();
				sum = sum + t.val;
				t.val = sum;
				p = t.left;
			}
		}
		return root;
	}
	
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);
		
		AddAllGreaterValuesToNode addAllGreaterValuesToNode = new AddAllGreaterValuesToNode();
		TreeNode modifiedRoot = addAllGreaterValuesToNode.addAllGreaterValuesToNode(root);
		
		InOrderImpl inOrderImpl = new InOrderImpl();
		inOrderImpl.inorderTraversal(modifiedRoot);
		
		
	}
	
}
