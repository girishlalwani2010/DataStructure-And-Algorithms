package graph;

/**
 * @author girish_lalwani
 *
 *
 *         Logical Thinking It is inductive that we can find the candidate and
 *         check whether it is up to standard or not. How do we decide the
 *         candidate? We are sure that if A knows B, A cannot be the celebrity
 *         while B may be, i.e., B is the candidate. Since there is only one
 *         celebrity, one loop is enough to decide the candidate. How do we
 *         check whether the candidate is up to standard? According to the
 *         definition of a celebrity, if !knows(i, candidate) ||
 *         knows(candidate, i) exists, the candidate is not qualified.
 * 
 */
public class FindtheCelebrity {

	static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	// Returns true if a knows
	// b, false otherwise
	static boolean knows(int a, int b) {
		boolean res = (MATRIX[a][b] == 1) ? true : false;
		return res;
	}

	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i == candidate) {
				continue;
			}
			if (!knows(i, candidate) || knows(candidate, i)) {
				return -1;
			}
		}
		return candidate;
	}

	public int findCelebrityIIndTry(int n) {
		int i = 0, j = n - 1;
		while (i < j) {
			if (knows(i, j)) {
				i++;
			} else if (knows(j, i)) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		for (int k = 0; k < n; k++) {
			if (k == i)
				continue;
			if (knows(i, k) || !knows(k, i)) {
				return -1;
			}
		}
		return i;
	}

	public int findCelebrityIIIrdWay(int n) {
		if (n == 1) {
			return 0;
		}
		int p1 = 0, p2 = n - 1;
		while (p1 < p2) {
			if (knows(p1, p2)) {// knows called only once
				p1++;
			} else {
				p2--;
			}
		}
		int celebrity = p1;
		for (int i = 0; i < n; i++) {
			if (i != celebrity) {
				if (knows(celebrity, i) || !knows(i, celebrity)) {
					return -1;
				}
			}
		}
		return celebrity;
	}
}
