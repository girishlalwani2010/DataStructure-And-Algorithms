package datastructure.tree;

public class LargestBSTInBinaryTree {

    public int largestBST(TreeNode root){
        MinMax m = largest(root);
        return m.size;
    }
    
    private MinMax largest(TreeNode root){
    	if(root == null)
    		return new MinMax();
    	
    	MinMax leftMinMax = largest(root.left);
    	MinMax rightMinMax = largest(root.right);
    	
    	MinMax m = new MinMax();
    	
    	if(leftMinMax.isBST == false || rightMinMax.isBST == false || leftMinMax.max > root.data || rightMinMax.min <= root.data){
    		m.size = Math.max(leftMinMax.size, rightMinMax.size);
    		m.isBST = false;
    		return m;
    	}
    	
    	m.size = leftMinMax.size + rightMinMax.size + 1;
    	m.max = root.right != null ? rightMinMax.max : root.data;
    	m.min = root.left != null ? leftMinMax.min : root.data;
    	m.isBST = true;
    	
    	return m;
    	
    }
    
    public static void main(String args[]){
        LargestBSTInBinaryTree lbi = new LargestBSTInBinaryTree();
        TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
        int largestBSTSize = lbi.largestBST(root);
        System.out.println("Size of largest BST  is " + largestBSTSize);
      // assert largestBSTSize == 8;
    }
}

/**
 * Object of this class holds information which child passes back
 * to parent node.
 */
class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;
    
    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = true;
        size = 0;
    }
}