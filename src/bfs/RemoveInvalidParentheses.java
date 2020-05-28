package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> validStrings = new ArrayList<>();
		if (s.length() == 0) {
			validStrings.add("");
			return validStrings;
		}
		Queue<String> q = new LinkedList<>();
		q.add(s);
		boolean found = false;
		Set<String> visited = new HashSet<>();

		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				String str = q.poll();
				if (isValid(str)) {
					validStrings.add(str);
					found = true;
				}
				if (found) {
					continue;
				}
				for (int i = 0; i < str.length(); i++) {
					if (Character.isLetter(str.charAt(i))) {
						continue;
					}
					String part = str.substring(0, i) + str.substring(i + 1, str.length());
					if (!visited.contains(part)) {
						visited.add(part);
						q.offer(part);
					}
				}
			}
			if (found) {
				return validStrings;
			}
		}
		return new ArrayList<>();
	}

	private boolean isValid(String str) {
		int count = 0;
		char[] strArr = str.toCharArray();
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] == '(') {
				count++;
			} else if (strArr[i] == ')') {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		return count == 0;
	}

}
