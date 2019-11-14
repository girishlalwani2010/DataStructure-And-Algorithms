package datastructure.tree;

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
	
	public static void main(String[] args) {
		int parrentArray[] = {1, 5, 5, 2, 2, -1, 3};
		BinaryTreeCreationFromParentArray binaryTreeCreationFromParentArray = new BinaryTreeCreationFromParentArray();
		TreeNode root = binaryTreeCreationFromParentArray.createBinaryTree(parrentArray);
	}

}
