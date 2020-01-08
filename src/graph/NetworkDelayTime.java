package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @author girish_lalwani
 *
 *         https://leetcode.com/problems/network-delay-time/
 *
 *         Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2 Output: 2
 * 
 */
public class NetworkDelayTime {

	public int networkDelayTime(int[][] times, int N, int K) {

		int[] distance = new int[N+1];
		Arrays.fill(distance,Integer.MAX_VALUE);

		List<Boolean> settled = new ArrayList<>(Collections.nCopies(N+1, true));
		for(int i=0; i<times.length; i++) {
			settled.set(times[i][1], false);
		}
		
		distance[K] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(N, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		//S,D,C
		int[] minimumCostNode = {0,K,0};
		pq.add(minimumCostNode);
		settled.set(minimumCostNode[1], false);
		while (settled.contains(false)) {
			minimumCostNode = pq.poll();
			for (int i = 0; i < times.length; i++) {
				if (times[i][0] == minimumCostNode[1] && settled.get(minimumCostNode[1]) == false) {
					// source
					int u = times[i][0];
					// destination
					int v = times[i][1];
					// cost
					int vCost = times[i][2];
					distance[v] = Integer.min(distance[v], distance[u] + vCost);
					pq.add(times[i]);
				}
			}

			settled.set(minimumCostNode[1], true);

		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<distance.length; i++) {
			if(distance[i]>max) {
				max = distance[i];
			}
		}
		
		if(max == Integer.MAX_VALUE) {
			return -1;
		}
		
		return max;
	}

	public static void main(String[] args) {
		NetworkDelayTime nDT = new NetworkDelayTime();
		int times[][] = {{2,1,1},{2,3,1},{3,4,1}};
		System.out.println(nDT.networkDelayTime(times, 4, 2));
		
	}

}
