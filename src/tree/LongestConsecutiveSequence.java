package tree;

public class LongestConsecutiveSequence {
	
	static int result;
	
	void getLongestConsecutiveSequenceLength(TreeNode root, int curLength, int expected){
		
		if(root == null)
			return;
		
		if(root.val == expected)
			curLength++;
		else
			curLength=1;
		
		
		result = Math.max(result, curLength);
		
		getLongestConsecutiveSequenceLength(root.left, curLength ,root.val+1);
		getLongestConsecutiveSequenceLength(root.right, curLength ,root.val+1);
		
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

		   TreeNode root = new TreeNode(3);
			root.left = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.right= new TreeNode(4);
			root.right.left = new TreeNode(5);
			root.right.right = new TreeNode(6);
			root.right.right.left = new TreeNode(7);
		longestConsecutiveSequence.getLongestConsecutiveSequenceLength(root, 1, root.val);
		System.out.println("Length of Longest Consecutive Suqsequence is "+result);
	}
	
}
