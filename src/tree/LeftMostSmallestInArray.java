package tree;

import java.util.Arrays;

public class LeftMostSmallestInArray {
	public static int[] findLeftmostMin(int[] arr) {
	    if(arr == null) return null;
	    if(arr.length < 2) return new int[]{-1};

	    int[] ans = new int[arr.length];
	    TreeNode root = new TreeNode(arr[0]);
	    ans[0] = -1;
	    TreeNode node = null;
	    for(int i=1;i<arr.length;i++) {
	        node = root;
	        while(node != null) {
	            if(arr[i] > node.val) {
	                ans[i] = node.val;
	                break;
	            }
	            else if(node.left == null) {
	                node.left = new TreeNode(arr[i]);
	                ans[i] = -1;
	                break;
	            } else {
	                node = node.left;
	            }
	        }
	    }

	    return ans;
	}
	
	public static void main(String[] args) {
		int []arr = {2,1,3,2,1,3};
		System.out.println(Arrays.toString(findLeftmostMin(arr)));
		int xor = 0;
		for(int i=1; i<4; i++) {
			xor ^= i;
		}
		System.out.println(xor);
	}
	

}
