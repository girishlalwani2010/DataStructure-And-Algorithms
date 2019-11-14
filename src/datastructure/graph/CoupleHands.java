package datastructure.graph;

import java.util.Arrays;

public class CoupleHands {

	public static int minSwapsCouples(int[] row) {
		int N = row.length / 2;
		int swap = 0;

		// initially we have N couples, each couple will have the same group identifier
		// index : 0 1 2 3 4 5 6 7 8 9
		// couple: 0 1 2 3 4 5 6 7 8 9
		// group identifier: 0 0 1 1 2 2 3 3 4 4
		int[] groups = new int[row.length];
		for (int group = 0; group < N; group++) {
			groups[group * 2] = group;
			groups[group * 2 + 1] = group;
		}

		// Since number of seats are even and all couples want to hold hands
		// if i is the group number, 0 <= i < N, each couple should seat at positions of
		// 2*i and 2*i+1
		for (int group = 0; group < N; group++) {
			int person1 = row[2 * group];
			int person2 = row[2 * group + 1];

			int couple1 = person1 / 2;
			int couple2 = person2 / 2;

			if (couple1 != couple2) { // if these two person are not couples (each person from different couples)

				// if we do swap people from two couples for the first time, this swap is
				// counted
				// if we want to swap people from the same two couples for the second time, we
				// don't need to
				// do anything since the first swap already exchange the 2 people to meet their
				// love partners.
				if (findGroup(groups, person1) != findGroup(groups, person2)) {
					swap++;
					// union couples into same group
					union(groups, person1, person2);
				}
			}
		}

		return swap;
	}
	
	private static int findGroup(int[] groups, int person) {
		return groups[person];
	}

	private static void union(int[] groups, int person1, int person2) {
		int group = groups[person1];
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] == group)
				groups[i] = groups[person2];
		}
	}

	public static int minSwapsCouplesUsingGreedyMap(int[] row) {
		int a[] = row;
		int map[] = new int[row.length];
		for (int i = 0; i < a.length; i++) {
			map[a[i]] = i;
		}

		int res = 0;
		for (int i = 0; i < a.length; i += 2) {
			if (isTheSame(a[i], a[i + 1]))
				continue;
			int pairPos = findPairPos(map, a[i + 1]);
			System.out.println("Before Swap!");
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(map));
			swap(map, a, i, pairPos);
			System.out.println("After Swap!");
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(map));
			res++;
		}
		return res;

	}

	static boolean isTheSame(int a, int b) {
		if (b % 2 == 0)
			return a == b + 1;
		return b == a + 1;
	}

	static int findPairPos(int map[], int val) {
		int queryVal = val - 1;
		if (val % 2 == 0)
			queryVal = val + 1;
		return map[queryVal];
	}

	static void swap(int map[], int a[], int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		map[a[j]] = j;
		map[a[i]] = i;
	}

	public static void main(String[] args) {
		int[] row = { 3,1,0,4,5,2 };
		System.out.println(minSwapsCouplesUsingGreedyMap(row));
	}

}
