package datastructure.tree;

import java.util.ArrayList;
import java.util.Stack;

public class AddAllGreaterValuesToNode {
	
	
	private int sumOfAllNodes(TreeNode root){
		
		if(root == null){
			return 0;
		}
		
		return root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
		
	}
	
	
	private TreeNode addAllGreaterValuesToNode(TreeNode root){
		
		ArrayList<Integer> returnList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int sum = sumOfAllNodes(root);
 
        while(!stack.empty() || p!=null){
 
            if(p != null){
                stack.push(p);
                p=p.left;
            }
            
            else
            {
            	TreeNode t = stack.pop();
            	int oldTData = t.data;
            	t.data = sum;
            	sum = sum - oldTData;
            	returnList.add(t.data);
            	p=t.right;
            }
 
        }
        
        System.out.println(returnList);
        
        return root;
        
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);
		
		AddAllGreaterValuesToNode addAllGreaterValuesToNode = new AddAllGreaterValuesToNode();
		TreeNode modifiedRoot = addAllGreaterValuesToNode.addAllGreaterValuesToNode(root);
		
		InOrderImpl inOrderImpl = new InOrderImpl();
		inOrderImpl.inorderTraversal(modifiedRoot);
		
		
	}
	
}
