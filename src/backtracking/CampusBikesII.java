package backtracking;

/**
 * @author girish_lalwani
 *Need to do that using DP.
 */
public class CampusBikesII {

	private static int min = Integer.MAX_VALUE;
	private static boolean[] visit;

	public static int assignBikes(int[][] workers, int[][] bikes) {
		visit = new boolean[bikes.length];
		dfs(visit, workers, 0, bikes, 0);
		return min;
	}

	/**
	 * @param visit
	 * @param workers
	 * @param i
	 * @param bikes
	 * @param distance
	 * 
	 * wi,bi steps in backtracking
	 * 0,0  0,0  0,1  0,1  0,2   0,2      
	   1,1  1,2  1,0  1,2  1,0   1,1
	   2,2  2,1  2,2  2,0  2,1   2,0
	 */
	public static void dfs(boolean[] visit, int[][] workers, int i, int[][] bikes, int distance) {
		if (i >= workers.length) {
			min = Math.min(distance, min);
			return;
		}
		if (distance > min) {
			return;
		}
		for (int j = 0; j < bikes.length; j++) {
			if (visit[j]) {
				continue;
			}
			visit[j] = true;
			System.out.println("WorkerIndex: ["+i+"]"+", "+"BikeIndex: ["+j+"]");
			dfs(visit, workers, i + 1, bikes, distance + dis(bikes[j], workers[i]));
			visit[j] = false;
		}

	}

	public static int dis(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

	public static void main(String[] args) {
		int[][] workers = {{0,0},{1,1},{2,0}};
		int[][] bikes = {{1,0},{2,2},{2,1}};
		System.out.println(assignBikes(workers, bikes));
	}

}
