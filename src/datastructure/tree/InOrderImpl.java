package datastructure.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderImpl {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
 
        if(root == null)
            return returnList;
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
 
        while(!stack.empty() || p!=null){
 
            if(p != null){
                stack.push(p);
                p=p.left;
            }
            
            else
            {
            	TreeNode t = stack.pop();
            	returnList.add(t.data);
            	p=t.right;
            }
 
        }
        return returnList;
    }
	
	public static void main(String args[])
	{
		
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(14);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(8);
		TreeNode t6 = new TreeNode(12);
		TreeNode t7 = new TreeNode(16);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		InOrderImpl inOrderImpl = new InOrderImpl();
		
		System.out.println(inOrderImpl.inorderTraversal(t1));
	}
	
}
	