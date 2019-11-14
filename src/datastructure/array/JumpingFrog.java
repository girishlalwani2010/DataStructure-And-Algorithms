package datastructure.array;

import java.util.HashMap;
import java.util.HashSet;

public class JumpingFrog {
	/*public static boolean canCross(int[] stones) {
        if(stones[1] > 1) return false;
        if(stones.length == 2) return true;
        return helper(stones, 1, 1);
    }
    private static boolean helper(int[] arr, int i, int step){
        boolean pass = false;
        if(i == arr.length-1) return true;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] <= arr[i] + step + 1 && arr[j] >= arr[i]+step-1){
                pass = pass || helper(arr, j, arr[j] - arr[i]);
            }
        }
        return pass;
    }*/
	
	/**
	 * 0->[1]
	 * 1->[1,2]
	 * 3->[1,2,3]
	 * 5->[1,2,3]
	 * 6->[1,2,3,4]
	 * 8->[1,2,3,4]
	 * 12->[3,4,5]
	 * 17->[]
	 * 
	 * */
    
    public static boolean canCross(int[] stones) {
        if (stones.length == 0) {
        	return true;
        }
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
        	map.put(stones[i], new HashSet<Integer>() );
        }
        
        for (int i = 0; i < stones.length - 1; i++) {
        	int stone = stones[i];
        	for (int step : map.get(stone)) {
        		int reach = step + stone;
        		if (reach >= stones[stones.length - 1]) {
        			return true;
        		}
        		HashSet<Integer> set = map.get(reach);
        		if (set != null) {
        		    set.add(step);
        		    if (step - 1 > 0) set.add(step - 1);
        		    set.add(step + 1);
        		}
        	}
        }
        
        return false;
    } 
	    
    public static void main(String[] args) {
    	int []stones = {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}
}

