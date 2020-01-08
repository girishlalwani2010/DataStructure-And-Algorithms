package tree;

public class BinaryTreeMaximumPathSum {
	
	 int maxSum = Integer.MIN_VALUE;
	    public int maxPath(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        int left = maxPath(root.left);
	        int right = maxPath(root.right);
	        maxSum = Math.max(maxSum,left+right+root.val);
	        if(Math.max(left,right)+root.val<0){
	            return 0;
	        }else{
	            return Math.max(left,right)+root.val;
	        }
	        
	    }
	    
	    public int maxPathSum(TreeNode root){
	       maxPath(root);
	        return maxSum;
	    } 

}
