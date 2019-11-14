package datastructure.recursion.backtracking.dfs.bfs.divideandconquer;

import datastructure.tree.TreeNode;

/**
 * @author girish_lalwani
 *
 *https://leetcode.com/problems/binary-tree-coloring-game/discuss/350738/Easy-to-understand-for-everyone
 *
 *Count left and right children's nodes of the player 1's initial node with value x. Lets call countLeft and countRight.

# if countLeft or countRight are bigger than n/2, player 2 chooses this child of the node and will win.
# If countLeft + countRight + 1 is smaller than n/2, player 2 chooses the parent of the node and will win;
# otherwise, player 2 has not chance to win.
 */
public class BinaryTreeColoringGame {
	int xleftCount, xRightCount =0;
	
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNodes(root,x);
        
        if(xleftCount>n/2 || xRightCount>n/2)
        	return true;
        
        if(xleftCount+xRightCount+1<=n/2)
        	return true;
        
        return false;
    }
	
	int countNodes(TreeNode node, int x) {
		if(node == null) return 0;
		int l = countNodes(node.left, x);
		int r = countNodes(node.right, x);
		if(x== node.data) {
			xleftCount = l;
			xRightCount = r;
		}
		return l+r+1;
	} 

}
