package datastructure.array;

public class SlidingWindow_Count_of_substrings_which_contains_a_given_character_K_times {

	static int getPossibleStrings(String str, int k, char c) {
		char[] charArray = str.toCharArray();
		int possibleStrs = 0;
		int start = 0, end = -1, count = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (c == charArray[i]) {
				count++;
			}
			end++;
			if(count == k){
				possibleStrs++;
			}
			int windowCount = count;
			start=0;
			while (windowCount >= k && (end-start>=(k-1))) {
				if (charArray[start] == c) {
					windowCount--;
				}
				if(windowCount == k){
					possibleStrs++;
				}
				start++;
			}
		
		}
		return possibleStrs;
	}
	
	public static void main(String[] args) {
		System.out.println(getPossibleStrings("ABADA", 2, 'A'));
		
	}

}
