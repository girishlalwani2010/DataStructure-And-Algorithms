package datastructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 09/22/2014
 * @author tusroy
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class SubstringSearch {

	static int amount_to_pay(String Q, String P, int[] cost){
		
		List<Integer> possibleMatches = new ArrayList<Integer>();
        int oldIndex = 0;
        int newIndex = 0;
        int i =1;
        int oldDiff = -1;
       // boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        while(P.length()>=Q.length()){
        	if(KMP(P.toCharArray(), Q.toCharArray())!=-1){
	        	newIndex = oldIndex + KMP(P.toCharArray(), Q.toCharArray());
	        	if(newIndex-oldIndex>=oldDiff)
	        		possibleMatches.add(newIndex);
	        	oldDiff = newIndex - oldIndex;
	        	oldIndex = newIndex;
        	}
        	P = P.substring(1, P.length());
        }
        int maxSum = -1;
        for(int k =0 ; k<possibleMatches.size();k++){
        	int sum = 0;
        	for(int l =k; l<possibleMatches.size();){
        		sum = sum + cost[possibleMatches.get(l)];
        		l = l+Q.length();
        	}
        	if(maxSum<sum){
        		maxSum = sum;
        	}
        }
		
		return maxSum;
        // Return the amount monk has to pay  Write your code here
    
    }
    
    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private static int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                	//while checking if there is mismatch in pattern itself and index is not equal to zero, then we need to check further from 
                	//value of lps[index-1], as there could be chance that by removing this mismatch we found another where we find the proper prefix 
                	// from where we have to start. for example
                	
                	// with string aabaabaaa, when index at last b and i at last a then there is mismatch,so we have to move to pattern[5]'s value,
                	// which will be 2 so index will come at first b positon which is again not equal to a ith position. so again we to look in the array 
                	// by exluding first b, so index will be equal to as lps[2-1] = 1, in this case and then we found a match and will move further. 
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    /**
     * KMP algorithm of pattern matching.
     */
    public static int KMP(char []text, char []pattern){
        
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        int steps = 0;
        while(i < text.length && j < pattern.length){
        	steps++;
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                	//update the j to index from where we have to again start matching, as there is a mismatch, so we have to jump to the position upto
                	// which we do not have to match as we proper prefix.
                	// for example abcxabcdabcdabcy
                	//						  |
                	//				   abcdabcy	 there is mismatch at y and d, so we exclude y and find the proper prefix length +1 index by looking into lps
                	//                           as it is storing the indexes from where we have to start if there is a mismatch.
                    j = lps[j-1];
                }
                // shift i by 1 to proceed in text and j will remain at its place as first letter itself is not matched, So we cannot proceed in pattern
                else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
        	return i-1;
        }
        return -1;
    }
        
    public static void main(String args[]){
        String Q = "ok";
        String P = "oksirok";
        int[] cost = {4,2,5,11,12,4,6};
    	System.out.println(amount_to_pay(Q,P,cost));
        
    }
}