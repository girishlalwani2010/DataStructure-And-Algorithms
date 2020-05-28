package string.substring.search;

import javax.print.attribute.TextSyntax;

public class RabinKarp {

	private final int PRIME = 101;

	/**
	 * @param str
	 * @param start
	 * @param end
	 * @return rolling hash function
	 */
	private long calculateHash(long oldHash, char[] str, int start, int end) {
		long hash = 0;
		if (start == 0) {
			for (int i = 0; i <= end; i++) {
				//hash = hash + str[i]* Math.pow(PRIME, i);
				hash += str[i]* Math.pow(PRIME, i);
			}
		} else {
			char oldChar = str[start - 1];
			char newChar = str[end];
			hash = (oldHash - oldChar) / PRIME;
			hash += newChar * Math.pow(PRIME, end - start);
		}
		return hash;
	}

	private boolean areEqual(char[] patternArr, char[] textArr, int textStart, int textEnd) {
		if (patternArr.length != textEnd - textStart + 1) {
			return false;
		} else {
			int i = 0;
			while (i < patternArr.length) {
				if (textArr[textStart] != patternArr[i]) {
					return false;
				}
				i++;
				textStart++;
			}
		}
		return true;
	}

	public int rabinKarp(String pattern, String text) {
		char[] patternArr = pattern.toCharArray();
		char[] textArr = text.toCharArray();
		int pattternLen = patternArr.length;
		long patternHash = calculateHash(0, patternArr, 0, pattternLen-1);
		long textHash = 0;
		int textEnd = textArr.length - pattternLen;
		for (int i = 0; i <= textEnd; i++) {
			textHash = calculateHash(textHash, textArr, i, i + pattternLen - 1);
			if (patternHash == textHash && areEqual(patternArr, textArr, i, i + pattternLen - 1)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
		String subString = "abcy";
		RabinKarp rk = new RabinKarp();
		System.out.println(rk.rabinKarp(subString, str));
	}
}
