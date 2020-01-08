package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {
	
	public static boolean isSubsequence(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        int matches = 0;
        int i=0,j=0;
        while(i<source.length && j<target.length){
            if(source[i] == target[j]){
                matches++;
                i++;
                j++;
            }
            else j++;
        }
        if(matches == source.length){
            return true;
        }
        return false;
    }
	
	public static boolean isSubsequenceBinarySearch(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i=0; i<target.length; i++){
            if(!map.containsKey(target[i])){
                map.put(target[i],new ArrayList<Integer>());
            }
            map.get(target[i]).add(i);
            
        }
        int sourcePos = -1;
        int prevPos = -1;
        for(int i=0; i<source.length; i++){
            List<Integer> list = map.get(source[i]);
            if(list == null){
                return false;
            }
            prevPos = sourcePos;
            sourcePos = findNext(list,sourcePos);
            if(sourcePos<=prevPos){
                return false;
            }
        }
        return true;
    }
    
    private static int findNext(List<Integer> list, int sourcePos){
        int lo = 0;
        int hi = list.size()-1;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(list.get(mid)>sourcePos){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return list.get(lo);
    }
	
	
	public static void main(String[] args) {
		String source = "leeeeetcode";
		//l -0
		//e-1,2,3
		String target = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyleeeeeeeeeeeeeeeeeeyyyyyyyyyyyyyyyyyyy";
		System.out.println(isSubsequence(source,target));
	}

}
