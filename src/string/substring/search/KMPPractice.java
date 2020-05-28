package string.substring.search;

/**
 * @author girish_lalwani
 *
 * LPS is longest proper prefix which is also a suffix
 * Example to understand algo : text - "onionions", pattern - "onions"
 */
public class KMPPractice {
	
	private void computeLPS(String pattern, int[] lps){
		int lenOfPrefix = 0;
		char[] patternArr = new char[pattern.length()];
		for(int i=1; i<patternArr.length;) {
			if(patternArr[lenOfPrefix] == patternArr[i]) {
				lps[i] = lenOfPrefix+1;
				i++;
				lenOfPrefix++;
			}else {
				if(lenOfPrefix!=0) {
					lenOfPrefix=lps[lenOfPrefix-1];
				}else {
					lps[i]=0;
					i++;
				}
			}
		}
	}
	
	
	public int kmp(String text, String pattern) {
		int lps[] = new int[pattern.length()];
		computeLPS(pattern,lps);
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int j=0;
		for(int i=0; i<textArr.length;) {
			if(textArr[i] == patternArr[j]) {
				i++;
				j++;
			}else  {
				if(j!=0) {
					j=lps[j-1];
				}else {
					i++;
				}
			}
			if(j == pattern.length()) {
				return i-j;
			}
			// j = lps[j-1] // to find all the occurrences of pattern in text.
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		KMPPractice kmp = new KMPPractice();
		int startIdx = kmp.kmp(str, subString);
		System.out.print(startIdx);
	}

}
