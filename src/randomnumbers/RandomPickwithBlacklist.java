package randomnumbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author girish_lalwani
 *
 *https://leetcode.com/problems/random-pick-with-blacklist/
 */
public class RandomPickwithBlacklist {
	  Map<Integer, Integer> m;
	    Random r;
	    int wlen;

	    public RandomPickwithBlacklist(int n, int[] b) {
	        m = new HashMap<>();
	        r = new Random();
	        wlen = n - b.length;
	        Set<Integer> w = new HashSet<>();
	        for (int i = wlen; i < n; i++) w.add(i);
	        for (int x : b) w.remove(x);
	        Iterator<Integer> wi = w.iterator();
	        for (int x : b)
	            if (x < wlen)
	                m.put(x, wi.next());
	    }

	    public int pick() {
	    	//this call can be inside RandomPickwithBlacklist(int n, int[] b) as well, so reads will be more fast
	        int k = r.nextInt(wlen);
	        return m.getOrDefault(k, k);
	    }
}
