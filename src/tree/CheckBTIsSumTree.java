package tree;

public class CheckBTIsSumTree {

	int sum;
	
	int checkForSumTree(TreeNode node, int sum){
		
		if(node == null){
			return 0;
		}
		
		if(node.left == null && node.right == null){
			return node.data;
		}
		
		sum = sum + checkForSumTree(node.left, sum) + checkForSumTree(node.right, sum);
		
		if(sum != node.data){
			return -1;
		}
		
		return node.data+sum;
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(2);
		
		CheckBTIsSumTree checkBTIsSumTree = new CheckBTIsSumTree();
		int returnedVal = checkBTIsSumTree.checkForSumTree(root,0);
		System.out.println(returnedVal);
		
	}
}
