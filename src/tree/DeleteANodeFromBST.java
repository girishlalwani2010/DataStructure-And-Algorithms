package tree;

public class DeleteANodeFromBST {
	
	    public TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null){
	            return null;
	        }
	        if(key<root.val){
	            root.left = deleteNode(root.left, key);
	        }else if(key>root.val){
	            root.right = deleteNode(root.right, key);
	        }else{
	            if(root.left == null){
	                return root.right;
	            }else if(root.right == null){
	                return root.left;
	            }
	            TreeNode successor = getMinFromRight(root.right);
	            root.val = successor.val;
	            root.right = deleteNode(root.right, successor.val);
	        }
	        return root;
	    }

	    private TreeNode getMinFromRight(TreeNode root) {
	        while(root.left!=null){
	            root = root.left;
	        }
	        return root;
	    }

}