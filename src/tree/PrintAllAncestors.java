package tree;

public class PrintAllAncestors {

	private boolean getAllAncestors(TreeNode root, TreeNode node){
		
		if((root.left.data == node.data) || (root.right.data == node.data) || getAllAncestors(root.left, node) || getAllAncestors(root.right, node)){
			System.out.println(root.data);
			return true;
		}
		
		return false;
	}	
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode node = new TreeNode(5);
		PrintAllAncestors printAllAncestors = new PrintAllAncestors();
		printAllAncestors.getAllAncestors(root,node);
	}
	
}
