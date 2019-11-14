package tree;

class TreeNodeWithRandom{
	int data;
	TreeNodeWithRandom left;
	TreeNodeWithRandom right;
	TreeNodeWithRandom random;
	public TreeNodeWithRandom(int data) {
		this.data = data;
	}
}


public class CloneBinaryTree {
	
	void cloneBinaryTree(TreeNodeWithRandom node, TreeNodeWithRandom cloneNode){
		if(node == null)
			return;
		
		cloneNode.left = node.left;
		cloneNode.right= node.right;
		cloneNode.random = node.random;
		
		if(node.left!=null){
			cloneBinaryTree(node.left, cloneNode.left);
		}
		
		if(node.right!=null){
			cloneBinaryTree(node.right, cloneNode.right);
		}
			
	}
	
	public void printInorder(TreeNodeWithRandom node)
	{
	    if (node == null)
	        return;
	 
	    /* First recur on left sutree */
	    printInorder(node.left);
	 
	    /* then print data of Node and its random */
	    System.out.print(node.data+"[");
	    if (node.random == null)
	       System.out.print("null"+"],");
	    else
	      System.out.print(node.random.data+"],"); 
	 
	    /* now recur on right subtree */
	    printInorder(node.right);
	}
	
	
	public static void main(String[] args) {
		
		TreeNodeWithRandom root = new TreeNodeWithRandom(1);
		root.left = new TreeNodeWithRandom(2);
		root.right = new TreeNodeWithRandom(3);
		root.left.left = new TreeNodeWithRandom(4);
		root.left.right = new TreeNodeWithRandom(5);
		
		root.random = root.left.left;
		root.left.random = root.left;
		root.right.random = root.left.right;
		root.left.left.random = root.right.left;
		root.left.right.random = root;
		
		TreeNodeWithRandom cloneNode = new TreeNodeWithRandom(root.data);
		
		CloneBinaryTree cloneBinaryTree = new CloneBinaryTree();
		cloneBinaryTree.cloneBinaryTree(root,cloneNode);
		cloneBinaryTree.printInorder(root);
		System.out.println();
		cloneBinaryTree.printInorder(cloneNode);
		
		
	}

}
