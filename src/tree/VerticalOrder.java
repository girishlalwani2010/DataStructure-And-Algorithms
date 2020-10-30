package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

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
            
            map.computeIfAbsent(hd,x-> new ArrayList<>()).add(tNode.val);
            
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
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> treeMap = new TreeMap<>();
        verticalTraversal(treeMap, root, 0, 0);
        List<List<Integer>> verticalOrder = new ArrayList<>();
        for(Map.Entry<Integer,TreeMap<Integer, ArrayList<Integer>>> entry : treeMap.entrySet()){
            TreeMap<Integer, ArrayList<Integer>> innerMap = entry.getValue();
            List<Integer> hdList = new ArrayList<>();
            for(List<Integer> list : innerMap.values()) {
            	hdList.addAll(list);
            }
            verticalOrder.add(hdList);
        }
        return verticalOrder;
    }
    
    private void verticalTraversal(TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> treeMap, TreeNode root, int hd, int level){
        
        if(root == null){
            return;
        }
        
        treeMap.computeIfAbsent(hd,x-> new TreeMap<Integer,ArrayList<Integer>>()).computeIfAbsent(level,x->new ArrayList<>()).add(root.val);
        
        verticalTraversal(treeMap, root.left, hd-1, level+1);
        verticalTraversal(treeMap, root.right, hd+1, level+1);
    }
}
