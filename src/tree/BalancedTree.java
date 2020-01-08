package tree;
 
public class BalancedTree {
 
    TreeNode root;
 
    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(TreeNode root){
    	if(root == null) {
    		return true;
    	}
    	int lHeight = height(root.left);
    	int rHeight = height(root.right);
    	if(Math.abs(lHeight-rHeight)<=1 && isBalanced(root.left) && isBalanced(root.right)) {
    		return true;
    	}
    	return false;
    }
 
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int height(TreeNode node)
    {
    	if(node == null) {
    		return 0;
    	}
    	return 1+Integer.max(height(node.left), height(node.right));
    }
 
    
    
    //Second Method Approach 2: Bottom-up recursion https://leetcode.com/problems/balanced-binary-tree/solution/
    final class TreeInfo {
  	  public final int height;
  	  public final boolean balanced;

  	  public TreeInfo(int height, boolean balanced) {
  	    this.height = height;
  	    this.balanced = balanced;
  	  }
  	}
    
    private TreeInfo isBalancedTreeHelper(TreeNode node) {
    	if(node == null) {
    		return new TreeInfo(-1,true);
    	}
    	TreeInfo left = isBalancedTreeHelper(node.left);
    	if(!left.balanced) {
    		return new TreeInfo(left.height, false);
    	}
    	TreeInfo right = isBalancedTreeHelper(node.right);
    	if(!right.balanced) {
    		return new TreeInfo(right.height, false);
    	}
    	if(Math.abs(left.height - right.height)<2) {
    		return new TreeInfo(Math.max(left.height, right.height)+1, true);
    	}
    	return new TreeInfo(-1, false);
    }  
    
    public boolean isBalanaced(TreeNode root) {
    	return isBalancedTreeHelper(root).balanced;
    }

    
    
    
    
    public static void main(String args[])
    {
 
        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BalancedTree tree = new BalancedTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.left.left.left = new TreeNode(7);
 
        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}