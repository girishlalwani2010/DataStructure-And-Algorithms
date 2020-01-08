package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumbersWithNDigits {

	List<String> list = new ArrayList<String>();
	int countUniqueDigits = 0;

	public List<String> generateNumberWithNDigits(int n) {
		if (n == 0) {
			List<String> newList = new ArrayList<String>();
			newList.add("");
			return newList;
		}
		List<String> childList = generateNumberWithNDigits(n-1);
		
		for (int j = 0; j < 10; j++) {
			for(String str : childList) {
				String localStr = j+str;
				list.add(localStr);
				if(localStr.length()>=2) {
					for(int i=0; i<localStr.length()-1; i++) {
						if(localStr.charAt(i)!=localStr.charAt(i+1)) {
							countUniqueDigits++;
						}
					}
				}else {
					countUniqueDigits++;
				}
				
			}
		}
		return new ArrayList(list);
	}
	
	
	//correct code
	public static int countNumbersWithUniqueDigits(int n) {
		if (n > 10) {
			return countNumbersWithUniqueDigits(10);
		}
		int count = 1; // x == 0
		long max = (long) Math.pow(10, n);

		boolean[] used = new boolean[10];

		for (int i = 1; i < 10; i++) {
			used[i] = true;
			count += search(i, max, used);
			used[i] = false;
		}

		return count;
	}

	private static int search(long prev, long max, boolean[] used) {
		int count = 0;
		if (prev < max) {
			count += 1;
		} else {
			return count;
		}

		for (int i = 0; i < 10; i++) {
			if (!used[i]) {
				used[i] = true;
				long cur = 10 * prev + i;
				count += search(cur, max, used);
				used[i] = false;
			}
		}

		return count;
	}


	public static void main(String[] args) {
		GenerateNumbersWithNDigits generateNumberWithNDigits = new GenerateNumbersWithNDigits();
		System.out.println(generateNumberWithNDigits.countNumbersWithUniqueDigits(3));
	}

}
