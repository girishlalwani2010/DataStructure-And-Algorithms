package tree;

public class SubtreeofAnotherTree {
	
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        if(t==null && s==null){
	            return true;
	        }
	        if(s == null || t == null){
	            return false;
	        }
	        return treeMatch(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
	    }
	    
	    private boolean treeMatch(TreeNode s, TreeNode t){
	        if(t==null && s==null){
	            return true;
	        }
	        if(s == null || t == null){
	            return false;
	        }
	        return t.val==s.val && treeMatch(s.left,t.left) && treeMatch(s.right,t.right);
	    }

}
