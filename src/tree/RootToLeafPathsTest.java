package tree;
import java.util.ArrayList;

	public class RootToLeafPathsTest {
	    public static void main(String[] args) {
	        PrintAllRootToLeafPaths printAllRootToLeafPaths = new PrintAllRootToLeafPaths();

	 	   TreeNode root = new TreeNode(1);
	 		root.left = new TreeNode(2);
	 		root.right = new TreeNode(3);
	 		root.left.left = new TreeNode(4);
	 		root.left.right = new TreeNode(5);
	 		root.right.left = new TreeNode(6);
	 		root.right.right = new TreeNode(7);
	        printAllRootToLeafPaths.printRootToLeafPaths(root);
	    }
	}
	
	class PrintAllRootToLeafPaths {	    
	    private TreeNode root;
	
	    public TreeNode getRoot() {
	        return root;
	    }
	
	    public void printRootToLeafPaths(TreeNode root) {
	       
	        ArrayList<Integer> path = new ArrayList<Integer>();
	        printRootToLeafPaths(root, path);
	    }
	
	    private void printRootToLeafPaths(TreeNode root, ArrayList<Integer> path) {
	    	 if(root == null) {
		            return;
		        }
	        path.add(root.data);
	        
	        if(root.left == null && root.right == null) {
	            printList(path);
	            return;
	        }
	        printRootToLeafPaths(root.left,new ArrayList<Integer>(path));
	        printRootToLeafPaths(root.right,new ArrayList<Integer>(path));
	    }
	
	    private void printList(ArrayList<Integer> path) {
	        for(Integer i: path) {
	            System.out.print(i + " " );
	        }
	        System.out.println();
	    }
	
	    public void setRoot(TreeNode root) {
	        this.root = root;
	    }

		public void bottomView() {
			// TODO Auto-generated method stub
			
		}
	    
	    
	}
	
	