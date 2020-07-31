package array;

import java.util.HashMap;

public class RepeatingSubstring {

	public static void main(String[] args) {
		String ans = getRecurringSequence(17, 18);
		System.out.println(ans);
	}

	public static String getRecurringSequence(int num, int den) {
		String result = "";
		HashMap<Integer, Integer> map = new HashMap<>();
		int rem = num % den;

		while ((rem != 0) && (!map.containsKey(rem))) {
			map.put(rem, result.length());
			rem = rem * 10;
			int resPart = rem / den;
			result = result + resPart;
			rem = rem % den;
		}

		return (rem == 0) ? "" : result.substring(map.get(rem));
	}

}
