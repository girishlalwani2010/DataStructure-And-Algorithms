package string.substring.search;

/**
 * @author girish_lalwani
 * Rabin Karp -- Substring Search
 */
public class RabinKarpPractice {
	
	private final int PRIME=101;
	
	
	/**
	 * @param text
	 * @param pattern
	 * @return
	 * Will return the starting index of pattern in string if string exist.
	 */
	public boolean substringSearch(String text, String pattern) {
		long patternHash = calculateHash(pattern, 0, pattern.length()-1);
		long oldHash=-1;
		for(int i=0; i<text.length()-pattern.length()+1; i++) {
			long newHash = calculateHash(text, i, i+pattern.length()-1, oldHash);
			if(newHash == patternHash) {
				return checkForEquality(pattern, text, i, i+pattern.length()-1);
			}
			oldHash = newHash;
		}
		return false;
	}
	
	private boolean checkForEquality(String pattern, String text, int i, int j) {
		int k=0;
		while(i<j) {
			if(pattern.charAt(k++) != text.charAt(i)){
				return false;
			}
			i++;
		}
		return true;
	}

	/**
	 * Calculate Pattern Hash
	 */
	private long calculateHash(String pattern, int start, int end) {
		long hash=0;
		for(int i=start; i<=end; i++) {
			hash+=pattern.charAt(i)*Math.pow(PRIME,i);
		}
		return hash;
	}
	
	/**
	 * rolling hash function
	 */
	private long calculateHash(char oldChar, char newChar, long oldHash, int patternLen) {
		long hash = (oldHash - oldChar) / PRIME;
		hash += newChar * Math.pow(PRIME, patternLen-1);
		return hash;
	}
	
	private long calculateHash(String text, int start, int end, long oldHash) {
		if(oldHash==-1) {
			return calculateHash(text, start, end);
		}else {
			return calculateHash(text.charAt(start-1),text.charAt(end),oldHash, end-start+1);
		}
		
	}

	public static void main(String[] args) {
		String str = "aabcxabcdabcdabcybc";
		String subString = "abcy";
		RabinKarpPractice rk = new RabinKarpPractice();
		System.out.println(rk.substringSearch(str, subString));
	}

}
