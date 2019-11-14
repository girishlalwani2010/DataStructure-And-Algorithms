package dp;

import java.util.Currency;

public class LongestPalindromSubstring {
	
	public static String longestPalindrome(String s) {
		
		if(s.isEmpty() || s==null) {
			return "";
		}
        
		boolean [][]palindrom = new boolean[s.length()][s.length()];
		int lengthOfString = s.length();
		int start = 0,end = 0;
		
		for(int i=0; i<s.length(); i++) {
			palindrom[i][i] = true;
			start=i;
			end=i;
		}
		
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				palindrom[i][i+1] = true;
				start=i;
				end=i+1;
			}
			
		}
		for(int currLength=3; currLength<=lengthOfString; currLength++) {
			for(int i=0; i<lengthOfString-currLength+1; i++) {
				int j=i+currLength-1;
				if(s.charAt(i) == s.charAt(j)) {
					if(palindrom[i+1][j-1] == true) {
						palindrom[i][j] = true;
						start = i;
						end = j;
					}
				}
			}
			
			
		}
		
		return s.substring(start, end+1);
		
    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("banana"));
	}

}
