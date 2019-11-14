package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class WorkerBikeAssociation{
	public int workerIndex;
	public int bikeIndex;
	public int manhattanDistance;
	
	public WorkerBikeAssociation(int wI, int bI, int mD){
		this.workerIndex = wI;
		this.bikeIndex = bI;
		this.manhattanDistance = mD;
	}
	
}

public class CampusBikes {

	 public static int[] assignBikes(int[][] workers, int[][] bikes) 
	    {
		 	int N = workers.length;
	        int M = bikes.length;
	        WorkerBikeAssociation[] workerBikeAssociations = new WorkerBikeAssociation[N*M];
	        int k=0;
	        for (int i = 0; i < N; ++i)
	        {
	            for (int j = 0; j < M; ++j)
	            {
	                WorkerBikeAssociation workerBikeAssociation = new WorkerBikeAssociation(i,j,Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]));
	                workerBikeAssociations[k++] = workerBikeAssociation;
	            }
	        }
	        
	        Arrays.sort(workerBikeAssociations,new Comparator<WorkerBikeAssociation>() {
	        	@Override
	        	public int compare(WorkerBikeAssociation wBA1, WorkerBikeAssociation wBA2) {
	        		if(wBA1.manhattanDistance == wBA2.manhattanDistance) {
	        			if(wBA1.workerIndex == wBA2.workerIndex) {
	        				return wBA1.bikeIndex - wBA2.bikeIndex;
	        			}
	        			return wBA1.workerIndex - wBA2.workerIndex;
	        		}else {
	        			return wBA1.manhattanDistance - wBA2.manhattanDistance;
	        		}
	        	}
			});
	        int i=0;
	        int[] result = new int[N];
	        Arrays.fill(result, -1);
	        Set<Integer> used_bikes = new HashSet<>();
	        while (used_bikes.size() < N)
	        {
	        	WorkerBikeAssociation workerBikeAssociation = workerBikeAssociations[i++];
	        	if(result[workerBikeAssociation.workerIndex] == -1 && !used_bikes.contains(workerBikeAssociation.bikeIndex)) {
	        		result[workerBikeAssociation.workerIndex] = workerBikeAssociation.bikeIndex;
	        		used_bikes.add(workerBikeAssociation.bikeIndex);
	        	}
	        }
	        
	        return result;
	    }
	 
	 public int[] assignBikesUsingCountingSort(int[][] workers, int[][] bikes) {
	        // Notice that the Manhattan distance is between 0 and 2000, 
	        // which means we can sort easily without even using priority queue
	        int w = workers.length, b = bikes.length;
	        int[] wo = new int[w], bi = new int[b];
	        List<int[]>[] dists = new List[2001];
	        Arrays.fill(wo, -1);
	        Arrays.fill(bi, -1);
	        for (int i = 0; i < w; i++) {
	            for (int j = 0; j < b; j++) {
	                int[] worker = workers[i];
	                int[] bike = bikes[j];
	                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	                if (dists[dist] == null) {
	                    dists[dist] = new ArrayList<int[]>();
	                }
	                dists[dist].add(new int[]{i, j});
	            }
	        }
	        int assigned = 0;
	        for (int i = 0; i <= 2000 && assigned < w; i++) {
	            if (dists[i] == null) continue;
	            for (int[] pair : dists[i]) {
	                if (wo[pair[0]] == -1 && bi[pair[1]] == -1) {
	                    wo[pair[0]] = pair[1];
	                    bi[pair[1]] = pair[0];
	                    assigned++;
	                }
	            }
	        }
	        return wo;
	    }
	 
	 
//	 As the question states, there are n workers and m bikes, and m > n.
//	 We are able to solve this question using a greedy approach.
//
//	 initiate a priority queue of bike and worker pairs. The heap order should be Distance ASC, WorkerIndex ASC, Bike ASC
//	 Loop through all workers and bikes, calculate their distance, and then throw it to the queue.
//	 Initiate a set to keep track of the bikes that have been assigned.
//	 initiate a result array and fill it with -1. (unassigned)
//	 poll every possible pair from the priority queue and check if the person already got his bike or the bike has been assigned.
//	 early exist on every people got their bike.

	    public int[] assignBikesUsingPQ(int[][] workers, int[][] bikes) {
	         int n = workers.length;
	         
	         // order by Distance ASC, WorkerIndex ASC, BikeIndex ASC
	         PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
	             int comp = Integer.compare(a[0], b[0]);
	             if (comp == 0) {
	                 if (a[1] == b[1]) {
	                     return Integer.compare(a[2], b[2]);
	                 }
	                 
	                 return Integer.compare(a[1], b[1]);
	             }
	             
	             return comp;
	         });
	             
	         // loop through every possible pairs of bikes and people,
	         // calculate their distance, and then throw it to the pq.
	         for (int i = 0; i < workers.length; i++) {
	             
	             int[] worker = workers[i];
	             for (int j = 0; j < bikes.length; j++) {
	                 int[] bike = bikes[j];
	                 int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
	                 q.add(new int[]{dist, i, j}); 
	             }
	         }
	         
	         // init the result array with state of 'unvisited'.
	         int[] res = new int[n];
	         Arrays.fill(res, -1);
	         
	         // assign the bikes.
	         Set<Integer> bikeAssigned = new HashSet<>();
	         while (bikeAssigned.size() < n) {
	             int[] workerAndBikePair = q.poll();
	             if (res[workerAndBikePair[1]] == -1 
	                 && !bikeAssigned.contains(workerAndBikePair[2])) {   
	                 
	                 res[workerAndBikePair[1]] = workerAndBikePair[2];
	                 bikeAssigned.add(workerAndBikePair[2]);
	             }
	         }
	         
	         return res;
	     }
	
	public static void main(String[] args) {
		int[][] workers = {{0,0},{1,1},{2,0}};
		int[][] bikes = {{1,0},{2,2},{2,1}};
		System.out.println(Arrays.toString(assignBikes(workers, bikes)));
	}
	
}
