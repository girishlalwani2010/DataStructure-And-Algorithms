package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	private List<String> result;

	public void helper(String digits, Map<Character, List<Character>> map, int digitPos, StringBuilder sb) {

		if (digits.length() == digitPos) {
			result.add(sb.toString());
			return;
		}

		for (Character chr : map.get(digits.charAt(digitPos))) {
			sb.append(chr);
			helper(digits, map, digitPos + 1, sb);
			sb.setLength(sb.length() - 1);
		}

	}

	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0) {
			return new ArrayList<String>();
		}
	        Map<Character,List<Character>> map = new HashMap<>();
	        List<Character> charsToDigit = stringToCharList("abc");
	        map.put('2',charsToDigit);
	        charsToDigit = stringToCharList("def");
	        map.put('3', charsToDigit);
	        charsToDigit = stringToCharList("ghi");
	        map.put('4', charsToDigit);
	        charsToDigit = stringToCharList("jkl");
	        map.put('5', charsToDigit);
	        charsToDigit = stringToCharList("mno");
	        map.put('6', charsToDigit);
	        charsToDigit = stringToCharList("pqrs");
	        map.put('7', charsToDigit);
	        charsToDigit = stringToCharList("tuv");
	        map.put('8', charsToDigit);
	        charsToDigit = stringToCharList("wxyz");
	        map.put('9', charsToDigit);
	        
	        result = new ArrayList<String>();
	        helper(digits, map, 0, new StringBuilder());
	        return result;
	    }

	private List<Character> stringToCharList(String str) {
		List<Character> charsToDigit = new ArrayList<Character>();
		char arrayChar[] = str.toCharArray();
		for (char aChar : arrayChar) {
			charsToDigit.add(aChar); //  autoboxing 
		}
		return charsToDigit;
	}
	
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
		System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
	}

}
