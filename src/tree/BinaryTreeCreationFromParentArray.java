package tree;

import javax.security.auth.login.CredentialException;

public class BinaryTreeCreationFromParentArray{
	
	private TreeNode createBinaryTree(int []parrentArray){
		TreeNode[] treeArray = new TreeNode[parrentArray.length];
		
		for(int i=0; i<parrentArray.length; i++){
				treeArray[i] = new TreeNode(i);
		}
		
		
		for(int i=0;i<parrentArray.length;i++){
				if(parrentArray[i] == -1){
				}
				else{
					if(treeArray[parrentArray[i]] !=null){
						if(treeArray[parrentArray[i]].left==null){
							treeArray[parrentArray[i]].left = treeArray[i];
						}
						else{
							treeArray[parrentArray[i]].right = treeArray[i];
						}
						
					}
				}
		}
		return treeArray[0];
	}
	
	
	// psuedo code
	int parentArray[];
	public void buildTree(int[] arr) {
		TreeNode root = null;
		this.parentArray = arr;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				root = new TreeNode(i);
			}
		}
		if(root!=null) {
			buildTree(root);
		}else {
			throw new IllegalStateException("Root is null");
		}
	}
	
	
	public void buildTree(TreeNode root) {
		for(int i=0;i<parentArray.length; i++) {
			if(parentArray[i] == root.val) {
				if(root.left == null) {
					root.left = new TreeNode(i);
				}
				if(root.right == null) {
					root.right = new TreeNode(i);
				}
			}
		}
		if(root.left!=null) {
			buildTree(root.left);
		}
		if(root.right!=null) {
			buildTree(root.right);
		}
	}
	
	public static void main(String[] args) {
		int parrentArray[] = {1, 5, 5, 2, 2, -1, 3};
		BinaryTreeCreationFromParentArray binaryTreeCreationFromParentArray = new BinaryTreeCreationFromParentArray();
		TreeNode root = binaryTreeCreationFromParentArray.createBinaryTree(parrentArray);
		
		
	}

}
