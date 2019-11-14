package array;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {
	
	public int findDistance(int x1, int y1, int x2, int y2) {
		return Integer.max(Math.abs(x1-x2), Math.abs(y1-y2));
	}
	
	
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int totalMinDistance = 0;
		for(int i=0; i<A.size()-1; i++) {
			totalMinDistance= totalMinDistance+findDistance(A.get(i),B.get(i),A.get(i+1),B.get(i+1));
		}
		return totalMinDistance;
	}
	

}
