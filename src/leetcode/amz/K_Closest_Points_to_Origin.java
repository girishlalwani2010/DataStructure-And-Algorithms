package leetcode.amz;

import java.util.Arrays;
import java.util.Comparator;

public class K_Closest_Points_to_Origin {
	
	public static int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] point1, int[] point2) {
				return (point1[0]*point1[0] + point1[1]*point1[1]) - 
				(point2[0]*point2[0] + point2[1]*point2[1]);
			}
		});
		
		int[][] points1 = new int[K][2];
		for(int i=0; i<K; i++) {
			points1[i] = points[i];
		}
		return points1;
	}
	
	public static void main(String[] args) {
		int [][]points = {{3,3},{5,-1},{-2,4}};
		kClosest(points,2);
		
	}
}

