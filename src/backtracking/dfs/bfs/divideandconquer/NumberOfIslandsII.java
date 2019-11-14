package backtracking.dfs.bfs.divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfIslandsII {

	/**
	 * @param m
	 * @param n
	 * @param positions
	 * @return
	 * 
	 * 		Solution not Worked passed 32 test cases out of 162
	 */
	public static List<Integer> numIslands2(int m, int n, int[][] positions) {

		// Postition class can be created and come in place of Integer Key
		Map<Integer, Integer> positionToNoOfIslands = new HashMap<>();
		List<Integer> IslandsAtPos = new ArrayList<>();

		for (int i = 0; i < positions.length; i++) {
			int noOfIslands = 1;
			int currentPosIndex = calculateIndex(n, positions[i][0], positions[i][1]);

			if (positionToNoOfIslands.isEmpty()) {
				positionToNoOfIslands.put(currentPosIndex, noOfIslands);
			} else {
				for (Integer positionToNoOfIslandEntry : positionToNoOfIslands.keySet()) {

					Integer noOfIslandsAtOlderPos = positionToNoOfIslands.get(positionToNoOfIslandEntry);

					if (!(calculateIndex(n, positions[i][0] + 1, positions[i][1]) == positionToNoOfIslandEntry
							|| calculateIndex(n, positions[i][0] - 1, positions[i][1]) == positionToNoOfIslandEntry
							|| calculateIndex(n, positions[i][0], positions[i][1] + 1) == positionToNoOfIslandEntry
							|| calculateIndex(n, positions[i][0], positions[i][1] - 1) == positionToNoOfIslandEntry)) {

						if (noOfIslands <= noOfIslandsAtOlderPos) {
							noOfIslands = noOfIslandsAtOlderPos + 1;
						}

					} else {

					}

				}
			}

			positionToNoOfIslands.put(currentPosIndex, noOfIslands);
			IslandsAtPos.add(noOfIslands);
		}

		return IslandsAtPos;
	}

	private static int calculateIndex(int noOfCols, int rowNo, int colNo) {
		return rowNo * noOfCols + colNo;
	}

	/**
	 * @param m
	 * @param n
	 * @param positions
	 * @return
	 * 
	 * 		Awesome solution
	 * 
	 */
	public List<Integer> workingumIslands2(int m, int n, int[][] positions) {
		List<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> land2id = new HashMap<Integer, Integer>();
		int num_islands = 0;
		int island_id = 0;

		for (int[] pos : positions) {
			int r = pos[0], c = pos[1];
			Set<Integer> overlap = new HashSet<Integer>();

			if (r - 1 >= 0 && land2id.containsKey((r - 1) * n + c)) {
				overlap.add(land2id.get((r - 1) * n + c));
			}
			if (r + 1 < m && land2id.containsKey((r + 1) * n + c)) {
				overlap.add(land2id.get((r + 1) * n + c));
			}
			if (c - 1 >= 0 && land2id.containsKey(r * n + c - 1)) {
				overlap.add(land2id.get(r * n + c - 1));
			}
			if (c + 1 < n && land2id.containsKey(r * n + c + 1)) {
				overlap.add(land2id.get(r * n + c + 1));
			}

			if (overlap.isEmpty()) {
				++num_islands;
				land2id.put(r * n + c, island_id++);
			} else if (overlap.size() == 1) {
				land2id.put(r * n + c, overlap.iterator().next());
			} else {
				int root_id = overlap.iterator().next();
				for (Map.Entry<Integer, Integer> entry : land2id.entrySet()) {
					int k = entry.getKey();
					int id = entry.getValue();
					if (overlap.contains(id)) {
						land2id.put(k, root_id);
					}
				}
				land2id.put(r * n + c, root_id);
				num_islands -= (overlap.size() - 1);
			}
			ans.add(num_islands);
		}

		return ans;
	}

	
	//Perfect way of doing this, but will not work for duplicates
	//For Duplicates map can be used to put older values correspoding to position if same position comes than we can return NumberOfIslands from 
	//MAP
	
	 private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

	    public List<Integer> numIslands2WithUFPathCompression(int m, int n, int[][] positions) {
	        UnionFind2D islands = new UnionFind2D(m, n);
	        List<Integer> ans = new ArrayList<>();
	        for (int[] position : positions) {
	            int x = position[0], y = position[1];
	            int p = islands.add(x, y);
	            for (int[] d : dir) {
	                int q = islands.getID(x + d[0], y + d[1]);
	                if (q > 0 && !islands.find(p, q))
	                    islands.unite(p, q);
	            }
	            ans.add(islands.size());
	        }
	        return ans;
	    }

	class UnionFind2D {
	    private int[] id;
	    private int[] sz;
	    private int m, n, count;

	    public UnionFind2D(int m, int n) {
	        this.count = 0;
	        this.n = n;
	        this.m = m;
	        this.id = new int[m * n + 1];
	        this.sz = new int[m * n + 1];
	    }

	    public int index(int x, int y) { return x * n + y + 1; }

	    public int size() { return this.count; }

	    public int getID(int x, int y) {
	        if (0 <= x && x < m && 0<= y && y < n)
	            return id[index(x, y)];
	        return 0;
	    }

	    public int add(int x, int y) {
	        int i = index(x, y);
	        id[i] = i; sz[i] = 1;
	        ++count;
	        return i;
	    }

	    public boolean find(int p, int q) {
	        return root(p) == root(q);
	    }

	    public void unite(int p, int q) {
	        int i = root(p), j = root(q);
	        if (sz[i] < sz[j]) { //weighted quick union
	            id[i] = j; sz[j] += sz[i];
	        } else {
	            id[j] = i; sz[i] += sz[j];
	        }
	        --count;
	    }

	    private int root(int i) {
	        for (;i != id[i]; i = id[i])
	            id[i] = id[id[i]]; //path compression
	        return i;
	    }
	}

	public static void main(String[] args) {
		int m = 2, n = 2;
		int[][] positions = { { 0, 0 }, { 1, 1 }, { 0, 1 } };
		System.out.println(numIslands2(m, n, positions));
	}

}
