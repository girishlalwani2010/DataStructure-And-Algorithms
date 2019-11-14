package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequenceLength {

	private static int longestSubsequenceLength(int []arr){
		
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++){
			hashSet.add(arr[i]);
		}
		int length = 0;
		for(int i=0; i<arr.length; i++){
		
			if(!hashSet.contains(arr[i]-1)){
				int j=arr[i];
				while(hashSet.contains(j)){
					j++;
				}
				if(j-arr[i]>length){
					length = j-arr[i];
				}
				
			}
			
			
		}
		
		
		return length;
	}
	
	public static void main(String[] args) {
		int arr[] =  {1, 9, 3, 10, 4, 20, 2};
		System.out.println(longestSubsequenceLength(arr));
	}
	
}
