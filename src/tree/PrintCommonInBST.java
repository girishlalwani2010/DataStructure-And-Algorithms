package tree;

import java.util.Stack;

//https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
	

/**
 * @author girish_lalwani
 *
 *
 *Method 2 (Linear Time) We can find common elements in O(n) time.
1) Do inorder traversal of first tree and store the traversal in an auxiliary array ar1[]. See sortedInorder() here.
2) Do inorder traversal of second tree and store the traversal in an auxiliary array ar2[]
3) Find intersection of ar1[] and ar2[]. See this for details.

Time complexity of this method is O(m+n) where m and n are number of nodes in first and second tree respectively. This solution requires O(m+n) extra space.

Method 3 (Linear Time and limited Extra Space) We can find common elements in O(n) time and O(h1 + h2) extra space where h1 and h2 are heights of first and second BSTs respectively.
The idea is to use iterative inorder traversal. We use two auxiliary stacks for two BSTs. Since we need to find common elements, whenever we get same element, we print it.
 */
public class PrintCommonInBST {

	void printCommon(TreeNode root1, TreeNode root2)
	{
	    // Create two stacks for two inorder traversals
	    Stack<TreeNode> s1 = new Stack();
	    Stack<TreeNode> s2 = new Stack();
	 
	    while (true)
	    {
	        // push the Nodes of first tree in stack s1
	        if (root1!=null)
	        {
	            s1.push(root1);
	            root1 = root1.left;
	        }
	 
	        // push the Nodes of second tree in stack s2
	        else if (root2!=null)
	        {
	            s2.push(root2);
	            root2 = root2.left;
	        }
	 
	        // Both root1 and root2 are NULL here
	        else if (!s1.empty() && !s2.empty())
	        {
	            root1 = s1.peek();
	            root2 = s2.peek();
	 
	            // If current keys in two trees are same
	            if (root1.val == root2.val)
	            {
	                System.out.print(root1.val+" ");
	                s1.pop();
	                s2.pop();
	 
	                // move to the inorder successor
	                root1 = root1.right;
	                root2 = root2.right;
	            }
	 
	            else if (root1.val < root2.val)
	            {
	                // If Node of first tree is smaller, than that of
	                // second tree, then its obvious that the inorder
	                // successors of current Node can have same value
	                // as that of the second tree Node. Thus, we pop
	                // from s2
	                s1.pop();
	                root1 = root1.right;
	 
	                // root2 is set to NULL, because we need
	                // new Nodes of tree 1
	                root2 = null;
	            }
	            else if (root1.val > root2.val)
	            {
	                s2.pop();
	                root2 = root2.right;
	                root1 = null;
	            }
	        }
	 
	        // Both roots and both stacks are empty
	        else  break;
	    }
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(10);
		root1.left.left = new TreeNode(0);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(7);
		root1.right.left.right = new TreeNode(9);
		
		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(7);
		root2.right = new TreeNode(20);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(9);
		
		PrintCommonInBST printCommonInBST = new PrintCommonInBST();
		printCommonInBST.printCommon(root1, root2);
		
	}
	
}
