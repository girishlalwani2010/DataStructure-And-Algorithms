package string.substring.search;

import java.util.ArrayDeque;
import java.util.Deque;

public class temp {
	
	
	public static void main(String[] args) {
		
		System.out.println(validateSearchParam("((Format=HTML)AND(ReportTypeId=inventory-report))OR(Format=CSV)"));
		
	}
	
	private static boolean validateSearchParam(String searchParam) {

		Deque<Character> stack = new ArrayDeque<>();
		Character reverseChar = ')';
		for (Character ch : searchParam.toCharArray()) {
			if (ch == '(' || ch == ')') {
				if (stack.isEmpty()) {
					stack.add(reverseChar);
				} else {
					Character peek = stack.peekLast();
					if (peek == ch) {
						stack.pollLast();
					} else {
						stack.push(reverseChar);;
					}
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;

	}
	
	

}

