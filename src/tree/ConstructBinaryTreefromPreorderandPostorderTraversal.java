package tree;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal {
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(0,pre.length-1,pre,post);
    }
    
    int preIndex=0;
    
    public TreeNode constructFromPrePost(int st, int end, int[] pre, int[] post){
        
        if(st>end){
            return null;
        }
        
        TreeNode newNode = new TreeNode(pre[preIndex++]);
        
        if(st==end){
            return newNode;
        }
        int i =0;
        for(i=st; i<=end; i++){
            if(post[i] == pre[preIndex]){
                break;
            }
        }
        
        newNode.left = constructFromPrePost(st, i, pre, post);
        newNode.right = constructFromPrePost(i+1, end-1, pre, post);
        
        return newNode;        
    }

}
