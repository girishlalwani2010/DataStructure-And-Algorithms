package dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGameII {

	public int jump(int[] jumps) {
        Map<Integer, Integer> memo = new HashMap<>();
        int minJumps = countMinJumps(jumps, jumps.length-1, 0, memo);
        if(minJumps == Integer.MAX_VALUE){
            return -1;
        }
        return minJumps;
    }
    private int countMinJumps(int[] jumps, int rem ,int start, Map<Integer, Integer> memo){
		if(rem == 0 || start==jumps.length-1) {
			return 0;
		}
		if(rem < 0) {
			return Integer.MAX_VALUE;
		}
        int key = start;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        //pruning
        if (start > 0 && jumps[start] < jumps[start-1]){
            return Integer.MAX_VALUE;
        }
		int minJumps = Integer.MAX_VALUE;
		for(int i=1; i<=jumps[start] && start+i<jumps.length; i++) {
			minJumps = Math.min(minJumps, countMinJumps(jumps, rem-i, start+i, memo));
		}
		minJumps = (minJumps == Integer.MAX_VALUE)?Integer.MAX_VALUE:minJumps+1;
        memo.put(key, minJumps);
		return minJumps;
	}
}
