package graph;

import java.util.Arrays;

/**
 * @author girish_lalwani
 *
 *video is better than below code https://www.youtube.com/watch?v=mJVQL-deD7A&t=242s
 *
 *Formula is Total Couples - Number of Connected Components 
 *
 *and will union members using couch formula that row[2*i]/2 to row[2*i+1]/2, if they will be on same
 *couch then they will not be unioned and if they will be on different couch then they will be unioned,
 *started number of disconnected components count to N/2.  
 */
public class CoupleHands {

	 private class UF {
	        private int[] parents;
	        public int count;
	        UF(int n) {
	            parents = new int[n];
	            for (int i = 0; i < n; i++) {
	                parents[i] = i;
	            }
	            count = n;
	        }
	        
	        private int find(int i) {
	            if (parents[i] == i) {
	                return i;
	            }
	            parents[i] = find(parents[i]);
	            return parents[i];
	        }
	        
	        public void union(int i, int j) {
	            int a = find(i);
	            int b = find(j);
	            if (a != b) {
	                parents[a] = b;
	                count--;
	            }
	        }
	    }
	    public int minSwapsCouples(int[] row) {
	        int N = row.length/ 2;
	        UF uf = new UF(N);
	        for (int i = 0; i < N; i++) {
	            int a = row[2*i];
	            int b = row[2*i + 1];
	            uf.union(a/2, b/2);
	        }
	        return N - uf.count;
	    }
}
