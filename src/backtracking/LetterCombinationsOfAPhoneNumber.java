package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	 Map<Integer,List<Character>> map = new HashMap<>();
	    List<String> result = new ArrayList<>();
	    
	    public List<String> letterCombinations(String digits) {
	        if(digits.length()==0){
	            return new ArrayList<>();
	        }
	        map.put(2,stringToCharList("abc"));
	        map.put(3,stringToCharList("def"));
	        map.put(4,stringToCharList("ghi"));
	        map.put(5,stringToCharList("jkl"));
	        map.put(6,stringToCharList("mno"));
	        map.put(7,stringToCharList("pqrs"));
	        map.put(8,stringToCharList("tuv"));
	        map.put(9,stringToCharList("wxyz"));
	        letterCombinations(digits, 0, new StringBuilder(), map);
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
	    
	    public void letterCombinations(String digits, int start, StringBuilder sb, Map<Integer,List<Character>> map) {
	        if(start == digits.length()){
	            result.add(sb.toString());
	            return;
	        }
	         for(Character ch : map.get(Character.getNumericValue(digits.charAt(start)))){
	            sb.append(ch);
	            letterCombinations(digits, start+1, sb, map);
	            sb.setLength(sb.length() -1);
	        }
	    }
	
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
		System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
	}

}
