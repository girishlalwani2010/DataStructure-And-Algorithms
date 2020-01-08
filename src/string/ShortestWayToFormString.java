package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWayToFormString {
	
	/**
	 * @param source
	 * @param target
	 * @return
	 * 
	 * for example for source xyz
	 * target xzyxz
	 * 
	 * HashMap will be like below will be implemented than we can apply binary search for character in target, and store the sourcePos till we have found match 
	 * and binary search will be to find next possible sourcePos by doing binary search on particular chartacter Array-List, and if it is less that or equal to previous found than 
	 * we can say that new subsequence matching started.  
	 * 
	 * x --> 0
	 * y --> 1
	 * z --> 2
	 * 
	 */
	public static int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<source.length(); i++){
            char cs = source.charAt(i);
            if(!map.containsKey(cs)){
                map.put(cs, new ArrayList<Integer>());
            }
            map.get(cs).add(i);
        }
        int res = 1;
        int sourcePos = -1;
        int prevSourcePos=-1;
        for(int j = 0; j<target.length(); j++){
            char ct = target.charAt(j);
            if(!map.containsKey(ct)) return -1;
            prevSourcePos = sourcePos;
            sourcePos = findNext(map.get(ct),sourcePos);
            if(sourcePos<=prevSourcePos) {
            	res++;
            }
        }
        return res;
    }
    private static int findNext(List<Integer> l, int pos){
    	int low = 0;
    	int high = l.size()-1;
    	if(pos >= l.get(l.size() - 1)) return l.get(0);
    	while(low<high) {
    		int mid = (low+high)/2;
    		if(l.get(mid) > pos) {
    			high = mid;
    		}else {
    			low = mid+1;
    		}
    	}
    	return l.get(low);
    }
    
    
    
    /**
     *  Inverted index data structure 
	 *	dict[i][c - 'a'] represents the earliest index >= i where character c occurs in source.
     *  
     *  For ex: String source = "xyz";
		String target = "xzyxz";
     * [[000000000..............123]
     * 	[000000000...............23]
     * 	[000000000................3]]
     * 
     * 
     * Snippet attached in the mail with example s->abcdabcadeba, target->abcaeac
     * for more visualisation
     */
    public static int shortestWayInONTime(String source, String target) {
    	char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        int M = s.length;
        int N = t.length;
        
        // Build inverted index for source
        int[][] dict = new int[M][26];
        
        Arrays.fill(dict[M-1], -1); // -1 represents no occurrence of the character
        
        dict[M-1][s[M-1] - 'a'] = M-1;
        for(int x = M - 2; x >= 0; --x) {
            dict[x] = Arrays.copyOf(dict[x+1], 26);
            dict[x][s[x] - 'a'] = x;
        }
        
        int ans = 0;
        int idx = 0;
        // Go through target and account for each character
        for(char c: t) {
            // If start of target i.e. c does not matches with start of source 'dict[0][c - 'a']'
            // then return -1;
            if(dict[0][c - 'a'] == -1) return -1;
            
            // If there are no c's left in source that occur >= idx
            // but there are c's from earlier in the subsequence
            // add 1 to subsequence count and reset idx of source to 0.
            // for Y in target for ex: of target->xz*y*xz
            if(dict[idx][c - 'a'] == -1) {
                ++ans;
                idx = 0;
            }
            
            // Then continue taking letters from the subsequence
            idx = dict[idx][c-'a'] + 1;
         // for z in target for ex: of target->x*z*yx*z*
            if(idx == M) {
                ++ans;
                idx = 0;
            }
        }
        
        return ans + (idx == 0? 0: 1);
    }
	
	
	public static void main(String[] args) {
		String source = "abcdabcadeba";
		String target = "xzyxz";
		System.out.println(shortestWayInONTime(source, target));
	}

}
