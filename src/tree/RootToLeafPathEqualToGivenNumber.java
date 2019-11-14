package tree;

public class RootToLeafPathEqualToGivenNumber {
	
	boolean rootToLeafPath(TreeNode node, int givenNumber){
		
		if(node==null)
			return false;
		
		givenNumber = givenNumber - node.data;
		
		if(node.left == null && node.right==null){
			return (givenNumber == 0);
		}
		
		return (rootToLeafPath(node.left, givenNumber)||rootToLeafPath(node.right, givenNumber));
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(8);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(2);
		RootToLeafPathEqualToGivenNumber rootToLeafPathEqualToGivenNumber = new RootToLeafPathEqualToGivenNumber();
		System.out.println(rootToLeafPathEqualToGivenNumber.rootToLeafPath(node, 15));
	}

}
