package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin {
	
	public int getDistance(int[] point) {
		return point[0]*point[0] + point[1]*point[1];
	}
	
	public int[][] kClosest(int[][] points, int K) {
		 Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
        	 public int compare(int[] o1, int[] o2){
                 return  getDistance(o2)-getDistance(o1); 
             }
        });
        
        for(int[] point : points) {
        	if(priorityQueue.size()<K) {
        		priorityQueue.offer(point);
        	}else{
        		if(getDistance(priorityQueue.peek())>getDistance(point)) {
        			priorityQueue.poll();
        			priorityQueue.offer(point);
        		}
        	}
        	
        }
        
        int[][] result = new int[K][2];
        
        for(int i=0; i<K; i++) {
        	result[i] = priorityQueue.poll();
        }
        return result;
	}

}
