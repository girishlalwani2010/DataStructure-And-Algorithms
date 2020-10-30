package string.substring.search;

public class KMPPraccticeIII {
	
	//KMP 
	public boolean substringSearch(char[] text, char[] pattern) {
		int[] lps = computeLPS(pattern);
		int i=0,j=0;
		while(i<text.length) {
			if(text[i] == pattern[j]) {
				i++;
				j++;
			}else {
				if(j!=0) {
					j=lps[j-1];
				}else {
					i++;
				}
			}
			if(j==pattern.length) {
				return true;
			}
		}	
		return false;
	}
	
	private int[] computeLPS(char[] pattern) {
		int index=0;
		int[] lps = new int[pattern.length];
		for(int i=0; i<pattern.length;) {
			if(pattern[index] == pattern[i]) {
				lps[i] = index+1;
				index++;
				i++;
			}else {
				if(index!=0) {
					index=lps[index-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	
	public static void main(String[] args) {
		
	}

}
