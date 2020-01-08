package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author girish_lalwani
 *
 *https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/SerializeDeserializeBinaryTree/SerializeDeserializeBinaryTree.java
 *
 *https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {

	    // Encodes a tree to a single string.
	    final String DELIMETER = ",";
	    final String NULL_STRING = "N";
	    public String serialize(TreeNode root) {
	        if(root == null){
	            return NULL_STRING+DELIMETER;
	        }
	        String left = serialize(root.left);
	        String right = serialize(root.right);
	        return root.val+DELIMETER+left+right;
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        // queue just used as a data-structure to poll from front. As we need to poll from front 
	        Queue<String> queue = new LinkedList<>();
	        queue.addAll(Arrays.asList(data.split(DELIMETER)));
	        return deserialize(queue);
	    }
	    
	    public TreeNode deserialize(Queue<String> q) {
	        String str = q.poll();
	        if(str.equals(NULL_STRING)){
	          return null;  
	        }
	        TreeNode newNode = new TreeNode(Integer.valueOf(str));
	        newNode.left = deserialize(q);
	        newNode.right = deserialize(q);
	        return newNode;
	    }
	    
	    
	}
