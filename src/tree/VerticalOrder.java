package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author girish_lalwani
 *
 *can only we done using BFS not DFS,
 *							
 *for example check for 3,9,20,null,null,15,7,null,10,null,null,null,20....
 *
 *TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(10);
		root.right.left.right = new TreeNode(20);
		
	as through DFS there could be the case that bottom one will be added first for that HD, then top 
	one in the list of that HD.
	But we have to add first element to list of HD which comes level wise first. Hence BFS.	
 */
public class VerticalOrder {

    
    class TreeNodeWithHD{
        public TreeNode node;
        public int hd;
        public TreeNodeWithHD(TreeNode node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    Map<Integer,List<Integer>> map = new TreeMap<>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNodeWithHD> q = new LinkedList<>(); 
        TreeNodeWithHD nodeWithHD = new TreeNodeWithHD(root,0);
        q.add(nodeWithHD);
        while(!q.isEmpty()){
            TreeNodeWithHD node = q.poll();
            int hd = node.hd;
            TreeNode tNode = node.node;
            if(map.containsKey(hd)){
                map.get(hd).add(tNode.val);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(tNode.val);
                map.put(hd,list);
            }
            if(tNode.left!=null){
                TreeNodeWithHD tNodeLeft = new TreeNodeWithHD(tNode.left,hd-1);
                q.add(tNodeLeft);
            }
            if(tNode.right!=null){
                TreeNodeWithHD tNodeRight = new TreeNodeWithHD(tNode.right,hd+1);
                q.add(tNodeRight);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(List<Integer> list: map.values()){
            res.add(list);
        }
        
        return res;
    }
}
