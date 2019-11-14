package tree;

public class TreePathsFromRootToLeaf {

	private static void printPath(int[] path, int pathLength) {
		for(int i=0; i<pathLength; i++){
			System.out.println(path[i]);
		}
		System.out.println();
	}
	
	private static void printPaths(TreeNode root, int[] path, int pathLength){
		if(root == null)
			return;
		
		path[pathLength] = root.data;
		pathLength++;
		
		if(root.left!=null && root.right!=null){
			printPath(path,pathLength);
		}
		
		else{
			printPaths(root.left,path,pathLength);
			printPaths(root.right,path,pathLength);
		}
			
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int[] path = new int[256];
		printPaths(root,path,0);
	}
	
	
}
