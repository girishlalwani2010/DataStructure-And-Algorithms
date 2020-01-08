package tree;

public class BinaryTreeSumOfAllPaths {
static int totalSum=0;
	static int binaryTreeSum(TreeNode root, int sum){
		
		if(root == null)
			return 0;
		
		sum = sum*10 + root.val;
		
		if(root.left == null && root.right==null){
			totalSum = totalSum + sum;
		}
		
		binaryTreeSum(root.left, sum);
		binaryTreeSum(root.right, sum);
		
		return totalSum;
		
	}
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		
		System.out.println(binaryTreeSum(root,0));
	}
	
}
