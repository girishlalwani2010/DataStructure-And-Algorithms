package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeConstructionFromPreAndInOrder {

	TreeNode root;
    static int preIndex = 0;
	
    private int search(int[] in, int inStrt, int inEnd, int data) {
    	
    	for(int i=0; i<in.length; i++){
    		if(in[i] == data)
    		{
    			return i;
    		}
    	}
    	
    	return -1;
	}
    
    
    private TreeNode buildTree(int[] in, int[] pre, int inStrt, int inEnd){
		
		if(inStrt > inEnd)
			return null;
		
		TreeNode tNode = new TreeNode(pre[preIndex++]);
		
		int inIndex = search(in, inStrt, inEnd, tNode.data);
		
		tNode.left = buildTree(in, pre, inStrt, inIndex);
		tNode.right = buildTree(in, pre, inIndex+1, inEnd);
		
		return tNode;
	}
	
	private void printInorder(TreeNode root) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String args[]){
		
		TreeConstructionFromPreAndInOrder treeConstructionFromPreAndInOrder = new TreeConstructionFromPreAndInOrder();
        int in[] = new int[]{4,2,5,1,6,3,7};
        int pre[] = new int[]{1,2,4,5,3,6,7};
        int len = in.length;
        TreeNode root = treeConstructionFromPreAndInOrder.buildTree(in, pre, 0, len - 1);
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        treeConstructionFromPreAndInOrder.printInorder(root);
        
	}

}
