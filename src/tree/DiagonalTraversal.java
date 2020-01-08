package tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DiagonalTraversal {
	
	public static void print(TreeNode root) {
        Map<Integer, List<Integer>> diagonalMap = new LinkedHashMap<>();
        printHelper(root, diagonalMap, 0);

        for (Map.Entry<Integer, List<Integer>> entry : diagonalMap.entrySet()) {
            System.out.printf("Diagonal : %d, Nodes: %s\n", entry.getKey(), entry.getValue());
        }

    }

    private static void printHelper(TreeNode node, Map<Integer, List<Integer>> diagonalMap, int diagonal) {

        if (Objects.isNull(node)) {
            return;
        }

        List<Integer> diagonalNodes = diagonalMap.getOrDefault(diagonal, new ArrayList<>());
        diagonalNodes.add(node.val);
        diagonalMap.put(diagonal, diagonalNodes);

        printHelper(node.left, diagonalMap, diagonal + 1);
        printHelper(node.right, diagonalMap, diagonal);

    }
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		print(root);
		
		
	}

}
