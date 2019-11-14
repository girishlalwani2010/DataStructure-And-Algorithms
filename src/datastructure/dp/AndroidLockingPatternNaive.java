package datastructure.dp;

public class AndroidLockingPatternNaive {
	static int result;
	    public static int numberOfPatterns(int m, int n) {
	        boolean[] visited = new boolean[10];
	        for (int i = 1; i <= 9; i++) {
	            visited[i] = true;
	            dfs(i, 1, m, n, visited);
	            visited[i] = false;
	        }
	        return result;
	    }
	    
	    private static void dfs(int start, int count, int m, int n, boolean[] visited) {
	        if (count >= m && count <= n) {
	            result++;
	        }
	        if (count > n) {
	        	 System.out.println("dfs end is :["+ " start:"+start+" count:"+(count+1)+" m:"+m+" n:"+n+"visited: "+visited);
	            return;
	        }
	        for (int i = 1; i <= 9; i++) {
	            if (!canMove(start, i, visited)) {
	                continue;
	            }
	            visited[i] = true;
	            System.out.println("dfs call is :["+ " i:"+i+" count:"+(count+1)+" m:"+m+" n:"+n+"visited: "+visited);
	            dfs(i, count + 1, m, n, visited);
	            visited[i] = false;
	        }
	    }
	    
	    private static boolean canMove(int start, int end, boolean[] visited) {
	        if (visited[end]) {
	            return false;
	        }
	        // on the same row
	        if (Math.abs(start - end) == 2 && (start - 1) / 3 == (end - 1) / 3) {
	            return visited[(start + end) / 2];
	        }
	        // on the same col
	        if (Math.abs(start - end) == 6 && start % 2 == end % 2) {
	            return visited[(start + end) / 2];
	        }
	        if (start + end == 10) {
	            return visited[5];
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(numberOfPatterns(3, 4));
		}

}

