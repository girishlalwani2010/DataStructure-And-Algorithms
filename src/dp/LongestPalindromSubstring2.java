package dp;

public class LongestPalindromSubstring2 {
	
	public static String longestPalindtomSubstringLength(String s) {
		if(s.isEmpty() || s==null) {
			return "";
		}
		
		boolean[] step1 = new boolean[s.length()];
		boolean[] step2 = new boolean[s.length()];
		int start=0;
		int end=0;
		
		for(int i=0; i<s.length(); i++) {
			step1[i] = true;
			start=i;
			end=i;
		}
		
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				step2[i] = true;
				start=i;
				end=i+1;
			}
		}
		
		for(int currLength=3; currLength<=s.length(); currLength++) {
			for(int j=0; j<=s.length()-currLength; j++) {
				if(s.charAt(j) == s.charAt(j+currLength-1)) {
					if(currLength%2 == 1) {
						step1[j] = step1[j+1];
						if(step1[j+1]==true) {
							start = j;
							end = j+currLength-1;
						}
					}
					if(currLength%2 == 0){
						step2[j] = step2[j+1];
						if(step2[j+1]==true) {
							start = j;
							end = j+currLength-1;
						}
					}
					
				}else {
					if(currLength%2 == 1) {
						step1[j] = false;
					}
					if(currLength%2 == 0){
						step2[j] = false;
					}
				}
				
				
			}
		}
		return s.substring(start,end+1);
	}
	//"aaabaaa"
	//
	public static void main(String[] args) {
		String s = "aaaabaaa";
		System.out.println(longestPalindtomSubstringLength(s));
	}

}
