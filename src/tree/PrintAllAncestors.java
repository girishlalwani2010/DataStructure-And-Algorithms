package tree;

public class PrintAllAncestors {

	private boolean getAllAncestors(TreeNode root, TreeNode node){
		
		if((root.left.val == node.val) || (root.right.val == node.val) || getAllAncestors(root.left, node) || getAllAncestors(root.right, node)){
			System.out.println(root.val);
			return true;
		}
		
		return false;
	}	
	
	
    boolean printAncestors(TreeNode node, int target)  
    { 
         /* base cases */
        if (node == null) 
            return false; 
   
        if (node.val == target) 
            return true; 
   
        /* If target is present in either left or right subtree  
           of this node, then print this node */
        if (printAncestors(node.left, target) 
                || printAncestors(node.right, target))  
        { 
            System.out.print(node.val + " "); 
            return true; 
        } 
   
        /* Else return false */
        return false; 
    } 
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode node = new TreeNode(5);
		PrintAllAncestors printAllAncestors = new PrintAllAncestors();
		printAllAncestors.getAllAncestors(root,node);
	}
	
}
