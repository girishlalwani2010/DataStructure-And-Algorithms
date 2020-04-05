package tree;

public class InorderSuccPractice {
	
	TreeNode succ,prev;
	public void inorderSuccesor(TreeNode root, TreeNode node) {
		if(root == null)
			return;
		inorderSuccesor(root.right, node);
		if(root.val == node.val) {
			succ = prev;
		}
		prev = root;
		inorderSuccesor(root.left, node);
	}
}
