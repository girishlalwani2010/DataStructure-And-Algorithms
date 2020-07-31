package array;

import java.util.HashMap;

public class RepeatingDecimalPattern {

	int findRepeat(int p, int q) {
		// case when there is 0 remainder
		if (p % q == 0)
			return 0;
		// performing basic division method (which we do manually ) and mapping
		// remainders with their position
		HashMap<Integer, Integer> mapp = new HashMap<>();
		Integer initial_rem, i, rem, curr_dividend, temp, newRem = -1;
		initial_rem = p % q;
		curr_dividend = p % q;
		mapp.put(initial_rem, 0);
		int z = 0;
		while (true) {

			i = 0;
			while (curr_dividend < q) {
				if (i == 0) {
					curr_dividend *= 10;

				} else {
					curr_dividend *= 10;
					z++;
				}
				i++;
			}
			temp = curr_dividend / q;
			newRem = curr_dividend % q;
			z++;
			// checking if current remainder is already present in map
			// if not present then adding it into map
			if (!mapp.containsKey(newRem)) {
				mapp.put(newRem, z);
			}
			// if present returning the length (current position - initial position)
			else {
				return z - mapp.get(newRem);
			}
			curr_dividend = newRem;
			// case when remainder is zero
			if (newRem == 0) {
				return 0;
			}

		}
	}
}
