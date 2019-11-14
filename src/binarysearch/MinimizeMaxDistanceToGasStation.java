package binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStation {
	
	 public static double minmaxGasDist(int[] stations, int K) {
	        int N = stations.length;
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] a, int[] b) {
					return (double)b[0]/b[1] < ((double)a[0]/a[1]) ? -1 : 1;
				}
	        	
			});
	        for (int i = 0; i < N-1; ++i)
	            pq.add(new int[]{stations[i+1] - stations[i], 1});

	        for (int k = 0; k < K; ++k) {
	            int[] node = pq.poll();
	            node[1]++;
	            pq.add(node);
	        }
	        
	        int[] node = pq.poll();
	        return (double)node[0] / node[1];
	    }
	 
	 
	 /**
	 *  Explanation of solution
		Now we are using binary search to find the smallest possible value of D.
		I initilze left = 0 and right = the distance between the first and the last station
		count is the number of gas station we need to make it possible.
		if count > K, it means mid is too small to realize using only K more stations.
		if count <= K, it means mid is possible and we can continue to find a bigger one.
		When left + 1e-6 >= right, it means the answer within 10^-6 of the true value and it will be accepted.
	 */
	public static double minmaxGasDistWithBS(int[] stations, int K) {
	        int count, N = stations.length;
	        double left = 0, right = stations[N - 1] - stations[0], mid;

	        while (right-left>1e-6) {
	            mid = (left + right) / 2;
	            count = 0;
	            for (int i = 0; i < N - 1; ++i)
	                count += Math.floor((stations[i + 1] - stations[i]) / mid);
	            if (count > K) left = mid;
	            else right = mid;
	        }
	        return right;
	  }
	 
	 
	 public static void main(String[] args) {
		 int[] stations = {1,5,10};
		 System.out.println(minmaxGasDist(stations,3));
		 System.out.println(minmaxGasDistWithBS(stations,3));
		 System.out.println(Math.floor(1.6));
		 System.out.println(Math.ceil(Math.floor(1.6)));
	 }

}
