package tree;
import java.util.ArrayList;
import java.util.List;

	public class RootToLeafPathsTest {
	    public static void main(String[] args) {
	        PrintAllRootToLeafPaths printAllRootToLeafPaths = new PrintAllRootToLeafPaths();

	 	   TreeNode root = new TreeNode(1);
	 		root.left = new TreeNode(2);
	 		root.right = new TreeNode(3);
	 		root.left.left = new TreeNode(4);
	 		root.left.right = new TreeNode(5);
	 		root.right.left = new TreeNode(6);
//	 		root.right.right = new TreeNode(7);
	        printAllRootToLeafPaths.printRootToLeafPaths(root);
	    }
	}
	
	class PrintAllRootToLeafPaths {	    
	    private TreeNode root;
	
	    public TreeNode getRoot() {
	        return root;
	    }
	
	    public void printRootToLeafPaths(TreeNode root) {
	        List<List<Integer>> paths = new ArrayList<>();
	        printRootToLeafPaths(root, paths, new ArrayList<>());
	        System.out.println(paths);
	    }
	
	    private void printRootToLeafPaths(TreeNode root, List<List<Integer>> paths, List<Integer> currPath) {
	    	if(root == null) {
	    		return;
	    	}
	    	currPath.add(root.val);
	    	if(root.left == null && root.right == null) {
	    		paths.add(new ArrayList<>(currPath));
	    		return;
	    	}
	    	printRootToLeafPaths(root.left, paths, currPath);
	    	if(root.left!=null) {
	    		currPath.remove(currPath.size()-1);
	    	}
	    	printRootToLeafPaths(root.right, paths, currPath);
	    	if(root.right!=null) {
	    		currPath.remove(currPath.size()-1);
	    	}
	    }
	
	    public void setRoot(TreeNode root) {
	        this.root = root;
	    }

		public void bottomView() {
			// TODO Auto-generated method stub
			
		}
	    
	    
	}
	
	