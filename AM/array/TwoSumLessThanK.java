package array;

import java.util.TreeSet;

public class TwoSumLessThanK {
	
	public int twoSumLessThanK(int[] A, int K) {
		// need to take a treeset as treeset implements Navigable set and floor,ceiling lower and higher are methods of it.
        TreeSet<Integer> treeset = new TreeSet<>();
        int result = -1;
        for(int num : A){
        	// why lower as floor will give number equal to or less than, but lower will give strictly less than key.
            Integer closestPair = treeset.lower(K-num);
            if(closestPair != null){
                result = Math.max(result,num+closestPair);
            }
            treeset.add(num);
        }
        return result;
    }

}
