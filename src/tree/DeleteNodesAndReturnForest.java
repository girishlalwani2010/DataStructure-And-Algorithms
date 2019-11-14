package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {
	
	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> forest = new ArrayList<>();
		if(root == null) {
			return null;
		}
		Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
		dfs(root, set, forest);
		if(!set.contains(root.data)) {
			forest.add(root);
		}
		return forest;
	}

    private static TreeNode dfs(TreeNode node, Set<Integer> toBeDeleted, List<TreeNode> forest) {
    	
    	if(node == null) {
    		return null;
    	}
    	
    	node.left = dfs(node.left, toBeDeleted, forest);
    	node.right = dfs(node.right, toBeDeleted, forest);
    	
    	if(toBeDeleted.contains(node.data)) {
    		if(node.left!=null)
    			forest.add(node.left);
      		if(node.right!=null)
    			forest.add(node.right);
      		return null;
    	}
    	
    	return node;
    }
    
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		int[] to_delete = {3,5};
		List<TreeNode> forest = delNodes(node, to_delete);
		System.out.println(forest.stream().map(treeNode -> PostOrderOfBinaryTree.postorderTraversal(treeNode)).collect(Collectors.toList()));
	}

}
