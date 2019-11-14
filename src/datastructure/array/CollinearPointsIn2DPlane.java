package datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class CollinearPointsIn2DPlane {
	
	public static int maxPoints(int[][] points) {
		if(points.length == 0) {
			return 0;
		}
		int maxCollinearPoints=1;
       for(int i=0; i<points.length-1; i++) {
    	   int duplicatesCount=0;
    	   int currentMaxCollinearPoints =1;
    	   Map<Double,Integer> map = new HashMap<>();
    	   for(int j=i+1; j<points.length; j++) {
    		   int jthSlopeOccs = 0;
			    if((points[i][0] == points[j][0]) && (points[i][1] == points[j][1])) {
			    	duplicatesCount++;
			    }
			    else {
				    double slope=Double.MAX_VALUE;
				    if((points[i][0]-points[j][0]) != 0) {
				    	slope = ((double)(points[i][1]-points[j][1]))/((double)(points[i][0]-points[j][0]));
				    	if(Math.abs(slope) == 0) {
				    		slope=0;
				    	}
				    }
				    if(map.containsKey(slope)) {
				    	jthSlopeOccs = map.get(slope);
				    	++jthSlopeOccs;
				    	map.put(slope, jthSlopeOccs);
				    	
				    }else {
				    	map.put(slope, 2);
				    	jthSlopeOccs =2;
				    }
					    if(currentMaxCollinearPoints<jthSlopeOccs) {
					    	currentMaxCollinearPoints = jthSlopeOccs;
				    	}
			    }
    	   }
    	   duplicatesCount = duplicatesCount + currentMaxCollinearPoints;
    	   if(maxCollinearPoints<duplicatesCount) {
    		   maxCollinearPoints = duplicatesCount;
    	   }
       }
       return maxCollinearPoints;
	}
	
	public static void main(String[] args) {
		//int [][]points = {{0,0},{1,1},{1,-1}};
		int [][]points = {{0,0},{94911151,94911150},{94911152,94911151}};
		//int [][]points = {{1,1},{2,2},{3,3}};
		//int [][]points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		System.out.println(maxPoints(points));
	}

}
