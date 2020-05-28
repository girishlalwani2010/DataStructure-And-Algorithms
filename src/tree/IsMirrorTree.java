package tree;

public class IsMirrorTree {

	 public boolean isSymmetric(TreeNode root) {
	        if(root == null){
	            return true;
	        }
	        return isSymmetric(root.left, root.right);
	    }
	    
	    private boolean isSymmetric(TreeNode node1, TreeNode node2){
	        if(node1 == null && node2 == null){
	            return true;
	        }
	        else if(node1==null){
	            return false;
	        }
	        else if(node2==null){
	            return false;
	        }else{
	            return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
	        }
	    }
	
}
