package recursion.backtracking;

public class RegularExpressionMatching {

	public boolean isMatch(String text, String pattern) {
		if(pattern.isEmpty()) {
			return text.isEmpty();
		}
		boolean firstMatch = false;
		if(!text.isEmpty() && ((text.charAt(0) == pattern.charAt(0)) || pattern.charAt(0) == '.')) {
			firstMatch = true;
		}
		if(pattern.length()>=2 && pattern.charAt(1) == '*') {
			return isMatch(text,pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
		}else {
			return firstMatch && isMatch(text.substring(1),pattern.substring(1));
		}
	}
	
}
