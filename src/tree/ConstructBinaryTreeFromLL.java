package tree;

import java.util.LinkedList;
import java.util.Queue;

import linkedlist.ListNode;

public class ConstructBinaryTreeFromLL {

	private TreeNode makeBinaryTree(TreeNode tRoot, ListNode lRoot){
		
		tRoot = new TreeNode(lRoot.data);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tRoot);
		while(lRoot.next!=null){
			TreeNode node = queue.poll();
			if(lRoot.next!=null){
				node.left = new TreeNode(lRoot.next.data);
				queue.add(node.left);
				lRoot = lRoot.next;
			}
			if(lRoot.next!=null){
				node.right = new TreeNode(lRoot.next.data);
				queue.add(node.right);
				lRoot = lRoot.next;
			}
		}
		
		return tRoot;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		ListNode head = new ListNode(10);
		head.next = new ListNode(12);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(25);
		head.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next = new ListNode(36);
		ConstructBinaryTreeFromLL constructBinaryTreeFromLL = new ConstructBinaryTreeFromLL();
		constructBinaryTreeFromLL.makeBinaryTree(null,head);
	}
	
}
