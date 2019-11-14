package tree;

public class LCA {

	/**
	 * This is for Binary Tree.
	 * 
	 */
	public TreeNode findLCAOfBT(TreeNode root, int itemA, int itemB)
	{
		if(root==null)
			return null;
		//LCA can be in the Left Subtree or Right Subtree.
		if(root.data == itemA || root.data == itemB)
		{
			return root;
		}
		
		//calling recursively for left and right portion
		TreeNode left = findLCAOfBT(root.left,itemA,itemB);
		TreeNode right = findLCAOfBT(root.right,itemA,itemB);
		
		//If one node is in the Left Subtree and other in the right subtree, then LCA is root
		if(left!=null && right!=null)
		{
			return root;
		}
		
		if(left == null)
			return right;
		else 
			return left;
	
		
	}
	
	public TreeNode findLCAOfBST(TreeNode node, int n1, int n2) 
    {
        if (node == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return findLCAOfBST(node.left, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2) 
            return findLCAOfBST(node.right, n1, n2);
        
        // This Line of Code is doing the actual work, 
        // if one node lies in the left subtree and other in the right subtree, then root will be the LCA.
        // because it is the recursion which is running top to down and then it is returning to upper function where ever
        // the above two condition will be false , three cases for this 1). if n1 lies in left/right and n2 lies in right/left
        // then LCA is deeper node which is satisfying this condition, and then this node will be return to the upper calls
        // which are dependent on this function return statement.
        
        return node;
    }
	
   public static void main(String args[])
   {
	   TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		LCA lca = new LCA();
		System.out.println(lca.findLCAOfBT(root, 2, 8).data);
   }
	
	
	
}
