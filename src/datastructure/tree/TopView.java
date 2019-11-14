package datastructure.tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class TreeNodeWithHd {
	int data;
	int hd;
	TreeNodeWithHd left;
	TreeNodeWithHd right;

	TreeNodeWithHd(int data) {
		this.data = data;
	}

}

class MapEntry {
	int nodeValue;
	int nodeLevel;

	public MapEntry(int value, int level) {
		nodeValue = value;
		nodeLevel = level;
	}
}

public class TopView {
	
	 static TreeNode root;

	private Map<Integer,Integer> printTopView(TreeNodeWithHd root) {

		Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		Queue<TreeNodeWithHd> queue = new LinkedList<TreeNodeWithHd>();
		queue.add(root);
		while (!queue.isEmpty()) {

			TreeNodeWithHd treeNodeWithHd = queue.poll();

			int hd = treeNodeWithHd.hd;

			if (!treeMap.containsKey(hd)) {
				treeMap.put(hd, treeNodeWithHd.data);
			}

			if (treeNodeWithHd.left != null) {
				treeNodeWithHd.left.hd = hd - 1;
				queue.add(treeNodeWithHd.left);
			}

			if (treeNodeWithHd.right != null) {
				treeNodeWithHd.right.hd = hd + 1;
				queue.add(treeNodeWithHd.right);
			}

		}
		
		return treeMap;

	}

	/*
	 * private void printTopViewInIncreadingHDOrder(TreeNodeWithHd root){
	 * Set<Integer> set = new HashSet<Integer>(); Stack<TreeNodeWithHd> stack =
	 * new Stack<TreeNodeWithHd>(); TreeNodeWithHd p = root;
	 * while(!stack.isEmpty() || p!=null){
	 * 
	 * if(p != null){ stack.push(p); if(p.left!=null){ p.left.hd = p.hd - 1; } p
	 * = p.left; }
	 * 
	 * else{ TreeNodeWithHd t = stack.pop();
	 * 
	 * int hd = t.hd;
	 * 
	 * if(!set.contains(hd)){ System.out.println(t.data); set.add(hd); }
	 * 
	 * if(t.right!=null){ t.right.hd =t.hd+1; } p = t.right;
	 * 
	 * }
	 * 
	 * } }
	 */

	
	public static void main(String[] args) {
		
		TreeNodeWithHd root = new TreeNodeWithHd(1);
		root.left = new TreeNodeWithHd(2);
		root.right = new TreeNodeWithHd(3);
		root.left.left = new TreeNodeWithHd(4);
		root.left.right = new TreeNodeWithHd(5);
		root.right.left = new TreeNodeWithHd(6);
		root.right.right = new TreeNodeWithHd(7);
		 

		// TopView topView = new TopView();
		// topView.printTopViewInIncreadingHDOrder(root);

		/*root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);*/

		TopView topView = new TopView();
		Map<Integer,Integer> map = topView.printTopView(root);
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			System.out.print(entry.getValue()+" ");
		}

	}
}
