package tree;

import java.util.ArrayList;
import java.util.List;

class Index {
	 
    int index = 0;
}

public class BuildBinaryTree {
	
	static Index index = new Index();
	
	static int preIndex;

	static int findIndexInInorder(List<Integer> inorder,int value){
		for(int i=0; i<inorder.size(); i++){
			if(inorder.get(i) == value){
				return i;
			}
		}
		return -1;
	}
	
	private static TreeNode buildBinaryTree(List<Integer> inorder, List<Integer> preorder, int start, int end){
		
		if(start>end){
			return null;
		}
		
		int value = preorder.get(preIndex++);
		TreeNode node = new TreeNode(value);
			
		if(start == end)
			return node;
		
		//can be improved by passing start and end. and using hashmap this step can be done in O(1)
		int index = findIndexInInorder(inorder,value);
		node.left = buildBinaryTree(inorder,preorder,start,index-1);
		node.right = buildBinaryTree(inorder,preorder,index+1,end);
		
		return node;
		
	}
	
	private static void printBinaryTree(TreeNode root){
		if(root!=null){
			printBinaryTree(root.left);
			System.out.print(root.val+" ");
			
			printBinaryTree(root.right);
		}
	}
	//can be done more efficiently using min, max in O(n)
	//TODO: Also look construct Binary Tree using Level Order and inorder Traversal.
	private static TreeNode buildBSTUsingPreorderOnly(int pre[],
            int low, int high){
		
        // Base case
        if (low > high || preIndex>=pre.length) {
            return null;
        }
 
        // The first node in preorder traversal is root. So take the node at
        // preIndex from pre[] and make it root, and increment preIndex
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex = preIndex + 1;
 
        // If the current sub-array has only one element, no need to recur
        if (low == high) {
            return root;
        }
 
        // Search for the first element greater than root
        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.val) {
                break;
            }
        }
 
        // Use the index of element found in preorder to divide preorder array in
        // two parts. Left subtree and right subtree
        root.left = buildBSTUsingPreorderOnly(pre, preIndex, i - 1);
        root.right = buildBSTUsingPreorderOnly(pre, i, high);
 
        return root;
		
	}
	
	static TreeNode constructBSTTreeNaiveAlgo(int pre[], int size) {
        return buildBSTUsingPreorderOnly(pre, 0, size - 1);
    }
	
	
	TreeNode constructTreeUtil(int pre[],
            int min, int max, int size) {
 
        // Base case
        if (preIndex >= size) {
            return null;
        }
 
        TreeNode root = null;
 
        // If current element of pre[] is in range, then
        // only it is part of current subtree
        
       int  key = pre[preIndex];
        if (key <= min || key >= max) {
        	return null;
        }
 
        root = new TreeNode(key);
        preIndex = preIndex + 1;
 
        if (preIndex < size) {
 
                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre,
                        min, key, size);
                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre,
                        key, max, size);
        }
        
        return root;
    }
 
       
 
    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil() and constructs tree in O(n)
    TreeNode constructBSTEfficiently(int pre[], int size) {
        return constructTreeUtil(pre, Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
    }
 
	
	
	
	public static void main(String[] args) {
		List<Integer> inorderList = new ArrayList<Integer>();
		inorderList.add(4);
		inorderList.add(2);
		inorderList.add(5);
		inorderList.add(1);
		inorderList.add(6);
		inorderList.add(3);
		inorderList.add(7);
		
		List<Integer> preorderList = new ArrayList<Integer>();
		preorderList.add(1);
		preorderList.add(2);
		preorderList.add(4);
		preorderList.add(5);
		preorderList.add(3);
		preorderList.add(6);
		preorderList.add(7);
		
		//TreeNode root = buildBinaryTree(inorderList,preorderList,0,preorderList.size()-1);
		
		//BinaryTree tree = new BinaryTree();
        /*int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TreeNode root = constructTree(pre, size);*/
        //System.out.println("Inorder traversal of the constructed tree is ");
        //tree.printInorder(root);
		BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
		TreeNode tree = new TreeNode();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TreeNode root = buildBinaryTree.constructBSTEfficiently(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
		
		printBinaryTree(root);
	}
	
}
