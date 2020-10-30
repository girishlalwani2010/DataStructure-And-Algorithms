package tree;

public class PrintNonSiblingNodes {

	private void printNonSiblingNodes(TreeNode node){
		
		if(node == null)
			return;
		
		printNonSiblingNodes(node.left);
		printNonSiblingNodes(node.right);
		
		if(node.left == null && node.right ==  null) {
			return;
		}
		
		if(node.left==null){
			System.out.println(node.right.val);
		}
		
		if(node.right==null){
			System.out.println(node.left.val);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		
		PrintNonSiblingNodes printNonSiblingNodes = new PrintNonSiblingNodes();
		printNonSiblingNodes.printNonSiblingNodes(root);
	}
	
}
