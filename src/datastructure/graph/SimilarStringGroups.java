package datastructure.graph;


class WeightedQuickUnion{
	
	private int noOfDisconnectedComponents;
	private int[] parent;
	private int[] size;
	
	public WeightedQuickUnion(String words[]) {
		parent = new int[words.length];
		size = new int[words.length];
		for(int i=0; i<words.length; i++) {
			parent[i] = i;
			size[i]=1;
			noOfDisconnectedComponents++;
		}
	}
	
	public int find(int p) {
		while(p!=parent[p]) {
			p=parent[p];
		}
		return p;
	}
	
	
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP == rootQ)
			return;
		if(size[rootP]>size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		noOfDisconnectedComponents--;
	}
	
	public int getNoOfDisconnectedComponents() {
		return noOfDisconnectedComponents;
	}
		
}
public class SimilarStringGroups {
	
	public boolean isCharDifferenceTwo(String s1, String s2) {
		int charDifference = 0;
		char[] charS1 = s1.toCharArray();
		char[] charS2 = s2.toCharArray();
		for(int i=0; i<s1.length(); i++) {
			if(charS1[i] != charS2[i]) {
				charDifference++;
			}
			if(charDifference>2) {
				return false;
			}
		}
		if(charDifference<=2) {
			return true;
		}else {
			return false;
		}
	}
	
	 public int numSimilarGroups(String[] A) {
		 
		 WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(A);
		 
		 for(int i=0; i<A.length; i++) {
			 for(int j=i+1; j<A.length; j++) {
				 if(isCharDifferenceTwo(A[i], A[j])) {
					 weightedQuickUnion.union(i,j);
					 if(weightedQuickUnion.getNoOfDisconnectedComponents() ==1) {
						 return 1;
					 }
				 }
			 }
		 }
		 
		 return weightedQuickUnion.getNoOfDisconnectedComponents();
	        
	 }
	 
	 public static void main(String[] args) {
		SimilarStringGroups similarStringGroups = new SimilarStringGroups();
		String[] A = {"tars","rats","arts","star"};
		System.out.println(similarStringGroups.numSimilarGroups(A));
	}

}
