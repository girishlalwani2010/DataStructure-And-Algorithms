package string.substring.search;

public class KMPPracticeII {

	private void computeLPS(String pattern, int[] lps) {
		int lenOfPrefix=0, i=1;
		char[] patternArr = pattern.toCharArray();
		while(i<patternArr.length) {
			if(patternArr[i] == patternArr[lenOfPrefix]) {
				lps[i] = lenOfPrefix+1;
				lenOfPrefix++;
				i++;
			}else {
				if(lenOfPrefix!=0) {
					lenOfPrefix = lps[lenOfPrefix-1];
				}else {
					lps[i] = 0;
					i++;
				}
				
			}
		}
	}
	
	public long kmp(String text, String pattern) {
		int[] lps = new int[pattern.length()];
		computeLPS(pattern, lps);
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int textP=0;
		int patternP=0;
		while(textP<textArr.length) {
			if(patternArr[patternP] == textArr[textP]) {
				patternP++;
				textP++;
			}else {
				if(patternP!=0) {
					patternP = lps[patternP-1];
				}else {
					textP++;
				}
			}
			if(patternP == patternArr.length) {
				return textP-patternArr.length; 
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		KMPPracticeII kmp = new KMPPracticeII();
		long startIdx = kmp.kmp(str, subString);
		System.out.print(startIdx);
	}
	
}
