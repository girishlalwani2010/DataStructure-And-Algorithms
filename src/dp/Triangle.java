package dp;

import java.util.List;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/triangle/
 *
 *Awesome Learning/Knowledge https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
 */
public class Triangle {
	    public int minimumTotal(List<List<Integer>> triangle) {
	        for(int i = triangle.size() - 2; i >= 0; i--)
	            for(int pos = 0; pos <= i; pos++)
	                triangle.get(i).set(pos, triangle.get(i).get(pos) + Math.min(triangle.get(i + 1).get(pos), triangle.get(i + 1).get(pos + 1)));
	        return triangle.get(0).get(0);
	    }
}
